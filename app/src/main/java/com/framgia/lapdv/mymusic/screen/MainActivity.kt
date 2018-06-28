package com.framgia.lapdv.mymusic.screen;

import com.framgia.lapdv.mymusic.R
import com.framgia.lapdv.mymusic.base.BaseActivity
import com.framgia.lapdv.mymusic.databinding.ActivityMainBinding
import com.framgia.lapdv.mymusic.screen.home.HomeFragment

class MainActivity : BaseActivity<ActivityMainBinding>() {

  override fun getLayoutId(): Int = R.layout.activity_main

  override fun getContainerId(): Int = R.id.fl_container

  override fun initView() {

  }

  override fun initData() {
    gotoFragment(HomeFragment(),null)
  }

}
