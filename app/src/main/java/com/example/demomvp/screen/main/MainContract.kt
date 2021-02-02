package com.example.demomvp.screen.main

import com.example.demomvp.utils.BasePresenter

interface MainContract {
    /**
     * View
     */
    interface View {
        fun onError(exception: Exception?)
    }

    /**
     * Presenter
     */
    interface Presenter : BasePresenter<View> {
    }
}
