package com.example.friendlyfiretasks.data

import com.example.friendlyfiretasks.domain.models.Task
import com.example.friendlyfiretasks.domain.TaskRepository

object TaskRepositoryImplementation : TaskRepository{
    override suspend fun addTask(task: Task) {
        TODO("Not yet implemented")
    }

    override suspend fun deleteTask(task: Task) {
        TODO("Not yet implemented")
    }

    override suspend fun getTasksFromList(id: Int): List<Task> {
        TODO("Not yet implemented")
    }


}