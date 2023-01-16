package com.ayousuf.playcompose.ui.compose.list

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.ayousuf.playcompose.data.ComposeItem
import com.ayousuf.playcompose.data.User
import com.ayousuf.playcompose.ui.compose.card.GetCard

@Composable
fun ListView( dataList : List<User>, onClick:(user: User) -> Unit){
    
    LazyColumn{
        items(dataList){ user ->
            GetCard(user = user, onClick = {
                onClick(it)
            })
        }
    }
}

@Composable
fun ComposeItemListView(dataList : List<ComposeItem>, onClick:(item: ComposeItem) -> Unit){

    LazyColumn{
        items(dataList){ item ->
            Column {
                Card(
                    shape = RectangleShape,
                    modifier = Modifier
                        .fillMaxWidth(),
                    backgroundColor = MaterialTheme.colors.surface,
                ) {
                    Column(
                        modifier = Modifier
                            .clickable { onClick(item) }
                            .padding(start = 8.dp, top = 12.dp, end = 8.dp, bottom = 12.dp)
                            .fillMaxWidth()
                    ) {
                        Text(text = item.name, fontSize = 22.sp)
                    }
                }
                Spacer(
                    modifier = Modifier
                        .height(6.dp)
                        .fillMaxWidth()
                        .background(color = Color.LightGray)
                )
            }

        }
    }
}