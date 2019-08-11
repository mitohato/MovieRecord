package com.ict.mito.movierecord.domain

import androidx.room.Entity

/**
 * Created by mitohato14 on 2019/04/08.
 */
@Entity(tableName = "movierecord_movie_table")
data class MovieItem(
    val id: Int,
    val title: String,
    val description: String,
    val imageUrl: String
)
