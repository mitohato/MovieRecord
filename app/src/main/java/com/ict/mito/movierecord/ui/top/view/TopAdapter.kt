package com.ict.mito.movierecord.ui.top.view

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.ict.mito.movierecord.databinding.MovieCardContentBinding
import com.ict.mito.movierecord.domain.MovieItem

/**
 * Created by mitohato14 on 2019/04/07.
 */
class TopAdapter(private val movieList: List<MovieItem>) : RecyclerView.Adapter<TopAdapter.TopViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TopViewHolder {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun getItemCount(): Int {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun onBindViewHolder(holder: TopViewHolder, position: Int) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    inner class TopViewHolder(private val binding: MovieCardContentBinding) : RecyclerView.ViewHolder(binding.root) {

    }
}