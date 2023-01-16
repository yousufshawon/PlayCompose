package com.ayousuf.playcompose.util

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Share
import com.ayousuf.playcompose.ComposeItem
import com.ayousuf.playcompose.data.ListItemData
import com.ayousuf.playcompose.data.User
import com.ayousuf.playcompose.ui.Screen

object DataUtil {

    fun getComposeItems() : List<ComposeItem>{
        return listOf(
            ComposeItem(name = "Text", Screen.Text),
            ComposeItem(name = "Card", Screen.Card),
            ComposeItem(name = "Progress", Screen.Progress),
            ComposeItem(name = "List View", Screen.ListView),
            ComposeItem(name = "Button", Screen.Button),
            ComposeItem(name = "Image", Screen.Image),
            ComposeItem(name = "Floating Action Button", Screen.FloatingActionBar),
            ComposeItem(name = "BadgedBox", Screen.BadgedBox),
            ComposeItem(name = "Menu", Screen.Menu),
            ComposeItem(name = "Scaffold", Screen.Scaffold),
            ComposeItem(name = "Dialog", Screen.Dialog),
            ComposeItem(name = "BottomSheet", Screen.BottomSheet),
            ComposeItem(name = "Calendar", Screen.Calendar)
        )
    }

    fun getUserList() = mutableListOf(
        User("Abdullah", "Dhaka"),
        User("Saifur", "Chittagong"),
        User("Yahiya", "Cumilla"),
        User("Jakaria", "Khulna"),
        User("Kasem", "Shylet")
    )

    fun getListItemForModalSheetContent() : List<ListItemData> {
        return listOf(
            ListItemData("Share", Icons.Default.Share),
            ListItemData("Email", Icons.Default.Email),
            ListItemData("Edit", Icons.Default.Edit),
            ListItemData("Delete", Icons.Default.Delete),
        )
    }
}

