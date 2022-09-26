package com.udacity.shoestore

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.navigation.NavController
import com.udacity.shoestore.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    private lateinit var navController: NavController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
    }

//    navController.addOnDestinationChangedListener { navController, destination, arguments ->
//        title = when (destination.id) {
//            R.id.loginFragment -> "Login"
//            R.id.welcomeFragment -> "Welcome"
//            R.id.instructionsFragment -> "Instructions"
//            R.id.listingFragment -> "List of shoes"
//            R.id.detailFragment -> "Shoe"
//            else -> "ShoeStore"
//        }
//    }

}




