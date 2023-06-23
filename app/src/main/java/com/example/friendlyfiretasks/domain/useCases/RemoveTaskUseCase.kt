package com.example.friendlyfiretasks.domain.useCases

import com.example.friendlyfiretasks.data.Task
import com.example.friendlyfiretasks.domain.Repository

class RemoveTaskUseCase (private val repository: Repository) {
    fun execute(task: Task) {
        repository.deleteTask(task)
    }
}