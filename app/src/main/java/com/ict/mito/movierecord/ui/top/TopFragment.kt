package com.ict.mito.movierecord.ui.top

import android.os.Bundle
import android.view.LayoutInflater
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
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
      viewLifecycleOwner,
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

    viewmodel.also {
      it.navController = findNavController()
      it.updateList()
    }

    binding?.let {
      it.viewmodel = viewmodel
      it.lifecycleOwner = this
    }
    return binding?.root
  }

  override fun onCreateOptionsMenu(
      menu: Menu,
      inflater: MenuInflater
  ) {
    inflater.inflate(
      R.menu.main_menu,
      menu
    )
  }

  override fun onOptionsItemSelected(item: MenuItem): Boolean {
    when (item.itemId) {
        R.id.watched_list -> findNavController().navigate(R.id.action_topFragment_to_watchedListFragment)
    }
    return super.onOptionsItemSelected(item)
  }

  override fun onResume() {
    super.onResume()

    setHasOptionsMenu(true)
    val appCompatActivity = activity as AppCompatActivity?
    appCompatActivity?.supportActionBar?.let {
      it.title = getString(R.string.title_top)
      it.setDisplayHomeAsUpEnabled(false)
      it.setHomeButtonEnabled(false)
    }
  }

  override fun onDestroy() {
    super.onDestroy()
    binding = null
  }
}
