package com.maskalor.myapplication.domain.usecase

import com.maskalor.myapplication.domain.TaskListRepository
import com.maskalor.myapplication.domain.models.TaskList

class GetAllTaskListUseCase(private val taskListRepository: TaskListRepository) {
    suspend fun execute() : List<TaskList>{
        return taskListRepository.getAllTaskLists()
    }
}