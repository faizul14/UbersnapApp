package com.faezolfp.ubersnaptodoapp.ui.screen.addtask

import androidx.lifecycle.ViewModel
import com.faezolfp.ubersnaptodoapp.core.domain.model.TaskModel
import com.faezolfp.ubersnaptodoapp.core.domain.usecase.UseCase
import com.faezolfp.ubersnaptodoapp.core.utils.TransactionFor
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class AddTaskViewModel @Inject constructor(private val useCase: UseCase): ViewModel() {
    fun saveTask(task: TaskModel) = useCase.transactionDatabase(task, TransactionFor.ISADD)
}