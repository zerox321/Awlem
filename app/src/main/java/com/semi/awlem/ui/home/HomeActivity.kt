package com.semi.awlem.ui.home

import android.os.Bundle
import androidx.navigation.ui.*
import com.semi.awlem.R
import com.semi.awlem.base.BaseActivity
import com.semi.awlem.databinding.ActivityHomeBinding

class HomeActivity : BaseActivity() {
    private val binding: ActivityHomeBinding by binding(R.layout.activity_home)

    private fun bind() {
        binding.apply {
            lifecycleOwner = this@HomeActivity
            this.executePendingBindings()
        }
    } // fun of bind

//    private val navController: NavController by lazy {
//        findNavController(R.id.nav_host_fragment)
//    }
    private val appBarConfiguration: AppBarConfiguration by lazy {
        AppBarConfiguration(
            setOf(
                R.id.navigation_home
            )

        )
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)
        bind()
        setupToolBar()

    }

    private fun setupToolBar() {
//        binding.navView.setupWithNavController(navController)
//        binding.navView.setOnNavigationItemReselectedListener {}

//        navController.addOnDestinationChangedListener { controller, destination, args ->
//            if (
//                destination.id == R.id.navigation_home ||
//                destination.id == R.id.FollowFragment ||
//                destination.id == R.id.CartFragment ||
//                destination.id == R.id.InsuranceFragment ||
//                destination.id == R.id.MenuFragment
//            )
//                showBottomNavigationView(nav_view)
//            else
//                hideBottomNavigationView(nav_view)


//        }
    }

//    override fun onOptionsItemSelected(item: MenuItem): Boolean {
//        return item.onNavDestinationSelected(navController)
//    }
//
//    override fun onSupportNavigateUp(): Boolean {
//        return navController.navigateUp(appBarConfiguration) || super.onSupportNavigateUp()
//    }
}