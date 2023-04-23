package com.alphadaly.taskslist.application.controllers.sqlite

import android.content.ContentValues
import android.content.Context
import android.database.Cursor
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import com.alphadaly.taskslist.application.controllers.sqlite.TasksDataBaseSchema.DATABASE_NAME
import com.alphadaly.taskslist.application.controllers.sqlite.TasksDataBaseSchema.DATABASE_VERSION
import com.alphadaly.taskslist.application.controllers.sqlite.TasksDataBaseSchema.TaskTable.Columns.KEY_TASK_DONE
import com.alphadaly.taskslist.application.controllers.sqlite.TasksDataBaseSchema.TaskTable.Columns.KEY_TASK_ID
import com.alphadaly.taskslist.application.controllers.sqlite.TasksDataBaseSchema.TaskTable.Columns.KEY_TASK_TEXT
import com.alphadaly.taskslist.application.controllers.sqlite.TasksDataBaseSchema.TaskTable.TABLE_NAME
import com.alphadaly.taskslist.application.models.Task

/** structure of the database */
object TasksDataBaseSchema {
    const val DATABASE_VERSION = 1
    const val DATABASE_NAME = "task_data_base.db"

    object TaskTable {
        const val TABLE_NAME = "tasks_list"

        object Columns {
            const val KEY_TASK_ID = "task_id"
            const val KEY_TASK_TEXT = "task_text"
            const val KEY_TASK_DONE = "task_done"

        }
    }
}

/** the sqlite database handler */

class TasksDataBaseSQLiteHandler(context: Context) :
    SQLiteOpenHelper(context, DATABASE_NAME, null, DATABASE_VERSION) {
    override fun onCreate(db: SQLiteDatabase?) {

        val createTaskTable =
            """CREATE TABLE $TABLE_NAME (
                $KEY_TASK_ID INTEGER PRIMARY KEY,
                $KEY_TASK_TEXT TEXT,
                $KEY_TASK_DONE BOOLEAN
                ); """
        db?.execSQL(createTaskTable)

    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
        db?.execSQL("DROP TABLE IF EXISTS $TABLE_NAME")
        onCreate(db)
    }


    fun readAllTasks(): ArrayList<Task> {
        val db: SQLiteDatabase = readableDatabase
        val tasksList = ArrayList<Task>()
        val selectAll = "SELECT * FROM $TABLE_NAME"

        val cursor: Cursor = db.rawQuery(selectAll, null)
        if (cursor.moveToFirst()) {
            do {
                val task = Task().apply {
                    id = cursor.getInt(with(cursor) { getColumnIndex(KEY_TASK_ID) })
                    text = cursor.getString(with(cursor) { getColumnIndex(KEY_TASK_TEXT) })
                    done = cursor.getInt(with(cursor) { getColumnIndex(KEY_TASK_DONE) }) == 1
                }
                tasksList.add(task)
            } while (cursor.moveToNext())
        }
        cursor.close()
        return tasksList
    }

/*    fun getTask(task: Task): Task {
        val taskId = task.id.toString()
        val db: SQLiteDatabase = writableDatabase
        val selectOne = "SELECT * FROM $TABLE_NAME WHERE $KEY_TASK_ID=?"
        val cursor: Cursor = db.rawQuery(selectOne, arrayOf(taskId))
        val getTask = Task()
        if (cursor.moveToFirst()) {
            do {
                getTask.apply {
                    id = cursor.getInt(with(cursor) { getColumnIndex(KEY_TASK_ID) })
                    text = cursor.getString(with(cursor) { getColumnIndex(KEY_TASK_TEXT) })
                    done = cursor.getInt(with(cursor) { getColumnIndex(KEY_TASK_DONE) }) == 1
                }
            } while (cursor.moveToNext())
        }
        cursor.close()
        return getTask

    }*/

    fun createTask(task: Task) {
        val db: SQLiteDatabase = writableDatabase
        val values = ContentValues()
        values.put(KEY_TASK_TEXT, task.text)
        values.put(KEY_TASK_DONE, task.done)

        db.insert(TABLE_NAME, null, values)
        db.close()
    }

/*    fun updateTask(task: Task): Int {
        val taskId = task.id.toString()
        val db: SQLiteDatabase = writableDatabase
        val values = ContentValues()
        values.put(KEY_TASK_TEXT, task.text)
        values.put(KEY_TASK_DONE, task.done)
        return db.update(TABLE_NAME, values, "$KEY_TASK_ID=?", arrayOf(taskId))
    }*/

 /*   fun validateTask(task: Task): Int {
        val taskId = task.id.toString()
        val db: SQLiteDatabase = writableDatabase
        val values = ContentValues()
        values.put(KEY_TASK_TEXT, task.text)
        values.put(KEY_TASK_DONE, true)
        return db.update(TABLE_NAME, values, "$KEY_TASK_ID=?", arrayOf(taskId))
    }*/

    fun deleteTask(task: Task) {
        val taskId = task.id.toString()
        val db: SQLiteDatabase = writableDatabase
        db.delete(TABLE_NAME, "$KEY_TASK_ID=?", arrayOf(taskId))
        db.close()

    }

/*    fun deleteAllTasks() {
        val db: SQLiteDatabase = readableDatabase
        db.execSQL(("DROP TABLE IF EXISTS $TABLE_NAME"))
    }*/
}