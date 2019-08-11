package com.ict.mito.movierecord.ui.top

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import com.ict.mito.movierecord.R
import com.ict.mito.movierecord.databinding.TopFragmentBinding
import org.koin.androidx.viewmodel.ext.android.viewModel

class TopFragment : Fragment() {

    private val viewmodel: TopViewModel by viewModel()
    private var binding: TopFragmentBinding? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        viewmodel.bindableRowItemList.observe(
            this,
            Observer { list ->
                viewmodel.groupAdapter.update(list)
            }
        )
        binding = DataBindingUtil.inflate(
            inflater,
            R.layout.top_fragment,
            container,
            false
        )

        binding?.let {
            it.viewmodel = viewmodel
            it.lifecycleOwner = this
        }
        return binding?.root
    }

    override fun onResume() {
        super.onResume()

        val appCompatActivity = activity as AppCompatActivity?
        appCompatActivity?.supportActionBar?.title = getString(R.string.title_top)
    }

    override fun onDestroy() {
        super.onDestroy()
        binding = null
    }
}
