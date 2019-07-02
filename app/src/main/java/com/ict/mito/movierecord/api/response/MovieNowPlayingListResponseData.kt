package com.ict.mito.movierecord.api.response

/**
 * Created by mitohato14 on 2019-06-19.
 */
data class MovieNowPlayingListResponseData(
    val vote_count: Int,
    val id: Int,
    val video: Boolean,
    val vote_averages: Double,
    val title: String,
    val popularity: Double,
    val poster_path: String,
    val original_language: String,
    val original_title: String,
    val genre_ids: Array<Int>,
    val backdrop_path: String,
    val adult: Boolean,
    val overview: String,
    val release_date: String
) {
    override fun equals(other: Any?): Boolean {
        return if (other is MovieDetailResponseData) {
            id == other.id
        } else {
            false
        }
    }

    override fun hashCode(): Int {
        var result = vote_count
        result = 31 * result + id
        result = 31 * result + video.hashCode()
        result = 31 * result + vote_averages.hashCode()
        result = 31 * result + title.hashCode()
        result = 31 * result + popularity.hashCode()
        result = 31 * result + poster_path.hashCode()
        result = 31 * result + original_language.hashCode()
        result = 31 * result + original_title.hashCode()
        result = 31 * result + genre_ids.contentHashCode()
        result = 31 * result + backdrop_path.hashCode()
        result = 31 * result + adult.hashCode()
        result = 31 * result + overview.hashCode()
        result = 31 * result + release_date.hashCode()
        return result
    }
}
