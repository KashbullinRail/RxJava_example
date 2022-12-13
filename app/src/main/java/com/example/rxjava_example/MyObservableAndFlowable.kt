package com.example.rxjava_example

import android.util.Log
import io.reactivex.rxjava3.core.Flowable
import io.reactivex.rxjava3.core.Observable


class MyObservableAndFlowable {

    fun myObservableFun() {

        val myObservable = Observable.just(
            1, 2, 3,
            4, 2, 6, 10, 10, 11, 10,
        )

        myObservable
            .map { it.toFloat() }
            .skip(1)
            .skipLast(1)
            .takeWhile { it < 11 }
            .distinct()
            .subscribe({
                Log.d("RxJava3", "onNext $it")
            },
                {},
                {})

    }

    fun myFlowableFun() {

        val myFlowable = Flowable.just(
            1, 2, 3,
            4, 2, 6, 10, 10, 11, 10,
        )

        myFlowable
            .repeat(2)
            .take(9)
            .skipWhile { it < 3 }
            .filter { it > 4 }
            .first(3)
            .subscribe({
                Log.d("RxJava3", "onNext $it")
            },
                {})

    }

}