package com.maskalor.myapplication.data

import com.maskalor.myapplication.data.room.entity.TaskEntity
import com.maskalor.myapplication.data.room.entity.TaskListEntity
import com.maskalor.myapplication.domain.models.Task
import com.maskalor.myapplication.domain.models.TaskList

class Mapper {
    fun taskListToTaskListEntity(taskList: TaskList) : TaskListEntity {
        return TaskListEntity(taskList.id, taskList.name)
    }

    fun taskListEntityToTaskList(taskList: TaskListEntity) : TaskList {
        return TaskList(taskList.name, taskList.id)
    }

    fun taskToTaskEntity(task: Task): TaskEntity {
        return TaskEntity(task.id, task.name, task.description, task.taskListId)
    }

    fun taskEntityToTask(task: TaskEntity): Task {
        return Task(task.name, task.description, task.taskListId, task.id)
    }
}