package com.udacity.shoestore

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.FragmentManager
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.setupActionBarWithNavController
import com.udacity.shoestore.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var navController: NavController
    private lateinit var appBarConfiguration: AppBarConfiguration

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        val mgr: FragmentManager = supportFragmentManager
        val navHostFragment = mgr.findFragmentById(R.id.nav_host_fragment) as NavHostFragment
        navController = navHostFragment.findNavController()

//        AppBarConfiguration for remove the back button in some fragments
        appBarConfiguration = AppBarConfiguration(
            setOf(
                R.id.loginFragment,
                R.id.welcomeFragment,
                R.id.shoeListingFragment
            )
        )
        setSupportActionBar(binding.toolbar)
        setupActionBarWithNavController(navController, appBarConfiguration)
    }

    override fun onSupportNavigateUp(): Boolean {
        return navController.navigateUp(appBarConfiguration) || super.onSupportNavigateUp()
    }
}