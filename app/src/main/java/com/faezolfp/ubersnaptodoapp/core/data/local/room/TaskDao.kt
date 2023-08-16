package com.faezolfp.ubersnaptodoapp.core.data.local.room

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import com.faezolfp.ubersnaptodoapp.core.data.local.entity.TaskEntity

@Dao
interface TaskDao {
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun addTask(task: TaskEntity)
    @Update
    fun updateTask(task: TaskEntity)
    @Delete
    fun deleteTask(task: TaskEntity)
    @Query("SELECT * FROM taskentity")
    fun getListTask(): LiveData<List<TaskEntity>>

}