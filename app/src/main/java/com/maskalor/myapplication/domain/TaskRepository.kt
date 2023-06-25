package com.maskalor.myapplication.domain

import com.maskalor.myapplication.domain.models.Task
import com.maskalor.myapplication.domain.models.TaskList

interface TaskRepository {
    suspend fun addTask(task: Task)
    suspend fun updateTask(task: Task)
    suspend fun deleteTask(task: Task)
    suspend fun getTasksFromTaskList(id: Int): List<Task>
    suspend fun getFavoriteTasksFromTaskList(): List<Task>
    suspend fun getTaskFromTaskList(id: Int, taskListId: Int): Task
}