package com.ict.mito.movierecord.api.response

import com.squareup.moshi.Json

/**
 * Created by mitohato14 on 2019-06-19.
 */
data class MovieNowPlayingListResponseData(
  @Json(name = "vote_count") val voteCount: Int,
  @Json(name = "id") val id: Int,
  @Json(name = "video") val video: Boolean,
  @Json(name = "vote_average") val voteAverage: Double,
  @Json(name = "title") val title: String,
  @Json(name = "popularity") val popularity: Double,
  @Json(name = "poster_path") val posterPath: String?,
  @Json(name = "original_language") val originalLanguage: String,
  @Json(name = "original_title") val originalTitle: String,
  @Json(name = "genre_ids") val genreIds: Array<Int>,
  @Json(name = "backdrop_path") val backdropPath: String?,
  @Json(name = "adult") val adult: Boolean,
  @Json(name = "overview") val overview: String,
  @Json(name = "release_date") val releaseDate: String
) {
  override fun equals(other: Any?): Boolean {
    return if (other is MovieDetailResponseData) {
      id == other.id
    } else {
      false
    }
  }

  override fun hashCode(): Int {
    var result = voteCount
    result = 31 * result + id
    result = 31 * result + video.hashCode()
    result = 31 * result + voteAverage.hashCode()
    result = 31 * result + title.hashCode()
    result = 31 * result + popularity.hashCode()
    result = 31 * result + posterPath.hashCode()
    result = 31 * result + originalLanguage.hashCode()
    result = 31 * result + originalTitle.hashCode()
    result = 31 * result + genreIds.contentHashCode()
    result = 31 * result + backdropPath.hashCode()
    result = 31 * result + adult.hashCode()
    result = 31 * result + overview.hashCode()
    result = 31 * result + releaseDate.hashCode()
    return result
  }
}
