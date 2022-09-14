package com.example.rxjava_example

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import io.reactivex.rxjava3.core.Observable
import io.reactivex.rxjava3.core.Observer
import io.reactivex.rxjava3.disposables.Disposable

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val someObservable = Observable.just(1, 1, 3, 4, 1, 1, 7, 8, 9)


        someObservable
            .map {
            it.toDouble()
        }.distinctUntilChanged()
            .subscribe(
                {
                    Log.d("RxJava3", "onNext $it")
                },
                {},
                {}
            )

    }
}