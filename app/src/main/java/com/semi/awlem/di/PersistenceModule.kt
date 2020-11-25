package com.semi.awlem.di

import android.content.Context
import com.semi.awlem.BuildConfig
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


//    @Provides
//    @Singleton
//    fun provideAppDatabase(@ApplicationContext appContext: Context): AppDatabase {
//        return Room.databaseBuilder(
//            appContext,
//            AppDatabase::class.java,
//            appContext.getString(R.string.app_db)
//        )
//            .allowMainThreadQueries()
//            .fallbackToDestructiveMigration()
//            .build()
//    }
//
//    ////////////////////////////////////////////////////////////////////////////////////////////////////
//    @Provides
//    @Singleton
//    fun provideCarColorDao(database: AppDatabase): CarColorDao {
//        return database.carColorDao()
//    }
//
//    @Provides
//    @Singleton
//    fun provideCarColorController(dao: CarColorDao): CarColorController {
//        return CarColorController(dao = dao)
//    }

////////////////////////////////////////////////////////////////////////////////////////////////////


}
