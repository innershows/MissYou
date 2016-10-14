package com.innershows.findwhatyoulike.base;

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
import com.innershows.findwhatyoulike.adapter.BaseRecycleAdapter;
import com.innershows.findwhatyoulike.adapter.GirlsImgRecycleAdapter;
import com.innershows.findwhatyoulike.utils.UITools;
import com.innershows.findwhatyoulike.utils.view.OnLoadMoreListener;
import com.innershows.findwhatyoulike.utils.view.SpacesItemDecoration;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by innershows on 16/8/12.
 *
 * @author innershows
 * @date 16/8/12
 * @e_mail innershow@gmail.com
 */
public abstract class BaseRefreshableFragment extends Fragment implements SwipeRefreshLayout.OnRefreshListener, OnLoadMoreListener, GirlsImgRecycleAdapter.OnItemClickListener {
    @BindView(R.id.recycle_view)
    protected RecyclerView recycleView;
    @BindView(R.id.sr_layout)
    protected SwipeRefreshLayout srLayout;

    protected int pagerOffset = 1;
    protected BaseRecycleAdapter mAdapter;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        init(getArguments());
    }

    public abstract void init(Bundle bundle);

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(loadView(), container, false);
        ButterKnife.bind(this, view);
        return view;
    }

    public abstract int loadView();

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        recycleView.setLayoutManager(setLayoutManager());

        SpacesItemDecoration decoration = new SpacesItemDecoration(setDecoration());

        srLayout.setOnRefreshListener(this);
        recycleView.addItemDecoration(decoration);

        recycleView.setAdapter(mAdapter);

        //   ptrView.setOnRefreshListener(this);
        UITools.setRecycleViewArrivedBottomListener(recycleView, this);


        mAdapter.setOnItemClickListener(this);

        if (mAdapter.getItemCount() == 0) {
            //开始加载数据
            initData();
            srLayout.postDelayed(() -> {
                if (!srLayout.isRefreshing()) {
                    srLayout.setRefreshing(true);
                }
            }, 200);
        }
    }

    public RecyclerView.LayoutManager setLayoutManager() {
        return new LinearLayoutManager(getContext());
    }

    public int setDecoration() {
        return 40;
    }

    public abstract void initData();


    public void loadFinished() {
        srLayout.postDelayed(() -> {
            if (srLayout.isRefreshing()) {
                srLayout.setRefreshing(false);
            }
        }, 200);
    }

    @Override
    public void onRefresh() {
        initData();
    }

    public void doRefresh() {
        srLayout.postDelayed(() -> {
            if (!srLayout.isRefreshing()) {
                srLayout.setRefreshing(true);
            }
        }, 200);

        initData();
    }

    @Override
    public abstract void loadMore();

    @Override
    public abstract void onItemClick(View v, int position);

}
