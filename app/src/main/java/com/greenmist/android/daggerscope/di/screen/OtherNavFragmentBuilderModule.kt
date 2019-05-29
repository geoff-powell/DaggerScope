package com.greenmist.android.daggerscope.di.screen

import com.greenmist.android.daggerscope.OtherNavFragment
import com.greenmist.android.daggerscope.di.FragmentModule
import com.greenmist.android.daggerscope.di.FragmentScope
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class OtherNavFragmentBuilderModule {

    @FragmentScope
    @ContributesAndroidInjector(
        modules = [
            FragmentModule::class
        ]
    )
    abstract fun contributeOtherNavFragmentInjector(): OtherNavFragment

}