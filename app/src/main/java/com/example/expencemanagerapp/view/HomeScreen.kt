package com.example.expencemanagerapp.view

import android.os.Bundle
import android.widget.ImageView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.expencemanagerapp.R
import com.example.expencemanagerapp.databinding.ActivityHomeScreenBinding
import com.google.android.material.bottomnavigation.BottomNavigationView

class HomeScreen : AppCompatActivity() {

    private lateinit var binding : ActivityHomeScreenBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityHomeScreenBinding.inflate(layoutInflater)
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }


        initClicks()

        // Set default fragment
        supportFragmentManager.beginTransaction()
            .replace(R.id.container, HomeFragment())
            .commit()

        // Set listener for BottomNavigationView
        val bottomNavigationView = findViewById<BottomNavigationView>(R.id.bottom_navigation)
        bottomNavigationView.setOnItemSelectedListener { item ->
            val fragment = when (item.itemId) {
                R.id.item_1 -> HomeFragment()
                R.id.item_2 -> ProfileFragment()
                R.id.item_3 -> NotificationFragment()
                else -> null
            }
            fragment?.let {
                supportFragmentManager.beginTransaction()
                    .replace(R.id.container, it)
                    .commit()
                true
            } ?: false
        }
    }

    private fun initClicks() {

    }
}
