@file:Suppress("DEPRECATION")

package com.example.vehiclemanagement

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.fragment.app.Fragment
import androidx.viewpager.widget.ViewPager
import com.example.vehiclemanagement.adapter.FragmentAdapter
import com.example.vehiclemanagement.databinding.ActivityMainBinding
import com.example.vehiclemanagement.fragment.AddFragment
import com.example.vehiclemanagement.fragment.ListFragment
import com.example.vehiclemanagement.fragment.SearchFragment

class MainActivity : AppCompatActivity() {


    private val binding by lazy { ActivityMainBinding.inflate(layoutInflater) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        setView()
    }

    private fun setView() {
        val toolbar: Toolbar = binding.toolbar
        setSupportActionBar(toolbar)

        val fragmentAdapter = FragmentAdapter(initFragment(), supportFragmentManager)
        binding.viewPager.adapter = fragmentAdapter

        binding.bottomNavigation.setOnNavigationItemSelectedListener {
            when (it.itemId) {
                R.id.menuSearch -> {
                    binding.viewPager.currentItem = 1
                    supportActionBar?.setTitle("Search Vehicle")
                }
                R.id.menuAdd -> {
                    binding.viewPager.currentItem = 2
                    supportActionBar?.setTitle("Add Vehicle")
                }
                R.id.menuList -> {
                    binding.viewPager.currentItem = 3
                    supportActionBar?.setTitle("List Vehicle")
                }
            }
            true
        }

        binding.viewPager.addOnPageChangeListener(object : ViewPager.OnPageChangeListener {
            override fun onPageScrolled(
                position: Int,
                positionOffset: Float,
                positionOffsetPixels: Int
            ) {

            }

            override fun onPageSelected(position: Int) {
                when (position) {
                    1 -> {
                        binding.bottomNavigation.menu.getItem(position).isChecked = true
                        supportActionBar?.setTitle("Search Vehicle")
                    }
                    2 -> {
                        binding.bottomNavigation.menu.getItem(position).isChecked = true
                        supportActionBar?.setTitle("Add Vehicle")
                    }
                    3 -> {
                        binding.bottomNavigation.menu.getItem(position).isChecked = true
                        supportActionBar?.setTitle("List Vehicle")
                    }
                }
            }

            override fun onPageScrollStateChanged(state: Int) {

            }
        })
    }

    private fun initFragment(): ArrayList<Fragment> {
        return arrayListOf(
            AddFragment.newInstance(),
            ListFragment.newInstance(),
            SearchFragment.newInstance()
        )
    }
}