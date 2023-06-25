package com.maskalor.myapplication.presentation

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.maskalor.myapplication.databinding.ActivityTaskBinding
import com.maskalor.myapplication.di.Dependencies
import com.maskalor.myapplication.domain.models.Task
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class TaskActivity : AppCompatActivity() {

    lateinit var binding: ActivityTaskBinding
    lateinit var newStatus: String
    lateinit var task: Task

    val taskListID by lazy { intent.getIntExtra(ARG_TASK_LIST_ID, 0)}
    val taskID by lazy { intent.getIntExtra(TASK_ID, 0)}

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityTaskBinding.inflate(layoutInflater)
        setContentView(binding.root)

        newStatus = intent.getStringExtra(NEW_STATUS).toString()
        task = Task("", "", "", taskListID)

        if(newStatus != "true") {

            GlobalScope.launch {
                task = Dependencies.taskRepository.getTaskFromTaskList(taskID, taskListID)

                binding.editName.setText(task.name)
                binding.editDesc.setText(task.description)
                binding.editDate.setText(task.date)
                binding.checkBox.isChecked = task.isFavorite
            }
        }

        binding.saveButton.setOnClickListener {
            task.name = binding.editName.text.toString()
            task.description = binding.editDesc.text.toString()
            task.date = binding.editDate.text.toString()
            task.isFavorite = binding.checkBox.isChecked
            GlobalScope.launch {
                if (newStatus == "true")
                    Dependencies.taskRepository.addTask(Task(task.name, task.description,
                        task.date, taskListID, task.isFavorite))
                else
                    Dependencies.taskRepository.updateTask(task)
                backOnMainActivity()
            }
        }

        binding.backButton.setOnClickListener {
            backOnMainActivity()
        }

        binding.deleteButton.setOnClickListener {
            GlobalScope.launch {
                if(newStatus != "true")
                    Dependencies.taskRepository.deleteTask(task)
                backOnMainActivity()
            }
        }
    }

    private fun backOnMainActivity() {
        finish()
    }

    companion object {
        private const val NEW_STATUS = "true"
        private const val TASK_ID = "taskId"
        private const val ARG_TASK_LIST_ID = "taskListID"
        fun getIntent(context: Context, taskListId: Int, newStatus: String, id: Int) : Intent{
            val intent = Intent(context, TaskActivity::class.java)
            intent.putExtra(ARG_TASK_LIST_ID, taskListId)
            intent.putExtra(TASK_ID, id)
            intent.putExtra(NEW_STATUS, newStatus)
            return intent
        }
    }
}