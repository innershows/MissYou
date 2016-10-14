package com.innershows.findwhatyoulike.girls_video.view;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.widget.Toast;

import com.innershows.findwhatyoulike.MyApp;
import com.innershows.findwhatyoulike.girls_video.model.VideoFuli;
import com.innershows.findwhatyoulike.http.HtmlParser;
import com.innershows.findwhatyoulike.http.RetrofitUtils;

import fm.jiecao.jcvideoplayer_lib.JCVideoPlayerStandard;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by innershows on 16/10/12.
 *
 * @author innershows
 * @date 16/10/12
 * @e_mail innershow@gmail.com
 */

public class MyVideoPlayer extends JCVideoPlayerStandard {

    private VideoFuli videoFuli;
    boolean isLoading = false;

    public MyVideoPlayer(Context context) {
        super(context);
    }

    public MyVideoPlayer(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    public void setTag(Object tag) {
        super.setTag(tag);
        videoFuli = (VideoFuli) tag;
    }


    @Override
    public void onClick(View v) {
        int i = v.getId();


        if (i == fm.jiecao.jcvideoplayer_lib.R.id.start && TextUtils.isEmpty(videoFuli.getVideoUrl())) {
            //处理图片为空的情况:
            //TODO 处理等待,下载完成之后才下载
            if (isLoading) {
                //正在下载中
                return;
            }
            isLoading = true;
            //Toast.makeText(getContext(), "视频地址获取中...", Toast.LENGTH_SHORT).show();

            loadingProgressBar.setVisibility(VISIBLE);
            startButton.setVisibility(INVISIBLE);
            RetrofitUtils
                    .getVideoDetailApi()
                    .videoDetail(videoFuli.getId())
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribeOn(Schedulers.newThread())
                    .onErrorReturn(Throwable::getMessage)
                    .doOnError(throwable -> Toast.makeText(MyApp.getApp(), "请求失败", Toast.LENGTH_SHORT).show())
                    .onErrorReturn(throwable -> "发生错误了" + throwable.toString())
                    .subscribe(s -> {
                        loadingProgressBar.setVisibility(INVISIBLE);
                        startButton.setVisibility(VISIBLE);
                        isLoading = false;

                        String url = HtmlParser.handleVideoDetail(s);
                        videoFuli.setVideoUrl(url);
                        setUp(url,
                                SCREEN_LAYOUT_LIST,
                                videoFuli.getCaption()
                        );
                    });
            return;

        }

        //如果不是url为null的情况,调用父类方法
        super.onClick(v);
    }
}
