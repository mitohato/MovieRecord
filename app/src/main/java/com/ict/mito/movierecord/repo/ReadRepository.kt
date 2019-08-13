package com.ict.mito.movierecord.repo

import com.ict.mito.movierecord.domain.MovieItem
import io.reactivex.Single

/**
 * Created by mitohato14 on 2019-08-13.
 */
interface ReadRepository {
    fun getAllMovie(): Single<List<MovieItem>>
}