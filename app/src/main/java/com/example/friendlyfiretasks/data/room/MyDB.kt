package com.example.friendlyfiretasks.data

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.friendlyfiretasks.data.room.dao.TaskDao
import com.example.friendlyfiretasks.data.room.dao.TaskListDao
import com.example.friendlyfiretasks.data.room.entity.TaskEntity
import com.example.friendlyfiretasks.data.room.entity.TaskListEntity

@Database(entities = [TaskListEntity::class, TaskEntity::class], version = 1)
abstract class MyDb : RoomDatabase(){
    abstract fun taskListDao() : TaskListDao
    abstract fun taskDao() : TaskDao
}