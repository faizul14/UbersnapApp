package com.faezolfp.ubersnaptodoapp.core.domain.repository

import androidx.lifecycle.LiveData
import com.faezolfp.ubersnaptodoapp.core.domain.model.ExampleModel
import com.faezolfp.ubersnaptodoapp.core.domain.model.TaskModel

interface Repository {
    fun example(): ExampleModel

    fun getListTask(): LiveData<List<TaskModel>>
    fun addTask(task: TaskModel)
    fun updateTask(task: TaskModel)
    fun deleteTask(task: TaskModel)
}