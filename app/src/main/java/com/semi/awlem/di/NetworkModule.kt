package com.semi.awlem.di

import com.jakewharton.retrofit2.adapter.kotlin.coroutines.CoroutineCallAdapterFactory
import com.semi.entity.sharedPref.Pref
import com.semi.home.home.HomeClient
import com.semi.home.home.HomeService
import com.semi.home.menu.faq.FaqClient
import com.semi.home.menu.faq.FaqService
import com.semi.home.menu.profile.ProfileClient
import com.semi.home.menu.profile.ProfileService
import com.semi.home.menu.rate.RateClient
import com.semi.home.menu.rate.RateService
import com.semi.home.menu.staticPage.StaticPageClient
import com.semi.home.menu.staticPage.StaticPageService
import com.semi.home.offer.OfferClient
import com.semi.home.offer.OfferService
import com.semi.network.BuildConfig
import com.semi.network.EndPoint
import com.semi.network.RequestInterceptor
import com.semi.splash.activate.ActivateClient
import com.semi.splash.activate.ActivateService
import com.semi.splash.login.LoginClient
import com.semi.splash.login.LoginService
import com.semi.splash.register.RegisterClient
import com.semi.splash.register.RegisterService
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
    fun provideOkHttpClient(
        pref: Pref
    ): OkHttpClient {
        return OkHttpClient.Builder()
            .addInterceptor(RequestInterceptor(pref))
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


    @Provides
    @Singleton
    fun provideFaqService(retrofit: Retrofit): FaqService {
        return retrofit.create(FaqService::class.java)
    }

    @Provides
    @Singleton
    fun provideFaqClient(service: FaqService): FaqClient {
        return FaqClient(service)
    }


    @Provides
    @Singleton
    fun provideLoginService(retrofit: Retrofit): LoginService {
        return retrofit.create(LoginService::class.java)
    }

    @Provides
    @Singleton
    fun provideLoginClient(service: LoginService): LoginClient {
        return LoginClient(service)
    }

    @Provides
    @Singleton
    fun provideRegisterService(retrofit: Retrofit): RegisterService {
        return retrofit.create(RegisterService::class.java)
    }

    @Provides
    @Singleton
    fun provideRegisterClient(service: RegisterService): RegisterClient {
        return RegisterClient(service)
    }

    @Provides
    @Singleton
    fun provideActivateService(retrofit: Retrofit): ActivateService {
        return retrofit.create(ActivateService::class.java)
    }

    @Provides
    @Singleton
    fun provideActivateClient(service: ActivateService): ActivateClient {
        return ActivateClient(service)
    }


    @Provides
    @Singleton
    fun provideOfferService(retrofit: Retrofit): OfferService {
        return retrofit.create(OfferService::class.java)
    }

    @Provides
    @Singleton
    fun provideOfferClient(service: OfferService): OfferClient {
        return OfferClient(service)
    }

    @Provides
    @Singleton
    fun provideRateService(retrofit: Retrofit): RateService {
        return retrofit.create(RateService::class.java)
    }

    @Provides
    @Singleton
    fun provideRateClient(service: RateService): RateClient {
        return RateClient(service)
    }

    @Provides
    @Singleton
    fun provideProfileService(retrofit: Retrofit): ProfileService {
        return retrofit.create(ProfileService::class.java)
    }

    @Provides
    @Singleton
    fun provideProfileClient(service: ProfileService): ProfileClient {
        return ProfileClient(service)
    }


}
