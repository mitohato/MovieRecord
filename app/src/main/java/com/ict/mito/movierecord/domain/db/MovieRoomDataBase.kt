package com.ict.mito.movierecord.domain.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.ict.mito.movierecord.domain.MovieItem
import com.ict.mito.movierecord.domain.db.dao.MovieDAO
import javax.inject.Singleton

/**
 * Created by mitohato14 on 2019-08-11.
 */
@Database(
  entities = [MovieItem::class],
  version = 1,
  exportSchema = false
)
abstract class MovieRoomDataBase : RoomDatabase() {
  abstract fun movieDao(): MovieDAO

  companion object {
    @Singleton
    private var INSTANCE: MovieRoomDataBase? = null

    fun getDataBase(context: Context): MovieRoomDataBase {
      return INSTANCE ?: synchronized(this) {
        val instance = Room.databaseBuilder(
          context.applicationContext,
          MovieRoomDataBase::class.java,
          "movie_database"
        )
          .allowMainThreadQueries()
          .fallbackToDestructiveMigration()
          .build()
        INSTANCE = instance
        instance
      }
    }
  }
}