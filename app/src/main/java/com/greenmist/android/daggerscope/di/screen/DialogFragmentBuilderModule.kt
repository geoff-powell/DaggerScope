package com.greenmist.android.daggerscope.di.screen

import com.greenmist.android.daggerscope.DialogFragment
import com.greenmist.android.daggerscope.di.ChildFragmentModule
import com.greenmist.android.daggerscope.di.ChildFragmentScope
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class DialogFragmentBuilderModule {

    @ChildFragmentScope
    @ContributesAndroidInjector(
        modules = [
            ChildFragmentModule::class
        ]
    )
    abstract fun contributeDialogFragmentInjector(): DialogFragment

}