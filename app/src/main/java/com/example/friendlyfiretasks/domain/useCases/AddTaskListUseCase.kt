package com.example.friendlyfiretasks.domain.useCases

import com.example.friendlyfiretasks.domain.TaskListRepository
import com.example.friendlyfiretasks.domain.models.TaskList

class AddTaskListUseCase(private val taskListRepository: TaskListRepository) {
    suspend fun execute(name: String){
        val taskList = TaskList(name)
        taskListRepository.addTaskList(taskList)
    }
}