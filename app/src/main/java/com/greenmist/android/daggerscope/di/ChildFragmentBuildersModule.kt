package com.greenmist.android.daggerscope.di

import com.greenmist.android.daggerscope.ChildFragment
import com.greenmist.android.daggerscope.DialogFragment
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class ChildFragmentBuildersModule {

    @ChildScreenScope
    @ChildFragmentScope
    @ContributesAndroidInjector(
        modules = [
            ChildFragmentModule::class
        ]
    )
    /* modules to install into the subcomponent */
    abstract fun contributeDialogFragmentInjector(): DialogFragment

    @ChildScreenScope
    @ChildFragmentScope
    @ContributesAndroidInjector(
        modules = [
            ChildFragmentModule::class
        ]
    )
    /* modules to install into the subcomponent */
    abstract fun contributeChildFragmentInjector(): ChildFragment
}