package com.example.mvp


import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ProgressBar
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.mvp.interfaces.MainContract
import com.example.mvp.presenter.MainPresenterImpl


class MainActivity : AppCompatActivity(), MainContract.MainView {

    private lateinit var textView: TextView
    private lateinit var button: Button
    private lateinit var progressBar: ProgressBar
    private lateinit var presenter: MainPresenterImpl

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initViews()
        button.setOnClickListener { (presenter).onButtonClick() }
    }

    private fun initViews() {
        textView = findViewById(R.id.textView)
        button = findViewById(R.id.button)
        progressBar = findViewById(R.id.progressBar)
        presenter = MainPresenterImpl(this, GetQuoteInteractImpl())
    }

    override fun onDestroy() {
        super.onDestroy()
        presenter.onDestroy()
    }

    override fun showProgress() {
        progressBar.visibility = View.VISIBLE
        textView.visibility = View.INVISIBLE
    }

    override fun hideProgress() {
        progressBar.visibility = View.GONE
        textView.visibility = View.VISIBLE
    }

    override fun setQuote(string: String) {
        textView.text = string
    }
}