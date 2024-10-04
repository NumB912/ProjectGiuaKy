package com.example.navigation

import android.os.Bundle
import android.view.LayoutInflater
import android.widget.Switch
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.NavigationUI
import com.google.android.material.bottomnavigation.BottomNavigationView;

class MainActivity : AppCompatActivity() {
    lateinit var bottomNavigationView: BottomNavigationView
    lateinit var navHostFragment: NavHostFragment
    lateinit var navController:NavController
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        bottomNavigationView = findViewById(R.id.BottomNavigationView_it)
        navHostFragment = supportFragmentManager.findFragmentById(R.id.Nav_Host_Fragment) as NavHostFragment
        navController = navHostFragment.navController
        NavigationUI.setupWithNavController(
            bottomNavigationView,navController
        )
        bottomNavigationView.setOnItemSelectedListener { item->
            when(item.itemId){
                R.id.Home->{
                    navController.navigate(R.id.firstFragment)
                }
                R.id.Searchs->{
                    navController.navigate(R.id.secondFragment)
                }
                R.id.Settings->{
                    navController.navigate(R.id.thirdFragment)
                }
            }
            true
        }




    }
}