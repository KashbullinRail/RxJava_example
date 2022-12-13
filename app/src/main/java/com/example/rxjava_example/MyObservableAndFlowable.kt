package com.example.rxjava_example

import io.reactivex.rxjava3.core.Observable

class MyObservableAndFlowable {

    fun myObservableAndFlowable() {

        var arrayList = ArrayList<Int>()
        for (i in 0 until 100) {
            arrayList.add(i)
        }

        val myObservable = Observable.just(arrayList)

        myObservable
            .



    }

}