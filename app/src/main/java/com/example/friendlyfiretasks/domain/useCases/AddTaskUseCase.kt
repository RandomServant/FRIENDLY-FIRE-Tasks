package com.example.friendlyfiretasks.domain.useCases

import com.example.friendlyfiretasks.domain.models.Task
import com.example.friendlyfiretasks.domain.TaskRepository

class AddTaskUseCase (private val repository: TaskRepository) {
    suspend fun execute(task: Task) {
        repository.addTask(task)
    }
}