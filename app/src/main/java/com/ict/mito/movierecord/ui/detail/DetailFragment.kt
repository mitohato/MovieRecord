package com.ict.mito.movierecord.ui.detail

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.ict.mito.movierecord.R
import org.koin.androidx.viewmodel.ext.android.viewModel

class DetailFragment : Fragment() {

    private val viewModel: DetailViewModel by viewModel()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val args = arguments ?: return null
        val safeArgs = DetailFragmentArgs.fromBundle(args)

        viewModel.movieId = safeArgs.movieId

        return inflater.inflate(
            R.layout.detail_fragment,
            container,
            false
        )
    }
}
