package com.greenmist.android.daggerscope.di.screen

import com.greenmist.android.daggerscope.ChildFragment
import com.greenmist.android.daggerscope.di.ChildFragmentModule
import com.greenmist.android.daggerscope.di.ChildFragmentScope
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class ChildFragmentBuilderModule {

    @ChildFragmentScope
    @ContributesAndroidInjector(
        modules = [
            ChildFragmentModule::class
        ]
    )
    abstract fun contributeChildFragmentInjector(): ChildFragment

}