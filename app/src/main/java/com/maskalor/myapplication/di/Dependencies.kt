package com.maskalor.myapplication.di

import android.content.Context
import androidx.room.Room
import com.maskalor.myapplication.data.TaskListRepositoryImpl
import com.maskalor.myapplication.data.TaskRepositoryImpl
import com.maskalor.myapplication.data.room.MyDb

object Dependencies {

    private lateinit var context: Context

    fun init(context: Context) {
        this.context = context
    }

    private val db by lazy {
        Room.databaseBuilder(context, MyDb::class.java, "task.db").build()
    }

    val taskListRepository by lazy {
        TaskListRepositoryImpl(db.taskListDao())
    }

    val taskRepository by lazy {
        TaskRepositoryImpl(db.taskDao())
    }
}