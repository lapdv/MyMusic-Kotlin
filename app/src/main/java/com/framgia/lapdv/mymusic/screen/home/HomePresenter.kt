package com.framgia.lapdv.mymusic.screen.home

import com.framgia.lapdv.mymusic.base.mvp.BasePresenter
import com.framgia.lapdv.mymusic.data.model.Song
import com.framgia.lapdv.mymusic.data.source.remote.OnFetchDataListener
import com.framgia.lapdv.mymusic.data.source.remote.SongRemoteDataSource
import com.framgia.lapdv.mymusic.data.source.remote.SongRepository

/**
 * Created by lap on 28/06/2018.
 */
class HomePresenter : BasePresenter<HomeContract.View>(),
    HomeContract.Presenter, OnFetchDataListener<Song> {


  private var mSongRepository: SongRepository? = null

  init {
    mSongRepository = SongRepository(SongRemoteDataSource())
  }

  override fun getSongs() {
    mSongRepository?.getSongsRemote(this)
  }

  override fun onFetchDataSuccess(data: List<Song>) {
    getView().getSongsSuccess(data!!)
  }

  override fun onFetchDataFailure(error: String) {
    getView().getSongsFailure(error)
  }
}