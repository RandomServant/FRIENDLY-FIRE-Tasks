package com.example.friendlyfiretasks.domain.useCases

import com.example.friendlyfiretasks.domain.TaskListRepository
import com.example.friendlyfiretasks.domain.models.TaskList

class GetAllTaskListUseCase(private val taskListRepository: TaskListRepository) {
    suspend fun execute() : List<TaskList>{
        return taskListRepository.getAllTaskLists()
    }
}