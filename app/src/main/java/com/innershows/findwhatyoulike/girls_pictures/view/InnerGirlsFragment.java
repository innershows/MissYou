package com.innershows.findwhatyoulike.girls_pictures.view;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.innershows.findwhatyoulike.MyApp;
import com.innershows.findwhatyoulike.R;
import com.innershows.findwhatyoulike.adapter.RecycleAdapter;
import com.innershows.findwhatyoulike.girls_pictures.model.ImageFuli;
import com.innershows.findwhatyoulike.http.HtmlParser;
import com.innershows.findwhatyoulike.http.RetrofitUtils;
import com.innershows.findwhatyoulike.utils.SpacesItemDecoration;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import rx.Observable;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action1;
import rx.functions.Func1;
import rx.schedulers.Schedulers;

public class InnerGirlsFragment extends Fragment {

    private final List<ImageFuli> mImageFuli = new ArrayList<>();

    private static final String PARAMS_CID = "cid";
    @BindView(R.id.recycle_view)
    RecyclerView recycleView;

    private int cid;
    private int pageOffset = 1;

    private RecycleAdapter mAdapter;


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

        mAdapter = new RecycleAdapter(mImageFuli, getContext());
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
        recycleView.setLayoutManager(new GridLayoutManager(getContext() , 2));

        SpacesItemDecoration decoration = new SpacesItemDecoration(40);
        recycleView.addItemDecoration(decoration);

        recycleView.setAdapter(mAdapter);


        loadData();

    }

    private void loadData() {
        Observable<String> observable;
//        if (cid == 0) {
//            observable = RetrofitUtils.getAPI()
//                    .allGirls(pageOffset);
//
//
//        } else {
        System.out.println("==cid==>" + cid);
        observable = RetrofitUtils.getAPI()
                .typedGirls(cid, pageOffset);
        //}

//        observable = RetrofitUtils.getAPI()
//                .test();

        observable.observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.newThread())
                .onErrorReturn(new Func1<Throwable, String>() {
                    @Override
                    public String call(Throwable throwable) {
                        return "错误发生了";
                    }
                })
                .doOnError(new Action1<Throwable>() {
                    @Override
                    public void call(Throwable throwable) {
                        Toast.makeText(MyApp.getApp(), "请求失败", Toast.LENGTH_SHORT).show();
                    }
                })
                .subscribe(new Action1<String>() {
                    @Override
                    public void call(String s) {
                        List<ImageFuli> imageFulis = HtmlParser.handleResponse(s);
                        InnerGirlsFragment.this.mImageFuli.addAll(imageFulis);
                        mAdapter.notifyDataSetChanged();
                    }
                });
    }
}
