package com.ayousuf.playcompose.ui.compose.layout

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import com.ayousuf.playcompose.R


/**
 * Created by Android Studio.
 * User:  Yousuf
 * Email:
 * Date:  16/1/23
 * To change this template use File | Settings | File and Code Templates.
 *
 */


@Preview(showBackground = true)
@Composable
fun CreateConstraintLayout() {
    ConstraintLayout(modifier = Modifier.fillMaxSize()) {

        val (topBanner, profile, title, description, space, contentText) = createRefs()

        Image(
            painter = painterResource(id = R.drawable.androidparty),
            contentDescription = "Top banner",
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .fillMaxWidth()
                .height(180.dp)
                .constrainAs(topBanner) {

                }
        )

        Image(
            painter = painterResource(id = R.drawable.flower),
            contentDescription = "Profile",
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .size(80.dp)
                .padding(2.dp)
                .border(BorderStroke(2.dp, Color.Magenta), RectangleShape)
                .constrainAs(profile) {
                    start.linkTo(parent.start, 20.dp)
                    bottom.linkTo(topBanner.bottom, (-40).dp)
                }
        )

        Text(
            text = "John Doe",
            fontSize = 26.sp,
            modifier = Modifier
                .constrainAs(title) {
                    bottom.linkTo(profile.bottom)
                    start.linkTo(profile.end, 20.dp)
                }
        )

        Text(
            text = "Little description",
            modifier = Modifier
                .constrainAs(description) {
                    top.linkTo(title.bottom,)
                    start.linkTo(title.start)
                }
        )

        Spacer(
            modifier = Modifier
                .background(Color.Gray)
                .fillMaxWidth()
                .height(1.dp)
                .constrainAs(space) {
                    top.linkTo(description.bottom, 20.dp)
                }
        )

        Text(
            text = "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum",
            fontSize = 20.sp,
            modifier = Modifier
                .padding(16.dp)
                .constrainAs(contentText) {
                    top.linkTo(space.bottom, 12.dp)
                }
        )

    }
}