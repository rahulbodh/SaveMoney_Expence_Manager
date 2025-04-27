package com.example.expencemanagerapp.db.repository

import com.example.expencemanagerapp.db.dao.RecentTransactionDao
import com.example.expencemanagerapp.db.entity.RecentTransaction

class RecentTransactionRepository (private val recentTransactionDao : RecentTransactionDao) {

    suspend fun insertRecentTransaction(recentTransaction: RecentTransaction) = recentTransactionDao.insertTransaction(recentTransaction)

    suspend fun updateTransaction(recentTransaction: RecentTransaction) = recentTransactionDao.updateTransaction(recentTransaction)

    suspend fun deleteRecentTransaction(recentTransaction: RecentTransaction) = recentTransactionDao.deleteTransaction(recentTransaction)
}