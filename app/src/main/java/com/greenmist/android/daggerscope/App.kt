package com.greenmist.android.daggerscope

import android.util.Log
import com.greenmist.android.daggerscope.di.AppComponent
import com.greenmist.android.daggerscope.di.AppModule
import com.greenmist.android.daggerscope.di.DaggerAppComponent
import dagger.android.AndroidInjector
import dagger.android.DaggerApplication
import javax.inject.Inject

class App : DaggerApplication() {

    @Inject
    lateinit var singletonManager: AppModule.SingletonManager

    override fun onCreate() {
        super.onCreate()

        Log.d(javaClass.simpleName, "Singleton App: ${singletonManager.type}")
    }

    fun applicationBuilder(): AppComponent.Builder {
        return DaggerAppComponent.builder()
            .application(this)
    }

    override fun applicationInjector(): AndroidInjector<out DaggerApplication> {
        return applicationBuilder().build()
    }

}