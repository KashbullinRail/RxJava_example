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

        val someObservable = Observable.just(1,2,3,4,5,6,7,8,9)

        val subscriber1 = object : Observer<Int>{
            override fun onSubscribe(d: Disposable) {
                //когда подписался подписчик
                Log.d("RxJava3", "subscribe1")
            }

            override fun onNext(t: Int) {
                //срабатывает на каждый следующий элемент из just
                Log.d("RxJava3", "onNext1 ${t*5}")
            }

            override fun onError(e: Throwable) {
                //если произошла ошибка
                Log.d("RxJava3", "onError1 $e")
            }

            override fun onComplete() {
                //если все выполнено успешно
                Log.d("RxJava3", "onComplete1")
            }

        }

        val subscriber2 = object : Observer<Int>{
            override fun onSubscribe(d: Disposable) {
                Log.d("RxJava3", "subscribe2")
            }

            override fun onNext(t: Int) {
                val devByZero = t/0
                Log.d("RxJava3", "onNext2 ${devByZero}")
            }

            override fun onError(e: Throwable) {
                Log.d("RxJava3", "onError2 $e")
            }

            override fun onComplete() {
                Log.d("RxJava3", "onComplete2")
            }

        }

        someObservable.subscribe(subscriber1)
        someObservable.subscribe(subscriber2)

    }
}