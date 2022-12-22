package com.ayousuf.playcompose.ui.compose.card

import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.ayousuf.playcompose.R
import com.ayousuf.playcompose.data.User

@Composable
fun GetCard(user: User, onClick : (user : User) -> Unit){
    Column(
        modifier = Modifier
            .padding(start = 8.dp, top = 4.dp, end = 8.dp, bottom = 4.dp)
            .fillMaxWidth()
            .clickable {
                onClick(user)
            }
    ) {
        Card(
            shape = RoundedCornerShape(8.dp),
            backgroundColor = MaterialTheme.colors.surface,
            modifier = Modifier
                .fillMaxWidth(),
            elevation = 4.dp
        ) {
            Row(
                modifier = Modifier
                    .padding(top = 4.dp, bottom = 4.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Spacer(modifier = Modifier.width(8.dp))
                Image(
                    painter = painterResource(id = R.drawable.avatar),
                    contentDescription = "",
                    contentScale = ContentScale.Crop,
                    modifier = Modifier
                        .size(65.dp)
                        //.clip(CircleShape)
                        .clip(RoundedCornerShape(percent = 10))
                        //.border(2.dp, Color.Gray, CircleShape)
                        .border(2.dp, Color.Gray, RoundedCornerShape(percent = 10))
                )
                
                Spacer(modifier = Modifier.width(8.dp))
                
                Column(
                    modifier = Modifier
                        .padding(8.dp)
                ) {
                    Text(text = user.name)
                    Text(
                        text = user.address,
                        color = Color.Gray
                    )
                }
            }

        }
    }
}