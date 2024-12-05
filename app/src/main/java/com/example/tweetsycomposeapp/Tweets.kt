package com.example.tweetsycomposeapp

import android.app.Application
import dagger.hilt.android.HiltAndroidApp
import dagger.hilt.android.components.ActivityComponent
import retrofit2.http.Headers

@HiltAndroidApp
class Tweets : Application() {

    override fun onCreate() {
        super.onCreate()
    }
}