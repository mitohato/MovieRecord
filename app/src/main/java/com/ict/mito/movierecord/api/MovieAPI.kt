package com.ict.mito.movierecord.api

import retrofit2.http.GET

/**
 * Created by mitohato14 on 2019-04-21.
 */
interface MovieAPI {

    fun getMovieList()

    fun getMovieInfo()

    @GET("movie/now_playing")
    fun getNowPlayingMovieList()
}