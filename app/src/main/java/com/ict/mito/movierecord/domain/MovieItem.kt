package com.ict.mito.movierecord.domain

import androidx.room.Entity
import androidx.room.PrimaryKey

/**
 * Created by mitohato14 on 2019/04/08.
 */
@Entity(tableName = "movierecord_movie_table")
data class MovieItem(
    val id: Int,
    val title: String,
    val description: String,
    val imageUrl: String,
    var watched: Boolean = false
) {
    @PrimaryKey(autoGenerate = true)
    var primaryId: Long = 0
}
