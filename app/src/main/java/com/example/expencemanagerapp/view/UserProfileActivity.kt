package com.example.expencemanagerapp.view

import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.expencemanagerapp.R
import com.example.expencemanagerapp.view.adapter.UserOptionAdapter

class UserProfileActivity : AppCompatActivity() {

    private lateinit var recyclerView: RecyclerView
    private val options = listOf(
        Pair("Recent Activities", R.drawable.baseline_account_circle_24),
        Pair("Refer", R.drawable.baseline_account_circle_24),
        Pair("Help & Support", R.drawable.baseline_account_circle_24),
        Pair("Logout", R.drawable.baseline_account_circle_24)
    )
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_user_profile)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        recyclerView = findViewById(R.id.list_section)
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = UserOptionAdapter(options) { option ->
            handleOptionClick(option)
        }
    }

        private fun handleOptionClick(option: String) {
            when (option) {
                "Recent Activities" -> {
                    // Handle Recent Activities
                    Toast.makeText(this, "Selected: $option", Toast.LENGTH_SHORT).show()
                }
                "Refer" -> {
                    // Handle Refer
                    Toast.makeText(this, "Selected: $option", Toast.LENGTH_SHORT).show()
                }
                "Help & Support" -> {
                    // Handle Help & Support
                    Toast.makeText(this, "Selected: $option", Toast.LENGTH_SHORT).show()
                }
                "Logout" -> {
                    // Handle Logout
                    Toast.makeText(this, "Selected: $option", Toast.LENGTH_SHORT).show()
                }
            }
        }
}