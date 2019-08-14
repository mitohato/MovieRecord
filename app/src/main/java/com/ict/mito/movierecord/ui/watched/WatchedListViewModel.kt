package com.ict.mito.movierecord.ui.watched

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.ict.mito.movierecord.repo.Repository
import com.xwray.groupie.GroupAdapter
import com.xwray.groupie.databinding.ViewHolder
import io.reactivex.rxkotlin.subscribeBy
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch
import kotlin.coroutines.CoroutineContext

class WatchedListViewModel(private val repository: Repository) : ViewModel() {
    val bindableRowItemList: MutableLiveData<ArrayList<WatchedListRowItem>> = MutableLiveData()
    val groupAdapter: GroupAdapter<ViewHolder<*>> = GroupAdapter()

    private val parentJob = Job()
    private val mainCoroutineContext: CoroutineContext
        get() = parentJob + Dispatchers.Main
    private val scope = CoroutineScope(mainCoroutineContext)

    init {
        scope.launch(Dispatchers.IO) {
            repository.getAllMovie().subscribeBy(
                onSuccess = {
                    val list = arrayListOf<WatchedListRowItem>()
                    it.forEach { item ->
                        list.add(WatchedListRowItem(item))
                    }
                    bindableRowItemList.postValue(list)
                },
                onError = {
                    throw it
                }
            )
        }
    }
}
