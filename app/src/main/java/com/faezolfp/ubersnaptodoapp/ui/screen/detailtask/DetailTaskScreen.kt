package com.faezolfp.ubersnaptodoapp.ui.screen.detailtask

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.navigation.compose.hiltViewModel
import com.faezolfp.ubersnaptodoapp.core.domain.model.TaskModel
import com.faezolfp.ubersnaptodoapp.ui.common.UiState
import com.faezolfp.ubersnaptodoapp.ui.componen.TaskItem
import com.faezolfp.ubersnaptodoapp.ui.screen.home.HomeContent
import com.faezolfp.ubersnaptodoapp.ui.theme.UbersnapTodoAppTheme

@Composable
fun DetailTaskScreen(
    modifier: Modifier = Modifier,
    idTask: Int,
    navigateBack: () -> Unit,
    viewModel: DetailTaskViewModel = hiltViewModel()
) {
    viewModel.uiState.collectAsState(initial = UiState.Loading).value.let { uiState ->
        when(uiState){
            is UiState.Loading ->{
                viewModel.getTaskById(idTask)
            }
            is UiState.Success ->{
                DetailTaskContent(taskList = uiState.data, navigateToEdit = {}, isDeleteTask ={}, navigateBack =  navigateBack )
            }
            is UiState.Error -> {}
        }
    }
    
}

@Composable
fun DetailTaskContent(
    modifier: Modifier = Modifier,
    taskList: TaskModel,
    navigateToEdit: (TaskModel) -> Unit,
    isDeleteTask: (TaskModel) -> Unit,
    navigateBack: () -> Unit
) {
    TaskItem(tittle = taskList.tittle.toString(), description = taskList.description.toString(), date = taskList.date.toString())
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun DetailTaskScreenPreview() {
    val dataTaskFake = TaskModel(
        id = 0, tittle = "tittle 1", description = "Lorem Ipsum Doolor Is Amet", date = "27 August 2023"

    )
    UbersnapTodoAppTheme {
        DetailTaskScreen(idTask = 0, navigateBack = { /*TODO*/ })
    }
}