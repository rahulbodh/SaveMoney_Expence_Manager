package com.example.expencemanagerapp.view.adapter

import android.annotation.SuppressLint
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.core.content.ContextCompat.startActivity
import androidx.recyclerview.widget.RecyclerView
import com.example.expencemanagerapp.R
import com.example.expencemanagerapp.model.CategoryCardItem
import com.example.expencemanagerapp.view.EntryCategoryDataActivity

class CategoryCardViewAdapter(
    private val items: List<CategoryCardItem>
) : RecyclerView.Adapter<CategoryCardViewAdapter.CardViewHolder>() {

    // ViewHolder to hold and bind the views
    inner class CardViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val recentActivityTextView: TextView = itemView.findViewById(R.id.recentActivityTextView)
        private val getMoneyTextView: TextView = itemView.findViewById(R.id.item)
        private val paidMoneyTextView: TextView = itemView.findViewById(R.id.paidItem)

        @SuppressLint("SetTextI18n")
        fun bind(item: CategoryCardItem) {
            recentActivityTextView.text = item.recentActivity
            getMoneyTextView.text = "Rs. ${item.getMoney}"
            paidMoneyTextView.text = "Rs. ${item.paidMoney}"
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CardViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.recent_activity_list_item, parent, false)
        view.setOnClickListener {
            val intent = Intent(parent.context, EntryCategoryDataActivity::class.java)
            startActivity(parent.context, intent, null)

        }
        return CardViewHolder(view)
    }

    override fun onBindViewHolder(holder: CardViewHolder, position: Int) {
        holder.bind(items[position])
    }

    override fun getItemCount(): Int = items.size
}
