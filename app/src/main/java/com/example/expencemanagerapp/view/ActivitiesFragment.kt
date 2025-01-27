package com.example.expencemanagerapp.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.expencemanagerapp.R
import com.example.expencemanagerapp.databinding.FragmentActivitiesBinding
import com.example.expencemanagerapp.view.adapter.TimePeriodAdapter
import com.google.android.material.dialog.MaterialAlertDialogBuilder

class ActivitiesFragment : Fragment() {
    private lateinit var binding: FragmentActivitiesBinding

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
        requireActivity().supportFragmentManager.beginTransaction()
            .replace(R.id.fragment_category_container, CategoriesFragment())
            .commit()

        val timePeriods = listOf(
            "This Month", "Last Month", "This Week","Last Week","This year"
        )

        val adapter = TimePeriodAdapter(requireContext(), timePeriods) { position, timePeriod ->
            Toast.makeText(requireContext(), "Clicked: $timePeriod", Toast.LENGTH_SHORT).show()
        }

        binding.horizontalRecyclerView.layoutManager =
            LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false)
        binding.horizontalRecyclerView.adapter = adapter
    }

    private fun initClickListeners() {
        binding.fab.setOnClickListener {
            showDialogForAddCategory()
        }
    }

    private fun showDialogForAddCategory() {
        // Inflate a custom layout for the dialog
        val dialogView = LayoutInflater.from(context).inflate(R.layout.dialog_add_category, null)

        // Get references to the EditTexts in the custom layout
        val categoryNameEditText = dialogView.findViewById<EditText>(R.id.editTextCategoryName)
        val balanceEditText = dialogView.findViewById<EditText>(R.id.editTextBalance)

        MaterialAlertDialogBuilder(requireContext())
            .setTitle("Add Category")
            .setView(dialogView)
            .setNegativeButton("Cancel") { dialog, _ ->
                dialog.dismiss() // Dismiss the dialog
            }
            .setPositiveButton("Add") { dialog, _ ->
                val categoryName = categoryNameEditText.text.toString().trim()
                val balance = balanceEditText.text.toString().trim()

                if (categoryName.isNotEmpty() && balance.isNotEmpty()) {
                    Toast.makeText(
                        requireContext(),
                        "Category: $categoryName, Balance: $balance",
                        Toast.LENGTH_SHORT
                    ).show()
                    // Add logic to handle the new category and balance
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
