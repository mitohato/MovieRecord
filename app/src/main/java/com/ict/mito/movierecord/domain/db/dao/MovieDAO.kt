package com.ict.mito.movierecord.domain.db.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import com.ict.mito.movierecord.domain.MovieItem

/**
 * Created by mitohato14 on 2019-08-11.
 */
@Dao
interface MovieDAO {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(movieItem: MovieItem)
}