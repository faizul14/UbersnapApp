package com.faezolfp.ubersnaptodoapp.core.domain.usecase

import androidx.lifecycle.LiveData
import com.faezolfp.ubersnaptodoapp.core.domain.model.ExampleModel
import com.faezolfp.ubersnaptodoapp.core.domain.model.TaskModel
import com.faezolfp.ubersnaptodoapp.core.utils.TransactionFor

interface UseCase {
    fun example(): ExampleModel

    fun getListTask(): LiveData<List<TaskModel>>
    fun getTaskById(id: Int): LiveData<TaskModel>

    fun addTask(task: TaskModel)
    fun updateTask(task: TaskModel)
    fun deleteTask(task: TaskModel)
    fun transactionDatabase(task: TaskModel, transactionFor: TransactionFor = TransactionFor.ISADD)
}