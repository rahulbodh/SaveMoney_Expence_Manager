package com.example.expencemanagerapp.model

class Transaction(
    val recentActivity: String, // Null if not a "Get Money" transaction
    val getMoney: String ? = null, // Null if not a "Pay Money" transaction
    val paidMoney: String? = null, // Type of transaction (Get, Pay, or Both)
    val type: Int
) {
    companion object {
        const val TYPE_GET: Int = 1
        const val TYPE_PAY: Int = 2
    }
}
