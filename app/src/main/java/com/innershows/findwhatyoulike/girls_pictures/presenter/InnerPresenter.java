package com.innershows.findwhatyoulike.girls_pictures.presenter;

import android.widget.Toast;

import com.innershows.findwhatyoulike.MyApp;
import com.innershows.findwhatyoulike.adapter.BaseRecycleAdapter;
import com.innershows.findwhatyoulike.girls_pictures.model.ImageFuli;
import com.innershows.findwhatyoulike.girls_pictures.view.IInnerView;
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
public class InnerPresenter implements IInnerPresenter {
    IInnerView iInnerView;
    //List<ImageFuli> imageFulis;

    public InnerPresenter(IInnerView iInnerView) {
        this.iInnerView = iInnerView;
    }

    @Override
    public void doLoading(int cid, final int pagerOffset, final BaseRecycleAdapter adapter) {


        if (cid != -1) {
            RetrofitUtils.getAPI()
                    .typedGirls(cid, pagerOffset)
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribeOn(Schedulers.newThread())
                    .onErrorReturn(Throwable::getMessage)
                    .onErrorReturn(throwable -> "发生错误了")
                    .doOnError(throwable ->
                            Toast.makeText(MyApp.getApp(), "请求失败", Toast.LENGTH_SHORT).show()
                    )
                    .subscribe(s -> {
                        if (pagerOffset == 1) {
                            adapter.clear();
                        }

                        List<ImageFuli> imageFulis = HtmlParser.handleImageResponse(s);
                        adapter.addData(imageFulis);
                        iInnerView.loadFinished();
                    });
        } else {
            RetrofitUtils.getAPI()
                    .fancyGirls(pagerOffset)
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribeOn(Schedulers.newThread())
                    .onErrorReturn(throwable -> "发生错误了")
                    .doOnError(throwable ->
                            Toast.makeText(MyApp.getApp(), "请求失败", Toast.LENGTH_SHORT).show()
                    )
                    .subscribe(s -> {
                        if (pagerOffset == 1) {
                            adapter.clear();
                        }

                        List<ImageFuli> imageFulis = HtmlParser.handleImageResponse(s);
                        adapter.addData(imageFulis);
                        iInnerView.loadFinished();
                    });
        }
    }


}
