package com.ict.mito.movierecord.repo

import com.ict.mito.movierecord.BuildConfig
import com.ict.mito.movierecord.api.ApiClient
import com.ict.mito.movierecord.api.response.MovieDetailResponseData
import com.ict.mito.movierecord.api.response.NowPlayingMovieList
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import kotlinx.coroutines.withContext
import javax.inject.Inject

/**
 * Created by mitohato14 on 2019-06-22.
 */
class NetRepository @Inject constructor(private val apiClient: ApiClient) {
  private val apiKey: String = BuildConfig.MOVIE_DB_API_KEY_V3
  suspend fun getNowPlayingMovieList(): NowPlayingMovieList? = withContext(Dispatchers.IO) {
    var list: NowPlayingMovieList? = null
    val job = async { apiClient.service.getNowPlayingMovieList(apiKey) }
    val res = job.await()
    if (res.isSuccessful) {
      list = res.body()
    }
    list
  }

  suspend fun getMovieDetail(movieId: Int): MovieDetailResponseData? = withContext(Dispatchers.IO) {
    var responseData: MovieDetailResponseData? = null
    val job = async {
      apiClient.service.getMovieDetail(
        movieId,
        apiKey
      )
    }
    val res = job.await()
    if (res.isSuccessful) {
      responseData = res.body()
    }
    responseData
  }
}
