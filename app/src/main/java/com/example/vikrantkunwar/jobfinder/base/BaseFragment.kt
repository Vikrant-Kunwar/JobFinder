package com.example.vikrantkunwar.jobfinder.base

import android.content.Context
import android.os.Bundle
import android.support.annotation.LayoutRes
import android.support.v7.app.AppCompatActivity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import butterknife.ButterKnife
import butterknife.Unbinder
import dagger.android.support.DaggerFragment

abstract class BaseFragment : DaggerFragment() {

    private var unbinder: Unbinder? = null
    var baseActivity: AppCompatActivity? = null
        private set


    @LayoutRes
    protected abstract fun layoutRes(): Int

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(layoutRes(), container, false)
        unbinder = ButterKnife.bind(this, view)

        return view
    }


    override fun onAttach(context: Context?) {
        super.onAttach(context)
        baseActivity = context as AppCompatActivity?
    }

    override fun onDetach() {
        super.onDetach()
        baseActivity = null
    }

    override fun onDestroyView() {
        super.onDestroyView()

        if (unbinder != null) {

            unbinder!!.unbind()
            unbinder = null
        }

    }
}
