package com.example.vehiclemanagement.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.RadioButton
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.vehiclemanagement.R
import com.example.vehiclemanagement.adapter.VehicleAdapter
import com.example.vehiclemanagement.data.database.DatabaseHelper
import kotlinx.android.synthetic.main.fragment_add.*
import kotlinx.android.synthetic.main.fragment_list.*

class ListFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_list, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        listVehicle()

        onRadioButtonClicked(view)

        buttonSort.setOnClickListener {
            sortVehicle()
        }
    }

    private fun sortVehicle() {
        val price = editTextAddVehiclePrice.text.toString()
        val pricee = price.toInt()
        val databaseHelper = DatabaseHelper(requireContext())
        if (price.isNotEmpty()) {
            val vehicleList = databaseHelper.getVehicleByPrice(pricee)
            if (vehicleList.size > 0) {
                textViewListFragmentBlank.visibility = View.GONE

                val vehicleAdapter = VehicleAdapter(requireContext(), vehicleList)
                recyclerView.layoutManager = LinearLayoutManager(requireContext())
                recyclerView.hasFixedSize()
                recyclerView.adapter = vehicleAdapter
            } else {
                recyclerView.visibility = View.GONE
                textViewListFragmentBlank.visibility = View.VISIBLE
            }
        } else {
            Toast.makeText(context, "Please enter a price", Toast.LENGTH_LONG).show()
        }
    }

    private fun onRadioButtonClicked(view: View) {
        if (view is RadioButton) {
            val checked = view.isChecked

            when (view.getId()) {
                R.id.buttonSortNameAsc ->
                    if (checked) {
                        val databaseHelper = DatabaseHelper(requireContext())
                        val vehicleList = databaseHelper.getVehicleNameAsc()
                        if (vehicleList.size > 0) {
                            textViewListFragmentBlank.visibility = View.GONE

                            val vehicleAdapter = VehicleAdapter(requireContext(), vehicleList)
                            recyclerView.layoutManager = LinearLayoutManager(requireContext())
                            recyclerView.hasFixedSize()
                            recyclerView.adapter = vehicleAdapter
                        } else {
                            recyclerView.visibility = View.GONE
                            textViewListFragmentBlank.visibility = View.VISIBLE
                        }
                    }
                R.id.buttonSortNameDesc ->
                    if (checked) {
                        val databaseHelper = DatabaseHelper(requireContext())
                        val vehicleList = databaseHelper.getVehicleNameDesc()
                        if (vehicleList.size > 0) {
                            textViewListFragmentBlank.visibility = View.GONE

                            val vehicleAdapter = VehicleAdapter(requireContext(), vehicleList)
                            recyclerView.layoutManager = LinearLayoutManager(requireContext())
                            recyclerView.hasFixedSize()
                            recyclerView.adapter = vehicleAdapter
                        } else {
                            recyclerView.visibility = View.GONE
                            textViewListFragmentBlank.visibility = View.VISIBLE
                        }
                    }
                R.id.buttonSortPriceAsc ->
                    if (checked) {
                        val databaseHelper = DatabaseHelper(requireContext())
                        val vehicleList = databaseHelper.getVehiclePriceAsc()
                        if (vehicleList.size > 0) {
                            textViewListFragmentBlank.visibility = View.GONE

                            val vehicleAdapter = VehicleAdapter(requireContext(), vehicleList)
                            recyclerView.layoutManager = LinearLayoutManager(requireContext())
                            recyclerView.hasFixedSize()
                            recyclerView.adapter = vehicleAdapter
                        } else {
                            recyclerView.visibility = View.GONE
                            textViewListFragmentBlank.visibility = View.VISIBLE
                        }
                    }
                R.id.buttonSortPriceDesc ->
                    if (checked) {
                        val databaseHelper = DatabaseHelper(requireContext())
                        val vehicleList = databaseHelper.getVehiclePriceDesc()
                        if (vehicleList.size > 0) {
                            textViewListFragmentBlank.visibility = View.GONE

                            val vehicleAdapter = VehicleAdapter(requireContext(), vehicleList)
                            recyclerView.layoutManager = LinearLayoutManager(requireContext())
                            recyclerView.hasFixedSize()
                            recyclerView.adapter = vehicleAdapter
                        } else {
                            recyclerView.visibility = View.GONE
                            textViewListFragmentBlank.visibility = View.VISIBLE
                        }
                    }
            }
        }
    }

    private fun listVehicle() {
        val databaseHelper = DatabaseHelper(requireContext())
        val vehicleList = databaseHelper.getAllVehicle()
        if (vehicleList.size > 0) {
            textViewListFragmentBlank.visibility = View.GONE

            val vehicleAdapter = VehicleAdapter(requireContext(), vehicleList)
            recyclerView.layoutManager = LinearLayoutManager(requireContext())
            recyclerView.hasFixedSize()
            recyclerView.adapter = vehicleAdapter
        } else {
            recyclerView.visibility = View.GONE
            textViewListFragmentBlank.visibility = View.VISIBLE
        }
    }


    companion object {
        @JvmStatic
        fun newInstance() = ListFragment()
    }
}