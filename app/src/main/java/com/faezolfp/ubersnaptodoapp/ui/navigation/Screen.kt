package com.faezolfp.ubersnaptodoapp.ui.navigation

sealed class Screen(val route: String) {
    object Home: Screen("home")
    object Addtask: Screen("addtask")
}