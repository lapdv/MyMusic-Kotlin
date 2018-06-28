package com.framgia.lapdv.mymusic.base.mvp


interface BaseMvpPresenter<V : BaseView> {

    fun getView(): V

    fun onActtach(view: V)

    fun onDettach()

    fun onStart()

    fun isViewAttached(): Boolean
}
