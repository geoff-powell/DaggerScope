package com.greenmist.android.daggerscope.di

import com.greenmist.android.daggerscope.MainActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class ActivityBuildersModule {

    @ActivityScope
    @ContributesAndroidInjector(modules = [ActivityModule::class])
     /* modules to install into the subcomponent */
    abstract fun contributeMainActivityInjector(): MainActivity
}