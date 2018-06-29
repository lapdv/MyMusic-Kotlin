package com.framgia.lapdv.mymusic.base

import android.databinding.DataBindingUtil
import android.databinding.ViewDataBinding
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.app.Activity
import android.content.Intent
import android.support.v4.app.FragmentTransaction
import android.view.View


abstract class BaseActivity<T : ViewDataBinding> : AppCompatActivity(), View.OnClickListener {

  protected var mBinding: T? = null

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    mBinding = DataBindingUtil.setContentView(this, getLayoutId())
    initView()
    initData()
  }

  abstract fun getLayoutId(): Int

  abstract fun initView()

  abstract fun initData()

  abstract fun getContainerId(): Int

  /**
   *  open activity
   */
  fun openActivity(pClass: Class<out Activity>) {
    openActivity(pClass, null)
  }

  fun openActivity(pClass: Class<out Activity>, isFinish: Boolean) {
    openActivity(pClass)
    if (isFinish) {
      finish()
    }
  }

  fun openActivity(pClass: Class<out Activity>, bundle: Bundle?) {
    val intent = Intent(this, pClass)
    intent.flags = Intent.FLAG_ACTIVITY_REORDER_TO_FRONT
    if (bundle != null) {
      intent.putExtras(bundle)
    }
    startActivity(intent)
  }

  fun gotoFragment(fragment: BaseFragment<*>, bundle: Bundle?) {
    val fragmentTransaction = supportFragmentManager.beginTransaction()
    fragment.setArguments(bundle)
    fragmentTransaction.replace(getContainerId(), fragment)
    fragmentTransaction.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN)
    fragmentTransaction.commit()
  }

  override fun onClick(p0: View?) {
  }
}
