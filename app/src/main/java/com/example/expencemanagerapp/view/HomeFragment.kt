package com.example.expencemanagerapp.view

import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import com.example.expencemanagerapp.R
import com.github.mikephil.charting.charts.PieChart
import com.github.mikephil.charting.data.PieData
import com.github.mikephil.charting.data.PieDataSet
import com.github.mikephil.charting.data.PieEntry

class HomeFragment : Fragment() {

    private lateinit var search: ImageView
    private lateinit var userInfo :ImageView
    private lateinit var piChart : PieChart
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_home, container, false)

        search = view.findViewById(R.id.searchIcon)
        userInfo= view.findViewById(R.id.userInfo)
        piChart = view.findViewById(R.id.pieChart_view);

        search.setOnClickListener {
            val intent = Intent(activity, SearchActivity::class.java)
            startActivity(intent)
        }

        userInfo.setOnClickListener {
            val intent = Intent(activity, UserProfileActivity::class.java)
            startActivity(intent)
        }

        showPieChart()

        return view
    }

    private fun showPieChart() {
        val pieEntries = ArrayList<PieEntry>()
        val label = "type"

        // Initializing data
        val typeAmountMap = mapOf(
            "Groceries" to 200,
            "Rents" to 230,
            "Clothes" to 100,
            "Stationary" to 500,
            "Phone" to 50
        )

        // Initializing colors for the entries
        val colors = listOf(
            Color.parseColor("#304567"),
            Color.parseColor("#309967"),
            Color.parseColor("#476567"),
            Color.parseColor("#890567"),
            Color.parseColor("#a35567"),
            Color.parseColor("#ff5f67"),
            Color.parseColor("#3ca567")
        )

        // Input data and fit data into pie chart entry
        for ((type, amount) in typeAmountMap) {
            pieEntries.add(PieEntry(amount.toFloat(), type))
        }

        // Collecting the entries with label name
        val pieDataSet = PieDataSet(pieEntries, label).apply {
            valueTextSize = 6f // Setting text size of the value
            setColors(colors)   // Providing color list for coloring different entries
        }

        // Grouping the data set from entry to chart
        val pieData = PieData(pieDataSet).apply {
            setDrawValues(true) // Showing the value of the entries
        }

        // Setting the data to PieChart
        piChart.data = pieData
        piChart.invalidate() // Refreshing the chart
    }

}