package com.ayousuf.playcompose.ui.compose.button

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.ayousuf.playcompose.util.showToast
import  com.ayousuf.playcompose.R

@Preview(showBackground = true)
@Composable
fun CreateButton(){
    val context = LocalContext.current
    Button(
        onClick = { context.showToast("Its Button") },
        colors = ButtonDefaults.buttonColors(backgroundColor = Color.DarkGray),
        elevation =  ButtonDefaults.elevation(
            defaultElevation = 10.dp,
            pressedElevation = 15.dp,
            disabledElevation = 0.dp
        )
    ) {
        Text(text = "Button", color = Color.White)
        Text(text = " Color ", color = Color.Magenta)
    }
}

@Preview(showBackground = true)
@Composable
fun CreateButtonWithBorder() {
    val context = LocalContext.current
    Button(
        onClick = { context.showToast("Its Button with Border") },
        border = BorderStroke(1.dp, Color.Red),
        colors = ButtonDefaults.outlinedButtonColors(contentColor = Color.Red)
    ) {
        Text(text = "Button with border", color = Color.DarkGray)
    }
}


@Preview(showBackground = true)
@Composable
fun CreateOutlinedButton() {
    val context = LocalContext.current
    OutlinedButton(
        onClick = { context.showToast("It's outlined") }
    ) {
        Text(text = "Outlined Button")
        
    }
}

@Preview(showBackground = true)
@Composable
fun CreateTextButton() {
    val context = LocalContext.current
    TextButton(
        onClick = { context.showToast("It's TextButton") }
    ) {
        Text(text = "TextButton")
    }
}

@Preview(showBackground = true)
@Composable
fun CreateButtonWithIcon() {
    val context = LocalContext.current
    Button(
        onClick = { context.showToast("Button with Icon") }
    ) {
        Image(painterResource(
            id = R.drawable.ic_baseline_shopping_cart_24),
            contentDescription = "Cart",
            modifier = Modifier.size(20.dp)
        )
        Text(text = "Add to cart", modifier = Modifier.padding(start = 6.dp))
    }
}

@Preview(showBackground = true)
@Composable
fun CreateButtonWithShape() {
    Button(
        onClick = {},
        shape = RoundedCornerShape(20.dp)
    ) {
        Text(text = "Round corner shape")
    }
}

