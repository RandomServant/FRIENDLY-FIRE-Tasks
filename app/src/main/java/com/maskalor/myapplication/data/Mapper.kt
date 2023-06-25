package com.maskalor.myapplication.data

import com.maskalor.myapplication.data.room.entity.TaskEntity
import com.maskalor.myapplication.data.room.entity.TaskListEntity
import com.maskalor.myapplication.domain.models.Task
import com.maskalor.myapplication.domain.models.TaskList

class Mapper {
    fun taskListToTaskListEntity(taskList: TaskList) : TaskListEntity {
        return TaskListEntity(taskList.id, taskList.name, taskList.isStandard)
    }

    fun taskListEntityToTaskList(taskList: TaskListEntity) : TaskList {
        return TaskList(taskList.name, taskList.isStandard, taskList.id)
    }

    fun taskToTaskEntity(task: Task): TaskEntity {
        return TaskEntity(task.id, task.name, task.description, task.date, task.taskListId, task.isFavorite)
    }

    fun taskEntityToTask(task: TaskEntity): Task {
        return Task(task.name, task.description, task.date, task.taskListId, task.isFavorite, task.id)
    }
}