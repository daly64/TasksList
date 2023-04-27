package com.alphadaly.taskslist.application.data

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "tasks")
data class Task(
    @PrimaryKey(autoGenerate = true)
    val id: Int,
    val text: String,
    val done: Boolean
)



