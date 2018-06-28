package com.framgia.lapdv.mymusic.screen.home.adapter

import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.bumptech.glide.request.RequestOptions
import com.framgia.lapdv.mymusic.R
import com.framgia.lapdv.mymusic.base.adapter.BaseRecyclerAdapter
import com.framgia.lapdv.mymusic.base.adapter.BaseViewHolder
import com.framgia.lapdv.mymusic.data.model.Song
import com.framgia.lapdv.mymusic.databinding.ItemSongBinding

/**
 * Created by lap on 28/06/2018.
 */
class SongAdapter : BaseRecyclerAdapter<Song, SongAdapter.SongViewHolder, ItemSongBinding>() {

  override fun getLayoutItemId(): Int = R.layout.item_song

  override fun onCreateRecyclerViewHolder(binding: ItemSongBinding, viewType: Int): SongViewHolder {
    return SongViewHolder(binding)
  }

  class SongViewHolder(binding: ItemSongBinding) : BaseViewHolder<Song, ItemSongBinding>(
      binding) {

    override fun binData(data: Song, position: Int) {
      mBinding?.apply {
        textSongTitle.text = data.mTitle
        textSongUser.text = data.mUsername
      }
      Glide.with(getContext()).load(data.mArtworkUrl)
          .apply(RequestOptions().error(R.drawable.ic_launcher_background)
              .diskCacheStrategy(DiskCacheStrategy.ALL))
          .into(mBinding?.imageSong)
    }
  }
}
