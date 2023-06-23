package com.example.friendlyfiretasks.data

import com.example.friendlyfiretasks.data.room.dao.TaskListDao
import com.example.friendlyfiretasks.domain.TaskListRepository
import com.example.friendlyfiretasks.domain.models.TaskList

class TaskListRepositoryImplementation(private val taskListDao: TaskListDao) : TaskListRepository {

    private val mapper = Mapper()

//    init {
//        for (i in 0..10) {
//            GlobalScope.launch {
//                addTaskList(TaskList("NAME $i"))
//            }
//        }
//    }

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
            TaskList(it.name, it.id)
        }
    }
}