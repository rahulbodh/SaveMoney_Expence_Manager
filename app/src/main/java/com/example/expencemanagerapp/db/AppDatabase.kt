package com.example.expencemanagerapp.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.expencemanagerapp.db.dao.CategoryDao
import com.example.expencemanagerapp.db.dao.ExpenseDao
import com.example.expencemanagerapp.db.entity.Category
import com.example.expencemanagerapp.db.entity.Expense

@Database(
    entities = [Category::class , Expense::class],
    version = 1,
    exportSchema = false
)
abstract class AppDatabase : RoomDatabase() {

    abstract fun categoryDao() : CategoryDao
    abstract fun expenseDao() : ExpenseDao

    companion object{

        @Volatile
        private var INSTANCE: AppDatabase? = null

        fun getDatabase(context : Context):AppDatabase {
            return INSTANCE ?: synchronized(this){
                val instanse = Room.databaseBuilder(
                    context.applicationContext,
                    AppDatabase::class.java,
                    "save_money_db"
                ).build()
                INSTANCE = instanse
                instanse
            }
        }
    }

}