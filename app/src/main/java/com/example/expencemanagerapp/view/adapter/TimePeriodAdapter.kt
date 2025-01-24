package com.example.expencemanagerapp.view.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.expencemanagerapp.R
import com.example.expencemanagerapp.view.adapter.TimePeriodAdapter.TimePeriodViewHolder


class TimePeriodAdapter(
    private val context: Context,
    private val timePeriods: List<String>,
    private val onItemClickListener: (Any, Any) -> Unit
) : RecyclerView.Adapter<TimePeriodViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TimePeriodViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.item_time_period, parent, false)
        return TimePeriodViewHolder(view)
    }

    override fun onBindViewHolder(holder: TimePeriodViewHolder, position: Int) {
        val timePeriod = timePeriods[position]
        holder.textItem.text = timePeriod

        holder.textItem.setOnClickListener { v: View? ->
            onItemClickListener?.invoke(position, timePeriod)
        }
    }

    override fun getItemCount(): Int {
        return timePeriods.size
    }

    class TimePeriodViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var textItem: TextView = itemView.findViewById(R.id.cat1)
    }

    interface OnItemClickListener {
        fun onItemClick(position: Int, timePeriod: String?)
    }
}