package com.framgia.lapdv.mymusic.screen.home

import android.support.v7.widget.GridLayoutManager
import android.widget.Toast
import com.framgia.lapdv.mymusic.R
import com.framgia.lapdv.mymusic.base.BaseFragment
import com.framgia.lapdv.mymusic.data.model.Song
import com.framgia.lapdv.mymusic.databinding.FragmentHomeBinding
import com.framgia.lapdv.mymusic.screen.home.adapter.SongAdapter
import com.framgia.lapdv.mymusic.utils.Constant

/**
 * Created by lap on 28/06/2018.
 */
class HomeFragment : BaseFragment<FragmentHomeBinding>(), HomeContract.View {

  private var mPresenter: HomeContract.Presenter? = null

  override fun getLayoutId(): Int = R.layout.fragment_home

  override fun initView() {
    mBinding?.recyclerviewSong?.layoutManager = GridLayoutManager(getBaseActivity(), Constant.SPAN_COUNT_ONE)
    super.initView()
  }

  override fun initData() {
    mPresenter = HomePresenter()
    mPresenter?.onActtach(this)
    mPresenter?.getSongs()
  }

  override fun getSongsSuccess(songs: List<Song>) {
    setUpAdapter(songs)
  }

  private fun setUpAdapter(songs: List<Song>) {
    val songAdapter = SongAdapter()
    songAdapter.setData(songs)
    mBinding?.recyclerviewSong?.adapter = songAdapter
  }

  override fun getSongsFailure(messages: String) {
    Toast.makeText(getBaseActivity(), "Error $messages", Toast.LENGTH_SHORT)
  }
}
