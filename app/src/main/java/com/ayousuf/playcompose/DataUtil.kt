package com.ayousuf.playcompose

import com.ayousuf.playcompose.data.User
import com.ayousuf.playcompose.ui.Screen

object DataUtil {

    fun getComposeItems() : List<ComposeItem>{
        return listOf(
            ComposeItem(name = "Card", Screen.Card),
            ComposeItem(name = "Progress", Screen.Progress),
            ComposeItem(name = "List View", Screen.ListView),
            ComposeItem(name = "Button", Screen.Button),
            ComposeItem(name = "Floating Action Button", Screen.FloatingActionBar),
            ComposeItem(name = "BadgedBox", Screen.BadgedBox),
            ComposeItem(name = "Menu", Screen.Menu)
        )
    }

    fun getUserList() = mutableListOf(
        User("Abdullah", "Dhaka"),
        User("Saifur", "Chittagong"),
        User("Yahiya", "Cumilla"),
        User("Jakaria", "Khulna"),
        User("Kasem", "Shylet")
    )
}

