package com.ict.mito.movierecord.api

import com.ict.mito.movierecord.BuildConfig
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import java.util.concurrent.TimeUnit

/**
 * Created by mitohato14 on 2019-07-04.
 */
class ApiClient {
    private val baseUrl = BuildConfig.MOVIE_DB_BASE_URL
    private var retrofit: Retrofit
    val service: MovieAPI
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
            .add(KotlinJsonAdapterFactory())
            .build()

        retrofit = Retrofit.Builder()
            .baseUrl(baseUrl)
            .client(okHttpClient)
            .addConverterFactory(MoshiConverterFactory.create(moshi))
            .build()

        service = retrofit.create(MovieAPI::class.java)
    }
}