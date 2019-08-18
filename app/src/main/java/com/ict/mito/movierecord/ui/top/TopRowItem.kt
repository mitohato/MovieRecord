package com.ict.mito.movierecord.ui.top

import androidx.navigation.NavController
import com.ict.mito.movierecord.R
import com.ict.mito.movierecord.databinding.MovieCardBinding
import com.ict.mito.movierecord.domain.MovieItem
import com.xwray.groupie.databinding.BindableItem

/**
 * Created by mitohato14 on 2019-06-19.
 */
class TopRowItem(
    val movieItem: MovieItem,
    val navController: NavController
) : BindableItem<MovieCardBinding>() {
    override fun getLayout(): Int = R.layout.movie_card

    override fun bind(
        viewBinding: MovieCardBinding,
        position: Int
    ) {
        viewBinding.movieItem = movieItem
    }
}