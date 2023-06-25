package com.maskalor.myapplication.domain.usecase

import com.maskalor.myapplication.domain.TaskListRepository
import com.maskalor.myapplication.domain.models.TaskList

class DeleteTaskListUseCase (private val taskListRepository: TaskListRepository) {
    suspend fun execute(taskList: TaskList){
        taskListRepository.deleteTaskList(taskList)
    }
}