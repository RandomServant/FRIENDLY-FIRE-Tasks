package com.maskalor.myapplication

import android.app.Application
import com.maskalor.myapplication.di.Dependencies
import com.maskalor.myapplication.domain.models.TaskList
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch


class App : Application() {
    override fun onCreate() {
        super.onCreate()
        Dependencies.init(applicationContext)

        GlobalScope.launch {
            if (Dependencies.taskListRepository.getAllTaskLists().size < 2) {
                Dependencies.taskListRepository.addTaskList(TaskList("Favorite", true))
                Dependencies.taskListRepository.addTaskList(TaskList("My Tasks", true))
            }
        }
    }
}