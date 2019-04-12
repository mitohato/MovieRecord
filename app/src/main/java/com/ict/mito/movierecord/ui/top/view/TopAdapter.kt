package com.ict.mito.movierecord.ui.top.view

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.ict.mito.movierecord.databinding.MovieCardBinding
import com.ict.mito.movierecord.domain.MovieItem

/**
 * Created by mitohato14 on 2019/04/07.
 */
class TopAdapter(private var movieList: List<MovieItem>) : RecyclerView.Adapter<TopAdapter.TopViewHolder>() {

    fun setMovieItemList(movieItemList: List<MovieItem>) {
        movieList = movieItemList
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): TopViewHolder = TopViewHolder.create(
        LayoutInflater.from(parent.context),
        parent,
        false
    )

    override fun getItemCount(): Int = movieList.size

    override fun onBindViewHolder(
        holder: TopViewHolder,
        position: Int
    ) {
        holder.bind(movieList[position])
    }

    class TopViewHolder(private val binding: MovieCardBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(movieItem: MovieItem) {
            binding.also {
                it.movieItem = movieItem
                it.executePendingBindings()
            }
        }

        fun unbind() {
            binding.unbind()
        }

        fun setOnClickListener(onClickListener: View.OnClickListener) {
            binding.root.setOnClickListener(onClickListener)
        }

        companion object {
            fun create(
                inflater: LayoutInflater,
                parent: ViewGroup,
                attachToRoot: Boolean
            ): TopViewHolder = TopViewHolder(
                MovieCardBinding.inflate(
                    inflater,
                    parent,
                    attachToRoot
                )
            )
        }
    }
}