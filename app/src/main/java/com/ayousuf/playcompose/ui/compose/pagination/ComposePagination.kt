package com.ayousuf.playcompose.ui.compose.pagination

import android.util.Log
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.ayousuf.playcompose.ui.main.MainViewModel
import com.ayousuf.playcompose.ui.compose.card.GetCard
import com.ayousuf.playcompose.ui.compose.progress.GetCircularProgressbar


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
fun CreatePagination(viewModel: MainViewModel = androidx.lifecycle.viewmodel.compose.viewModel()) {
    LazyColumn(modifier = Modifier.fillMaxSize()) {
        Log.i("Pagination", " ${viewModel.state.items.size} items")

        items(viewModel.state.items.size) { index ->
            Log.i("Pagination: ", "Loading $index reached: ${viewModel.state.endReached}")
            if (index >= viewModel.state.items.size - 1 && !viewModel.state.endReached && !viewModel.state.isLoading ) {
                Log.i("Pagination: ", "loadNextPage")
                viewModel.loadNextPage()
            }
            val user = viewModel.state.items[index]
            GetCard(
                user = user,
                onClick = { }
            )
        }
        item {
            if (viewModel.state.isLoading) {
                GetCircularProgressbar()
            }
        }
    }
}