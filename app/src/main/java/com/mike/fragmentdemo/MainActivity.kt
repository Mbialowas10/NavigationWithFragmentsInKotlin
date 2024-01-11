package com.mike.fragmentdemo

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {

    lateinit var bottomNavBar: BottomNavigationView

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        bottomNavBar = findViewById(R.id.bottomNavBar)

        bottomNavBar.setOnItemSelectedListener { menuItem ->
            when(menuItem.itemId){
                R.id.nav_home -> replaceFragment(HomeFragment())
                R.id.nav_search -> replaceFragment(SearchFragment())
                R.id.nav_profile -> replaceFragment(ProfileFragment())
            }
            true
        }

    }
    private fun replaceFragment(fragment: Fragment) {
        Log.i("mjb", "fragment method being called")
        supportFragmentManager.beginTransaction()
            .replace(R.id.fragmentContainer, fragment)
            .commit()
    }
}