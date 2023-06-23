package com.example.friendlyfiretasks.domain

import com.example.friendlyfiretasks.domain.models.Task

interface Repository {
    fun createTask (task: Task)
    fun getTaskById(id: Int) : Task
    fun updateTask(task: Task)
    fun deleteTask(task: Task)
    fun getAllTask() : List<Task>
}