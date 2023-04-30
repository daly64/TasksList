package com.alphadaly.taskslist.application.room.task

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = [Task::class], version = 1)
abstract class TaskDatabase : RoomDatabase() {
    abstract val dao: TaskDAO

}
