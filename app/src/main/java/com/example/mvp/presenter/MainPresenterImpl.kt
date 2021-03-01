package com.example.mvp.presenter

import com.example.mvp.interfaces.MainContract


class MainPresenterImpl(
    private var mainView: MainContract.MainView?,
    private val getQuoteInteract: MainContract.ApiService
) : MainContract.Presenter, MainContract.ApiService.OnFinishedListener {

    override fun onButtonClick() {
        if (mainView != null) {
            mainView!!.showProgress()
        }
        getQuoteInteract.getNextQuote(this)
    }

    override fun onDestroy() {
        mainView = null
    }

    override fun onFinished(string: String) {
        if (mainView != null) {
            mainView!!.setQuote(string)
            mainView!!.hideProgress()
        }
    }
}