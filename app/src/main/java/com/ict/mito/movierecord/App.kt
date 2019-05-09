package com.ict.mito.movierecord

import android.app.Application
import com.ict.mito.movierecord.repo.Repository
import com.ict.mito.movierecord.ui.top.TopViewModel
import org.koin.android.ext.koin.androidContext
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.core.context.startKoin
import org.koin.core.module.Module

/**
 * Created by mitohato14 on 2019/04/02.
 */
class App : Application() {

    override fun onCreate() {
        super.onCreate()

        startKoin {
            // declare used Android context
            androidContext(this@App)
            // declare modules
            modules(
                viewModelModule,
                repositoryModule
            )
        }
    }

    private val viewModelModule: Module = org.koin.dsl.module {
        viewModel { TopViewModel(get()) }
    }

    private val repositoryModule: Module = org.koin.dsl.module {
        factory { RepositoryImpl() as Repository }
    }
}
