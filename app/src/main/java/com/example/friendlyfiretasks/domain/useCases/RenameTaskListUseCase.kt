package com.example.friendlyfiretasks.domain.useCases

import com.example.friendlyfiretasks.domain.TaskListRepository
import com.example.friendlyfiretasks.domain.models.TaskList

class RenameTaskListUseCase(private val repository: TaskListRepository) {
    suspend fun execute(taskList: TaskList, newName: String) {
        taskList.name = newName
        repository.updateTaskList(taskList)
    }
}