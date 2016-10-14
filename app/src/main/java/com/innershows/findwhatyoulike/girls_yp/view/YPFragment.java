package com.innershows.findwhatyoulike.girls_yp.view;


import android.os.Bundle;
import android.view.View;

import com.innershows.findwhatyoulike.R;
import com.innershows.findwhatyoulike.adapter.YPRecycleAdapter;
import com.innershows.findwhatyoulike.base.BaseRefreshableFragment;
import com.innershows.findwhatyoulike.girls_yp.presenter.IYPPresenter;
import com.innershows.findwhatyoulike.girls_yp.presenter.YPPresenter;

public class YPFragment extends BaseRefreshableFragment implements IYPView {


    IYPPresenter presenter;

    public static YPFragment newInstance() {
        YPFragment fragment = new YPFragment();
        return fragment;
    }

    @Override
    public void init(Bundle bundle) {
        presenter = new YPPresenter(this);

        if (mAdapter == null) {
            mAdapter = new YPRecycleAdapter(null, getContext());
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
