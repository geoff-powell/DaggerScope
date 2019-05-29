package com.greenmist.android.daggerscope.di.screen

import com.greenmist.android.daggerscope.NavFragment
import com.greenmist.android.daggerscope.di.FragmentModule
import com.greenmist.android.daggerscope.di.FragmentScope
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class NavFragmentBuilderModule {

    @FragmentScope
    @ContributesAndroidInjector(
        modules = [
            FragmentModule::class,
            ChildFragmentBuilderModule::class,
            DialogFragmentBuilderModule::class
        ]
    )
    abstract fun contributeNavFragmentInjector(): NavFragment

}