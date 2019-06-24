package com.ict.mito.movierecord.repo

import com.ict.mito.movierecord.api.MovieAPI
import com.ict.mito.movierecord.domain.MovieDetailResponseData
import com.ict.mito.movierecord.domain.NowPlayingMovieList
import com.squareup.moshi.KotlinJsonAdapterFactory
import com.squareup.moshi.Moshi
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import java.util.concurrent.TimeUnit

/**
 * Created by mitohato14 on 2019-06-22.
 */
class NetRepository {
    private val baseUrl = ""
    private val apiKey = ""
    private var retrofit: Retrofit
    private val service: MovieAPI
    private val okHttpClient = OkHttpClient
        .Builder()
        .connectTimeout(120, TimeUnit.SECONDS)
        .readTimeout(120, TimeUnit.SECONDS)
        .addInterceptor(HttpLoggingInterceptor().apply {
            level = HttpLoggingInterceptor.Level.BODY
        })
        .build()

    init {
        val moshi = Moshi.Builder()
            .add(KotlinJsonAdapterFactory())
            .build()

        retrofit = Retrofit.Builder()
            .baseUrl(baseUrl)
            .addConverterFactory(MoshiConverterFactory.create(moshi))
            .client(okHttpClient)
            .build()

        service = retrofit.create(MovieAPI::class.java)
    }

    fun getNowPlayingMovieList(): Response<NowPlayingMovieList> {
        return service.getNowPlayingMovieList(apiKey).execute()
    }

    fun getMovieDetail(movieId: Int): Response<MovieDetailResponseData> {
        return service.getMovieDetail(
            movieId,
            apiKey
        ).execute()
    }
}