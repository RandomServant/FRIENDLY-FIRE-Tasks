package com.example.friendlyfiretasks.domain

import com.example.friendlyfiretasks.domain.models.Task

interface TaskRepository {
    suspend fun addTask (task: Task)
    suspend fun deleteTask(task: Task)
    suspend fun getTasksFromList(id: Int) : List<Task>
}