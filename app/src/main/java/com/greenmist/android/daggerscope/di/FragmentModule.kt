package com.greenmist.android.daggerscope.di

import dagger.Module
import dagger.Provides

@Module(includes = [
    FragmentViewModelModule::class
])
class FragmentModule {

    @FragmentScope
    @Provides
    fun provideFragmentDependency(): FragmentDependency = FragmentDependency()

    class FragmentDependency {

        val count: Int = instance++

        companion object {
            var instance = 0
        }
    }
}