package com.faezolfp.ubersnaptodoapp.core.domain.usecase

import androidx.lifecycle.LiveData
import com.faezolfp.ubersnaptodoapp.core.domain.model.ExampleModel
import com.faezolfp.ubersnaptodoapp.core.domain.model.TaskModel
import com.faezolfp.ubersnaptodoapp.core.domain.repository.Repository
import com.faezolfp.ubersnaptodoapp.core.utils.TransactionFor
import javax.inject.Inject
import javax.inject.Singleton

class ImplUseCase @Inject constructor(private val repository: Repository) : UseCase {
    override fun example(): ExampleModel {
        return repository.example()
    }

    override fun getListTask(): LiveData<List<TaskModel>> {
        return repository.getListTask()
    }

    override fun addTask(task: TaskModel) {
        repository.addTask(task)
    }

    override fun updateTask(task: TaskModel) {
        repository.updateTask(task)
    }

    override fun deleteTask(task: TaskModel) {
        repository.deleteTask(task)
    }

    override fun transactionDatabase(
        task: TaskModel,
        transactionFor: TransactionFor
    ) {
        when (transactionFor) {
            TransactionFor.ISADD -> {
                repository.addTask(task)
            }

            TransactionFor.ISUPDATE -> {
                repository.updateTask(task)
            }

            TransactionFor.ISDELETE -> {
                repository.deleteTask(task)
            }
        }
    }
}