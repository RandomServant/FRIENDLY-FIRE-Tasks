package com.maskalor.myapplication.domain.usecase

import com.maskalor.myapplication.domain.TaskListRepository
import com.maskalor.myapplication.domain.models.TaskList

class AddTaskListUseCase(private val taskListRepository: TaskListRepository) {
    suspend fun execute(name: String){
        val taskList = TaskList(name)
        taskListRepository.addTaskList(taskList)
    }
}