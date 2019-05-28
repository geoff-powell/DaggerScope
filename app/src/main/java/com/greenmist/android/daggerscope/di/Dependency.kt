package com.greenmist.android.daggerscope.di

open class Dependency {
    val count: Int = instance++

    companion object {
        var instance = 0
    }
}