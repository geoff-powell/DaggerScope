package com.greenmist.android.daggerscope.di

import dagger.Module
import dagger.Provides

@Module(includes = [FragmentBuildersModule::class])
class ActivityModule {

    @ActivityScope
    @Provides
    fun provideActivityDependency(): ActivityDependency = ActivityDependency()

    class ActivityDependency {

        val count: Int = instance++

        companion object {
            var instance = 0
        }
    }
}