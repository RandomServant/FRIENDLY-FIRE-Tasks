package com.example.friendlyfiretasks.data.entity

import androidx.room.PrimaryKey
import androidx.room.Entity

@Entity(tableName = "Task")
data class TaskEntity(
    @PrimaryKey(autoGenerate = true)
    val id: Int,
    val name: String,
    val description: String,
    val taskListId: Int
)