package com.ayousuf.playcompose.ui.navigation

import android.widget.Toast
import androidx.compose.foundation.layout.*
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.ayousuf.playcompose.DataUtil
import com.ayousuf.playcompose.data.User
import com.ayousuf.playcompose.ui.Screen
import com.ayousuf.playcompose.ui.compose.badgebox.CreateBadgeBox
import com.ayousuf.playcompose.ui.compose.button.*
import com.ayousuf.playcompose.ui.compose.card.GetCard
import com.ayousuf.playcompose.ui.compose.list.ComposeItemListView
import com.ayousuf.playcompose.ui.compose.list.ListView
import com.ayousuf.playcompose.ui.compose.menu.CreateDropdownMenu
import com.ayousuf.playcompose.ui.compose.menu.CreateExposedDropdownMenu
import com.ayousuf.playcompose.ui.compose.progress.*

@Composable
fun Navigation(){
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = Screen.Main.route){
        composable(route = Screen.Main.route) {
            MainScreen(navController = navController)
        }

        composable(route = Screen.Card.route){
            CardScreen()
        }
        composable(route = Screen.Progress.route) {
            ProgressScreen()
        }
        composable(route = Screen.ListView.route){
            ListViewScreen()
        }
        composable(route = Screen.Button.route) {
            ButtonScreen()
        }
        composable(route = Screen.FloatingActionBar.route) {
            FloatingActionButtonScreen()
        }
        composable(route = Screen.BadgedBox.route) {
            BadgedBoxScreen()
        }
        composable(route = Screen.Menu.route) {
            MenuScreen()
        }
    }
}

@Composable
fun MainScreen(navController : NavController){
    ComposeItemListView(dataList = DataUtil.getComposeItems(), onClick = {
        navController.navigate(it.screen.route)
    })
}

@Composable
fun CardScreen() {
    Column {
        val context = LocalContext.current
        GetCard(user = User(name = "Harun", address = "Dhaka"), onClick = {
            Toast.makeText(context, it.name, Toast.LENGTH_SHORT).show()
        } )
    }
}

@Composable
fun ProgressScreen(){
    Column {
        GetCircularProgressbar()
        GetCircularProgressbarWithProgress(0.6f)
        CircularProgressAnimated()
        GetLinearProgress()
        GetLinearProgressWithProgress(0.6f)
    }
}

@Composable
fun ListViewScreen(){
    val context = LocalContext.current
    ListView(dataList = DataUtil.getUserList(), onClick = {
        Toast.makeText(context, it.name, Toast.LENGTH_SHORT).show()
    })
}

@Composable
fun ButtonScreen(){
    Column(
        modifier = Modifier
            .padding(12.dp)
            //.background(color = Color.LightGray)
            .fillMaxSize()
    ) {
        CreateButton()
        Spacer(modifier = Modifier.height(12.dp))
        CreateButtonWithBorder()
        Spacer(modifier = Modifier.height(12.dp))
        CreateOutlinedButton()
        Spacer(modifier = Modifier.height(12.dp))
        CreateTextButton()
        Spacer(modifier = Modifier.height(12.dp))
        CreateButtonWithIcon()
        Spacer(modifier = Modifier.height(12.dp))
        CreateButtonWithShape()
    }
}

@Composable
fun FloatingActionButtonScreen() {
    Column(
        modifier = Modifier
            .padding(12.dp)
            .fillMaxSize()
    ) {
        CreateFloatingActionButton()
        Spacer(modifier = Modifier.height(12.dp))
        CreateExtendedFloatingActionButton()
        Spacer(modifier = Modifier.height(12.dp))
        CreateFloatingActionButtonIcon()
        Spacer(modifier = Modifier.height(12.dp))
        CreateFloatingActionButtonShapeIcon()
    }
}

@Composable
fun BadgedBoxScreen(){
    Scaffold(bottomBar = { CreateBadgeBox() }
    ) {
        Box(modifier = Modifier
            //.background(Color(0xff546e7a))
            .fillMaxSize()
            .padding(it)
        )
    }
}

@Composable
fun MenuScreen(){
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(end = 16.dp),
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.End
    ) {
        CreateDropdownMenu()
        Spacer(modifier = Modifier.height(250.dp))
        CreateExposedDropdownMenu()
    }
}