package com.greenmist.android.daggerscope

import android.annotation.SuppressLint
import android.os.Bundle
import android.util.Log
import com.greenmist.android.daggerscope.di.ActivityModule
import com.greenmist.android.daggerscope.di.AppModule
import dagger.android.support.DaggerAppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*
import javax.inject.Inject

class MainActivity : DaggerAppCompatActivity() {

    @Inject
    lateinit var activityDependency: ActivityModule.ActivityDependency

    @Inject
    lateinit var singletonManager: AppModule.SingletonManager

    private var state: Boolean = false

    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        Log.d(javaClass.simpleName, "TAG Singleton: ${singletonManager.type}")
        Log.d(javaClass.simpleName, "TAG Activity: ${activityDependency.count}")

        text_activity.text = "Singleton: ${singletonManager.type} - Activity: ${activityDependency.count}"

        switchFragment()

        button.setOnClickListener {
            switchFragment()
        }
    }

    private fun switchFragment() {
        state = !state

        val fragment = if (state) NavFragment() else OtherNavFragment()

        supportFragmentManager.beginTransaction()
            .replace(R.id.container, fragment)
            .commitNowAllowingStateLoss()
    }
}
