package com.framgia.lapdv.mymusic.screen.home

import com.framgia.lapdv.mymusic.base.mvp.BaseMvpPresenter
import com.framgia.lapdv.mymusic.base.mvp.BaseView
import com.framgia.lapdv.mymusic.data.model.Song

/**
 * Created by lap on 28/06/2018.
 */
interface HomeContract {

  /**
   * All the action of home view
   */
  interface View : BaseView {
    fun getSongsSuccess(songs: List<Song>)

    fun getSongsFailure(messages: String)
  }

  /**
   * All the logic of Home screen
   */
  interface Presenter : BaseMvpPresenter<View> {
    fun getSongs()
  }

}
