package com.innershows.findwhatyoulike.girls_video.view;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.innershows.findwhatyoulike.R;
import com.innershows.findwhatyoulike.adapter.GirlsImgRecycleAdapter;
import com.innershows.findwhatyoulike.adapter.GirlsVideoRecycleAdapter;
import com.innershows.findwhatyoulike.girls_pictures.view.IInnerView;
import com.innershows.findwhatyoulike.girls_video.presenter.IVideoPresenter;
import com.innershows.findwhatyoulike.girls_video.presenter.VideoPresenter;
import com.innershows.findwhatyoulike.utils.UITools;
import com.innershows.findwhatyoulike.utils.view.OnLoadMoreListener;
import com.innershows.findwhatyoulike.utils.view.SpacesItemDecoration;

import butterknife.BindView;
import butterknife.ButterKnife;

public class VideoFragment extends Fragment implements IInnerView, SwipeRefreshLayout.OnRefreshListener, OnLoadMoreListener, GirlsImgRecycleAdapter.OnItemClickListener {


    @BindView(R.id.recycle_view)
    RecyclerView recycleView;
    @BindView(R.id.sr_layout)
    SwipeRefreshLayout srLayout;
    private GirlsVideoRecycleAdapter mAdapter;
    private int pagerOffset = 1;

    IVideoPresenter presenter;

    public static VideoFragment newInstance() {
        VideoFragment fragment = new VideoFragment();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        presenter = new VideoPresenter(this);

        if (mAdapter == null) {

            mAdapter = new GirlsVideoRecycleAdapter(null, getContext());
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_video, container, false);
        ButterKnife.bind(this, view);
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        recycleView.setLayoutManager(new LinearLayoutManager(getContext()));

        SpacesItemDecoration decoration = new SpacesItemDecoration(40);

        srLayout.setOnRefreshListener(this);
        recycleView.addItemDecoration(decoration);
        mAdapter.setOnItemClickListener(this);

        recycleView.setAdapter(mAdapter);

        UITools.setRecycleViewArrivedBottomListener(recycleView, this);

        if (mAdapter.getItemCount() == 0) {
            //开始加载数据
            presenter.doLoading(pagerOffset, mAdapter);
            srLayout.postDelayed(new Runnable() {
                @Override
                public void run() {
                    if (!srLayout.isRefreshing()) {
                        srLayout.setRefreshing(true);
                    }
                }
            }, 200);
        }

    }


    @Override
    public void loadFinished() {
        srLayout.postDelayed(new Runnable() {
            @Override
            public void run() {
                if (srLayout.isRefreshing()) {
                    srLayout.setRefreshing(false);
                }
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
        //Recycle 里面的Item的点击事件
//        Intent intent = new Intent(getContext(), ShowBigImgActivity.class);
//        intent.putExtra("position", position);
//        intent.putExtra("data", mAdapter.getData());
//        startActivity(intent);
    }
}
