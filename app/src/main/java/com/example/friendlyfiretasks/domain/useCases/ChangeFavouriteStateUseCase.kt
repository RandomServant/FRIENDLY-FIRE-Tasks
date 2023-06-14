package com.example.friendlyfiretasks.domain.useCases

import com.example.friendlyfiretasks.data.Task
import com.example.friendlyfiretasks.domain.Repository

class ChangeFavouriteStateUseCase(private val repository: Repository) {
    fun execute(task: Task) {
        task.isFavourite = !task.isFavourite
        repository.updateTask(task)
    }
}