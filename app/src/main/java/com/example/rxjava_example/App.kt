package com.example.rxjava_example

import android.app.Application
import android.util.Log
import io.reactivex.rxjava3.exceptions.UndeliverableException
import io.reactivex.rxjava3.plugins.RxJavaPlugins


class App : Application() {

    override fun onCreate() {
        super.onCreate()
        RxJavaPlugins.setErrorHandler { e ->
            if (e is UndeliverableException) {
                Log.e("Error", "${e.message}")
            } else {
                Thread.currentThread()
                    .also { thread -> thread.uncaughtExceptionHandler.uncaughtException(thread, e) }
            }
        }
    }
}