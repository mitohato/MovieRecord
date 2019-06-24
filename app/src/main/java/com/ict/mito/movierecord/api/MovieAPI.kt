package com.ict.mito.movierecord.api

import com.ict.mito.movierecord.domain.MovieDetailResponseData
import com.ict.mito.movierecord.domain.NowPlayingMovieList
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

/**
 * Created by mitohato14 on 2019-04-21.
 */
interface MovieAPI {

    @GET("movie/{movie_id}")
    fun getMovieDetail(
        @Path("movie_id") id: Int,
        @Query("api_key") apiKey: String,
        @Query("language") language: String = "ja"
    ): Call<MovieDetailResponseData>

    @GET("movie/now_playing")
    fun getNowPlayingMovieList(
        @Query("api_key") apiKey: String,
        @Query("language") language: String = "ja"
    ): Call<NowPlayingMovieList>
}