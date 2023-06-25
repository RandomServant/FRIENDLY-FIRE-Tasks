package com.maskalor.myapplication.domain.usecase

import com.maskalor.myapplication.domain.TaskListRepository
import com.maskalor.myapplication.domain.models.TaskList

class RenameTaskListUSeCase(private val repository: TaskListRepository) {
    suspend fun execute(taskList: TaskList, newName: String) {
        taskList.name = newName
        repository.updateTaskList(taskList)
    }
}