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
        result = 31 * result + (backdrop_path?.hashCode() ?: 0)
        result = 31 * result + (belongs_to_collection?.hashCode() ?: 0)
        result = 31 * result + budget
        result = 31 * result + genres.contentHashCode()
        result = 31 * result + (homepage?.hashCode() ?: 0)
        result = 31 * result + id
        result = 31 * result + (imdb_id?.hashCode() ?: 0)
        result = 31 * result + original_language.hashCode()
        result = 31 * result + original_title.hashCode()
        result = 31 * result + (overview?.hashCode() ?: 0)
        result = 31 * result + popularity.hashCode()
        result = 31 * result + (poster_path?.hashCode() ?: 0)
        result = 31 * result + production_companies.contentHashCode()
        result = 31 * result + production_countries.contentHashCode()
        result = 31 * result + release_date.hashCode()
        result = 31 * result + revenue
        result = 31 * result + (runtime ?: 0)
        result = 31 * result + spokenLanguages.contentHashCode()
        result = 31 * result + status.hashCode()
        result = 31 * result + (tagline?.hashCode() ?: 0)
        result = 31 * result + title.hashCode()
        result = 31 * result + video.hashCode()
        result = 31 * result + vote_average.hashCode()
        result = 31 * result + vote_count
        return result
    }
}
