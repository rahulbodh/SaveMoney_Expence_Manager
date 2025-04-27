package com.example.expencemanagerapp.db.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "recent_transaction")
data class RecentTransaction(
    @PrimaryKey(autoGenerate = true)
    val id : Int = 0,
    val transactionId : String,
    val amount : Float,
    val time : String,
    val totalAmount : Float
)
