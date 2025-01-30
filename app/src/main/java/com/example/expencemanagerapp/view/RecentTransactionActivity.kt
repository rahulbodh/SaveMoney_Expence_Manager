package com.example.expencemanagerapp.view

import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContentProviderCompat.requireContext
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.expencemanagerapp.R
import com.example.expencemanagerapp.databinding.ActivityRecentTransactionBinding
import com.example.expencemanagerapp.model.Transaction
import com.example.expencemanagerapp.view.adapter.TimePeriodAdapter
import com.example.expencemanagerapp.view.adapter.TransactionAdapter

class RecentTransactionActivity : AppCompatActivity() {
    private lateinit var binding : ActivityRecentTransactionBinding
    private lateinit var recentTransactionAdapter: TransactionAdapter
    private lateinit var transactionList : MutableList<Transaction>
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityRecentTransactionBinding.inflate(layoutInflater)
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        initViews()
        clickListeners()


    }

    private fun clickListeners() {
        binding.topAppBar.setNavigationOnClickListener {
            onBackPressedDispatcher.onBackPressed()
        }
    }

    private fun initViews() {

        transactionList = mutableListOf()
        populateTransactionList()
        recentTransactionAdapter  = TransactionAdapter(this, transactionList)

        binding.RecentActivitiesRV.layoutManager = LinearLayoutManager(this)
        binding.RecentActivitiesRV.adapter = recentTransactionAdapter
    }

    private fun populateTransactionList() {
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
}