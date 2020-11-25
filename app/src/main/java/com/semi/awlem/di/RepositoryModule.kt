package com.semi.awlem.di

import com.semi.awlem.ui.home.home.HomeRepository
import com.semi.home.home.HomeClient
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object RepositoryModule {


    @Provides
    @Singleton
    fun provideHomeRepository(client: HomeClient): HomeRepository {
        return HomeRepository(client)
    }


}
