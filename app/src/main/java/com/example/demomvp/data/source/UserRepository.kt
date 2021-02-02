package com.example.demomvp.data.source

import com.example.demomvp.data.model.User
import com.example.demomvp.data.source.local.UserLocalDataSource
import com.example.demomvp.data.source.remote.OnFetchDataJsonListener
import com.example.demomvp.data.source.remote.UserRemoteDataSource

class UserRepository private constructor(
    private val remote: UserDataSource.Remote,
    private val local: UserDataSource.Local
) {

    private object Holder {
        val INSTANCE = UserRepository(
            remote = UserRemoteDataSource.instance,
            local = UserLocalDataSource.instance
        )
    }

    fun getUsers(listener: OnFetchDataJsonListener<MutableList<User>>) {
        remote.getUsers(listener)
    }

    companion object {
        val instance: UserRepository by lazy { Holder.INSTANCE }
    }
}
