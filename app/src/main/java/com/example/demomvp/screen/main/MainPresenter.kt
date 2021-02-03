package com.example.demomvp.screen.main

import com.example.demomvp.data.model.User
import com.example.demomvp.data.source.UserRepository
import com.example.demomvp.data.source.remote.OnFetchDataJsonListener
import java.lang.Exception

class MainPresenter internal constructor(private val userRepository: UserRepository?) :
    MainContract.Presenter {

    private var view: MainContract.View? = null

    override fun onStart() {
        getUsers()
    }

    override fun onStop() = Unit

    override fun setView(view: MainContract.View?) {
        this.view = view
    }

    override fun getUsers() {
        userRepository?.getUsers(object : OnFetchDataJsonListener<MutableList<User>> {
            override fun onSuccess(data: MutableList<User>) {
                view?.onGetUsersSuccess(data)
            }

            override fun onError(exception: Exception?) {
                view?.onError(exception)
            }
        })
    }
}
