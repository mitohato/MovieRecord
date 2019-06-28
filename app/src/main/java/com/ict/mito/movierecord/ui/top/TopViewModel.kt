package com.ict.mito.movierecord.ui.top

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.ict.mito.movierecord.api.response.ResponseConverter
import com.ict.mito.movierecord.repo.NetRepository
import com.xwray.groupie.GroupAdapter
import com.xwray.groupie.databinding.ViewHolder

class TopViewModel(private val repository: NetRepository) : ViewModel() {
    val bindableRowItemList: MutableLiveData<ArrayList<TopRowItem>> = MutableLiveData()
    val groupAdapter: GroupAdapter<ViewHolder<*>> = GroupAdapter()

    init {
        bindableRowItemList.value = arrayListOf()
        val response = repository.getNowPlayingMovieList()
        if (response.isSuccessful) {

            response.body()?.results?.forEach {
                bindableRowItemList.value?.add(TopRowItem(ResponseConverter().convertToMovieItemFromNowPlayingList(it)))
            }

        }
        groupAdapter.update(bindableRowItemList.value ?: arrayListOf())
    }
}
