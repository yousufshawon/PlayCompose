package com.ayousuf.playcompose.ui.main

import com.ayousuf.playcompose.data.User
import kotlinx.coroutines.delay


/**
 * Created by Android Studio.
 * User:  Yousuf
 * Email:
 * Date:  16/1/23
 * To change this template use File | Settings | File and Code Templates.
 *
 */

class Repository {

    private val remoteDataSource = (1..100).map {
        User(
            name = "User $it",
            address = "Address $it"
        )
    }

    suspend fun getUserList(page:Int, pageSize:Int) : Result<List<User>> {
        delay(1500)
        val startIndex = page * pageSize
        return if (startIndex + pageSize <= remoteDataSource.size){
            Result.success(
                remoteDataSource.slice(startIndex until startIndex + pageSize)
            )
        } else {
            //Result.success(emptyList())
            Result.success(remoteDataSource.slice(startIndex until remoteDataSource.size))
        }
    }
}