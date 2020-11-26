package com.semi.awlem.di

import com.semi.awlem.ui.home.home.HomeRepository
import com.semi.awlem.ui.home.menu.help.HelpRepository
import com.semi.awlem.ui.home.menu.staticPage.StaticRepository
import com.semi.entity.database.categoryController.CategoryController
import com.semi.entity.database.faqController.FaqController
import com.semi.entity.sharedPref.Pref
import com.semi.home.home.HomeClient
import com.semi.home.menu.faq.FaqClient
import com.semi.home.menu.staticPage.StaticPageClient
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
    fun provideHomeRepository(
        client: HomeClient,
        categoryController: CategoryController
    ): HomeRepository {
        return HomeRepository(client, categoryController)
    }


    @Provides
    @Singleton
    fun provideStaticRepository(
        client: StaticPageClient,
        pref: Pref
    ): StaticRepository {
        return StaticRepository(client, pref)
    }

    @Provides
    @Singleton
    fun provideHelpRepository(
        client: FaqClient,
        faqController: FaqController
    ): HelpRepository {
        return HelpRepository(client, faqController)
    }


}
