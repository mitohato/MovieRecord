package com.ict.mito.movierecord.ui.watched

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.ict.mito.movierecord.repo.Repository
import com.xwray.groupie.GroupAdapter
import com.xwray.groupie.databinding.ViewHolder

class WatchedListViewModel(private val repository: Repository) : ViewModel() {
    val bindableRowItemList: MutableLiveData<ArrayList<WatchedListRowItem>> = MutableLiveData()
    val groupAdapter: GroupAdapter<ViewHolder<*>> = GroupAdapter()
}
