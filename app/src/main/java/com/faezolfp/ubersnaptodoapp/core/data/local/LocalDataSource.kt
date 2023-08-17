package com.faezolfp.ubersnaptodoapp.core.data.local

import androidx.lifecycle.LiveData
import com.faezolfp.ubersnaptodoapp.core.data.local.entity.TaskEntity
import com.faezolfp.ubersnaptodoapp.core.data.local.room.TaskDao
import java.util.concurrent.ExecutorService
import java.util.concurrent.Executors
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class LocalDataSource @Inject constructor(private val taskDao: TaskDao) {
    private val executorService: ExecutorService = Executors.newSingleThreadExecutor()

    fun getListTast(): LiveData<List<TaskEntity>> = taskDao.getListTask()
    fun getTaskById(id: Int): LiveData<TaskEntity> = taskDao.getTaskById(id)
    fun addTad(task: TaskEntity){
        executorService.execute{
            taskDao.addTask(task)
        }
    }
    fun updateTas(task: TaskEntity){
        executorService.execute{
            taskDao.updateTask(task)
        }
    }
    fun deleteTas(task: TaskEntity){
        executorService.execute{
            taskDao.deleteTask(task)
        }
    }
}