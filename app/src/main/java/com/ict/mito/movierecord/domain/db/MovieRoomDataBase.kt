package com.ict.mito.movierecord.domain.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.ict.mito.movierecord.domain.MovieItem

/**
 * Created by mitohato14 on 2019-08-11.
 */
@Database(
    entities = [MovieItem::class],
    version = 1,
    exportSchema = false
)
abstract class MovieRoomDataBase : RoomDatabase() {
}