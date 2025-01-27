package com.example.expencemanagerapp.view

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContentProviderCompat.requireContext
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.expencemanagerapp.R
import com.example.expencemanagerapp.databinding.ActivityEntryCategoryDataBinding
import com.example.expencemanagerapp.model.EntryCategoryData
import com.example.expencemanagerapp.view.adapter.EntryCategoryDataItemAdapter

class EntryCategoryDataActivity : AppCompatActivity() {
    private lateinit var binding : ActivityEntryCategoryDataBinding
    private lateinit var recyclerView: RecyclerView
    private lateinit var adapter: EntryCategoryDataItemAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityEntryCategoryDataBinding.inflate(layoutInflater)
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

         val sampleData = listOf(
            EntryCategoryData("Jan 27, 2025", "10:00 AM", 1000, 200), // Item 1
            EntryCategoryData("Jan 27, 2025", "12:00 PM", 800, 300),  // Item 2
            EntryCategoryData("Jan 27, 2025", "03:00 PM", 500, 100),  // Item 3
            EntryCategoryData("Jan 27, 2025", "06:00 PM", 400, 200)   // Item 4
        )

        // Initialize RecyclerView
        recyclerView = findViewById(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL,true)

        // Set up the adapter with sample data
        adapter = EntryCategoryDataItemAdapter(this, sampleData)
        recyclerView.adapter = adapter


    }
}