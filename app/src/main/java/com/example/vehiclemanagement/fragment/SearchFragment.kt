package com.example.vehiclemanagement.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.vehiclemanagement.R
import com.example.vehiclemanagement.adapter.SearchVehicleAdapter
import com.example.vehiclemanagement.data.database.DatabaseHelper
import kotlinx.android.synthetic.main.fragment_list.*
import kotlinx.android.synthetic.main.fragment_search.*

class SearchFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_search, container, false)
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        buttonSearchVehicleID.setOnClickListener {
            findVehicleByID()
        }

        buttonSearchVehicleName.setOnClickListener {
            findVehicleByName()
        }
    }

    private fun findVehicleByID() {
        val id = editTextSearchVehicleID.text.toString()

        val databaseHelper = DatabaseHelper(requireContext())

        val query = databaseHelper.getVehicleByID(id)
        if (query != null) {
            textViewListFragmentBlank.visibility = View.GONE

            val vehicleAdapter = SearchVehicleAdapter(requireContext(), query)
            recyclerView.layoutManager = LinearLayoutManager(requireContext())
            recyclerView.hasFixedSize()
            recyclerView.adapter = vehicleAdapter
        } else {
            recyclerView.visibility = View.GONE
            textViewListFragmentBlank.visibility = View.VISIBLE
        }
    }

    private fun findVehicleByName() {
        val name = editTextSearchVehicleName.text.toString()

        val databaseHelper = DatabaseHelper(requireContext())

        val query = databaseHelper.getVehicleByName(name)
        if (query != null) {
            textViewListFragmentBlank.visibility = View.GONE

            val vehicleAdapter = SearchVehicleAdapter(requireContext(), query)
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
        fun newInstance() = SearchFragment()
    }
}