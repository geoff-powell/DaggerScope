package com.greenmist.android.daggerscope.di

import com.greenmist.android.daggerscope.NavFragment
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class FragmentBuildersModule {

    @ScreenScope
    @FragmentScope
    @ContributesAndroidInjector(
        modules = [
            FragmentModule::class,
            ScreenModule::class
        ]
    )
    /* modules to install into the subcomponent */
    abstract fun contributeNavFragmentInjector(): NavFragment

}