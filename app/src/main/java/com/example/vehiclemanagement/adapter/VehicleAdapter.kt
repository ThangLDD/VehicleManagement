package com.example.vehiclemanagement.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.vehiclemanagement.R
import com.example.vehiclemanagement.data.model.Vehicle

class VehicleAdapter(private val context: Context, private val vehicleList: ArrayList<Vehicle>) :
    RecyclerView.Adapter<VehicleAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VehicleAdapter.ViewHolder {
        return ViewHolder(
            LayoutInflater.from(context).inflate(R.layout.item_vehicle, parent, false)
        )
    }

    override fun onBindViewHolder(holder: VehicleAdapter.ViewHolder, position: Int) {
        val currentItem = vehicleList[position]
        holder.textViewID.text = currentItem.id
        holder.textViewName.text = currentItem.name
        holder.textViewType.text = currentItem.type
        holder.textViewPrice.text = currentItem.price.toString()
    }

    override fun getItemCount(): Int = vehicleList.size

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        val textViewID: TextView = itemView.findViewById(R.id.item_id)
        val textViewName: TextView = itemView.findViewById(R.id.item_name)
        val textViewType: TextView = itemView.findViewById(R.id.item_type)
        val textViewPrice: TextView = itemView.findViewById(R.id.item_price)

    }
}