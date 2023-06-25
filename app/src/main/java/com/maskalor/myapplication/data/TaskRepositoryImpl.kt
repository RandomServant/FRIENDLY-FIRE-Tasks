package com.maskalor.myapplication.data

import android.util.Log
import com.maskalor.myapplication.domain.dao.TaskDao
import com.maskalor.myapplication.domain.TaskRepository
import com.maskalor.myapplication.domain.models.Task
import com.maskalor.myapplication.domain.models.TaskList
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class TaskRepositoryImpl(private val taskDao: TaskDao) : TaskRepository {

    private val mapper = Mapper()

    override suspend fun addTask(task: Task) {
        taskDao.addTask(mapper.taskToTaskEntity(task))
    }
    override suspend fun updateTask(task: Task) {
        taskDao.updateTask(mapper.taskToTaskEntity(task))
    }

    override suspend fun deleteTask(task: Task) {
        taskDao.deleteTask(mapper.taskToTaskEntity(task))
    }

    override suspend fun getTasksFromTaskList(id: Int): List<Task> {
        return taskDao.getTasksFromTaskList(id).map {
            mapper.taskEntityToTask(it)
        }
    }

    override suspend fun getTaskFromTaskList(id: Int, taskListId: Int): Task {
        return mapper.taskEntityToTask(taskDao.getTaskFromTaskList(id, taskListId))
    }

}