package com.example.expencemanagerapp.db.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Update
import com.example.expencemanagerapp.db.entity.RecentTransaction

@Dao
interface RecentTransactionDao {

    @Insert
    suspend fun insertTransaction(transaction: RecentTransaction)

    @Update
    suspend fun updateTransaction(transaction: RecentTransaction)

    @Delete
    suspend fun deleteTransaction(transaction: RecentTransaction)
}