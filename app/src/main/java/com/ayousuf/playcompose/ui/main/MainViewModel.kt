package com.ayousuf.playcompose.ui.main

import android.util.Log
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ayousuf.playcompose.data.User
import kotlinx.coroutines.launch


/**
 * Created by Android Studio.
 * User:  Yousuf
 * Email:
 * Date:  16/1/23
 * To change this template use File | Settings | File and Code Templates.
 *
 */

class MainViewModel : ViewModel() {

    private val repository = Repository()
    private var page = 0
    private val pageSize = 15
    var state by mutableStateOf(UserListState())

    init {
        loadMore(page)
    }

    fun loadNextPage() {
        loadMore(page + 1)
    }

    private fun loadMore(userPage : Int, size : Int = pageSize) {
        viewModelScope.launch {
            state = state.copy(isLoading = true)
            Log.i("MainViewModel", "Loading items for page $userPage")
            val result = repository.getUserList(userPage, size)
            val userList = result.getOrElse {
                state = state.copy(isLoading = false)
                return@launch
            }

            if (state.items.isNotEmpty()) {
                page = userPage
            }
            state = state.copy(
                isLoading = false,
                items = state.items + userList,
                page = userPage,
                endReached = userList.isEmpty()
            )
        }
    }

}

data class UserListState(
    val isLoading : Boolean = false,
    val items : List<User> = emptyList(),
    val page : Int = 0,
    val endReached : Boolean = false
)