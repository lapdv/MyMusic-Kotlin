package com.framgia.lapdv.mymusic.base.adapter

import android.content.Context
import android.databinding.ViewDataBinding
import android.support.v7.widget.RecyclerView

abstract class BaseViewHolder<T, B : ViewDataBinding>(binding: B)
  : RecyclerView.ViewHolder(binding.root) {

  protected var mBinding: B? = null

  init {
    this.mBinding = binding
  }

  /**
   * bind view data item adapter
   */
  abstract fun binData(data: T, position: Int)

  fun getContext(): Context {
    return itemView.context
  }
}
