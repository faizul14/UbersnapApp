package com.faezolfp.ubersnaptodoapp.ui.screen.detailtask

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
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class DetailTaskViewModel @Inject constructor(private val useCase: UseCase) : ViewModel() {
    private val _uiState: MutableStateFlow<UiState<TaskModel>> = MutableStateFlow(UiState.Loading)
    val uiState: StateFlow<UiState<TaskModel>>
        get() = _uiState

    fun getTaskById(id: Int) {
        viewModelScope.launch {
            useCase.getTaskById(id).asFlow()
                .catch {
                    _uiState.value = UiState.Error(it.message.toString())
                }.collect {
                    _uiState.value = UiState.Success(it)
                }
        }
    }
}