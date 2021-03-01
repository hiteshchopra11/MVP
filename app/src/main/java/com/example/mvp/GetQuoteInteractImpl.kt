package com.example.mvp

import com.example.mvp.interfaces.MainContract
import java.util.*

class GetQuoteInteractImpl : MainContract.ApiService {
    private val arrayList: List<String> = listOf(
        "Be yourself. everyone else is already taken.",
        "A room without books is like a body without a soul.",
        "You only live once, but if you do it right, once is enough.",
        "Be the change that you wish to see in the world.",
        "If you tell the truth, you don't have to remember anything."
    )

    override fun getNextQuote(onFinishedListener: MainContract.ApiService.OnFinishedListener) {
        onFinishedListener.onFinished(randomString)
    }

    private val randomString: String
        get() {
            val random = Random()
            val index: Int = random.nextInt(arrayList.size)
            return arrayList[index]
        }
}