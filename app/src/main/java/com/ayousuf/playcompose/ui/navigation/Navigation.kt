package com.ayousuf.playcompose.ui.navigation

import android.util.Log
import android.widget.Toast
import androidx.activity.compose.BackHandler
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.ayousuf.playcompose.ui.main.MainViewModel
import com.ayousuf.playcompose.util.DataUtil
import com.ayousuf.playcompose.data.User
import com.ayousuf.playcompose.ui.Screen
import com.ayousuf.playcompose.ui.compose.badgebox.CreateBadgeBox
import com.ayousuf.playcompose.ui.compose.bottomsheet.CreateModalBottomSheet
import com.ayousuf.playcompose.ui.compose.bottomsheet.CreateScaffoldBottomSheet
import com.ayousuf.playcompose.ui.compose.button.*
import com.ayousuf.playcompose.ui.compose.card.GetCard
import com.ayousuf.playcompose.ui.compose.dialog.CreateAlertDialog
import com.ayousuf.playcompose.ui.compose.dialog.CreateDialog
import com.ayousuf.playcompose.ui.compose.image.*
import com.ayousuf.playcompose.ui.compose.layout.CreateConstraintLayout
import com.ayousuf.playcompose.ui.compose.list.ComposeItemListView
import com.ayousuf.playcompose.ui.compose.list.ListView
import com.ayousuf.playcompose.ui.compose.menu.CreateDropdownMenu
import com.ayousuf.playcompose.ui.compose.menu.CreateExposedDropdownMenu
import com.ayousuf.playcompose.ui.compose.pagination.CreatePagination
import com.ayousuf.playcompose.ui.compose.picker.CreateCalendar
import com.ayousuf.playcompose.ui.compose.picker.CreateTimePicker
import com.ayousuf.playcompose.ui.compose.progress.*
import com.ayousuf.playcompose.ui.compose.scaffold.CreateScaffoldLayout
import com.ayousuf.playcompose.ui.compose.text.*
import kotlinx.coroutines.launch


@Composable
fun Navigation(viewModel: MainViewModel){
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = Screen.Main.route){
        composable(route = Screen.Main.route) {
            MainScreen(navController = navController)
        }
        composable(route = Screen.Text.route){
            TextScreen()
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
        composable(route = Screen.Scaffold.route) {
            ScaffoldScreen()
        }
        composable(route = Screen.Dialog.route) {
            DialogScreen()
        }
        composable(route = Screen.BottomSheet.route) {
            BottomSheetScreen(navController = navController)
        }
        composable(route = Screen.Image.route) {
            ImageScreen()
        }
        composable(route = Screen.Calendar.route) {
            CalendarScreen()
        }
        composable(route = Screen.Pagination.route) {
            PaginationScreen(viewModel)
        }
        composable(route = Screen.ConstraintLayout.route) {
            ConstraintLayoutScreen()
        }
    }
}

@Composable
fun MainScreen(navController : NavController){
    Scaffold(
        topBar = {
            TopAppBar(title = {
                Text(text = "Compose List")
            })
        }
    ) { paddingValues ->
        Box(modifier = Modifier.padding(paddingValues)){
            ComposeItemListView(
                dataList = DataUtil.getComposeItems(),
                onClick = {
                    navController.navigate(it.screen.route)
                }
            )
        }
    }

}

