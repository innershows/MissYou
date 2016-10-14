package com.innershows.findwhatyoulike.utils;

import com.innershows.findwhatyoulike.girls_yp.model.YP;
import com.innershows.findwhatyoulike.http.HtmlParser;
import com.innershows.findwhatyoulike.http.RetrofitUtils;

import java.util.List;

/**
 * Created by innershows on 16/8/10.
 *
 * @author innershows
 * @date 16/8/10
 * @e_mail innershow@gmail.com
 */
public class Test {

    public static void main(String[] args) {
        RetrofitUtils
                .getAPI()
                .ypGroup(1)
                //在订阅在子线程发生的事
//                .subscribeOn(Schedulers.newThread())
//                //一个人在主线程偷偷观察
//                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(s -> {
                    List<YP> yps = HtmlParser.handleYPResponse(s);
                    System.out.println("====>" + yps);

                });
    }
}
