package com.greenmist.android.daggerscope.di

import com.greenmist.android.daggerscope.MainActivity
import com.greenmist.android.daggerscope.di.screen.NavFragmentBuilderModule
import com.greenmist.android.daggerscope.di.screen.OtherNavFragmentBuilderModule
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class ActivityBuildersModule {

    @ActivityScope
    @ContributesAndroidInjector(
        modules = [
            ActivityModule::class,
            NavFragmentBuilderModule::class,
            OtherNavFragmentBuilderModule::class
        ]
    )
    abstract fun contributeMainActivityInjector(): MainActivity
}