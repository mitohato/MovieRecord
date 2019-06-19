package com.ict.mito.movierecord.ui.top

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.ict.mito.movierecord.domain.DummyData
import com.xwray.groupie.GroupAdapter
import com.xwray.groupie.databinding.ViewHolder

class TopViewModel : ViewModel() {
    val bindableRowItemList: MutableLiveData<ArrayList<TopRowItem>> = MutableLiveData()
    val groupAdapter: GroupAdapter<ViewHolder<*>> = GroupAdapter()

    init {
        DummyData.data.forEach {
            bindableRowItemList.value?.add(TopRowItem(it))
        }
        groupAdapter.update(bindableRowItemList.value ?: arrayListOf())
    }
}
