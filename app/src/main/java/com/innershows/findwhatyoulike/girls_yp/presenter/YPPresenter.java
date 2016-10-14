package com.innershows.findwhatyoulike.girls_yp.presenter;

import android.widget.Toast;

import com.innershows.findwhatyoulike.MyApp;
import com.innershows.findwhatyoulike.adapter.BaseRecycleAdapter;
import com.innershows.findwhatyoulike.girls_yp.model.YP;
import com.innershows.findwhatyoulike.girls_yp.view.IYPView;
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
public class YPPresenter implements IYPPresenter {
    IYPView IYPView;

    public YPPresenter(IYPView IYPView) {
        this.IYPView = IYPView;
    }

    @Override
    public void doLoading(final int pagerOffset, final BaseRecycleAdapter adapter) {

        RetrofitUtils
                .getAPI()
                .ypGroup(pagerOffset)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.newThread())
                .onErrorReturn(Throwable::getMessage)
                .doOnError(throwable1 ->
                        Toast.makeText(MyApp.getApp(), "请求失败", Toast.LENGTH_SHORT).show()
                )
                .subscribe(s -> {
                    if (pagerOffset == 1) {
                        adapter.clear();
                    }
                    List<YP> yps = HtmlParser.handleYPResponse(s);
                    adapter.addData(yps);
                    IYPView.loadFinished();
                });
    }
}
