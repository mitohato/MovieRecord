package com.ict.mito.movierecord.ui.detail

import androidx.lifecycle.ViewModel
import com.ict.mito.movierecord.domain.DetailMovieItem
import com.ict.mito.movierecord.repo.NetRepository

class DetailViewModel(private val repository: NetRepository) : ViewModel() {
    lateinit var detailMovieItem: DetailMovieItem
    var movieId: Int = -1
}