@Composable
fun TextScreen() {
    Column(
        modifier = Modifier
            .padding(start = 20.dp, top = 32.dp, bottom = 64.dp, end = 16.dp)
            .verticalScroll(rememberScrollState())
    ) {
        Spacer(modifier = Modifier.height(16.dp))
        CreateSimpleText()
        Spacer(modifier = Modifier.height(16.dp))
        CreateCenterText()
        Spacer(modifier = Modifier.height(16.dp))
        CreateTextShadow()
        Spacer(modifier = Modifier.height(16.dp))
        CreateTextWithDifferentFonts()
        Spacer(modifier = Modifier.height(16.dp))
        CreateTextWithCustomFont()
        Spacer(modifier = Modifier.height(16.dp))
        CreateMultipleStylesInText()
        Spacer(modifier = Modifier.height(16.dp))
        CreateOverflowedText()
        Spacer(modifier = Modifier.height(16.dp))
        CreateTextStyleWithBrush()
        Spacer(modifier = Modifier.height(16.dp))
        CreateTextFieldWithBrush()
        Spacer(modifier = Modifier.height(16.dp))
        CreateSelectableText()
        Spacer(modifier = Modifier.height(16.dp))
        CreatePartiallySelectableText()
        Spacer(modifier = Modifier.height(16.dp))
        CreateSimpleClickableTextWithPosition()
        Spacer(modifier = Modifier.height(16.dp))
        CreateSimpleFilledTextFieldSample()
        Spacer(modifier = Modifier.height(16.dp))
        CreateSimpleOutlinedTextFieldSample()
        Spacer(modifier = Modifier.height(16.dp))
        CreatePasswordTextField()
    }
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
fun ImageScreen() {
    Column(
        modifier = Modifier
            .padding(32.dp)
            .verticalScroll(rememberScrollState())
    ) {

        Spacer(modifier = Modifier.height(16.dp))
        CreateSimpleImageView()
        Spacer(modifier = Modifier.height(16.dp))
        CreateImageView()
        Spacer(modifier = Modifier.height(16.dp))
        CreateImageViewWithCircleShape()
        Spacer(modifier = Modifier.height(16.dp))
        CreateImageViewWithRoundedCornerShape()
        Spacer(modifier = Modifier.height(16.dp))
        CreateImageViewWithSquashedOvalShape()
        Spacer(modifier = Modifier.height(16.dp))
        CreateImageViewWithBorder()
        Spacer(modifier = Modifier.height(16.dp))
        CreateImageViewWithRainbowBorder()
        Spacer(modifier = Modifier.height(16.dp))
        CreateImageViewWithCustomAspectRatio()
        Spacer(modifier = Modifier.height(16.dp))
        CreateImageViewWithColorFilter()
        Spacer(modifier = Modifier.height(16.dp))
        CreateImageViewWithFilterWithColorMatrix()
        Spacer(modifier = Modifier.height(16.dp))
        CreateImageViewWithBlur()
        Spacer(modifier = Modifier.height(16.dp))
        CreateImageViewWithTint()
        Spacer(modifier = Modifier.height(16.dp))
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

@Composable
fun ScaffoldScreen() {
    Box(
        modifier = Modifier
            .fillMaxSize()
    ) {
        CreateScaffoldLayout()
    }
}

@Composable
fun DialogScreen() {

    val openAlertDialog = remember { mutableStateOf(false) }
    val openDialog = remember { mutableStateOf(false) }
    Column(
        modifier = Modifier
            .padding(16.dp)
            .fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Button(
            onClick = {
                openAlertDialog.value = true
            }
        ) {
            Text(text = "Open Alert Dialog")
        }

        CreateAlertDialog(openAlertDialog)

        Spacer(modifier = Modifier.height(32.dp))
        
        Button(
            onClick = {
                openDialog.value = true
            }
        ) {
            Text(text = "Open Dialog")
        }

        CreateDialog(openDialog)
    }
}


@OptIn(ExperimentalMaterialApi::class)
@Composable
fun BottomSheetScreen(navController : NavController) {

    val bottomSheetScaffoldState = rememberBottomSheetScaffoldState(bottomSheetState = BottomSheetState(BottomSheetValue.Collapsed))
    var sheetPeekHeight by remember { mutableStateOf(BottomSheetScaffoldDefaults.SheetPeekHeight) }
    val modalBottomSheetState = rememberModalBottomSheetState(initialValue = ModalBottomSheetValue.Hidden, confirmStateChange = {
        Log.i("BottomSheetScreen", "Modal Bottom Sheet state: $it")
        if (it == ModalBottomSheetValue.Hidden){
            sheetPeekHeight = BottomSheetScaffoldDefaults.SheetPeekHeight
        }
        true
    })
    val coroutineScope = rememberCoroutineScope()

    BackHandler(modalBottomSheetState.isVisible) {
        coroutineScope.launch { modalBottomSheetState.hide() }
    }

    CreateScaffoldBottomSheet(navController, bottomSheetScaffoldState, coroutineScope, sheetPeekHeight) {
        Box {
            Column {
                Spacer(modifier = Modifier.height(32.dp))
                Button(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(start = 32.dp, end = 32.dp),
                    onClick = {
                        coroutineScope.launch {
                            if (bottomSheetScaffoldState.bottomSheetState.isCollapsed) {
                                bottomSheetScaffoldState.bottomSheetState.expand()
                            } else {
                                bottomSheetScaffoldState.bottomSheetState.collapse()
                            }
                        }
                    }
                ) {
                    Text(text = "Show Scaffold Bottom Sheet")
                }

                Spacer(modifier = Modifier.height(32.dp))

                Button(
                    modifier = Modifier
                        .padding(start = 32.dp, end = 32.dp)
                        .fillMaxWidth(),
                    onClick = {
                        coroutineScope.launch {
                            sheetPeekHeight = -BottomSheetScaffoldDefaults.SheetPeekHeight
                            if (bottomSheetScaffoldState.bottomSheetState.isExpanded){
                                bottomSheetScaffoldState.bottomSheetState.collapse()
                            }
                            modalBottomSheetState.show()
                        }
                    }
                ) {
                    Text(text = "Show Modal Bottom Sheet")
                }
            }
            CreateModalBottomSheet(modalBottomSheetState, coroutineScope)
        }
    }

}

@Composable
fun CalendarScreen() {
    Column(modifier = Modifier
        .fillMaxSize()
        .verticalScroll(rememberScrollState())
    ) {
        CreateCalendar()
        Spacer(modifier = Modifier.heightIn(12.dp))
        CreateTimePicker()
    }
}

@Composable
fun PaginationScreen(viewModel: MainViewModel) {
    CreatePagination(viewModel)
}

@Composable
fun ConstraintLayoutScreen() {
    CreateConstraintLayout()
}