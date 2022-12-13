package com.example.rxjava_example

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val publish = PublishSubjectSample()
        println("\n")
        publish.doSomeWorkPublish()
        println("\n")

        val async = AsyncSubjectSample()
        async.doSomeWorkAsync()
        println("\n")

        val behavior = BehaviorSubjectSample()
        behavior.doSomeWorkBehavior()
        println("\n")

        val replay = ReplaySubjectSample()
        replay.doSomeWorkReplay()
        println("\n")

        val myObservableAndFlowable = MyObservableAndFlowable()
        myObservableAndFlowable.myObservableFun()
        println("\n")
        myObservableAndFlowable.myFlowableFun()
        println("\n")

        val lesson = LessonExample()
        println("\n")
        lesson.lessonExample()
        println("\n")

    }

}