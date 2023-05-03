package com.alphadaly.taskslist.application.data.task

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "tasks")
data class Task(
    var text: String,
    var done: Boolean,
    @PrimaryKey(autoGenerate = true)
    val id: Int=0,
)



