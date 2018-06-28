package com.framgia.lapdv.mymusic.base.mvp

class BasePresenter<V : BaseView> : BaseMvpPresenter<V> {

    private var mMvpView: V? = null

    override fun getView(): V {
        return mMvpView!!
    }

    override fun onActtach(view: V) {
        this.mMvpView = view
    }

    override fun onDettach() {
        if (mMvpView != null) {
            mMvpView = null
        }
    }

    override fun onStart() {

    }

    override fun isViewAttached(): Boolean {
        return mMvpView != null
    }
}
