package com.myapp.mindfulmoments

import android.content.Intent
import android.content.res.Configuration
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.app.AppCompatDelegate
import androidx.drawerlayout.widget.DrawerLayout
import androidx.appcompat.widget.Toolbar
import com.google.android.material.navigation.NavigationView

class MainActivity2 : AppCompatActivity(), NavigationView.OnNavigationItemSelectedListener {

    private lateinit var drawerLayout: DrawerLayout
    private lateinit var navView: NavigationView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)

        // Find the toolbar and set it as the support action bar
        val toolbar = findViewById<Toolbar>(R.id.toolbar)
        setSupportActionBar(toolbar)

        // Initialize views
        drawerLayout = findViewById(R.id.drawer_layout)
        navView = findViewById(R.id.nav_view)

        // Set navigation item listener
        navView.setNavigationItemSelectedListener(this)

        // Set up ActionBarDrawerToggle
        val actionBarDrawerToggle = ActionBarDrawerToggle(
            this, drawerLayout, toolbar,
            R.string.open_navigation_drawer, R.string.closed_navigation_drawer
        )
        drawerLayout.addDrawerListener(actionBarDrawerToggle)
        actionBarDrawerToggle.syncState()

        // If savedInstanceState is null, replace the fragment with HomeFragment
        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .replace(R.id.fragment_container, HomeFragment())
                .commit()
//            navView.setCheckedItem(R.id.imageSlider)
        }
    }
    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        // Handle navigation item clicks here
        when (item.itemId) {
            R.id.menu_home -> {
                supportFragmentManager.beginTransaction()
                    .replace(R.id.fragment_container, HomeFragment())
                    .commit()
            }
            R.id.menu_activity -> {
                Toast.makeText(this, "Activity Fragment", Toast.LENGTH_LONG).show()
                supportFragmentManager.beginTransaction()
                    .replace(R.id.fragment_container, ActivityFragment())
                    .commit()
            }
            R.id.menu_rate-> {
                Toast.makeText(this, "Rating Fragment", Toast.LENGTH_LONG).show()
                supportFragmentManager.beginTransaction()
                    .replace(R.id.fragment_container, RatingFragment())
                    .commit()
            }

            R.id.menu_logOut ->{
                val intent = Intent(this, MainActivity::class.java)
                startActivity(intent)
                finish()
            }

            R.id.menu_mode_toggle ->{
                toggleTheme()
            }

            // Add more cases for other menu items if needed
        }
        // Close the navigation drawer after item selection
        drawerLayout.closeDrawer(navView)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.menu_mode_toggle -> {
                toggleTheme()
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }

    private fun toggleTheme() {
        val currentNightMode = AppCompatDelegate.getDefaultNightMode()
        val newNightMode = when (currentNightMode) {
            AppCompatDelegate.MODE_NIGHT_NO -> AppCompatDelegate.MODE_NIGHT_YES
            AppCompatDelegate.MODE_NIGHT_YES -> AppCompatDelegate.MODE_NIGHT_NO
            else -> AppCompatDelegate.MODE_NIGHT_FOLLOW_SYSTEM
        }
        AppCompatDelegate.setDefaultNightMode(newNightMode)
    }
}
