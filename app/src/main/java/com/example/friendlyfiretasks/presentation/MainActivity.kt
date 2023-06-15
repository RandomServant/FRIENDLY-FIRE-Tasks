package com.example.friendlyfiretasks.presentation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.friendlyfiretasks.R
import com.google.android.material.floatingactionbutton.FloatingActionButton

class MainActivity : AppCompatActivity() {

    private lateinit var viewModel: TaskActivityViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        viewModel = ViewModelProvider(this)[TaskActivityViewModel::class.java]

        val recycler = findViewById<RecyclerView>(R.id.recycler)
        val adapter = TaskListAdapter()
        recycler.adapter = adapter
        recycler.layoutManager = LinearLayoutManager(this)

        adapter.onClick = {
            startActivity(TaskActivity.getIntent(this, it.name, it.description))
        }

        adapter.onLongClick = { task, pos ->
            viewModel.changeFavoriteState(task)
            adapter.update(pos)
            true
        }

        viewModel.taskList.observe(this) {
            adapter.submitList(it)
        }

        viewModel.getAllTaskList()

        findViewById<FloatingActionButton>(R.id.button_add).setOnClickListener {
            viewModel.addTaskToList("New task", "desc")
        }
    }
}