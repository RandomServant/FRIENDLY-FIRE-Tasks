package com.example.friendlyfiretasks.domain

import com.example.friendlyfiretasks.domain.models.TaskList

interface TaskListRepository {
    suspend fun addTaskList(taskList: TaskList)
    suspend fun deleteTaskList(taskList: TaskList)
    suspend fun updateTaskList(taskList: TaskList)
    suspend fun getAllTaskLists() : List<TaskList>
}