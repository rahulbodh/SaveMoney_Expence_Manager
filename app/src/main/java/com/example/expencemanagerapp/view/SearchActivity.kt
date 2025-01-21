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
import com.example.expencemanagerapp.view.adapter.SearchResultsAdapter
import com.google.android.material.chip.Chip
import com.google.android.material.chip.ChipGroup

class SearchActivity : AppCompatActivity() {

    private lateinit var searchResultsRecyclerView: RecyclerView
    private lateinit var categoryChipGroup: ChipGroup

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_search)

        // Initialize RecyclerView
        searchResultsRecyclerView = findViewById(R.id.searchResultsRecyclerView)
        searchResultsRecyclerView.layoutManager = LinearLayoutManager(this)
        searchResultsRecyclerView.adapter = SearchResultsAdapter(getSampleData())

        // Initialize ChipGroup and set listener
        categoryChipGroup = findViewById(R.id.categoryChipGroup)
        categoryChipGroup.setOnCheckedChangeListener { group, checkedId ->
            val chip = findViewById<Chip>(checkedId)
            if (chip != null) {
                filterResults(chip.text.toString())
            }
        }
    }

    private fun filterResults(category: String) {
        Toast.makeText(this, "Selected: $category", Toast.LENGTH_SHORT).show()
        // Update RecyclerView with filtered results
        // Replace this logic with your filtering implementation
    }

    private fun getSampleData(): List<String> {
        return listOf("Result 1", "Result 2", "Result 3", "Result 4", "Result 5")
    }
}