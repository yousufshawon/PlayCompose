package com.ayousuf.playcompose.ui.compose.dialog

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.Dialog
import com.ayousuf.playcompose.R


/**
 * Created by Android Studio.
 * User:  Yousuf
 * Email: yousuf.kuet08@gmail.com
 * Date:  25/12/22
 * To change this template use File | Settings | File and Code Templates.
 *
 */
 
@Preview(showBackground = true)
@Composable
fun CreateAlertDialog(openAlertDialog: MutableState<Boolean> = mutableStateOf(true)) {
    if (openAlertDialog.value){
        AlertDialog(
            onDismissRequest = {
                openAlertDialog.value = false
            },
            title = {
                Text(text = "Warning")
            },
            text = {
                Text(text = "Please check your network connection")
            },
            confirmButton = {
                Button(
                    onClick = {
                        openAlertDialog.value = false
                    }
                ) {
                    Text(text = "Ok")
                }
            },
            dismissButton = {
                Button(
                    onClick = {
                        openAlertDialog.value = false
                    }
                ) {
                    Text(text = "Cancel")
                }
            }
        )
    }
}


@Preview(showBackground = true)
@Composable
fun CreateDialog(openDialog : MutableState<Boolean> = mutableStateOf(true)) {
    if (openDialog.value){
        Dialog(
            onDismissRequest = {
                openDialog.value = false
            }
        ) {
            Surface(elevation = 4.dp) {
                Column(
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally,
                    modifier = Modifier.background(color = Color.White),
                ) {
                    Box(
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(120.dp)
                            .background(color = Color(0xFF35898f)),
                        contentAlignment = Alignment.Center
                    ) {
                        Image(
                            painter = painterResource(id = R.drawable.ic_baseline_shopping_cart_24),
                            contentDescription = "Cart",
                            alignment = Alignment.Center,
                            modifier = Modifier.size(50.dp)
                        )
                    }

                    Spacer(modifier = Modifier.height(16.dp))

                    Text(
                        text = "Continue shopping",
                        fontWeight = FontWeight.Bold,
                        fontSize = 20.sp
                    )
                    Spacer(modifier = Modifier.height(12.dp))
                    Text(
                        text = "Do you want to continue  shopping?",
                        fontSize = 16.sp
                    )
                    Spacer(modifier = Modifier.height(16.dp))

                    Button(
                        onClick = {
                            openDialog.value = false
                        }
                    ) {
                        Text(text = "Continue")
                    }

                    TextButton(
                        onClick = {
                            openDialog.value = false
                        }
                    ) {
                        Text(text = "Not now")
                    }
                    Spacer(modifier = Modifier.height(8.dp))
                }
            }
        }
    }
}