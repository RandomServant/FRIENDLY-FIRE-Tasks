package com.maskalor.myapplication.domain.dao

import androidx.room.*
import com.maskalor.myapplication.data.room.entity.TaskListEntity

@Dao
abstract class TaskListDao {
    @Insert
    abstract suspend fun addTaskList(taskListEntity: TaskListEntity)

    @Delete
    abstract suspend fun deleteTaskList(taskListEntity: TaskListEntity)

    @Update
    abstract suspend fun updateTaskList(taskListEntity: TaskListEntity)

    @Query("SELECT * FROM taskList")
    abstract suspend fun getAllTaskLists() : List<TaskListEntity>
    @Query("SELECT * FROM taskList WHERE id = :id")
    abstract suspend fun getTaskList(id: Int) : TaskListEntity
}