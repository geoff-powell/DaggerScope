package com.greenmist.android.daggerscope.di

import androidx.fragment.app.Fragment
import dagger.Subcomponent
import dagger.android.AndroidInjector

@ScreenScope
@Subcomponent(modules = [ScreenModule::class])
interface ScreenComponent : AndroidInjector<Fragment>  {

    fun plus(): ChildScreenComponent

    @Subcomponent.Builder
    interface Builder {
        fun build(): ScreenComponent
    }
}