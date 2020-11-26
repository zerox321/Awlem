package com.semi.awlem.di

import com.jakewharton.retrofit2.adapter.kotlin.coroutines.CoroutineCallAdapterFactory
import com.semi.home.home.HomeClient
import com.semi.home.home.HomeService
import com.semi.home.menu.staticPage.StaticPageClient
import com.semi.home.menu.staticPage.StaticPageService
import com.semi.network.BuildConfig
import com.semi.network.EndPoint
import com.semi.network.RequestInterceptor
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import java.util.concurrent.TimeUnit
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {


    @Provides
    @Singleton
    fun provideOkHttpClient(): OkHttpClient {
        return OkHttpClient.Builder()
            .addInterceptor(RequestInterceptor())
            .connectTimeout(EndPoint.timeOut, TimeUnit.SECONDS)
            .readTimeout(EndPoint.timeOut, TimeUnit.SECONDS)
            .writeTimeout(EndPoint.timeOut, TimeUnit.SECONDS)
            .build()
    }

    @Provides
    @Singleton
    fun provideMoshi(): Moshi {
        return Moshi.Builder()
            .add(KotlinJsonAdapterFactory())
            .build()
    }

    @Provides
    @Singleton
    fun provideRetrofit(okHttpClient: OkHttpClient, moshi: Moshi): Retrofit {
        return Retrofit.Builder()
            .client(okHttpClient)
            .baseUrl(BuildConfig.baseUrl)
            .addConverterFactory(MoshiConverterFactory.create(moshi))
            .addCallAdapterFactory(CoroutineCallAdapterFactory())
            .build()
    }


    @Provides
    @Singleton
    fun provideHomeService(retrofit: Retrofit): HomeService {
        return retrofit.create(HomeService::class.java)
    }

    @Provides
    @Singleton
    fun provideHomeClient(service: HomeService): HomeClient {
        return HomeClient(service)
    }

    @Provides
    @Singleton
    fun provideStaticPageService(retrofit: Retrofit): StaticPageService {
        return retrofit.create(StaticPageService::class.java)
    }

    @Provides
    @Singleton
    fun provideStaticPageClient(service: StaticPageService): StaticPageClient {
        return StaticPageClient(service)
    }


}
