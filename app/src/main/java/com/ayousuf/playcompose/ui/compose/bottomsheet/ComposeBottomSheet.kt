package com.ayousuf.playcompose.ui.compose.bottomsheet

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.rounded.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.ayousuf.playcompose.ui.theme.Purple500
import com.ayousuf.playcompose.util.DataUtil
import kotlinx.coroutines.CoroutineScope


/**
 * Created by Android Studio.
 * User:  Yousuf
 * Email:
 * Date:  27/12/22
 * To change this template use File | Settings | File and Code Templates.
 *
 */


@OptIn(ExperimentalMaterialApi::class)
@Preview(showBackground = true)
@Composable
fun CreateModalBottomSheet(
    state: ModalBottomSheetState = rememberModalBottomSheetState(initialValue = ModalBottomSheetValue.Expanded),
    coroutineScope: CoroutineScope = rememberCoroutineScope()
) {
    ModalBottomSheetLayout(
        sheetState = state,
        sheetContent = {
            GetModalSheetContent()
        }
    ) {
        // content
    }
}


@OptIn(ExperimentalMaterialApi::class)
@Preview(showBackground = true)
@Composable
fun CreateScaffoldBottomSheet(
    navController : NavController = rememberNavController(),
    bottomSheetScaffoldState : BottomSheetScaffoldState = rememberBottomSheetScaffoldState(bottomSheetState = BottomSheetState(BottomSheetValue.Expanded)),
    coroutineScope: CoroutineScope = rememberCoroutineScope(),
    sheetPeekHeight : Dp = BottomSheetScaffoldDefaults.SheetPeekHeight,
    content: @Composable (PaddingValues) -> Unit = {}
) {

    BottomSheetScaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text("Bottom Sheet")
                },
                navigationIcon = {
                    IconButton(onClick = {
                        navController.navigateUp()
                    }) {
                        Icon(Icons.Rounded.ArrowBack, "Back")
                    }
                }
            )
        },
        scaffoldState = bottomSheetScaffoldState,
        sheetPeekHeight = sheetPeekHeight,
        sheetContent = {
            GetPersistentSheetContent()
        },
        floatingActionButton = { GetFloatingActionButton()}
    ) {
        content(it)
    }

}

@OptIn(ExperimentalMaterialApi::class)
@Preview(showBackground = true)
@Composable
private fun GetModalSheetContent() {
    val itemList = DataUtil.getListItemForModalSheetContent()

    LazyColumn {
        items(itemList.size) { index ->
            ListItem(
                text = { Text(text = itemList[index].itemName, fontSize = 18.sp) },
                icon = {
                    Icon(
                        itemList[index].imageVector,
                        contentDescription = itemList[index].itemName
                    )
                }
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun GetPersistentSheetContent() {
    Column {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(70.dp)
                .background(color = Purple500),
            contentAlignment = Alignment.CenterStart
        ){
            Text(
                text = "Standard BottomSheet",
                fontSize = 22.sp,
                color = Color.White,
                modifier = Modifier
                    .padding(start = 16.dp)
            )
        }
        Text(
            text = "Standard bottom sheets co-exist with the screen’s main UI region and allow for simultaneously viewing and interacting with both regions. They are commonly used to keep a feature or secondary content visible on screen when content in main UI region is frequently scrolled or panned.",
            fontSize = 16.sp,
            modifier = Modifier.padding(all = 16.dp)
        )

        Row (
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceEvenly
        ){
            TextButton(onClick = {  }) {
                Text(text = "Call", fontSize = 18.sp)
            }

            TextButton(onClick = {  }) {
                Text(text = "Website", fontSize = 18.sp)
            }

            TextButton(onClick = {  }) {
                Text(text = "Save", fontSize = 18.sp)
            }
        }

        Spacer(modifier = Modifier.height(16.dp))
    }
}

@Preview(showBackground = true)
@Composable
fun GetFloatingActionButton(){
    FloatingActionButton(
        onClick = {  }
    ) {
        Icon(Icons.Filled.Favorite, "Add", tint = Purple500)
    }
}