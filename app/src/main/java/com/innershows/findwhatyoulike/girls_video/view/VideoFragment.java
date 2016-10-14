package com.innershows.findwhatyoulike.girls_video.view;


import android.os.Bundle;
import android.view.View;

import com.innershows.findwhatyoulike.R;
import com.innershows.findwhatyoulike.adapter.GirlsVideoRecycleAdapter;
import com.innershows.findwhatyoulike.base.BaseRefreshableFragment;
import com.innershows.findwhatyoulike.girls_video.presenter.IVideoPresenter;
import com.innershows.findwhatyoulike.girls_video.presenter.VideoPresenter;

import fm.jiecao.jcvideoplayer_lib.JCVideoPlayer;

public class VideoFragment extends BaseRefreshableFragment implements IVideoView {


    IVideoPresenter presenter;

    public static VideoFragment newInstance() {
        VideoFragment fragment = new VideoFragment();
        return fragment;
    }

    @Override
    public void init(Bundle bundle) {
        presenter = new VideoPresenter(this);

        if (mAdapter == null) {
            mAdapter = new GirlsVideoRecycleAdapter(null, getContext());
        }
    }

    @Override
    public int loadView() {
        return R.layout.refresh_layout;
    }

    @Override
    public void initData() {
        presenter.doLoading(pagerOffset, mAdapter);
        srLayout.postDelayed(() -> {
            if (!srLayout.isRefreshing()) {
                srLayout.setRefreshing(true);
            }
        }, 200);
    }

    @Override
    public void onPause() {
        super.onPause();
        JCVideoPlayer.releaseAllVideos();

    }

    @Override
    public void onRefresh() {
        pagerOffset = 1;
        presenter.doLoading(pagerOffset, mAdapter);
    }

    @Override
    public void loadMore() {
        presenter.doLoading(++pagerOffset, mAdapter);
    }

    @Override
    public void onItemClick(View v, int position) {
    }
}
