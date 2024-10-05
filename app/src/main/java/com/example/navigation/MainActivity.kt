package com.example.navigation

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.MenuItem
import android.widget.Switch
import android.widget.Toast
import android.widget.Toolbar
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.app.AppCompatActivity
import androidx.drawerlayout.widget.DrawerLayout
import androidx.fragment.app.Fragment
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.NavigationUI
import com.example.navigation.databinding.ActivityMainBinding
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationView
import androidx.core.view.GravityCompat
import androidx.lifecycle.viewmodel.CreationExtras

class MainActivity : AppCompatActivity(){
    lateinit var bottomNavigationView: BottomNavigationView
    lateinit var navHostFragment: NavHostFragment
    lateinit var navController:NavController
    lateinit var drawer:DrawerLayout
    lateinit var toggle:ActionBarDrawerToggle
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        bottomNavigationView = findViewById(R.id.BottomNavigationView_it)
        navHostFragment = supportFragmentManager.findFragmentById(R.id.Nav_Host_Fragment) as NavHostFragment
        navController = navHostFragment.navController
        val navigationView: NavigationView = findViewById(R.id.nav_view)
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

        val toolbar = findViewById<androidx.appcompat.widget.Toolbar>(R.id.toolbar)
        drawer = findViewById(R.id.main)
        toggle = ActionBarDrawerToggle(this, drawer, toolbar, R.string.open, R.string.close)
        drawer.addDrawerListener(toggle)
        toggle.syncState()

         navigationView.setNavigationItemSelectedListener { item ->
            when (item.itemId) {
                R.id.nav_home -> {
                    navController.navigate(R.id.firstFragment)
                    bottomNavigationView.selectedItemId = R.id.Home
                    item.isChecked = true

                }
                R.id.nav_searchs -> {
                    navController.navigate(R.id.secondFragment)
                    bottomNavigationView.selectedItemId = R.id.Searchs
                }
                R.id.nav_Settings->{
                    navController.navigate(R.id.thirdFragment)
                    bottomNavigationView.selectedItemId = R.id.Settings
                }
                R.id.nav_profile->{
                    navController.navigate(R.id.fourth)
                }
            }

            drawer.closeDrawer(GravityCompat.START)
            true
        }


    }


}