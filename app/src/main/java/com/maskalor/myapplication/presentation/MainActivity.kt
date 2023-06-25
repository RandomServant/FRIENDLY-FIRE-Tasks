package com.maskalor.myapplication.presentation

import android.content.pm.ActivityInfo
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.get
import androidx.lifecycle.ViewModelProvider
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayout.OnTabSelectedListener
import com.google.android.material.tabs.TabLayoutMediator
import com.maskalor.myapplication.databinding.ActivityMainBinding
import com.maskalor.myapplication.di.Dependencies
import com.maskalor.myapplication.domain.models.Task
import com.maskalor.myapplication.domain.models.TaskList

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding
    lateinit var vpAdapter: ViewPagerAdapter
    lateinit var vm: MainViewModel
    var tabIndex: Int = 0


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        requestedOrientation = ActivityInfo.SCREEN_ORIENTATION_PORTRAIT

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        vm = ViewModelProvider(this)[MainViewModel::class.java]

        Dependencies.taskRepository

        vm.taskLists.observe(this){
            vpAdapter = ViewPagerAdapter(this, it)
            binding.viewPager.adapter = vpAdapter
            TabLayoutMediator(binding.tabLayout, binding.viewPager) { tab, pos ->
                tab.text = it[pos].name
                tab.id = it[pos].id
            }.attach()
        }

        binding.addListButton.setOnClickListener {
            startActivity(
                TaskListActivity.getIntent(applicationContext, TaskList.UNDEFINED_ID, "true")
            )
        }

        binding.addTaskListButton.setOnClickListener {
            if(tabIndex == 0) tabIndex++
            startActivity(
                vm.taskLists.value?.get(tabIndex)?.let { it1 -> TaskActivity.getIntent(
                    this, it1.id, "true", Task.UNDEFINED_ID) })
        }

        vm.getAllTAskList()

        binding.tabLayout.addOnTabSelectedListener(object : OnTabSelectedListener{
            override fun onTabSelected(tab: TabLayout.Tab?) {
                tabIndex = tab!!.position
            }

            override fun onTabUnselected(tab: TabLayout.Tab?) {
                return
            }

            override fun onTabReselected(tab: TabLayout.Tab?) {
                startActivity(
                    tab?.let {
                        TaskListActivity.getIntent(applicationContext, it.id, "false")
                    })
                return
            }
        })
    }

    override fun onResume() {
        super.onResume()
        vm.getAllTAskList()
    }
}