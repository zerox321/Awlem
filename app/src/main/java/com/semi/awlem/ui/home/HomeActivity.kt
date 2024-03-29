package com.semi.awlem.ui.home

import android.os.Bundle
import android.view.MenuItem
import android.view.View
import androidx.navigation.NavController
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.onNavDestinationSelected
import androidx.navigation.ui.setupWithNavController
import com.semi.awlem.R
import com.semi.awlem.base.BaseActivity
import com.semi.awlem.databinding.ActivityHomeBinding
import com.semi.awlem.utility.animation.SlideViewAnimator.startSlideView
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HomeActivity : BaseActivity() {
    private val binding: ActivityHomeBinding by binding(R.layout.activity_home)

    private val navController: NavController by lazy {
        findNavController(R.id.nav_host_fragment)
    }
    private val topLevelDestinationIds = setOf(
        R.id.navigation_home,
        R.id.navigation_order,
        R.id.navigation_offers,
        R.id.navigation_more
    )
    private val appBarConfiguration: AppBarConfiguration by lazy {
        AppBarConfiguration(
            topLevelDestinationIds
        )
    }

    private fun bind() {
        binding.apply {
            lifecycleOwner = this@HomeActivity
            this.executePendingBindings()
        }
    } // fun of bind

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        bind()

        binding.navView.setOnNavigationItemReselectedListener {}
        binding.navView.setupWithNavController(navController)
        navController.addOnDestinationChangedListener { _, destination, _ ->
            topLevelDestinationIds.forEachIndexed { index, element ->
                if (destination.id == element) {
                    binding.navView.startSlideView(
                        height = 0f,
                        onAnimationStart = { binding.navView.visibility = View.VISIBLE },
                        onAnimationEnd = {})
                    return@addOnDestinationChangedListener
                }
                binding.navView.startSlideView(
                    height = binding.navView.height.toFloat(),
                    onAnimationStart = {},
                    onAnimationEnd = { binding.navView.visibility = View.GONE })

            }

        }
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return item.onNavDestinationSelected(navController)
    }

    override fun onSupportNavigateUp(): Boolean {
        return navController.navigateUp(appBarConfiguration) || super.onSupportNavigateUp()
    }
}