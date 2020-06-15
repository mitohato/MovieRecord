package com.ict.mito.movierecord.ui.detail

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import com.ict.mito.movierecord.R
import com.ict.mito.movierecord.databinding.DetailFragmentBinding
import org.koin.androidx.viewmodel.ext.android.viewModel

class DetailFragment : Fragment() {

  private var binding: DetailFragmentBinding? = null
  private val viewModel: DetailViewModel by viewModel()

  override fun onCreateView(
      inflater: LayoutInflater,
      container: ViewGroup?,
      savedInstanceState: Bundle?
  ): View? {

    val args = arguments ?: return null
    val safeArgs = DetailFragmentArgs.fromBundle(args)

    viewModel.also {
      it.movieId = safeArgs.movieId
      it.detailMovieItem.observe(
        viewLifecycleOwner,
        Observer {
          binding?.notifyChange()
        }
      )
    }

    binding = DataBindingUtil.inflate(
      inflater,
      R.layout.detail_fragment,
      container,
      false
    )

    binding?.let {
      it.viewmodel = viewModel
      it.lifecycleOwner = this
    }

    return binding?.root
  }

  override fun onResume() {
    super.onResume()
    val appCompatActivity = activity as AppCompatActivity?
    appCompatActivity?.supportActionBar?.let {
      it.title = viewModel.detailMovieItem.value?.title
      it.setDisplayHomeAsUpEnabled(true)
      it.setHomeButtonEnabled(true)
    }
  }

  override fun onDestroy() {
    super.onDestroy()
    binding = null
  }
}
