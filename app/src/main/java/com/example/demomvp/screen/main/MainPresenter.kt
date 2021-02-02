package com.example.demomvp.screen.main

class MainPresenter internal constructor() : MainContract.Presenter {

    private var view: MainContract.View? = null

    override fun onStart() {
    }

    override fun onStop() = Unit

    override fun setView(view: MainContract.View?) {
        this.view = view
    }
}
