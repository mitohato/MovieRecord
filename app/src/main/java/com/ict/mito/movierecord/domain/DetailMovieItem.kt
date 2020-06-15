package com.ict.mito.movierecord.domain

import com.ict.mito.movierecord.api.response.Genre
import com.ict.mito.movierecord.api.response.SpokenLanguage

/**
 * Created by mitohato14 on 2019-08-18.
 */
data class DetailMovieItem(
  val movieId: Int,
  val genres: Array<Genre>,
  val homepageUrl: String,
  val originalLanguage: String,
  val originalTitle: String,
  val overview: String,
  val popularity: Double,
  val posterPath: String,
  val releaseDate: String,
  val spokenLanguage: Array<SpokenLanguage>,
  val title: String,
  var watched: Boolean = false
) {
  override fun equals(other: Any?): Boolean {
    if (this === other) return true
    if (javaClass != other?.javaClass) return false

    other as DetailMovieItem

    if (movieId != other.movieId) return false
    if (!genres.contentEquals(other.genres)) return false
    if (homepageUrl != other.homepageUrl) return false
    if (originalLanguage != other.originalLanguage) return false
    if (originalTitle != other.originalTitle) return false
    if (overview != other.overview) return false
    if (popularity != other.popularity) return false
    if (posterPath != other.posterPath) return false
    if (releaseDate != other.releaseDate) return false
    if (!spokenLanguage.contentEquals(other.spokenLanguage)) return false
    if (title != other.title) return false

    return true
  }

  override fun hashCode(): Int {
    var result = movieId
    result = 31 * result + genres.contentHashCode()
    result = 31 * result + homepageUrl.hashCode()
    result = 31 * result + originalLanguage.hashCode()
    result = 31 * result + originalTitle.hashCode()
    result = 31 * result + overview.hashCode()
    result = 31 * result + popularity.hashCode()
    result = 31 * result + posterPath.hashCode()
    result = 31 * result + releaseDate.hashCode()
    result = 31 * result + spokenLanguage.contentHashCode()
    result = 31 * result + title.hashCode()
    return result
  }
}
