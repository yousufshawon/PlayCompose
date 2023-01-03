package com.ayousuf.playcompose.ui

sealed class Screen(val route:String){
    object Main : Screen("Main")
    object Text : Screen("Text")
    object Progress : Screen("Progress")
    object Card : Screen("Card")
    object ListView : Screen("ListView")
    object Button : Screen("Button")
    object FloatingActionBar : Screen("Fab")
    object BadgedBox : Screen("BadgedBox")
    object Menu : Screen("Menu")
    object Scaffold : Screen("Scaffold")
    object Dialog : Screen("Dialog")
    object BottomSheet : Screen("BottomSheet")
}
