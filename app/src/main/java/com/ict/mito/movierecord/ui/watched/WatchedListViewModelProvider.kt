package com.ict.mito.movierecord.ui.watched

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.ict.mito.movierecord.repo.Repository

/**
 * Created by mitohato14 on 2020/06/15.
 */
class WatchedListViewModelProvider(private val repository: Repository) :
    ViewModelProvider.NewInstanceFactory() {
    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return WatchedListViewModel(repository) as T
    }
}
