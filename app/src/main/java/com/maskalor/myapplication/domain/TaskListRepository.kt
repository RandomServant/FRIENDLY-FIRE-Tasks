package com.maskalor.myapplication.domain

import com.maskalor.myapplication.domain.models.TaskList

interface TaskListRepository {
    suspend fun addTaskList(taskList: TaskList)
    suspend fun deleteTaskList(taskList: TaskList)
    suspend fun updateTaskList(taskList: TaskList)
    suspend fun getAllTaskLists() : List<TaskList>
    suspend fun getTaskList(id : Int) : TaskList
}