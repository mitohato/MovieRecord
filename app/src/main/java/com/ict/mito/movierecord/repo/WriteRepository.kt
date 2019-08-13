package com.ict.mito.movierecord.repo

import com.ict.mito.movierecord.domain.MovieItem

/**
 * Created by mitohato14 on 2019-08-13.
 */
interface WriteRepository {
    fun add(movieItem: MovieItem)
}
