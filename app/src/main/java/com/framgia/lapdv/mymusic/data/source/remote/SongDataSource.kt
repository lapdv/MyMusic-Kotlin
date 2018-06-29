package com.framgia.lapdv.mymusic.data.source.remote

import com.framgia.lapdv.mymusic.data.model.Song

/**
 * Created by lap on 28/06/2018.
 */
interface SongDataSource {

  interface RemoteDataSource {
    fun getSongsRemote(listener: OnFetchDataListener<Song>)
  }
}