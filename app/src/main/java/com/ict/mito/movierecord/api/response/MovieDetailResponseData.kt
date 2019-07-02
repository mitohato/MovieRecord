package com.ict.mito.movierecord.api.response

/**
 * Created by mitohato14 on 2019-06-19.
 */
data class MovieDetailResponseData(
    val adult: Boolean,
    val backdrop_path: String?,
    val belongs_to_collection: Any?,
    val budget: Int,
    val genres: Array<Genre>,
    val homepage: String?,
    val id: Int,
    val imdb_id: String?,
    val original_language: String,
    val original_title: String,
    val overview: String?,
    val popularity: Double,
    val poster_path: String?,
    val production_companies: Array<ProductionCompany>,
    val production_countries: Array<ProducitonCountry>,
    val release_date: String,
    val revenue: Int,
    val runtime: Int?,
    val spokenLanguages: Array<SpokenLanguage>,
    val status: String,
    val tagline: String?,
    val title: String,
    val video: Boolean,
    val vote_average: Double,
    val vote_count: Int
)
