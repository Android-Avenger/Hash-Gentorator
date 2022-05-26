package com.andavn.hashgenerator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.fragment.NavHostFragment

class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

//
//        val hostFragment = supportFragmentManager.findFragmentById(R.id.navigation) as NavHostFragment
//        val navController = hostFragment.navController
//        val navGraph = navController.navInflater.inflate(R.navigation.navigation)
//        navGraph.setStartDestination(R.id.homeFragment)
//        navController.graph = navGraph
    }
}