package com.greenmist.android.daggerscope

import android.annotation.SuppressLint
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.greenmist.android.daggerscope.di.*
import com.greenmist.android.daggerscope.vm.FragmentViewModel
import dagger.android.support.DaggerDialogFragment
import kotlinx.android.synthetic.main.fragment_dialog.*
import javax.inject.Inject

class DialogFragment : DaggerDialogFragment() {

    @Inject
    lateinit var singletonManager: AppModule.SingletonManager

    @Inject
    lateinit var activityDependency: ActivityModule.ActivityDependency

    @Inject
    lateinit var fragmentDependency: FragmentModule.FragmentDependency

    @Inject
    lateinit var childFragmentDependency: ChildFragmentModule.ChildFragmentDependency

    @Inject
    lateinit var fragmentDaggerViewModelFactory: FragmentDaggerViewModelFactory

    private lateinit var viewModel: FragmentViewModel

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_dialog, container, false)
    }

    @SuppressLint("SetTextI18n")
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        Log.d(javaClass.simpleName, "TAG Singleton: ${singletonManager.type}")
        Log.d(javaClass.simpleName, "TAG Activity: ${activityDependency.count}")
        Log.d(javaClass.simpleName, "TAG Fragment: ${fragmentDependency.count}")
        Log.d(javaClass.simpleName, "TAG Child Fragment: ${childFragmentDependency.count}")

        viewModel = ViewModelProviders.of(this, fragmentDaggerViewModelFactory).get(FragmentViewModel::class.java)
        viewModel.data.observe(viewLifecycleOwner, Observer {
            Log.e(javaClass.simpleName, "TAG VM: $it")
        })

        text_dialog.text =
            "Singleton: ${singletonManager.type}\nActivity: ${activityDependency.count}\nFragment: ${fragmentDependency.count}\nChild Fragment: ${childFragmentDependency.count}"

        childFragmentManager.beginTransaction()
            .replace(R.id.child_fragment, ChildFragment())
            .commitNowAllowingStateLoss()
    }
}