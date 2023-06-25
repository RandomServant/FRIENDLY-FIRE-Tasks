package com.maskalor.myapplication.presentation

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.maskalor.myapplication.databinding.ActivityTaskListBinding
import com.maskalor.myapplication.di.Dependencies
import com.maskalor.myapplication.domain.models.Task
import com.maskalor.myapplication.domain.models.TaskList
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlin.coroutines.CoroutineContext

class TaskListActivity : AppCompatActivity() {

    private lateinit var binding: ActivityTaskListBinding
    lateinit var newStatus: String
    lateinit var taskList: TaskList

    private val ID by lazy { intent.getIntExtra(ARG_LIST_ID, 0)}

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityTaskListBinding.inflate(layoutInflater)
        setContentView(binding.root)

        newStatus = intent.getStringExtra(NEW_STATUS).toString()
        taskList = TaskList("")

        if(newStatus != "true") {
            GlobalScope.launch {
                taskList = Dependencies.taskListRepository.getTaskList(ID)

                binding.editName.setText(taskList.name)
            }
        }

        binding.saveButton.setOnClickListener {
            taskList.name = binding.editName.text.toString();
            GlobalScope.launch {
                if (newStatus == "true")
                    Dependencies.taskListRepository.addTaskList(TaskList(taskList.name))
                else
                    Dependencies.taskListRepository.updateTaskList(taskList)
                backOnMainActivity()
            }
        }

        binding.backButton.setOnClickListener {
            backOnMainActivity()
        }

        binding.deleteButton.setOnClickListener {
            GlobalScope.launch {
                if(newStatus != "true")
                    Dependencies.taskListRepository.deleteTaskList(taskList)
                backOnMainActivity()
            }
        }
    }

    private fun backOnMainActivity() {
        finish()
    }

    companion object {
        private const val ARG_LIST_ID = "taskListID"
        private const val NEW_STATUS = "true"
        fun getIntent(context: Context, taskListId: Int, newStatus: String) : Intent {
            val intent = Intent(context, TaskListActivity::class.java)
            intent.putExtra(ARG_LIST_ID, taskListId)
            intent.putExtra(NEW_STATUS, newStatus)
            return intent
        }
    }
}