package com.framgia.lapdv.mymusic.data.source.remote

/**
 * Created by lap on 28/06/2018.
 */
interface OnFetchDataListener<T> {
  /**
   * @param data
   * fetch data success
   */
  fun onFetchDataSuccess(data: List<T>)

  /**
   * @param error
   * fetch data error
   */
  fun onFetchDataFailure(error: String)

}