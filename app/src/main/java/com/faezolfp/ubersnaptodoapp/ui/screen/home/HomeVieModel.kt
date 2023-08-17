package com.faezolfp.ubersnaptodoapp.ui.screen.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.asFlow
import androidx.lifecycle.viewModelScope
import com.faezolfp.ubersnaptodoapp.core.domain.model.TaskModel
import com.faezolfp.ubersnaptodoapp.core.domain.usecase.UseCase
import com.faezolfp.ubersnaptodoapp.ui.common.UiState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeVieModel @Inject constructor(private val useCase: UseCase): ViewModel() {
    val getTaskList = useCase.getListTask()
//    private val _uiState: MutableStateFlow<UiState<List<OrderReward>>> = MutableStateFlow(UiState.Loading)
//    val uiState: StateFlow<UiState<List<OrderReward>>>
//        get() = _uiState
//
//    fun getAllRewards() {
//        viewModelScope.launch {
//            repository.getAllRewards()
//                .catch {
//                    _uiState.value = UiState.Error(it.message.toString())
//                }
//                .collect { orderRewards ->
//                    _uiState.value = UiState.Success(orderRewards)
//                }
//        }
//    }

    private val _uiState: MutableStateFlow<UiState<List<TaskModel>>> = MutableStateFlow(UiState.Loading)
    val uiState: StateFlow<UiState<List<TaskModel>>>
        get() = _uiState

    fun getTaskList() {
        viewModelScope.launch {
            useCase.getListTask().asFlow()
                .catch {
                    _uiState.value = UiState.Error(it.message.toString())
                }
                .collect{taskList->
                    _uiState.value = UiState.Success(taskList)
                }
        }
    }
}