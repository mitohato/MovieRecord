package com.ict.mito.movierecord.di

import android.app.Application
import com.ict.mito.movierecord.api.ApiClient
import com.ict.mito.movierecord.domain.db.MovieRoomDataBase
import com.ict.mito.movierecord.domain.db.dao.MovieDAO
import com.ict.mito.movierecord.repo.NetRepository
import com.ict.mito.movierecord.repo.Repository
import com.ict.mito.movierecord.repo.impl.RepositoryImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import javax.inject.Singleton

/**
 * Created by mitohato14 on 2020/06/15.
 */
@InstallIn(ApplicationComponent::class)
@Module
object AppModule {
  @Provides
  @Singleton
  fun provideNetRepository(apiClient: ApiClient): NetRepository = NetRepository(apiClient)

  @Provides
  @Singleton
  fun provideRepository(impl: RepositoryImpl): Repository = impl

  @Provides
  @Singleton
  fun provideApiClient(): ApiClient = ApiClient()

  @Provides
  @Singleton
  fun provideDataBase(application: Application): MovieRoomDataBase =
    MovieRoomDataBase.getDataBase(application.applicationContext)

  @Provides
  @Singleton
  fun provideDao(dataBase: MovieRoomDataBase): MovieDAO = dataBase.movieDao()
}
