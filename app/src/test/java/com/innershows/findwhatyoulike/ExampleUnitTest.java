package com.innershows.findwhatyoulike;

import com.innershows.findwhatyoulike.girls_yp.model.YP;
import com.innershows.findwhatyoulike.http.HtmlParser;
import com.innershows.findwhatyoulike.http.RetrofitUtils;

import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;

/**
 * To work on unit tests, switch the Test Artifact in the Build Variants view.
 */
public class ExampleUnitTest {


    @Test
    public void addition_isCorrect() throws Exception {
        assertEquals(4, 2 + 2);
    }

//    @Test
//    public void test() throws Exception {
//
//        RetrofitUtils
//                .getAPI()
//                .videoGirls(1)
//                //在订阅在子线程发生的事
//                //.subscribeOn(Schedulers.newThread())
//                //一个人在主线程偷偷观察
//                //.observeOn(AndroidSchedulers.mainThread())
//                .subscribe(s -> {
//                    List<VideoFuli> videoFulis = HtmlParser.handleVideoResponse(s);
//                    System.out.println("===>" + videoFulis);
//
//
//                    for (int i = 0; i < videoFulis.size(); i++) {
//                        String linkUrl = videoFulis.get(i).getLinkUrl();
//                        System.out.println("=======>" + linkUrl);
//
//                        Uri parse = Uri.parse(linkUrl);
//                        String scid = parse.getQueryParameter("scid");
//                        System.out.println("====>http://wsqncdn.miaopai.com/stream/" + scid + "__.mp4");
//
//                    }
//
//                });
//    }

    @Test
    public void test1() throws Exception {

        RetrofitUtils
                .getAPI()
                .ypGroup(1)
                //在订阅在子线程发生的事
//                .subscribeOn(Schedulers.newThread())
//                //一个人在主线程偷偷观察
//                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(s -> {
                    List<YP> yps = HtmlParser.handleYPResponse(s);
                    System.out.println("====>"+yps);

                });
    }
}