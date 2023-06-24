package com.example.friendlyfiretasks.presentation

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import com.example.friendlyfiretasks.R
import com.example.friendlyfiretasks.databinding.ActivityTaskBinding
import com.example.friendlyfiretasks.di.Dependencies
import com.example.friendlyfiretasks.domain.models.Task
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class TaskActivity : AppCompatActivity() {

    lateinit var binding: ActivityTaskBinding

    val taskListID by lazy { intent.getIntExtra(ARG_TASK_LIST_ID, 0)}

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityTaskBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.saveButton.setOnClickListener {
            val title = binding.editName.text.toString()
            val desc = binding.editDesc.text.toString()
            val date = binding.editDate.text.toString()
            GlobalScope.launch {
                Dependencies.taskRepository.addTask(Task(title, desc, taskListID, date))
            }

        }
    }

    companion object {
        private const val ARG_TASK_LIST_ID = "taskListID"
        fun getIntent(context: Context, taskListId: Int) : Intent{
            val intent = Intent(context, TaskActivity::class.java)
            intent.putExtra(ARG_TASK_LIST_ID, taskListId)
            return intent
        }
    }
}