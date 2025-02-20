package com.example.expencemanagerapp.db.repository

import com.example.expencemanagerapp.db.dao.CategoryDao
import com.example.expencemanagerapp.db.dao.ExpenseDao
import com.example.expencemanagerapp.db.entity.Category
import com.example.expencemanagerapp.db.entity.Expense

class CategoryRepository(private val expenseDao: ExpenseDao , private val categoryDao: CategoryDao){

    suspend fun insertCategory(category: Category) = categoryDao.insertCategory(category)

    fun getCategoriesForMonth(monthYear: String) = categoryDao.getCategoriesForMonth(monthYear)


    suspend fun updateCategory(category: Category) = categoryDao.updateCategory(category)

    suspend fun deleteCategory(category: Category) = categoryDao.delete(category)

    // Expense operations
    fun getExpensesForDateRange(startDate: String, endDate: String) =
        expenseDao.getExpensesByDateRange(startDate, endDate)

    fun getExpensesByCategory(categoryId: Int) = expenseDao.getExpensesByCategory(categoryId)

    fun getTotalExpenseForCategory(categoryId: Int, startDate: String, endDate: String) =
        expenseDao.getTotalExpenseForCategory(categoryId, startDate, endDate)

    suspend fun insertExpense(expense: Expense) = expenseDao.insert(expense)

    suspend fun updateExpense(expense: Expense) = expenseDao.update(expense)

    suspend fun deleteExpense(expense: Expense) = expenseDao.delete(expense)
}