package com.ict.mito.movierecord.api.response

import com.ict.mito.movierecord.domain.MovieItem

/**
 * Created by mitohato14 on 2019-06-28.
 */
class ResponseConverter {
    fun convertToMovieItemFromNowPlayingList(response: MovieNowPlayingListResponseData): MovieItem {
        return MovieItem(
            title = response.title,
            description = response.overview,
            movieId = "${response.id}",
            imageUrl = response.poster_path
        )
    }
}