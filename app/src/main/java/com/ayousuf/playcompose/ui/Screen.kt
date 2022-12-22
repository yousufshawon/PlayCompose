package com.ayousuf.playcompose.ui

sealed class Screen(val route:String){
    object Main : Screen("Main")
    object Progress : Screen("Progress")
    object Card : Screen("Card")
    object ListView : Screen("ListView")
    object Button : Screen("Button")
    object FloatingActionBar : Screen("Fab")
    object BadgedBox : Screen("BadgedBox")
    object Menu : Screen("Menu")
}
