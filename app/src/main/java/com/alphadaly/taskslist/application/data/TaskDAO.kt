package com.alphadaly.taskslist.application.data

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import kotlinx.coroutines.flow.Flow

@Dao
interface TaskDAO {
    @Query("SELECT * FROM tasks")
    fun getAll(): Flow<List<Task>>

    @Query("SELECT * FROM tasks WHERE id IN (:id)")
    fun getById(id: Int): Flow<Task>


    @Insert
    suspend fun insert(task: Task)

    @Update(onConflict = OnConflictStrategy.IGNORE)
    suspend fun update(task: Task)

    @Delete
    suspend fun delete(task: Task)
}