package com.greenmist.android.daggerscope.di

import androidx.lifecycle.ViewModel
import com.greenmist.android.daggerscope.vm.FragmentViewModel
import com.greenmist.android.daggerscope.vm.TestViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
abstract class FragmentViewModelModule {

    @Binds
    @IntoMap
    @ViewModelKey(FragmentViewModel::class)
    abstract fun bindFragmentViewModel(viewModel: FragmentViewModel): ViewModel

}