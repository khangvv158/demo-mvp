package com.example.demomvp.data.source

import com.example.demomvp.data.model.User
import com.example.demomvp.data.source.remote.OnFetchDataJsonListener

interface UserDataSource {
    /**
     * Local
     */
    interface Local

    /**
     * Remote
     */
    interface Remote {
        fun getUsers(listener: OnFetchDataJsonListener<MutableList<User>>)
    }
}
