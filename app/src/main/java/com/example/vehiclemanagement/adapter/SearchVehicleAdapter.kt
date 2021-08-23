package com.example.vehiclemanagement.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.vehiclemanagement.R
import com.example.vehiclemanagement.data.model.Vehicle
import com.example.vehiclemanagement.fragment.SearchFragment

class SearchVehicleAdapter(private val context: Context, private val vehicle: Vehicle) :
    RecyclerView.Adapter<SearchVehicleAdapter.ViewHolder>() {

    val searchFragment = SearchFragment()
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SearchVehicleAdapter.ViewHolder {
        return ViewHolder(
            LayoutInflater.from(context).inflate(R.layout.item_search_vehicle, parent, false)
        )
    }

    override fun getItemCount(): Int = 1

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        val textViewID: TextView = itemView.findViewById(R.id.item_search_id)
        val textViewName: TextView = itemView.findViewById(R.id.item_search_name)
        val textViewType: TextView = itemView.findViewById(R.id.item_search_type)
        val textViewPrice: TextView = itemView.findViewById(R.id.item_search_price)
        val buttonEdit:ImageButton = itemView.findViewById(R.id.imageButtonEdit)
        val buttonDelete:ImageButton = itemView.findViewById(R.id.imageButtonDelete)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.textViewID.text = vehicle.id
        holder.textViewName.text = vehicle.name
        holder.textViewType.text = vehicle.type
        holder.textViewPrice.text = vehicle.price.toString()

        holder.buttonEdit.setOnClickListener {
            editVehicle()
        }

        holder.buttonDelete.setOnClickListener {
            deleteVehicle()
        }
    }
}