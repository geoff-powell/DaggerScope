package com.greenmist.android.daggerscope.di

import android.app.Application
import android.content.Context
import dagger.Module
import dagger.Provides
import javax.inject.Singleton
import kotlin.random.Random

@Module
class AppModule {

    @Provides
    @Singleton
    fun providesSingletonManager(): SingletonManager = SingletonManager(Random.nextInt())

    @Provides
    @Singleton
    fun providesAppContext(app: Application): Context = app

    data class SingletonManager(val type: Int)
}