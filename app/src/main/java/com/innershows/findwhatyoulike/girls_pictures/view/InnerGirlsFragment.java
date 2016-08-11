package com.innershows.findwhatyoulike.girls_pictures.view;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.innershows.findwhatyoulike.R;
import com.innershows.findwhatyoulike.adapter.RecycleAdapter;
import com.innershows.findwhatyoulike.girls_pictures.presenter.IInnerPresenter;
import com.innershows.findwhatyoulike.girls_pictures.presenter.InnerPresenter;
import com.innershows.findwhatyoulike.utils.OnLoadMoreListener;
import com.innershows.findwhatyoulike.utils.SpacesItemDecoration;
import com.innershows.findwhatyoulike.utils.UITools;

import butterknife.BindView;
import butterknife.ButterKnife;


public class InnerGirlsFragment extends Fragment implements IInnerView, SwipeRefreshLayout.OnRefreshListener, OnLoadMoreListener {


    private static final String PARAMS_CID = "cid";
    @BindView(R.id.recycle_view)
    RecyclerView recycleView;
    @BindView(R.id.sr_layout)
    SwipeRefreshLayout srLayout;
//    @BindView(R.id.ptr_view)
//    PullToRefreshView ptrView;

    private int cid;
    private int pageOffset = 1;

    private RecycleAdapter mAdapter;

    IInnerPresenter presenter;

    public static InnerGirlsFragment newInstance(int cid) {
        InnerGirlsFragment fragment = new InnerGirlsFragment();
        Bundle args = new Bundle();
        args.putInt(PARAMS_CID, cid);

        fragment.setArguments(args);

        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            cid = getArguments().getInt(PARAMS_CID);
        }
        presenter = new InnerPresenter(this);
        mAdapter = new RecycleAdapter(null, getContext());
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_girls, container, false);
        ButterKnife.bind(this, view);
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        //recycleView.setLayoutManager(new StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL));
        recycleView.setLayoutManager(new GridLayoutManager(getContext(), 2));

//        ptrView.
        SpacesItemDecoration decoration = new SpacesItemDecoration(40);

//        recycleView.setOnRefreshListener(this);
//        recycleView.setPagingableListener(this);
//
        srLayout.setOnRefreshListener(this);
        recycleView.addItemDecoration(decoration);
        recycleView.setAdapter(mAdapter);

        //   ptrView.setOnRefreshListener(this);
        UITools.setRecycleViewArrivedBottomListener(recycleView, this);

        if (mAdapter.getItemCount() == 0) {
            //开始加载数据
            presenter.doLoading(cid, pageOffset, mAdapter);
            srLayout.postDelayed(new Runnable() {
                @Override
                public void run() {
                    if (!srLayout.isRefreshing()) {
                        srLayout.setRefreshing(true);
                    }
                }
            }, 500);
        }
    }

    @Override
    public void loadFinished() {
        srLayout.setRefreshing(false);
    }

    @Override
    public void onRefresh() {
        pageOffset = 1;
        presenter.doLoading(cid, pageOffset, mAdapter);
    }


    @Override
    public void loadMore() {
        presenter.doLoading(cid, ++pageOffset, mAdapter);

    }
}
