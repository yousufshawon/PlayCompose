package com.ayousuf.playcompose.ui.compose.image

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.BlurredEdgeTreatment
import androidx.compose.ui.draw.blur
import androidx.compose.ui.draw.clip
import androidx.compose.ui.geometry.Rect
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.*
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Density
import androidx.compose.ui.unit.LayoutDirection
import androidx.compose.ui.unit.dp
import com.ayousuf.playcompose.R


/**
 * Created by Android Studio.
 * User:  Yousuf
 * Email:
 * Date:  3/1/23
 * To change this template use File | Settings | File and Code Templates.
 *
 */


@Preview(showBackground = true)
@Composable
fun CreateSimpleImageView() {
    Image(
        painter = painterResource(id = R.drawable.flower),
        contentDescription = "Flower",
        contentScale = ContentScale.Fit,
    )
}

@Preview(showBackground = true)
@Composable
fun CreateImageView() {
    val imageModifier = Modifier
        .size(150.dp)
        .border(BorderStroke(1.dp, Color.Black))
        .background(Color.Yellow)

    Image(
        painter = painterResource(id = R.drawable.flower),
        contentDescription = "Flower",
        contentScale = ContentScale.Fit,
        modifier = imageModifier
    )
}

@Preview(showBackground = true)
@Composable
fun CreateImageViewWithCircleShape() {
    Image(
        painter = painterResource(id = R.drawable.flower),
        contentDescription = "Flower",
        contentScale = ContentScale.Crop,
        modifier = Modifier
            .size(200.dp)
            .clip(CircleShape)
    )
}

@Preview(showBackground = true)
@Composable
fun CreateImageViewWithRoundedCornerShape() {
    Image(
        painter = painterResource(id = R.drawable.flower),
        contentDescription = "Flower",
        contentScale = ContentScale.Crop,
        modifier = Modifier
            .size(200.dp)
            .clip(RoundedCornerShape(16.dp))
    )
}

@Preview(showBackground = true)
@Composable
fun CreateImageViewWithSquashedOvalShape() {

    Image(
        painter = painterResource(id = R.drawable.flower),
        contentDescription = "",
        contentScale = ContentScale.Crop,
        modifier = Modifier
            .size(200.dp)
            .clip(SquashedOval())
    )

}

@Preview(showBackground = true)
@Composable
fun CreateImageViewWithBorder() {
    val borderWidth = 3.dp
    Image(
        painter = painterResource(id = R.drawable.flower),
        contentDescription = "",
        contentScale = ContentScale.Crop,
        modifier = Modifier
            .size(150.dp)
            .border(BorderStroke(borderWidth, Color.Magenta), CircleShape)
            .padding(borderWidth)
            .clip(CircleShape)
    )
}


@Preview(showBackground = true)
@Composable
fun CreateImageViewWithRainbowBorder() {
    val borderWidth = 3.dp
    val rainbowColorsBrush = remember {
        Brush.sweepGradient(
            listOf(
                Color(0xFF9575CD),
                Color(0xFFBA68C8),
                Color(0xFFE57373),
                Color(0xFFFFB74D),
                Color(0xFFFFF176),
                Color(0xFFAED581),
                Color(0xFF4DD0E1),
                Color(0xFF9575CD)
            )
        )
    }
    Image(
        painter = painterResource(id = R.drawable.flower),
        contentDescription = "",
        contentScale = ContentScale.Crop,
        modifier = Modifier
            .size(150.dp)
            .border(BorderStroke(borderWidth, rainbowColorsBrush), CircleShape)
            .padding(borderWidth)
            .clip(CircleShape)
    )
}

@Preview(showBackground = true)
@Composable
fun CreateImageViewWithCustomAspectRatio() {
    Image(
        painter = painterResource(id = R.drawable.flower),
        contentDescription = "",
        contentScale = ContentScale.Crop,
        modifier = Modifier.aspectRatio(16f/9f)
    )
}

@Preview(showBackground = true)
@Composable
fun CreateImageViewWithColorFilter() {
    Image(
        painter = painterResource(id = R.drawable.flower),
        contentDescription = "",
        colorFilter = ColorFilter.tint(Color.Green, blendMode = BlendMode.Darken),
        modifier = Modifier.width(150.dp)
    )
}

@Preview(showBackground = true)
@Composable
fun CreateImageViewWithFilterWithColorMatrix() {
    Image(
        painter = painterResource(id = R.drawable.flower),
        contentDescription = "",
        colorFilter = ColorFilter.colorMatrix(
            ColorMatrix()
                .apply {
                    setToSaturation(0f)
                }
        ),
        modifier = Modifier.width(150.dp)
    )
}

@Preview(showBackground = true)
@Composable
fun CreateImageViewWithBlur() {
    Image(
        painter = painterResource(id = R.drawable.flower),
        contentDescription = "",
        contentScale = ContentScale.Crop,
        modifier = Modifier
            .size(150.dp)
            .blur(
                radiusX = 10.dp,
                radiusY = 10.dp,
                edgeTreatment = BlurredEdgeTreatment(RoundedCornerShape(8.dp))
            )
    )
}

@Preview(showBackground = true)
@Composable
fun CreateImageViewWithTint() {
    Image(
        painter = painterResource(id = R.drawable.ic_baseline_shopping_cart_24),
        contentDescription = "",
        colorFilter = ColorFilter.tint(Color.Red),
        modifier = Modifier.size(100.dp)
    )
}



class SquashedOval : Shape {
    override fun createOutline(
        size: Size,
        layoutDirection: LayoutDirection,
        density: Density
    ): Outline {
        val path = Path().apply {
            // We create an Oval that starts at ¼ of the width, and ends at ¾ of the width of the container.
            addOval(
                Rect(
                    left = size.width / 4f,
                    top = 0f,
                    right = size.width * 3 / 4f,
                    bottom = size.height
                )
            )
        }
        return Outline.Generic(path = path)
    }

}