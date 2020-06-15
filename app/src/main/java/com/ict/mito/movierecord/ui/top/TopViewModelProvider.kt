package com.ict.mito.movierecord.ui.top

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.ict.mito.movierecord.repo.NetRepository
import javax.inject.Inject

/**
 * Created by mitohato14 on 2020/06/15.
 */
class TopViewModelProvider @Inject constructor(private val repository: NetRepository) :
  ViewModelProvider.NewInstanceFactory() {
  @Suppress("UNCHECKED_CAST")
  override fun <T : ViewModel?> create(modelClass: Class<T>): T {
    return TopViewModel(repository) as T
  }
}
