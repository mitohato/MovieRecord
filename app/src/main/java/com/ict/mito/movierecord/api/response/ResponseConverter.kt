package com.ict.mito.movierecord.api.response

import com.ict.mito.movierecord.BuildConfig
import com.ict.mito.movierecord.domain.DetailMovieItem
import com.ict.mito.movierecord.domain.MovieItem

/**
 * Created by mitohato14 on 2019-06-28.
 */
class ResponseConverter {
    fun convertToMovieItemFromNowPlayingList(response: MovieNowPlayingListResponseData): MovieItem {
        val imageBaseUrl: String = BuildConfig.MOVIE_DB_IMAGE_BASE_URL
        return MovieItem(
            title = response.title,
            description = response.overview,
            id = response.id,
            imageUrl = imageBaseUrl + response.posterPath
        )
    }

    fun convertToDetailMovieItemFromMovieDetail(response: MovieDetailResponseData): DetailMovieItem {
        val imageBaseUrl: String = BuildConfig.MOVIE_DB_IMAGE_BASE_URL
        return DetailMovieItem(
            movieId = response.id,
            genres = response.genres,
            homepageUrl = response.homepage ?: "",
            originalLanguage = response.originalLanguage,
            originalTitle = response.originalTitle,
            overview = response.overview ?: "",
            popularity = response.popularity,
            posterPath = imageBaseUrl + response.posterPath,
            releaseDate = response.releaseDate,
            spokenLanguage = response.spokenLanguages,
            title = response.title
        )
    }
}