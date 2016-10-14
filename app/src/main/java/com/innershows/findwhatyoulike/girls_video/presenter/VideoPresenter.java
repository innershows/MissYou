package com.innershows.findwhatyoulike.girls_video.presenter;

import android.widget.Toast;

import com.google.gson.Gson;
import com.innershows.findwhatyoulike.MyApp;
import com.innershows.findwhatyoulike.adapter.BaseRecycleAdapter;
import com.innershows.findwhatyoulike.girls_video.model.VideoFuli;
import com.innershows.findwhatyoulike.girls_video.view.IVideoView;
import com.innershows.findwhatyoulike.http.RetrofitUtils;

import java.util.Arrays;
import java.util.List;

import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by innershows on 16/8/11.
 *
 * @author innershows
 * @date 16/8/11
 * @e_mail innershow@gmail.com
 */
public class VideoPresenter implements IVideoPresenter {
    public static final int TYPE = 19;
    public static final int COUNT = 10;
    IVideoView iVideoView;
    private Gson gson = new Gson();

    public VideoPresenter(IVideoView iVideoView) {
        this.iVideoView = iVideoView;
    }

    @Override
    public void doLoading(final int pagerOffset, final BaseRecycleAdapter adapter) {

        RetrofitUtils.getVideoApi()
                .videoGirls(COUNT, pagerOffset, TYPE)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.newThread())
                .onErrorReturn(Throwable::getMessage)
                .onErrorReturn(throwable -> "发生错误了")
                .doOnError(throwable1 ->
                        Toast.makeText(MyApp.getApp(), "请求失败", Toast.LENGTH_SHORT).show()
                )
                .subscribe(s -> {
                    if (pagerOffset == 1) {
                        adapter.clear();
                    }
                    System.out.println("====美拍下载的数据>" + s);
                    List<VideoFuli> videoFulis = Arrays.asList(gson.
                            fromJson(s, VideoFuli[].class));
                    adapter.addData(videoFulis);

                    iVideoView.loadFinished();
                });
    }
}
