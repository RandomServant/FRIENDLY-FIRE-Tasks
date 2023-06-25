package com.maskalor.myapplication.domain.dao

import androidx.room.*
import com.maskalor.myapplication.data.room.entity.TaskEntity

@Dao
abstract class TaskDao {
    @Insert
    abstract suspend fun addTask(task: TaskEntity)

    @Update
    abstract suspend fun updateTask(task: TaskEntity)

    @Delete
    abstract suspend fun deleteTask(task: TaskEntity)

    @Query("SELECT * FROM task WHERE taskListId = :taskListId")
    abstract suspend fun getTasksFromTaskList(taskListId: Int): List<TaskEntity>

    @Query("SELECT * FROM task WHERE (id = :id AND taskListId = :taskListId)")
    abstract suspend fun getTaskFromTaskList(id: Int, taskListId: Int): TaskEntity

}