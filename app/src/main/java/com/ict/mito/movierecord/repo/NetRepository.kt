package com.ict.mito.movierecord.repo

import com.ict.mito.movierecord.BuildConfig
import com.ict.mito.movierecord.api.ApiClient
import com.ict.mito.movierecord.api.response.MovieDetailResponseData
import com.ict.mito.movierecord.api.response.NowPlayingMovieList
import kotlinx.coroutines.async
import kotlinx.coroutines.runBlocking

/**
 * Created by mitohato14 on 2019-06-22.
 */
class NetRepository(private val apiClient: ApiClient) {
  private val apiKey: String = BuildConfig.MOVIE_DB_API_KEY_V3
  fun getNowPlayingMovieList(): NowPlayingMovieList? {
    var list: NowPlayingMovieList? = null
    runBlocking {
      val job = async { apiClient.service.getNowPlayingMovieList(apiKey) }
      val res = job.await()
      if (res.isSuccessful) {
        list = res.body()
      }
    }
    return list
  }

  fun getMovieDetail(movieId: Int): MovieDetailResponseData? {
    var responseData: MovieDetailResponseData? = null
    runBlocking {
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
    }
    return responseData
  }
}