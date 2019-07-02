package com.ict.mito.movierecord.api.response

import com.squareup.moshi.Json

/**
 * Created by mitohato14 on 2019-06-19.
 */
data class MovieDetailResponseData(
    @Json(name = "adult")val adult: Boolean,
    @Json(name = "backdrop_path")val backdropPath: String?,
    @Json(name = "belongs_to_collection")val belongsToCollection: Any?,
    @Json(name = "budget")val budget: Int,
    @Json(name = "genres")val genres: Array<Genre>,
    @Json(name = "homepage")val homepage: String?,
    @Json(name = "id")val id: Int,
    @Json(name = "imdb_id")val imdbId: String?,
    @Json(name = "original_language")val originalLanguage: String,
    @Json(name = "original_title")val originalTitle: String,
    @Json(name = "overview")val overview: String?,
    @Json(name = "popularity")val popularity: Double,
    @Json(name = "poster_path")val posterPath: String?,
    @Json(name = "production_companies")val productionCompanies: Array<ProductionCompany>,
    @Json(name = "production_countries")val productionCountries: Array<ProducitonCountry>,
    @Json(name = "release_date")val releaseDate: String,
    @Json(name = "revenue")val revenue: Int,
    @Json(name = "runtime")val runtime: Int?,
    @Json(name = "spoken_languages")val spokenLanguages: Array<SpokenLanguage>,
    @Json(name = "status")val status: String,
    @Json(name = "tagline")val tagline: String?,
    @Json(name = "title")val title: String,
    @Json(name = "video")val video: Boolean,
    @Json(name = "vote_average")val voteAverage: Double,
    @Json(name = "vote_count")val voteCount: Int
) {
    override fun equals(other: Any?): Boolean {
        return if (other is MovieDetailResponseData) {
            id == other.id
        } else {
            false
        }
    }

    override fun hashCode(): Int {
        var result = adult.hashCode()
        result = 31 * result + (backdropPath?.hashCode() ?: 0)
        result = 31 * result + (belongsToCollection?.hashCode() ?: 0)
        result = 31 * result + budget
        result = 31 * result + genres.contentHashCode()
        result = 31 * result + (homepage?.hashCode() ?: 0)
        result = 31 * result + id
        result = 31 * result + (imdbId?.hashCode() ?: 0)
        result = 31 * result + originalLanguage.hashCode()
        result = 31 * result + originalTitle.hashCode()
        result = 31 * result + (overview?.hashCode() ?: 0)
        result = 31 * result + popularity.hashCode()
        result = 31 * result + (posterPath?.hashCode() ?: 0)
        result = 31 * result + productionCompanies.contentHashCode()
        result = 31 * result + productionCountries.contentHashCode()
        result = 31 * result + releaseDate.hashCode()
        result = 31 * result + revenue
        result = 31 * result + (runtime ?: 0)
        result = 31 * result + spokenLanguages.contentHashCode()
        result = 31 * result + status.hashCode()
        result = 31 * result + (tagline?.hashCode() ?: 0)
        result = 31 * result + title.hashCode()
        result = 31 * result + video.hashCode()
        result = 31 * result + voteAverage.hashCode()
        result = 31 * result + voteCount
        return result
    }
}
