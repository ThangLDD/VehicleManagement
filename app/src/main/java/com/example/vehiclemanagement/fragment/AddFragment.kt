package com.example.vehiclemanagement.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.example.vehiclemanagement.R
import com.example.vehiclemanagement.data.database.DatabaseHelper
import com.example.vehiclemanagement.data.model.Vehicle
import kotlinx.android.synthetic.main.fragment_add.*

class AddFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_add, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        buttonAddVehicle.setOnClickListener {
            addVehicle()
        }
    }

    private fun addVehicle() {
        val id = editTextAddVehicleID.text.toString()
        val name = editTextAddVehicleName.text.toString()
        val type = editTextAddVehicleType.text.toString()
        val price = editTextAddVehiclePrice.text.toString()

        val databaseHelper = DatabaseHelper(requireContext())

        if (id.isNotEmpty() && name.isNotEmpty() && type.isNotEmpty() && price.isNotEmpty()) {
            val pricee = price.toInt()
            val status = databaseHelper.addVehicle(Vehicle(id, name, type, pricee))
            if (status > -1) {
                Toast.makeText(context, "Vehicle added", Toast.LENGTH_SHORT).show()
                editTextAddVehicleID.text.clear()
                editTextAddVehicleName.text.clear()
                editTextAddVehicleType.text.clear()
                editTextAddVehiclePrice.text.clear()
            }
        } else {
            Toast.makeText(context, "Please fill full information", Toast.LENGTH_LONG).show()
        }
    }

    companion object {
        @JvmStatic
        fun newInstance() = AddFragment()
    }
}