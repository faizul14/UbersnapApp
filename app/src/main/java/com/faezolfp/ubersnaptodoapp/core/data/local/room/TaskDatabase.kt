package com.faezolfp.ubersnaptodoapp.core.data.local.room

import androidx.room.Database
import androidx.room.RoomDatabase
import com.faezolfp.ubersnaptodoapp.core.data.local.entity.TaskEntity

@Database(entities = [TaskEntity::class], version = 1, exportSchema = false)
abstract class TaskDatabase: RoomDatabase() {
    abstract fun taskDao(): TaskDao
}