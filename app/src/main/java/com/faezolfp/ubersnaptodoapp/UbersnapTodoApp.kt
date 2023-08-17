package com.faezolfp.ubersnaptodoapp

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.faezolfp.ubersnaptodoapp.ui.navigation.Screen
import com.faezolfp.ubersnaptodoapp.ui.screen.addtask.AddTaskScreen
import com.faezolfp.ubersnaptodoapp.ui.screen.home.HomeScreen
import com.faezolfp.ubersnaptodoapp.ui.theme.UbersnapTodoAppTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun UbersnapTodoApp(
    modifier: Modifier = Modifier,
    navController: NavHostController = rememberNavController()
) {
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentRoute = navBackStackEntry?.destination?.route
    Scaffold (
        floatingActionButton = {
            if (currentRoute != Screen.Addtask.route){
                Button(onClick = { navController.navigate(Screen.Addtask.route) }) {
                    Text(text = "ClickMee")
                }
            }
        }
    ){it
        NavHost(
            navController = navController,
            startDestination = Screen.Home.route,
            modifier = modifier.padding(it)
        ){
            composable(Screen.Home.route){
                HomeScreen(navigateToDetail = {}, navigateToAddTask = { navController.navigate(Screen.Addtask.route)})
            }
            composable(Screen.Addtask.route){
                AddTaskScreen(onTaskAdded = {
                    navController.navigateUp()
                })
            }
        }
    }
}

@Preview
@Composable
fun UbersnapTodoAppPreview() {
    UbersnapTodoAppTheme {
        UbersnapTodoApp()
    }

}