package com.semi.awlem.di

import com.semi.awlem.ui.home.home.HomeRepository
import com.semi.awlem.ui.home.menu.MenuRepository
import com.semi.awlem.ui.home.menu.help.HelpRepository
import com.semi.awlem.ui.home.menu.rate.RateRepository
import com.semi.awlem.ui.home.menu.staticPage.StaticRepository
import com.semi.awlem.ui.home.offers.OffersRepository
import com.semi.awlem.ui.splash.login.LoginRepository
import com.semi.awlem.ui.splash.register.RegisterRepository
import com.semi.awlem.ui.splash.verification.VerificationRepository
import com.semi.entity.database.categoryController.CategoryController
import com.semi.entity.database.faqController.FaqController
import com.semi.entity.sharedPref.Pref
import com.semi.home.home.HomeClient
import com.semi.home.menu.faq.FaqClient
import com.semi.home.menu.profile.ProfileClient
import com.semi.home.menu.rate.RateClient
import com.semi.home.menu.staticPage.StaticPageClient
import com.semi.home.offer.OfferClient
import com.semi.splash.activate.ActivateClient
import com.semi.splash.login.LoginClient
import com.semi.splash.register.RegisterClient
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
        categoryController: CategoryController,
        pref: Pref

    ): HomeRepository {
        return HomeRepository(client, categoryController, pref)
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
        faqController: FaqController,
        pref: Pref

    ): HelpRepository {
        return HelpRepository(client, faqController, pref)
    }

    @Provides
    @Singleton
    fun provideLoginRepository(
        client: LoginClient,
        pref: Pref
    ): LoginRepository {
        return LoginRepository(client, pref)
    }

    @Provides
    @Singleton
    fun provideRegisterRepository(
        client: RegisterClient,
        pref: Pref
    ): RegisterRepository {
        return RegisterRepository(client, pref)
    }


    @Provides
    @Singleton
    fun provideVerificationRepository(
        client: ActivateClient,
        pref: Pref
    ): VerificationRepository {
        return VerificationRepository(client, pref)
    }

    @Provides
    @Singleton
    fun provideOffersRepository(
        client: OfferClient,
        pref: Pref
    ): OffersRepository {
        return OffersRepository(client, pref)
    }

    @Provides
    @Singleton
    fun provideRateRepository(
        client: RateClient,
        pref: Pref
    ): RateRepository {
        return RateRepository(client, pref)
    }

    @Provides
    @Singleton
    fun provideMenuRepository(
        client: ProfileClient,
        pref: Pref
    ): MenuRepository {
        return MenuRepository(client, pref)
    }


}
