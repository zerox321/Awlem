package com.semi.awlem.ui.splash

import android.os.Bundle
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.android.material.snackbar.Snackbar
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.NavController
import androidx.navigation.findNavController
import com.semi.awlem.R
import com.semi.awlem.base.BaseActivity
import com.semi.awlem.databinding.ActivitySplashBinding
import com.semi.awlem.utility.NavigationUtil.navigateTo
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class SplashActivity : BaseActivity() {

    private val binding: ActivitySplashBinding by binding(R.layout.activity_splash)

    private val navController: NavController by lazy {
        findNavController(R.id.splash_nav_host_fragment)
    }

    private fun bind() {
        binding.apply {
            lifecycleOwner = this@SplashActivity
            this.executePendingBindings()
        }
    } // fun of bind

    private fun isGuestNavigateToLogin(isGuest: Boolean) {
//        if (isGuest)
//            navController.navigateTo(
//                id = R.id.action_SplashFragment_to_LoginFragment,
//            )
    }//Navigate Guest To Login Screen

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        bind()
        val isGuest = intent.getBooleanExtra("isGuest", false)
        isGuestNavigateToLogin(isGuest = isGuest)

    }

}