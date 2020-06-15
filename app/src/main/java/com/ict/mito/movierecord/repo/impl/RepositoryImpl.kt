package com.ict.mito.movierecord.repo.impl

import androidx.annotation.WorkerThread
import com.ict.mito.movierecord.domain.MovieItem
import com.ict.mito.movierecord.domain.db.dao.MovieDAO
import com.ict.mito.movierecord.repo.Repository
import io.reactivex.Single
import javax.inject.Inject

/**
 * Created by mitohato14 on 2019-08-13.
 */
class RepositoryImpl @Inject constructor(private val dao: MovieDAO) : Repository {
    @WorkerThread
    override fun getAllMovie(): Single<List<MovieItem>> = dao.getAllMovie()

    @WorkerThread
    override fun add(movieItem: MovieItem) = dao.insert(movieItem)
}
