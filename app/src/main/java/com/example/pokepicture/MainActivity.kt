package com.example.pokepicture

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.example.pokepicture.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var navController: NavController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.d(TAG, this.resources.getString(R.string.on_create_called))

        binding = ActivityMainBinding.inflate(layoutInflater)

        val navHostFragment =
            supportFragmentManager.findFragmentById(R.id.navHostFragment) as NavHostFragment
        val navController = navHostFragment.navController
        val appBarConfiguration = AppBarConfiguration(setOf(
            R.id.pokeListFragment,
            R.id.favoriteFragment
        ))

        binding.bottomNavigationView.setupWithNavController(navController)
        setupActionBarWithNavController(navController, appBarConfiguration)

        setContentView(binding.root)
    }

    override fun onResume() {
        super.onResume()

    }

    override fun onSupportNavigateUp(): Boolean {
        return navController.navigateUp() || super.onSupportNavigateUp()
    }

    companion object {
        private val TAG = MainActivity::class.java.simpleName
    }
}
