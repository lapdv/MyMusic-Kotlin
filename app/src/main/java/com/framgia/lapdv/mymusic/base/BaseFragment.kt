package com.framgia.lapdv.mymusic.base

import android.databinding.DataBindingUtil
import android.databinding.ViewDataBinding
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentTransaction
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

abstract class BaseFragment<T : ViewDataBinding> : Fragment(), View.OnClickListener {

    protected var mBinding: T? = null

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        if (null == mBinding) {
            mBinding = DataBindingUtil.inflate(inflater, getLayoutId(), container, false)
        }
        return mBinding?.root
    }

    abstract fun getLayoutId(): Int

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initView()
    }

    open fun initView() {

    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        initData();
    }

    abstract fun initData()

    fun getBaseActivity(): BaseActivity<*>? {
        return if (activity is BaseActivity<*>) {
            activity as BaseActivity<*>?
        } else null
    }

    fun replaceFragment(fragment: BaseFragment<*>, bundle: Bundle) {
        val fragmentTransaction = getBaseActivity()?.supportFragmentManager
                ?.beginTransaction()
        fragment.arguments = bundle
        fragmentTransaction?.replace(getContainerId(), fragment)
        fragmentTransaction?.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN)
        fragmentTransaction?.addToBackStack(null)
        fragmentTransaction?.commit()
    }

    protected fun getContainerId(): Int {
        return 0
    }

    override fun onClick(p0: View?) {
    }
}
