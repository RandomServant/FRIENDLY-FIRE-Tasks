package com.maskalor.myapplication.domain.usecase

import com.maskalor.myapplication.domain.TaskRepository
import com.maskalor.myapplication.domain.models.Task

class ChangeFavoriteState(private val repository: TaskRepository) {
    suspend fun execute(task: Task) {
        task.isFavorite = !task.isFavorite
        repository.updateTask(task)
    }
}