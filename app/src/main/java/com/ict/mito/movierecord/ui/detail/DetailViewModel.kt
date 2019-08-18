package com.ict.mito.movierecord.ui.detail

import androidx.lifecycle.ViewModel
import com.ict.mito.movierecord.domain.DetailMovieItem

class DetailViewModel : ViewModel() {
    lateinit var detailMovieItem: DetailMovieItem
    var movieId: Int = -1
}
