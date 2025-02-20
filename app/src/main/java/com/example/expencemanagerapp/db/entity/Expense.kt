package com.example.expencemanagerapp.db.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "expenses")
data class Expense(
    @PrimaryKey(autoGenerate = true)
    val id : Int = 0,
    val categoryId : Int ,
    val description : String,
    val amount : Float,
    val time : String
)