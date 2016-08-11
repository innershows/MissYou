package com.innershows.findwhatyoulike.girls_pictures.presenter;

import android.widget.Toast;

import com.innershows.findwhatyoulike.MyApp;
import com.innershows.findwhatyoulike.adapter.RecycleAdapter;
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
public class InnerPresenter implements IInnerPresenter {
    IInnerView iInnerView;
    //List<ImageFuli> imageFulis;

    public InnerPresenter(IInnerView iInnerView) {
        this.iInnerView = iInnerView;
    }

    @Override
    public void doLoading(int cid, final int pagerOffset, final RecycleAdapter adapter) {

        RetrofitUtils.getAPI()
                .typedGirls(cid, pagerOffset)
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

                        List<ImageFuli> imageFulis = HtmlParser.handleResponse(s);
                        adapter.addData(imageFulis);
                        iInnerView.loadFinished();
                    }
                });
    }
}
