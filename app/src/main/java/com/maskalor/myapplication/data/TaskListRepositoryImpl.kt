package com.maskalor.myapplication.data

import com.maskalor.myapplication.domain.dao.TaskListDao
import com.maskalor.myapplication.data.room.entity.TaskListEntity
import com.maskalor.myapplication.di.Dependencies
import com.maskalor.myapplication.domain.TaskListRepository
import com.maskalor.myapplication.domain.models.TaskList
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class TaskListRepositoryImpl(private val taskListDao: TaskListDao) : TaskListRepository {

    private val mapper = Mapper()

    init {
        GlobalScope.launch {
            if (getAllTaskLists().size < 2) {
                addTaskList(TaskList("Favorite", true))
                addTaskList(TaskList("My Tasks", true))
            }
        }
    }

    override suspend fun addTaskList(taskList: TaskList) {
        taskListDao.addTaskList(mapper.taskListToTaskListEntity(taskList))
    }

    override suspend fun deleteTaskList(taskList: TaskList) {
        taskListDao.deleteTaskList(mapper.taskListToTaskListEntity(taskList))
    }

    override suspend fun updateTaskList(taskList: TaskList) {
        taskListDao.updateTaskList(mapper.taskListToTaskListEntity(taskList))
    }

    override suspend fun getAllTaskLists(): List<TaskList> {
        return taskListDao.getAllTaskLists().map {
            TaskList(it.name, it.isStandard, it.id)
        }
    }

    override suspend fun getTaskList(id: Int): TaskList {
        return mapper.taskListEntityToTaskList(taskListDao.getTaskList(id))
    }
}