package com.example.friendlyfiretasks.domain.useCases

import com.example.friendlyfiretasks.domain.models.Task
import com.example.friendlyfiretasks.domain.Repository

class AddTaskUseCase (private val repository: Repository) {
    fun execute(task: Task) {
        repository.createTask(task)
    }
}