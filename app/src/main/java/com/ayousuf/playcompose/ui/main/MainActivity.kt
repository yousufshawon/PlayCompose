package com.ayousuf.playcompose.ui.main

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.viewmodel.compose.viewModel
import com.ayousuf.playcompose.ui.navigation.Navigation
import com.ayousuf.playcompose.ui.theme.PlayComposeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            PlayComposeTheme {
                val viewModel = viewModel<MainViewModel>()
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                    //color = Color.Gray
                ) {
                    MainContent(viewModel)
                }
            }
        }
    }
}

@Composable
fun MainContent(viewModel: MainViewModel){
    Navigation(viewModel)
}


@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    PlayComposeTheme {
        val viewModel = viewModel<MainViewModel>()
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = MaterialTheme.colors.background
            //color = Color.Gray
        ) {
            MainContent(viewModel)
        }
    }
}