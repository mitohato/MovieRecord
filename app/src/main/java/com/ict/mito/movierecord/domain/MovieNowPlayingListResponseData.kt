package com.ict.mito.movierecord.domain

/**
 * Created by mitohato14 on 2019-06-19.
 */
data class MovieNowPlayingListResponseData(
    val vote_count: Int,
    val id: Int,
    val video: Boolean,
    val vote_averages: Float,
    val title: String,
    val popularity: Float,
    val poster_path: String,
    val original_language: String,
    val original_title: String,
    val genre_ids: IntArray,
    val backdrop_path: String,
    val adult: Boolean,
    val overview: String,
    val release_date: String
) {
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as MovieNowPlayingListResponseData

        if (vote_count != other.vote_count) return false
        if (id != other.id) return false
        if (video != other.video) return false
        if (vote_averages != other.vote_averages) return false
        if (title != other.title) return false
        if (popularity != other.popularity) return false
        if (poster_path != other.poster_path) return false
        if (original_language != other.original_language) return false
        if (original_title != other.original_title) return false
        if (!genre_ids.contentEquals(other.genre_ids)) return false
        if (backdrop_path != other.backdrop_path) return false
        if (adult != other.adult) return false
        if (overview != other.overview) return false
        if (release_date != other.release_date) return false

        return true
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
