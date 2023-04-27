package com.alphadaly.taskslist.application.data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [Task::class], version = 1)
abstract class TasksDatabase : RoomDatabase() {
    abstract fun taskDao(): TaskDAO

    companion object {
        @Volatile
        private var Instance: TasksDatabase? = null
        fun getDatabase(context: Context): TasksDatabase {
            return Instance ?: synchronized(this) {
                Room.databaseBuilder(context, TasksDatabase::class.java, "tasks_database")
                    .build()
                    .also { Instance = it }
            }
        }
    }
}
