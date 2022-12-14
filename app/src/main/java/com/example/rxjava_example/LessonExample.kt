package com.example.rxjava_example

import android.util.Log
import io.reactivex.rxjava3.core.Observable
import io.reactivex.rxjava3.schedulers.Schedulers


class LessonExample {

    fun lessonExample() {

        val someObservable = Observable.just(
            1, 1, 3, 4, 1,
            1, 7, 8, 9
        )

//        someObservable
//            .filter {
//                it < 8
//            }
//            .distinctUntilChanged()
//            .map {
//                it.toDouble()
//            }.subscribe(
//                {
//                Log.d("RxJava3test", "onNext $it")
//                }, {}, {}
//            )

        someObservable
            .subscribeOn(Schedulers.newThread())
            .doOnNext {
                Log.d("RxJava3", "doNExtOne ${Thread.currentThread().name}")
            }
            .observeOn(Schedulers.newThread())
            .doOnNext {
                Log.d("RxJava3", "doNextTwo ${Thread.currentThread().name}")
            }
            .subscribe(
                {
                    Log.d("RxJava3", "onNext $it")
                },
                {},
                {}
            )

//        Flowable.just(1, 1, 3, 4, 1, 1, 7, 8, 9)
//            .onBackpressureBuffer(4)
//            .subscribe({
//                Log.d("RxJava3", "doOnNextFlow $it")
//            },
//                {},
//                {}
//            )
//
//        Single.just(1)
//            .subscribe({
//
//            },{
//
//            })

    }

}