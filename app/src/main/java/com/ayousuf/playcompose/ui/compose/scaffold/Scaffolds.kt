package com.ayousuf.playcompose.ui.compose.scaffold

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Search
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.ayousuf.playcompose.R
import com.ayousuf.playcompose.util.showToast
import kotlinx.coroutines.launch


/**
 * Created by Android Studio.
 * User:  Yousuf
 * Email: yousuf.kuet08@gmail.com
 * Date:  23/12/22
 * To change this template use File | Settings | File and Code Templates.
 *
 */


@Preview(showBackground = true)
@Composable
fun CreateScaffoldLayout() {
    val context = LocalContext.current
    val coroutineScope = rememberCoroutineScope()
    val scaffoldState = rememberScaffoldState()
    Scaffold(
        scaffoldState = scaffoldState,
        topBar = {
            TopAppBar(
                title = {
                    Text("TopAppBar")
                },
                navigationIcon = {
                     IconButton(onClick = {
                         context.showToast("Menu")
                         if (scaffoldState.drawerState.isClosed) {
                             coroutineScope.launch {
                                 scaffoldState.drawerState.open()
                             }
                         }
                     }) {
                         Icon(imageVector = Icons.Filled.Menu, contentDescription = "Menu")
                     }
                },
                actions = {
                    IconButton(onClick = {
                        context.showToast("Search")
                    }) {
                        Icon(imageVector = Icons.Filled.Search, contentDescription = "Search")
                    }
                },
                elevation = 10.dp
            )
        },
        floatingActionButton = {
            FloatingActionButton(onClick = {
                context.showToast("Add")
            }) {
                Icon(imageVector = Icons.Filled.Add, contentDescription = "Add")
            }
        },
        floatingActionButtonPosition = FabPosition.End,
        drawerContent = { CreateDrawerContent() },
        bottomBar = {
            BottomAppBar {
                Text(text = "BottomAppBar", modifier = Modifier.padding(start = 16.dp))
            }
        }
    ) {
        //Text(text = "Body Content", modifier = Modifier.padding(it))
        CreateContent(it)
    }
}

@Preview(showBackground = true)
@Composable
private fun CreateDrawerContent() {
    Spacer(modifier = Modifier.height(40.dp))
    Column(
        modifier = Modifier
            .fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally

    ) {
        Image(
            painter = painterResource(id = R.drawable.avatar),
            modifier = Modifier
                .size(80.dp)
                .clip(CircleShape)
                .border(2.dp, Color.Gray, CircleShape),
            alignment = Alignment.TopCenter,
            contentDescription = "Profile Pic"
        )
    }
    Spacer(modifier = Modifier.height(20.dp))
    Spacer(modifier = Modifier
        .height(1.dp)
        .fillMaxWidth()
        .background(color = Color.Gray))
    Spacer(modifier = Modifier.height(20.dp))
    Text(
        text = "Home",
        modifier = Modifier
            .padding(start = 20.dp),
        fontSize = 18.sp
    )
    Spacer(modifier = Modifier.height(16.dp))
    Text(
        text = "Message",
        modifier = Modifier
            .padding(start = 20.dp),
        fontSize = 18.sp
    )
    Spacer(modifier = Modifier.height(16.dp))
    Text(
        text = "Notification",
        modifier = Modifier
            .padding(start = 20.dp),
        fontSize = 18.sp
    )
}

@Preview(showBackground = true)
@Composable
private fun CreateContent(paddingValues: PaddingValues = PaddingValues(0.dp)){
    Column {
        Spacer(modifier = Modifier.height(20.dp))
        Text(
            text = "Body Content",
            modifier = Modifier.padding(paddingValues).fillMaxWidth(),
            fontSize  = 22.sp,
            textAlign = TextAlign.Center
        )
    }
}
 