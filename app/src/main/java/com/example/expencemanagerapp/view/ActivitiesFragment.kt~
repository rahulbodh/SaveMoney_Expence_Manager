package com.example.expencemanagerapp.view

import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.AccelerateInterpolator
import android.view.animation.DecelerateInterpolator
import android.widget.EditText
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.expencemanagerapp.R
import com.example.expencemanagerapp.databinding.FragmentActivitiesBinding
import com.example.expencemanagerapp.model.CategoryCardItem
import com.example.expencemanagerapp.view.adapter.CategoryCardViewAdapter
import com.example.expencemanagerapp.view.adapter.TimePeriodAdapter
import com.google.android.material.dialog.MaterialAlertDialogBuilder

class ActivitiesFragment : Fragment() {
    private lateinit var binding: FragmentActivitiesBinding
    private lateinit var categoryAdapter: CategoryCardViewAdapter
    private val categoryList = mutableListOf<CategoryCardItem>()
    private var isScrolling = false
    private val handler = Handler(Looper.getMainLooper())

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentActivitiesBinding.inflate(inflater, container, false)
        initViews()
        initClickListeners()
        return binding.root
    }

    private fun initViews() {
        // Initialize the category list
        categoryList.addAll(
            listOf(
                CategoryCardItem("Grocery", 15000, 5000),
                CategoryCardItem("Shopping", 12000, 7000),
                CategoryCardItem("Entertainment", 20000, 15000),
                CategoryCardItem("Utilities", 8000, 4000),
                CategoryCardItem("Travel", 25000, 18000),
                CategoryCardItem("Health", 10000, 5000),
                CategoryCardItem("Education", 30000, 20000),
                CategoryCardItem("Dining", 9000, 6000),
                CategoryCardItem("Miscellaneous", 7000, 3000)
            )
        )

        // Set up the RecyclerView with the adapter
        categoryAdapter = CategoryCardViewAdapter(categoryList)
        binding.categoryRecyclerView2.layoutManager = LinearLayoutManager(requireContext())
        binding.categoryRecyclerView2.adapter = categoryAdapter

        val timePeriods = listOf(
            "This Month", "Last Month", "This Week", "Last Week", "This year"
        )

        val adapter = TimePeriodAdapter(requireContext(), timePeriods) { _, timePeriod ->
            Toast.makeText(requireContext(), "Clicked: $timePeriod", Toast.LENGTH_SHORT).show()
        }

        binding.horizontalRecyclerView.layoutManager =
            LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false)
        binding.horizontalRecyclerView.adapter = adapter

        var isScrollingFast = false
        var isScrolling = false
        var lastScrollY = 0
        var shrinkRunnable = Runnable {
            binding.fab.animate().scaleX(1f).scaleY(1f).alpha(1f)
                .setInterpolator(DecelerateInterpolator())
                .setDuration(200).start()
        }

        binding.categoryRecyclerView2.addOnScrollListener(object : RecyclerView.OnScrollListener() {
            override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {
                val currentScrollY = recyclerView.computeVerticalScrollOffset()
                val scrollSpeed = Math.abs(currentScrollY - lastScrollY)

                isScrollingFast = scrollSpeed > 20
                isScrolling = dy != 0
                lastScrollY = currentScrollY

                if (isScrollingFast) {
                    binding.fab.animate().alpha(0f).setDuration(150).start() // Hide FAB when scrolling fast
                } else if (isScrolling) {
                    binding.fab.animate().scaleX(0.8f).scaleY(0.8f).alpha(1f)
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

    private fun initClickListeners() {
        binding.fab.setOnClickListener {
            showDialogForAddCategory()
        }
    }

    private fun showDialogForAddCategory() {
        val dialogView = LayoutInflater.from(context).inflate(R.layout.dialog_add_category, null)
        val categoryNameEditText = dialogView.findViewById<EditText>(R.id.editTextCategoryName)
        val balanceEditText = dialogView.findViewById<EditText>(R.id.editTextBalance)

        MaterialAlertDialogBuilder(requireContext())
            .setTitle("Add Category")
            .setView(dialogView)
            .setNegativeButton("Cancel") { dialog, _ ->
                dialog.dismiss()
            }
            .setPositiveButton("Add") { dialog, _ ->
                val categoryName = categoryNameEditText.text.toString().trim()
                val balance = balanceEditText.text.toString().trim()

                if (categoryName.isNotEmpty() && balance.isNotEmpty()) {
                    try {
                        val balanceValue = balance.toInt()

                        // Add new item to the list
                        val newItem = CategoryCardItem(categoryName, balanceValue, 0)
                        categoryList.add(newItem)

                        // Notify adapter
                        categoryAdapter.notifyItemInserted(categoryList.size - 1)

                        Toast.makeText(
                            requireContext(),
                            "Category: $categoryName added successfully!",
                            Toast.LENGTH_SHORT
                        ).show()
                    } catch (e: NumberFormatException) {
                        Toast.makeText(
                            requireContext(),
                            "Please enter a valid number for balance.",
                            Toast.LENGTH_SHORT
                        ).show()
                    }
                } else {
                    Toast.makeText(
                        requireContext(),
                        "Please fill in both fields.",
                        Toast.LENGTH_SHORT
                    ).show()
                }
            }
            .show()
    }
}
