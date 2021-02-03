package com.example.demomvp.screen.main

import com.example.demomvp.data.model.User
import com.example.demomvp.utils.BasePresenter

interface MainContract {
    /**
     * View
     */
    interface View {
        fun onGetUsersSuccess(users: MutableList<User>)
        fun onError(exception: Exception?)
    }

    /**
     * Presenter
     */
    interface Presenter : BasePresenter<View> {
        fun getUsers()
    }
}
