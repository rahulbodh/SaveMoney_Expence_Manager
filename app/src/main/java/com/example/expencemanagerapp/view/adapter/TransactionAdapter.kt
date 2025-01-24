package com.example.expencemanagerapp.view.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.expencemanagerapp.R
import com.example.expencemanagerapp.model.Transaction

class TransactionAdapter(
    private val context: Context,
    private val transactionList: List<Transaction>
) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    override fun getItemViewType(position: Int): Int {
        return transactionList[position].type
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val inflater = LayoutInflater.from(context)

        if (viewType == TYPE_GET) {
            val view = inflater.inflate(R.layout.transaction_get_item, parent, false)
            return GetViewHolder(view)
        } else {
            val view = inflater.inflate(R.layout.transaction_pay_item, parent, false)
            return PayViewHolder(view)
        }
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val transaction = transactionList[position]

        if (holder is GetViewHolder) {
            holder.recentActivityTextView.text = transaction.recentActivity
            holder.getMoneyTextView.text = transaction.getMoney
        } else if (holder is PayViewHolder) {
            holder.recentActivityTextView.text = transaction.recentActivity
            holder.paidMoneyTextView.text = transaction.paidMoney
        }
    }

    override fun getItemCount(): Int {
        return transactionList.size
    }

    // ViewHolder for "Get Money" transactions
    class GetViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var recentActivityTextView: TextView = itemView.findViewById(R.id.getActivityTextView)
        var getMoneyTextView: TextView = itemView.findViewById(R.id.getTextView)
    }

    // ViewHolder for "Pay Money" transactions
    class PayViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var recentActivityTextView: TextView = itemView.findViewById(R.id.paidActivityTextView)
        var paidMoneyTextView: TextView = itemView.findViewById(R.id.paidTextView)
    }

    companion object {
        private const val TYPE_GET = Transaction.TYPE_GET
        private const val TYPE_PAY = Transaction.TYPE_PAY
    }
}