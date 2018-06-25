package com.framgia.lapdv.mymusic.base.adapter

import android.content.Context
import android.databinding.DataBindingUtil
import android.databinding.ViewDataBinding
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.framgia.lapdv.mymusic.callback.OnRecyclerViewItemClick
import java.util.*

abstract class BaseRecyclerAdapter<T, VH : BaseViewHolder<T, B>, B : ViewDataBinding>
  : RecyclerView.Adapter<BaseViewHolder<T, B>>() {

  private var mContext: Context? = null
  private var mData: MutableList<T>? = arrayListOf()
  private var mHolder: VH? = null

  private var mOnRecyclerViewItemClick: OnRecyclerViewItemClick<T>? = null

  fun setOnRecyclerViewItemClick(onRecyclerViewItemClick: OnRecyclerViewItemClick<T>) {
    this.mOnRecyclerViewItemClick = onRecyclerViewItemClick
  }

  override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseViewHolder<T, B> {
    val binding: B = DataBindingUtil.inflate(LayoutInflater.from(parent.context)
        , getLayoutItemId(), parent, false)
    return onCreateRecyclerViewHolder(binding, viewType)
  }

  abstract fun getLayoutItemId(): Int

  abstract fun onCreateRecyclerViewHolder(binding: B, viewType: Int): VH

  override fun getItemCount(): Int = mData?.mData.size ?: 0

  override fun onBindViewHolder(holder: BaseViewHolder<T, B>, position: Int) {
    if (holder == null) return
    if (holder is BaseViewHolder) {
      this.mHolder = holder as VH
      if (mData != null && mData?.size!! > position && mData?.get(position) != null) {
        this.mHolder!!.binData(mData!!.get(position), position)
      }
      this.mHolder!!.itemView.setOnClickListener({
        if (mOnRecyclerViewItemClick != null) {
          val position = holder.adapterPosition
          mOnRecyclerViewItemClick?.onClickItem(mData!!.get(position), position)
        }
      })
    }
  }

  fun setData(items: List<T>) {
    mData?.clear()
    if (items != null) {
      mData?.addAll(items)
    }
    notifyDataSetChanged()
  }

  fun getData(): List<T> {
    return mData!!
  }

}
