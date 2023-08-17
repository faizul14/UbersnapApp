package com.faezolfp.ubersnaptodoapp.ui.navigation

import com.faezolfp.ubersnaptodoapp.core.domain.model.TaskModel

sealed class Screen(val route: String) {
    object Home: Screen("home")
    object Addtask: Screen("addtask")
    object DetailTask:Screen("home/{idTask}"){
        fun createRoute(idTask: Int) = "home/$idTask"
    }
}