package com.example.expencemanagerapp.view.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.expencemanagerapp.R

class UserOptionAdapter(
    private val options: List<Pair<String, Int>>,
    private val onOptionClick: (String) -> Unit
) : RecyclerView.Adapter<UserOptionAdapter.UserOptionViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserOptionViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_user_option, parent, false)
        return UserOptionViewHolder(view)
    }

    override fun onBindViewHolder(holder: UserOptionViewHolder, position: Int) {
        val (optionText, iconRes) = options[position]
        holder.bind(optionText, iconRes)
        holder.itemView.setOnClickListener { onOptionClick(optionText) }
    }

    override fun getItemCount() = options.size

    class UserOptionViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val icon: ImageView = itemView.findViewById(R.id.item_icon)
        private val text: TextView = itemView.findViewById(R.id.item_text)

        fun bind(optionText: String, iconRes: Int) {
            text.text = optionText
            icon.setImageResource(iconRes)
        }
    }
}
