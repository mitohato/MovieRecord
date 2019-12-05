package com.ict.mito.movierecord.util

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.squareup.picasso.Picasso

/**
 * Created by mitohato14 on 2019-07-03.
 */

@BindingAdapter("app:imageURL")
fun loadImage(
    imageView: ImageView,
    url: String?
) {
    Picasso.get().load(url).into(imageView)
}
