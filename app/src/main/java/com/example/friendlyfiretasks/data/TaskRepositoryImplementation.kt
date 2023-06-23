package com.example.friendlyfiretasks.data

import com.example.friendlyfiretasks.data.room.dao.TaskDao
import com.example.friendlyfiretasks.domain.models.Task
import com.example.friendlyfiretasks.domain.TaskRepository

class TaskRepositoryImplementation(private val taskDao: TaskDao) : TaskRepository {

    private val mapper = Mapper()

//    init {
//        GlobalScope.launch {
//            for (i in 0..10) {
//                addTask(Task("NAME $i", "test", i+1))
//                addTask(Task("NAgdfgsdgsgME $i", "test", i+1))
//            }
//
//        }
//    }

    override suspend fun addTask(task: Task) {
        taskDao.addTask(mapper.taskToTaskEntity(task))
    }

    override suspend fun deleteTask(task: Task) {
        taskDao.deleteTask(mapper.taskToTaskEntity(task))
    }

    override suspend fun getTasksFromList(id: Int): List<Task> {
        return taskDao.getTasksFromTaskList(id).map {
            mapper.taskEntityToTask(it)
        }
    }
}