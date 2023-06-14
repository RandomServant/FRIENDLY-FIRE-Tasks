package com.example.friendlyfiretasks.domain.useCases

import com.example.friendlyfiretasks.data.Task
import com.example.friendlyfiretasks.domain.Repository

class GetAllTaskListUseCase(private val repository: Repository) {
    fun execute() : List<Task> {
        return repository.getAllTask()
    }
}