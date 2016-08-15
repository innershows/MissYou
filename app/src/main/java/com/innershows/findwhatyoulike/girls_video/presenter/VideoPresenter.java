package com.innershows.findwhatyoulike.girls_video.presenter;

import android.widget.Toast;

import com.innershows.findwhatyoulike.MyApp;
import com.innershows.findwhatyoulike.adapter.BaseRecycleAdapter;
import com.innershows.findwhatyoulike.girls_video.model.VideoFuli;
import com.innershows.findwhatyoulike.girls_video.view.IVideoView;
import com.innershows.findwhatyoulike.http.HtmlParser;
import com.innershows.findwhatyoulike.http.RetrofitUtils;

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
    IVideoView iVideoView;

    public VideoPresenter(IVideoView iVideoView) {
        this.iVideoView = iVideoView;
    }

    @Override
    public void doLoading(final int pagerOffset, final BaseRecycleAdapter adapter) {

        RetrofitUtils.getAPI()
                .videoGirls(pagerOffset)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.newThread())
                .onErrorReturn(throwable -> "发生错误了")
                .doOnError(throwable1 ->
                        Toast.makeText(MyApp.getApp(), "请求失败", Toast.LENGTH_SHORT).show()
                )
                .subscribe(s -> {
                    if (pagerOffset == 1) {
                        adapter.clear();
                    }
                    List<VideoFuli> videoFulis = HtmlParser.handleVideoResponse(s);
                    adapter.addData(videoFulis);
                    iVideoView.loadFinished();
                });
    }
}
