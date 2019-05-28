package com.greenmist.android.daggerscope.di

import dagger.Subcomponent

@ChildScreenScope
@Subcomponent()
interface ChildScreenComponent {

    @Subcomponent.Builder
    interface Builder {
        fun build(): ChildScreenComponent
    }
}