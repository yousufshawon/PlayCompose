package com.ayousuf.playcompose.ui.compose.badgebox

import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountBox
import androidx.compose.material.icons.filled.Create
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview

@Preview(showBackground = true)
@Composable
fun CreateBadgeBox(){
    BottomNavigation {
        BottomNavigationItem(
            icon = {
                   BadgedBox(badge = { Badge { Text(text = "9")} }) {
                       Icon(
                           Icons.Filled.Favorite,
                           "Favorite"
                       )
                   }
            },
            selected = true,
            onClick = {  }
        )
        BottomNavigationItem(
            icon = {
                BadgedBox(badge = {  }) {
                    Icon(
                        Icons.Filled.Create,
                        "Create"
                    )
                }
            },
            selected = false,
            onClick = {  }
        )
        BottomNavigationItem(
            icon = {
                BadgedBox(badge = { Badge { Text(text = "2")} }) {
                    Icon(
                        Icons.Filled.AccountBox,
                        "AccountBox"
                    )
                }
            },
            selected = false,
            onClick = {  }
        )
    }
}