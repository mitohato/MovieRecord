package com.ict.mito.movierecord.ui.detail

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.ict.mito.movierecord.repo.NetRepository
import com.ict.mito.movierecord.repo.Repository

/**
 * Created by mitohato14 on 2020/06/15.
 */
class DetailViewModelFactory(
    private val netRepository: NetRepository,
    private val repository: Repository
) : ViewModelProvider.NewInstanceFactory() {
    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return DetailViewModel(
            netRepository,
            repository
        ) as T
    }
}
