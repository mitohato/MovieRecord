package com.ict.mito.movierecord.ui.top

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
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
        viewmodel.movieListLiveData.observe(
            this,
            Observer { list ->
                viewmodel.adapter.setMovieItemList(list)
            }
        )
        binding = DataBindingUtil.inflate<TopFragmentBinding>(
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

    override fun onDestroy() {
        super.onDestroy()
        binding = null
    }
}
