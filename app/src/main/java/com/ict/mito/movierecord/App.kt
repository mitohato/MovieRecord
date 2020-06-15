package com.ict.mito.movierecord

import android.app.Application
import com.ict.mito.movierecord.api.ApiClient
import com.ict.mito.movierecord.domain.db.MovieRoomDataBase
import com.ict.mito.movierecord.domain.db.dao.MovieDAO
import com.ict.mito.movierecord.repo.NetRepository
import com.ict.mito.movierecord.repo.Repository
import com.ict.mito.movierecord.repo.impl.RepositoryImpl
import com.ict.mito.movierecord.ui.detail.DetailViewModel
import com.ict.mito.movierecord.ui.top.TopViewModel
import com.ict.mito.movierecord.ui.watched.WatchedListViewModel
import org.koin.android.ext.koin.androidContext
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.core.context.startKoin
import org.koin.core.module.Module
import org.koin.dsl.module

/**
 * Created by mitohato14 on 2019/04/02.
 */
@Suppress("unused")
class App : Application() {

  override fun onCreate() {
    super.onCreate()

    startKoin {
      // declare used Android context
      androidContext(this@App)
      // declare modules
      modules(
        listOf(
          viewModelModule,
          repositoryModule,
          apiModule,
          dataBaseModule
        )
      )
    }
  }

  private val viewModelModule: Module = module {
    viewModel { TopViewModel(get()) }
    viewModel { WatchedListViewModel(get()) }
    viewModel {
      DetailViewModel(
        get(),
        get()
      )
    }
  }

  private val repositoryModule: Module = module {
    single { NetRepository(get()) }
    @Suppress("USELESS_CAST")
    single { RepositoryImpl(get() as MovieDAO) as Repository }
  }

  private val apiModule: Module = module {
    single { ApiClient() }
  }

  private val dataBaseModule: Module = module {
    single { MovieRoomDataBase.getDataBase(androidContext()) }
    single { get<MovieRoomDataBase>().movieDao() }
  }
}
