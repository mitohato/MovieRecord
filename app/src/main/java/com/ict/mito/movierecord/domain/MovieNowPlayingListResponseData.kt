package com.ict.mito.movierecord.domain

/**
 * Created by mitohato14 on 2019-06-19.
 */
data class MovieNowPlayingListResponseData(
    val vote_count: Int,
    val id: Int,
    val video: Boolean,
    val vote_averages: Number,
    val title: String,
    val popularity: Number,
    val poster_path: String,
    val original_language: String,
    val original_title: String,
    val genre_ids: Array<Int>,
    val backdrop_path: String,
    val adult: Boolean,
    val overview: String,
    val release_date: String
)
