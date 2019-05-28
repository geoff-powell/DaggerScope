package com.greenmist.android.daggerscope.di

import dagger.Module
import dagger.Provides

@Module(
    subcomponents = [ChildScreenComponent::class]
)
class ScreenModule {

    @Provides
    @FragmentScope
    fun provideCategoryFilter(): CategoryFilter {
        return CategoryFilter()
    }

    class CategoryFilter {

        val count: Int = instance++

        companion object {
            var instance = 0
        }
    }
}