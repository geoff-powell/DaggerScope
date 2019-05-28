package com.greenmist.android.daggerscope.di

import dagger.Module
import dagger.Provides

@Module
class ChildFragmentModule {

    @ChildFragmentScope
    @Provides
    fun provideFragmentDependency(): ChildFragmentDependency = ChildFragmentDependency()

    class ChildFragmentDependency : Dependency()
}