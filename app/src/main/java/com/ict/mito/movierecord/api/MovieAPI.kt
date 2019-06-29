package com.ict.mito.movierecord.api

import com.ict.mito.movierecord.api.response.MovieDetailResponseData
import com.ict.mito.movierecord.api.response.NowPlayingMovieList
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

/**
 * Created by mitohato14 on 2019-04-21.
 */
interface MovieAPI {

    @GET("movie/{movie_id}")
    suspend fun getMovieDetail(
        @Path("movie_id") id: Int,
        @Query("api_key") apiKey: String,
        @Query("language") language: String = "ja"
    ): Response<MovieDetailResponseData>

    @GET("movie/now_playing")
    suspend fun getNowPlayingMovieList(
        @Query("api_key") apiKey: String,
        @Query("language") language: String = "ja"
    ): Response<NowPlayingMovieList>
}