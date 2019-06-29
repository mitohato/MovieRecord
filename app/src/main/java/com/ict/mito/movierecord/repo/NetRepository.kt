package com.ict.mito.movierecord.repo

import com.ict.mito.movierecord.BuildConfig
import com.ict.mito.movierecord.api.MovieAPI
import com.ict.mito.movierecord.api.response.MovieDetailResponseData
import com.ict.mito.movierecord.api.response.NowPlayingMovieList
import com.squareup.moshi.Moshi
import kotlinx.coroutines.async
import kotlinx.coroutines.runBlocking
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
    private val baseUrl = BuildConfig.MOVIE_DB_BASE_URL
    private val apiKey = BuildConfig.MOVIE_DB_API_KEY_V3
    private var retrofit: Retrofit
    private val service: MovieAPI
    private val okHttpClient = OkHttpClient
        .Builder()
        .connectTimeout(
            120,
            TimeUnit.SECONDS
        )
        .readTimeout(
            120,
            TimeUnit.SECONDS
        )
        .addInterceptor(HttpLoggingInterceptor().apply {
            level = HttpLoggingInterceptor.Level.BODY
        })
        .build()

    init {
        val moshi = Moshi.Builder()
            .add(com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory())
            .build()

        retrofit = Retrofit.Builder()
            .baseUrl(baseUrl)
            .addConverterFactory(MoshiConverterFactory.create(moshi))
            .client(okHttpClient)
            .build()

        service = retrofit.create(MovieAPI::class.java)
    }

    fun getNowPlayingMovieList(): NowPlayingMovieList? {
        var list: NowPlayingMovieList? = null
        runBlocking {
            val job = async { service.getNowPlayingMovieList(apiKey) }
            val res = job.await()
            if (res.isSuccessful) {
                list = res.body()
            }
        }
        return list
    }

    fun getMovieDetail(movieId: Int): Response<MovieDetailResponseData> {
        var responseData: MovieDetailResponseData? = null
        runBlocking {
            val job = async {
                service.getMovieDetail(
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