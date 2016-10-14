package com.innershows.findwhatyoulike.girls_pictures.view;


import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.innershows.findwhatyoulike.R;
import com.innershows.findwhatyoulike.adapter.GirlsImgRecycleAdapter;
import com.innershows.findwhatyoulike.base.BaseRefreshableFragment;
import com.innershows.findwhatyoulike.girls_pictures.presenter.IInnerPresenter;
import com.innershows.findwhatyoulike.girls_pictures.presenter.InnerPresenter;


public class InnerGirlsFragment extends BaseRefreshableFragment implements IInnerView {


    private static final String PARAMS_CID = "cid";
    //    @BindView(R.id.ptr_view)
//    PullToRefreshView ptrView;

    private int cid;

    IInnerPresenter presenter;

    public static InnerGirlsFragment newInstance(int cid) {
        InnerGirlsFragment fragment = new InnerGirlsFragment();
        Bundle args = new Bundle();
        args.putInt(PARAMS_CID, cid);
        fragment.setArguments(args);

        

        return fragment;
    }


    @Override
    public RecyclerView.LayoutManager setLayoutManager() {
        return new GridLayoutManager(getContext(), 2);
    }

    @Override
    public void init(Bundle bundle) {
        mAdapter = new GirlsImgRecycleAdapter(null, getContext());
        presenter = new InnerPresenter(this);
        cid = bundle.getInt(PARAMS_CID);
    }

    @Override
    public int loadView() {
        return R.layout.refresh_layout;
    }

    @Override
    public void initData() {
        pagerOffset = 1;
        presenter.doLoading(cid, pagerOffset, mAdapter);
    }


    @Override
    public void loadMore() {
        presenter.doLoading(cid, ++pagerOffset, mAdapter);
    }

    @Override
    public void onItemClick(View v, int position) {
        //Recycle 里面的Item的点击事件
        Intent intent = new Intent(getContext(), ShowBigImgActivity.class);
        intent.putExtra("position", position);
        intent.putExtra("data", mAdapter.getData());
        startActivity(intent);
    }
}
