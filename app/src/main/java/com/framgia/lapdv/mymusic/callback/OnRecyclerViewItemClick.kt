package com.framgia.lapdv.mymusic.callback

interface OnRecyclerViewItemClick<T> {
    fun onClickItem(t: T, position: Int)
}