package com.example.expencemanagerapp.db.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.example.expencemanagerapp.db.entity.Expense
import kotlinx.coroutines.flow.Flow

@Dao
interface ExpenseDao {

    @Insert
    suspend fun insert(expense: Expense)

    @Update
    suspend fun update(expense: Expense)

    @Delete
    suspend fun delete(expense: Expense)

    @Query("SELECT * FROM expenses WHERE time =:time")
    fun getExpensesByDate(time : String) : Flow<List<Expense>>

    @Query("SELECT * FROM expenses WHERE time BETWEEN :startTime AND :endTime")
    fun getExpensesByDateRange(startTime : String , endTime: String) : Flow<List<Expense>>

    @Query("SELECT * FROM expenses WHERE categoryId =:categoryId")
    fun getExpensesByCategory(categoryId : Int) : Flow<List<Expense>>

    @Query("SELECT * FROM expenses WHERE categoryId =:categoryId And time BETWEEN :startTime AND :endTime")
    fun getTotalExpenseForCategory(categoryId: Int , startTime : String , endTime : String) : Flow<List<Expense>>

}