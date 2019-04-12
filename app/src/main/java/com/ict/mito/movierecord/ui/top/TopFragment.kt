package com.ict.mito.movierecord.ui.top

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.ict.mito.movierecord.R
import com.ict.mito.movierecord.databinding.TopFragmentBinding

class TopFragment : Fragment() {

    companion object {
        fun newInstance() = TopFragment()
    }

    private lateinit var viewModel: TopViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        viewModel.movieListLiveData.observe(
            this,
            Observer { list ->
                viewModel.adapter.setMovieItemList(list)
            }
        )
        val binding = DataBindingUtil.inflate<TopFragmentBinding>(
            inflater,
            R.layout.top_fragment,
            container,
            false
        )

        binding.also {
            it.viewmodel = viewModel
            it.lifecycleOwner = this
        }
        return binding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(TopViewModel::class.java)
        // TODO: Use the ViewModel
    }
}
