package com.faezolfp.ubersnaptodoapp.core.di

import android.content.Context
import androidx.room.Room
import com.faezolfp.ubersnaptodoapp.core.data.local.room.TaskDao
import com.faezolfp.ubersnaptodoapp.core.data.local.room.TaskDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class DatabaseModule {
    @Singleton
    @Provides
    fun provideDatabase(@ApplicationContext context: Context): TaskDatabase = Room.databaseBuilder(
        context,
        TaskDatabase::class.java,
        name = "Task.db"
    ).fallbackToDestructiveMigration().build()

    @Provides
    fun provideTaskDao(taskDatabase: TaskDatabase): TaskDao = taskDatabase.taskDao()
}