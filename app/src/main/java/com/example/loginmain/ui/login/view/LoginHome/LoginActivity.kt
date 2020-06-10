package com.example.loginmain.ui.login


import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.Navigation
import androidx.navigation.ui.NavigationUI
import com.example.loginmain.R
import com.google.android.material.bottomnavigation.BottomNavigationView

class LoginActivity : AppCompatActivity() {


    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        val inflater: MenuInflater = menuInflater
        inflater.inflate(R.menu.optional_menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle item selection
        return when (item.itemId) {
            R.id.settings -> {
                Toast.makeText(
                    this,
                    "Settings clicked",
                    Toast.LENGTH_SHORT
                ).show()

                true
            }
            R.id.logout -> {

                Toast.makeText(
                    this,
                    "Logging Out",
                    Toast.LENGTH_SHORT
                ).show()

                val intent = Intent(this, LoginActivity::class.java)
                startActivity(intent)
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_main)


        val bottomNavigation: BottomNavigationView = findViewById(R.id.Bottom_Nav)

        val navController = Navigation.findNavController(this, R.id.fragment_main)

        navController.addOnDestinationChangedListener { _, destination, _ ->

            when (destination.id) {

                R.id.loginFragment -> bottomNavigation.visibility = View.GONE

                else -> bottomNavigation.visibility = View.VISIBLE
            }
        }

        NavigationUI.setupWithNavController(bottomNavigation, navController)


    }


}
