package com.example.demomvp.data.source.local

import com.example.demomvp.data.source.UserDataSource

class UserLocalDataSource : UserDataSource.Local {

    private object Holder {
        val INSTANCE = UserLocalDataSource()
    }

    companion object {
        val instance: UserLocalDataSource by lazy { Holder.INSTANCE }
    }
}
