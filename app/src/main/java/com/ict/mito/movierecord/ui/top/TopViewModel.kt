package com.ict.mito.movierecord.ui.top

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.ict.mito.movierecord.domain.MovieItem
import com.ict.mito.movierecord.ui.top.view.TopAdapter

class TopViewModel : ViewModel() {
    var movieListLiveData: LiveData<List<MovieItem>> = MutableLiveData()
    val adapter: TopAdapter = TopAdapter(movieListLiveData.value ?: listOf())
}
