package com.framgia.lapdv.mymusic.data.source.remote

import com.framgia.lapdv.mymusic.data.model.Song
import com.framgia.lapdv.mymusic.utils.ConfigApi

/**
 * Created by lap on 28/06/2018.
 */
class SongRemoteDataSource : SongDataSource.RemoteDataSource {

  override fun getSongsRemote(listener: OnFetchDataListener<Song>) {
    //TODO call api get song
    callApiGetListSong(listener)
  }

  private fun callApiGetListSong(
      listener: OnFetchDataListener<Song>) {
    var songs: MutableList<Song> = mutableListOf()
    for (i in 1..10) {
      var song = Song()
      song.mTitle = "Ten bai hat $i"
      song.mUsername = "lapdv $i"
      song.mArtworkUrl = "https://i1.sndcdn.com/artworks-000352463436-depnj5-large.jpg"
      songs.add(song)
    }
    listener.onFetchDataSuccess(songs)
  }

}
