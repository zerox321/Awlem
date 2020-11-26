package com.semi.awlem.di

import android.content.Context
import androidx.room.Room
import com.semi.awlem.BuildConfig
import com.semi.awlem.R
import com.semi.entity.database.AppDatabase
import com.semi.entity.database.categoryController.CategoryController
import com.semi.entity.database.categoryController.CategoryDao
import com.semi.entity.database.faqController.FaqController
import com.semi.entity.database.faqController.FaqDao
import com.semi.entity.sharedPref.Pref
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object PersistenceModule {

    @Provides
    @Singleton
    fun providePref(@ApplicationContext appContext: Context): Pref {
        return Pref(appContext, BuildConfig.APPLICATION_ID)
    }


    @Provides
    @Singleton
    fun provideAppDatabase(@ApplicationContext appContext: Context): AppDatabase {
        return Room.databaseBuilder(
            appContext,
            AppDatabase::class.java,
            appContext.getString(R.string.app_db)
        )
            .allowMainThreadQueries()
            .fallbackToDestructiveMigration()
            .build()
    }

    ////////////////////////////////////////////////////////////////////////////////////////////////////
    @Provides
    @Singleton
    fun provideCategoryDao(database: AppDatabase): CategoryDao {
        return database.categoryDao()
    }

    @Provides
    @Singleton
    fun provideCategoryController(dao: CategoryDao): CategoryController {
        return CategoryController(dao = dao)
    }

////////////////////////////////////////////////////////////////////////////////////////////////////

    @Provides
    @Singleton
    fun provideFaqDao(database: AppDatabase): FaqDao {
        return database.faqDao()
    }

    @Provides
    @Singleton
    fun provideFaqController(dao: FaqDao): FaqController {
        return FaqController(dao = dao)
    }

////////////////////////////////////////////////////////////////////////////////////////////////////


}
