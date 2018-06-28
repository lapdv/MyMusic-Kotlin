package com.framgia.lapdv.mymusic.utils

import com.framgia.lapdv.mymusic.BuildConfig

/**
 * Created by lap on 28/06/2018.
 */
object ConfigApi {

  var BASE_URL = "https://api-v2.soundcloud.com/charts"
  var BASE_URL_SEARCH = "http://api.soundcloud.com/tracks"
  var GET_KIND_TOP = "?kind=top"
  var GET_FILLTER = "?filter=public"
  var CONFIG_CLIENT_ID = "&client_id="
  var LIMIT_DEFAULT = "&limit=20"
  var CONFIG_PARAM_SEARCH = "&q="
  var STREAM = "/stream"
  var CLIENT_ID = "?client_id="
  var DOWNLOAD = "download/"
  val API_ALL_MUSIC = "all-music"

  fun getUrl(genres: String, limit: String, offset: String): String {
    val stringBuilder = StringBuilder(BASE_URL)
        .append(GET_KIND_TOP)
        .append("&genre=soundcloud:genres:")
        .append(genres)
        .append("&client_id=")
        .append(BuildConfig.API_KEY)
        .append("&limit=")
        .append(limit)
        .append("&offset=")
        .append(offset)
    return stringBuilder.toString()
  }
}