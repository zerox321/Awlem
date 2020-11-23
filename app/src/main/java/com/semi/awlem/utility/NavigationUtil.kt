package com.semi.awlem.utility


import android.os.Bundle
import android.view.View
import androidx.navigation.NavController
import androidx.navigation.NavOptions
import androidx.navigation.Navigator
import androidx.navigation.findNavController
import timber.log.Timber


object NavigationUtil {
    fun View.findNavigationController() = this.findNavController()


    fun NavController.navigateTo(
        id: Int,
        args: Bundle? = null,
        navOptions: NavOptions? = null,
        extras: Navigator.Extras? = null
    ) {
        try {
            this.navigate(id, args, navOptions, extras)
        } catch (t: Throwable) {
            Timber.e("Multiple navigation attempts handled. $t")
        }
    }

    fun NavController.clearNavigateStack(destinationId: Int? = null) {
        try {
            if (destinationId != null)
                this.popBackStack(destinationId, false)
            else
                this.popBackStack()


        } catch (t: Throwable) {
            Timber.e("Multiple navigation attempts handled. $t")
        }
    }

}
