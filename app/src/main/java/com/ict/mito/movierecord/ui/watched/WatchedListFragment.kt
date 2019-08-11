package com.ict.mito.movierecord.ui.watched

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import com.ict.mito.movierecord.R
import com.ict.mito.movierecord.databinding.WatchedListFragmentBinding
import org.koin.androidx.viewmodel.ext.android.viewModel

class WatchedListFragment : Fragment() {

    private var binding: WatchedListFragmentBinding? = null


    private val viewModel: WatchedListViewModel by viewModel()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        viewModel.bindableRowItemList.observe(
            this,
            Observer {
                viewModel.groupAdapter.update(it)
            }
        )
        binding = DataBindingUtil.inflate(
            inflater,
            R.layout.watched_list_fragment,
            container,
            false
        )

        binding?.also {
            it.viewmodel = viewModel
            it.lifecycleOwner = this
        }

        return binding?.root
    }


    override fun onDestroy() {
        super.onDestroy()
        binding = null
    }
}
