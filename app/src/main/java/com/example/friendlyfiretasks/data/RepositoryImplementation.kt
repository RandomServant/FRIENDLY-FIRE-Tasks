package com.example.friendlyfiretasks.data

import com.example.friendlyfiretasks.domain.Repository

object RepositoryImplementation : Repository{

    private val taskList = mutableListOf<Task>()

    private var autoIncrement = 0

    init {
        for (i in 0..5) {
            val task = Task("Task № ${i}", "Description № ${i}")
            createTask(task)
        }
    }

    override fun createTask(task: Task) {
        if (task.id == Task.UNDEFINED_ID) {
            task.id = autoIncrement++
        }
        taskList.add(task)
    }

    override fun getTaskById(id: Int): Task {
        return taskList.find {
            it.id == id
        }!!
    }

    override fun updateTask(task: Task) {
        val oldTask = taskList.find {
            it.id == task.id
        }
        taskList.remove(oldTask)
        taskList.add(task.id, task)
    }

    override fun deleteTask(task: Task){
        taskList.remove(task)
    }

    override fun getAllTask(): List<Task> {
        return taskList.toList()
    }
}