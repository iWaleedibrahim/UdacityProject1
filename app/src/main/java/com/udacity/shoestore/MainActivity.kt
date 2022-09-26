package com.udacity.shoestore

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.navigation.NavController
import androidx.navigation.findNavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import com.udacity.shoestore.R
import com.udacity.shoestore.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    private lateinit var navController: NavController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
//        initActionBar()
    }


//    private fun initActionBar() {
//        val navHostFragment = supportFragmentManager.findFragmentById(
//            R.id.myNavHostFragment
//        ) as NavHostFragment
//        navController = navHostFragment.navController
//
//        val appBarConfiguration = AppBarConfiguration(
//            setOf(
//                R.id.listingFragment,
//                R.id.detailFragment
//            )
//        )
//
//        setupActionBarWithNavController(navController, appBarConfiguration)
//    }

}
