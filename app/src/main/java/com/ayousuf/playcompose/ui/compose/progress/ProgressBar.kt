package com.ayousuf.playcompose.ui.compose.progress

import androidx.compose.animation.core.*
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.LinearProgressIndicator
import androidx.compose.material.ProgressIndicatorDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.ayousuf.playcompose.R

@Preview(showBackground = true)
@Composable
fun GetCircularProgressbar(){
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(50.dp),
        contentAlignment = Alignment.Center
    ){
        CircularProgressIndicator(
            modifier = Modifier
                .size(size = 32.dp),
            color = colorResource(id = R.color.purple_700),
            strokeWidth = 2.dp
        )
    }

}

@Preview(showBackground = true)
@Composable
fun GetCircularProgressbarWithProgress(progress: Float = 0.5f){
    //val progress = 0.5f
    val animatedProgress = animateFloatAsState(
        targetValue = progress,
        animationSpec = ProgressIndicatorDefaults.ProgressAnimationSpec
    ).value
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(50.dp),
        contentAlignment = Alignment.Center
    ){
        CircularProgressIndicator(
            progress = 0.5f,
            modifier = Modifier
                .size(size = 32.dp),
            color = colorResource(id = R.color.purple_700),
            strokeWidth = 2.dp
        )
    }
}

@Preview(showBackground = false)
@Composable
fun CircularProgressAnimated(){
    val progressValue = 0.75f
    val infiniteTransition = rememberInfiniteTransition()

    val progressAnimationValue by infiniteTransition.animateFloat(
        initialValue = 0.0f,
        targetValue = progressValue,animationSpec = infiniteRepeatable(animation = tween(900)))

    Box(
        modifier = Modifier
            .background(color = Color.White)
            .fillMaxWidth()
            .height(50.dp),
        contentAlignment = Alignment.Center
    ) {
        CircularProgressIndicator(progress = progressAnimationValue)
    }

}

@Preview(showBackground = false)
@Composable
fun GetLinearProgress(){
    Box(
        modifier = Modifier
            .background(color = Color.White)
            .fillMaxWidth()
            .height(50.dp),
        contentAlignment = Alignment.Center
    ) {
        LinearProgressIndicator(
            color = colorResource(id = R.color.purple_700)
        )
    }
}

@Preview(showBackground = false)
@Composable
fun GetLinearProgressWithProgress(progress: Float = 0.6f){
    Box(
        modifier = Modifier
            .background(color = Color.White)
            .fillMaxWidth()
            .height(50.dp),
        contentAlignment = Alignment.Center
    ) {
        LinearProgressIndicator(
            progress = progress,
            color = Color.Red,
            backgroundColor = Color.LightGray
        )
    }
}