package com.ayousuf.playcompose.ui.compose.button

import androidx.compose.foundation.layout.padding
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.ayousuf.playcompose.util.showToast

@Preview(showBackground = true)
@Composable
fun CreateFloatingActionButton(){
    val context = LocalContext.current
    FloatingActionButton(
        onClick = { context.showToast("Fab") }
    ) {
        Text(text = "Floating Action Button", modifier = Modifier.padding(start = 12.dp, end = 12.dp))
    }
}


@Preview(showBackground = true)
@Composable
fun CreateExtendedFloatingActionButton(){
    val context = LocalContext.current
    ExtendedFloatingActionButton(
        icon = {Icon(Icons.Filled.Favorite, "Favourite")},
        text = { Text(text = "Floating Action Button")},
        onClick = { context.showToast("Extended Fab") },
        elevation = FloatingActionButtonDefaults.elevation(8.dp)
    )
}

@Preview(showBackground = true)
@Composable
fun CreateFloatingActionButtonIcon(){
    val context = LocalContext.current
    FloatingActionButton(
        onClick = { context.showToast("Fab") },
        elevation = FloatingActionButtonDefaults.elevation(8.dp)
    ) {
        Icon(Icons.Filled.Add, "Add")
    }
}

@Preview(showBackground = true)
@Composable
fun CreateFloatingActionButtonShapeIcon(){
    val context = LocalContext.current
    FloatingActionButton(
        onClick = { context.showToast("Fab") },
        shape = RectangleShape,
        elevation = FloatingActionButtonDefaults.elevation(8.dp)
    ) {
        Icon(Icons.Filled.Add, "Add")
    }
}