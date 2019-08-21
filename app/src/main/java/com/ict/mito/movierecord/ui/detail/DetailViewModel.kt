package com.ict.mito.movierecord.ui.detail

import android.view.View
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.ict.mito.movierecord.api.response.ResponseConverter
import com.ict.mito.movierecord.domain.DetailMovieItem
import com.ict.mito.movierecord.domain.MovieItem
import com.ict.mito.movierecord.repo.NetRepository
import com.ict.mito.movierecord.repo.Repository

class DetailViewModel(
    private val netRepository: NetRepository,
    private val repository: Repository
) : ViewModel() {
    lateinit var detailMovieItem: MutableLiveData<DetailMovieItem>
    var movieId: Int = -1
        set(value) {
            field = value
            netRepository.getMovieDetail(value)?.let {
                detailMovieItem.postValue(
                    ResponseConverter().convertToDetailMovieItemFromMovieDetail(it)
                )
            }
        }

    fun addToWatchedList(view: View) {
        detailMovieItem.value.also {
            repository.add(
                MovieItem(
                    id = it.movieId,
                    title = it.title,
                    description = it.overview,
                    imageUrl = it.posterPath,
                    watched = it.watched
                )
            )
        }
    }
}
