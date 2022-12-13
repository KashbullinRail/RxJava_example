package com.example.rxjava_example

import android.util.Log
import io.reactivex.rxjava3.core.Observer
import io.reactivex.rxjava3.disposables.Disposable
import io.reactivex.rxjava3.subjects.BehaviorSubject

class BehaviorSubjectSample {

    fun doSomeWorkBehavior() {
        var source = BehaviorSubject.create<Int>()
        source.subscribe(getFirstObserver())
        source.onNext(1)
        source.onNext(2)
        source.onNext(3)

        source.subscribe(getSecondObserver())
        source.onNext(4)
        source.onComplete()
    }

}

private fun getFirstObserver(): Observer<Int> {
    return object : Observer<Int> {
        override fun onSubscribe(d: Disposable) {
            Log.d("RxJava", "\n First onSubscribe Behavior : + ${d.isDisposed()}")
        }

        override fun onNext(value: Int) {
            Log.d("RxJava", " First onNext value Behavior: $value")
        }

        override fun onError(e: Throwable) {
            Log.d("RxJava", " First onError Behavior : " + e.message)
        }

        override fun onComplete() {
            Log.d("RxJava", " First onComplete Behavior \n")
        }
    }
}

private fun getSecondObserver(): Observer<Int> {
    return object : Observer<Int> {
        override fun onSubscribe(d: Disposable) {
            Log.d("RxJava", "\n Second onSubscribe Behavior :  + ${d.isDisposed()} \n")
        }

        override fun onNext(value: Int) {
            Log.d("RxJava", " Second onNext value Behavior : $value")
        }

        override fun onError(e: Throwable) {
            Log.d("RxJava", " Second onError Behavior :  + ${e.message}")
        }

        override fun onComplete() {
            Log.d("RxJava", " Second onComplete Behavior \n")
        }

    }
}


