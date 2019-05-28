package com.greenmist.android.daggerscope.di

import dagger.Module
import dagger.Provides

@Module(includes = [ChildFragmentBuildersModule::class])
class FragmentModule {

    @FragmentScope
    @Provides
    fun provideFragmentDependency(): FragmentDependency = FragmentDependency()

    class FragmentDependency : Dependency()
}