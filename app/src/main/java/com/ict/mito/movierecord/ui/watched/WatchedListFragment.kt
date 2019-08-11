package com.ict.mito.movierecord.ui.watched

import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import com.ict.mito.movierecord.R

class WatchedListFragment : Fragment() {

    companion object {
        fun newInstance() = WatchedListFragment()
    }

    private lateinit var viewModel: WatchedListViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.watched_list_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(WatchedListViewModel::class.java)
        // TODO: Use the ViewModel
    }

}