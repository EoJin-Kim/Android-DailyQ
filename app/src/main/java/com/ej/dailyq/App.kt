package com.ej.dailyq

import android.app.Application
import com.ej.dailyq.api.ApiService


class App : Application() {

    override fun onCreate() {
        super.onCreate()

        ApiService.init(this)
    }
}
