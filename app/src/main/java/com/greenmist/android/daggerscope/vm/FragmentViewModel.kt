package com.greenmist.android.daggerscope.vm

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.greenmist.android.daggerscope.di.FragmentModule
import javax.inject.Inject

class FragmentViewModel
@Inject
constructor(
    private val fragmentDependency: FragmentModule.FragmentDependency
) : ViewModel() {

    val data = MutableLiveData<Int>()

    init {
        data.postValue(fragmentDependency.count)
    }

    fun changeData(data: Int) {
        this.data.postValue(data)
    }
}