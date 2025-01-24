package com.example.expencemanagerapp.view

import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.expencemanagerapp.R
import com.example.expencemanagerapp.databinding.FragmentHomeBinding
import com.example.expencemanagerapp.model.Transaction
import com.example.expencemanagerapp.view.adapter.TimePeriodAdapter
import com.example.expencemanagerapp.view.adapter.TransactionAdapter
import com.github.mikephil.charting.charts.PieChart
import com.github.mikephil.charting.data.PieData
import com.github.mikephil.charting.data.PieDataSet
import com.github.mikephil.charting.data.PieEntry

class HomeFragment : Fragment() {

    private lateinit var binding: FragmentHomeBinding

    private lateinit var recentTransactionAdapter: TransactionAdapter
    private lateinit var transactionList : MutableList<Transaction>
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentHomeBinding.inflate(inflater, container, false)

        initViews()
        clickListeners()
        showPieChart()
        return binding.root
    }

    private fun initViews() {
        val timePeriods = listOf("This Month", "Last Month", "This Week", "January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December")

        val adapter = TimePeriodAdapter(requireContext(), timePeriods) { position, timePeriod ->
            Toast.makeText(requireContext(), "Clicked: $timePeriod", Toast.LENGTH_SHORT).show()
        }

        binding.horizontalRecyclerView.layoutManager = LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false)
        binding.horizontalRecyclerView.adapter = adapter

        transactionList = mutableListOf()
        populateTransactionList()
        recentTransactionAdapter  = TransactionAdapter(requireContext(), transactionList)

        binding.RecentActivitiesRecyclerView.layoutManager = LinearLayoutManager(requireContext())
        binding.RecentActivitiesRecyclerView.adapter = recentTransactionAdapter
    }

    private fun clickListeners() {

        binding.searchIcon.setOnClickListener {
            val intent = Intent(activity, SearchActivity::class.java)
            startActivity(intent)
        }

        binding.userInfo.setOnClickListener {
            val intent = Intent(activity, UserProfileActivity::class.java)
            startActivity(intent)
        }
    }

    private fun populateTransactionList() {
        // Add 10 sample transactions
        transactionList.add(Transaction("Electricity Bill", null, "Rs. 200", Transaction.TYPE_PAY))
        transactionList.add(Transaction("Shopping", null, "Rs. 300", Transaction.TYPE_PAY))
        transactionList.add(Transaction("Dining Out", "Rs. 300", null, Transaction.TYPE_GET))
        transactionList.add(Transaction("Loan Payment", null, "Rs. 1000", Transaction.TYPE_PAY))
        transactionList.add(Transaction("Freelance Work", "Rs. 2000", null, Transaction.TYPE_GET))
        transactionList.add(Transaction("Car Maintenance", null, "Rs. 800", Transaction.TYPE_PAY))
        transactionList.add(Transaction("Refund Received", "Rs. 150", null, Transaction.TYPE_GET))
        transactionList.add(Transaction("Subscription Fee", null, "Rs. 400", Transaction.TYPE_PAY))
        transactionList.add(Transaction("Part-Time Job", "Rs. 1200", null, Transaction.TYPE_GET))
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
        binding.pieChartView.data = pieData
        binding.pieChartView.invalidate() // Refreshing the chart
    }

}