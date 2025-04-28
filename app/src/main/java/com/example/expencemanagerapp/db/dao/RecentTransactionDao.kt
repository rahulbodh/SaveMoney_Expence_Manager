package com.example.expencemanagerapp.db.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.example.expencemanagerapp.db.entity.RecentTransaction

@Dao
interface RecentTransactionDao {

    @Query("SELECT * FROM recent_transaction ORDER BY id DESC")
    fun getAllTransaction() : LiveData<List<RecentTransaction>>

    @Insert
    suspend fun insertTransaction(transaction: RecentTransaction)

    @Update
    suspend fun updateTransaction(transaction: RecentTransaction)

    @Delete
    suspend fun deleteTransaction(transaction: RecentTransaction)
}