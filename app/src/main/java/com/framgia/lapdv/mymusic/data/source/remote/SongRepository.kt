package com.framgia.lapdv.mymusic.data.source.remote

import com.framgia.lapdv.mymusic.data.model.Song

/**
 * Created by lap on 28/06/2018.
 */
class SongRepository : SongDataSource.RemoteDataSource {

  private var mRemoteDataSource: SongDataSource.RemoteDataSource? = null

  constructor(remoteDataSource: SongDataSource.RemoteDataSource) {
    mRemoteDataSource = remoteDataSource
  }

  override fun getSongsRemote(listener: OnFetchDataListener<Song>) {
    mRemoteDataSource?.getSongsRemote(listener)
  }
}
