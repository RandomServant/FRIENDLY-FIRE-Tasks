package com.example.friendlyfiretasks.data

import com.example.friendlyfiretasks.data.room.entity.TaskEntity
import com.example.friendlyfiretasks.data.room.entity.TaskListEntity
import com.example.friendlyfiretasks.domain.models.Task
import com.example.friendlyfiretasks.domain.models.TaskList

class Mapper {
    fun taskListToTaskListEntity(taskList: TaskList) : TaskListEntity {
        return TaskListEntity(taskList.id, taskList.name)
    }

    fun taskToTaskEntity(task: Task): TaskEntity {
        return TaskEntity(task.id, task.name, task.description,
            task.date, task.taskListId, task.isFavourite)
    }

    fun taskEntityToTask(task: TaskEntity): Task {
        return Task(task.name, task.description, task.taskListId,
            task.date, task.isFavorite, task.id)
    }
}