package com.maskalor.myapplication.data.room

import androidx.room.Database
import androidx.room.RoomDatabase
import com.maskalor.myapplication.domain.dao.TaskDao
import com.maskalor.myapplication.domain.dao.TaskListDao
import com.maskalor.myapplication.data.room.entity.TaskEntity
import com.maskalor.myapplication.data.room.entity.TaskListEntity

@Database(entities = [TaskListEntity::class, TaskEntity::class], version = 2)
abstract class MyDb : RoomDatabase(){
    abstract fun taskListDao() : TaskListDao
    abstract fun taskDao() : TaskDao
}