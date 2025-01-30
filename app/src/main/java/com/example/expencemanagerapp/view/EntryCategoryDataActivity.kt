package com.example.expencemanagerapp.view

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.animation.AccelerateInterpolator
import android.view.animation.DecelerateInterpolator
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
    private var handler = Handler(Looper.getMainLooper())
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

        initViews()
        initClicks()

    }

    private fun initClicks() {
        binding.topAppBar.setNavigationOnClickListener {
            onBackPressedDispatcher.onBackPressed()
        }

        binding.extendedFab.setOnClickListener {
            val intent = Intent(this, AddTransactionToCategoryActivity::class.java)
            startActivity(intent)
        }
    }

    private fun initViews() {
        var isScrollingFast = false
        var isScrolling = false
        var lastScrollY = 0
        var shrinkRunnable = Runnable {
            binding.extendedFab.animate().scaleX(1f).scaleY(1f).alpha(1f)
                .setInterpolator(DecelerateInterpolator())
                .setDuration(200).start()
        }

        val sampleData = listOf(
            EntryCategoryData("Jan 27, 2025", "10:00 AM", 1000, 200), // Item 1
            EntryCategoryData("Jan 27, 2025", "12:00 PM", 800, 300),  // Item 2
            EntryCategoryData("Jan 27, 2025", "03:00 PM", 500, 100),  // Item 3
            EntryCategoryData("Jan 27, 2025", "06:00 PM", 400, 200),   // Item 4
        )

        // Initialize RecyclerView
        recyclerView = findViewById(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL,true)

        // Set up the adapter with sample data
        adapter = EntryCategoryDataItemAdapter(this, sampleData)
        recyclerView.adapter = adapter

        binding.recyclerView.addOnScrollListener(object : RecyclerView.OnScrollListener() {
            override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {
                val currentScrollY = recyclerView.computeVerticalScrollOffset()
                val scrollSpeed = Math.abs(currentScrollY - lastScrollY)

                isScrolling = dy != 0
                lastScrollY = currentScrollY

                if (isScrollingFast) {
                    binding.extendedFab.animate().alpha(0f).setDuration(150).start() // Hide FAB when scrolling fast
                } else if (isScrolling) {
                    binding.extendedFab.animate().scaleX(0.8f).scaleY(0.8f).alpha(1f)
                        .setInterpolator(AccelerateInterpolator()).setDuration(150).start() // Shrink FAB
                }

                handler.removeCallbacks(shrinkRunnable)
            }

            override fun onScrollStateChanged(recyclerView: RecyclerView, newState: Int) {
                if (newState == RecyclerView.SCROLL_STATE_IDLE) {
                    isScrollingFast = false
                    isScrolling = false
                    handler.postDelayed(shrinkRunnable, 200)
                }
            }
        })

    }
}