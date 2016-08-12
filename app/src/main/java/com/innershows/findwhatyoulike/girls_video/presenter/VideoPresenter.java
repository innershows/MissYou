package com.innershows.findwhatyoulike.girls_video.presenter;

import android.widget.Toast;

import com.innershows.findwhatyoulike.MyApp;
import com.innershows.findwhatyoulike.adapter.BaseRecycleAdapter;
import com.innershows.findwhatyoulike.girls_pictures.model.ImageFuli;
import com.innershows.findwhatyoulike.girls_pictures.view.IInnerView;
import com.innershows.findwhatyoulike.http.HtmlParser;
import com.innershows.findwhatyoulike.http.RetrofitUtils;

import java.util.List;

import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action1;
import rx.functions.Func1;
import rx.schedulers.Schedulers;

/**
 * Created by innershows on 16/8/11.
 *
 * @author innershows
 * @date 16/8/11
 * @e_mail innershow@gmail.com
 */
public class VideoPresenter implements IVideoPresenter {
    IInnerView iInnerView;
    //List<ImageFuli> imageFulis;

    public VideoPresenter(IInnerView iInnerView) {
        this.iInnerView = iInnerView;
    }

    @Override
    public void doLoading(final int pagerOffset, final BaseRecycleAdapter adapter) {

        RetrofitUtils.getAPI()
                .videoGirls(pagerOffset)
                .observeOn(AndroidSchedulers.mainThread())
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
                        if (pagerOffset == 1) {
                            adapter.clear();
                        }
                        List<ImageFuli> imageFulis = HtmlParser.handleVideoResponse(s);
                        adapter.addData(imageFulis);
                        iInnerView.loadFinished();
                    }
                });
    }
}
