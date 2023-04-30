package com.alphadaly.taskslist.application.room.task

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import androidx.room.Upsert
import kotlinx.coroutines.flow.Flow

@Dao
interface TaskDAO {
    @Query("SELECT * FROM tasks")
    fun getAll(): Flow<List<Task>>

    /*
        @Query("SELECT * FROM tasks WHERE id IN (:id)")
        fun getById(id: Int): Flow<Task>
    */

    @Upsert
    suspend fun upsertTask(task: Task)

    @Insert
    suspend fun insertTask(task: Task)

    @Update(onConflict = OnConflictStrategy.IGNORE)
    suspend fun updateTask(task: Task)


    @Delete
    suspend fun deleteTask(task: Task)

    @Query("DELETE FROM tasks")
    suspend fun deleteAll()

}