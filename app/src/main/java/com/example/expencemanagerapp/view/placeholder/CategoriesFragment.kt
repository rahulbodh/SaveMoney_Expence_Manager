package com.example.expencemanagerapp.view.placeholder

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.expencemanagerapp.R
import com.example.expencemanagerapp.databinding.FragmentCategoriesBinding
import com.example.expencemanagerapp.model.CategoryCardItem
import com.example.expencemanagerapp.view.adapter.CategoryCardViewAdapter

class CategoriesFragment : Fragment() {

    private var _binding: FragmentCategoriesBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentCategoriesBinding.inflate(inflater, container, false)

        // Sample data
        val sampleData = listOf(
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


        // Set up RecyclerView
        binding.categoryRecyclerView.layoutManager = LinearLayoutManager(requireContext())
        binding.categoryRecyclerView.adapter = CategoryCardViewAdapter(sampleData)

        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
