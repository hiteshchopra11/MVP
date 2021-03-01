package com.example.mvp.interfaces

interface MainContract {

    interface MainView {
        fun showProgress()
        fun hideProgress()
        fun setQuote(string: String)
    }

    interface ApiService {
        interface OnFinishedListener {
            fun onFinished(string: String)
        }
        fun getNextQuote(onFinishedListener: OnFinishedListener)
    }

    interface Presenter {
        fun onButtonClick()
        fun onDestroy()
    }
}