package com.faezolfp.ubersnaptodoapp.ui.screen.home

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.currentCompositionLocalContext
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.asFlow
import com.faezolfp.ubersnaptodoapp.core.domain.model.TaskModel
import com.faezolfp.ubersnaptodoapp.core.utils.DataFake
import com.faezolfp.ubersnaptodoapp.ui.componen.TaskItem
import com.faezolfp.ubersnaptodoapp.ui.theme.UbersnapTodoAppTheme
import java.util.ArrayList
import androidx.compose.runtime.collectAsState
import com.faezolfp.ubersnaptodoapp.ui.common.UiState


@Composable
fun HomeScreen(
    navigateToDetail: (Int) -> Unit,
    navigateToAddTask: () -> Unit,
    modifier: Modifier = Modifier,
    vieModel: HomeVieModel = hiltViewModel()
) {
    vieModel.uiState.collectAsState(initial = UiState.Loading).value.let { uiState->
        when(uiState){
            is UiState.Loading -> {
                vieModel.getTaskList()
            }
            is UiState.Success ->{
                HomeContent(dataListTask = uiState.data , navigateToDetail = navigateToDetail )
            }
            is UiState.Error -> {}
        }
    }
}

@Composable
fun HomeContent(
    modifier: Modifier = Modifier,
    dataListTask: List<TaskModel>,
    navigateToDetail: (Int)-> Unit
) {
    LazyColumn(
        verticalArrangement = Arrangement.spacedBy(5.dp),
        modifier = modifier
    ){
        items(dataListTask){
            TaskItem(
                tittle = it.tittle.toString(),
                description = it.description.toString(),
                date = it.date.toString(),
                modifier = modifier.clickable {
                    navigateToDetail(it.id)
                }
            )
        }
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun HomeScreenPreview() {
    UbersnapTodoAppTheme {
        HomeScreen(navigateToDetail = {}, navigateToAddTask = { /*TODO*/ })
    }
}

