package com.ict.mito.movierecord

import android.app.Application
import org.koin.core.context.startKoin
import org.koin.core.module.Module

/**
 * Created by mitohato14 on 2019/04/02.
 */
class App : Application() {

    override fun onCreate() {
        super.onCreate()

        startKoin { module }
    }

    private val module: Module = org.koin.dsl.module {
//        factory { HogeViewModel }
    }
}
