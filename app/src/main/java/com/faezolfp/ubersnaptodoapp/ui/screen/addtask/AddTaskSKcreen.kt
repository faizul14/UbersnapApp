package com.faezolfp.ubersnaptodoapp.ui.screen.addtask

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import com.faezolfp.ubersnaptodoapp.core.domain.model.TaskModel
import com.faezolfp.ubersnaptodoapp.ui.theme.UbersnapTodoAppTheme
import java.util.Calendar

@Composable
fun AddTaskScreen(
    onTaskAdded: () -> Unit,
    modifier: Modifier = Modifier,
    viewModel: AddTaskViewModel = hiltViewModel()
) {
    var title by remember {
        mutableStateOf("")
    }
    var description by remember {
        mutableStateOf("")
    }
    var date by remember {
        mutableStateOf(Calendar.getInstance())
    }

    AddContent(
        addTask = {
            viewModel.saveTask(it)
            onTaskAdded()
        },
        titleState = {title = it},
        descriptionState = {description = it} ,
        title = title,
        description = description,
        date = date.toString())
    
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AddContent(
    modifier: Modifier = Modifier,
    addTask: (TaskModel) -> Unit,
    titleState: (String)-> Unit,
    descriptionState: (String)-> Unit,
    title: String,
    description: String,
    date: String,
) {
    Column(
        modifier = modifier
            .fillMaxWidth()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        TextField(
            value = title,
            onValueChange = {dataChange -> titleState(dataChange) },
            placeholder = { Text(text = "Title") },
            textStyle = TextStyle(fontSize = 20.sp),

            modifier = modifier.fillMaxWidth()
        )

        TextField(
            value = description,
            onValueChange = { dataChange -> descriptionState(dataChange) },
            placeholder = { Text(text = "Description") },
            textStyle = TextStyle(fontSize = 16.sp),
//            modifier = modifier.fillMaxWidth()
            modifier = Modifier
                .height(150.dp) // Set the desired height
                .fillMaxWidth(),
        )

        // Date picker can be implemented here

        Button(
            onClick = {
                val task = TaskModel(
                    id = 0,
                    tittle = title,
                    description = description,
                    date = date.toString()
                )
                addTask(task)
            },
            modifier = Modifier.align(Alignment.End)
        ) {
            Text(text = "Add Task")
        }
    }
}

@Preview(showBackground = true)
@Composable
fun AddTaskScreenPreview() {
    UbersnapTodoAppTheme {
        AddTaskScreen(onTaskAdded = {})
    }
}