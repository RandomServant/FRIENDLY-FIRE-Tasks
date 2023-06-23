package com.example.friendlyfiretasks.di

import android.content.Context
import androidx.room.Room
import com.example.friendlyfiretasks.data.MyDb
import com.example.friendlyfiretasks.data.TaskListRepositoryImplementation
import com.example.friendlyfiretasks.data.TaskRepositoryImplementation

object Dependencies {
    private lateinit var context: Context

    fun init(context: Context) {
        this.context = context
    }

    private val db by lazy {
        Room.databaseBuilder(context, MyDb::class.java, "task.db").build()
    }

    val taskListRepository by lazy {
        TaskListRepositoryImplementation(db.taskListDao())
    }

    val taskRepository by lazy {
        TaskRepositoryImplementation(db.taskDao())
    }
}