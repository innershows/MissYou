package com.innershows.findwhatyoulike.http;

import retrofit2.http.GET;
import retrofit2.http.Query;
import rx.Observable;

/**
 * Created by innershows on 16/8/10.
 *
 * @author innershows
 * @date 16/8/10
 * @e_mail innershow@gmail.com
 */
public interface API {
    //图片栏目
    @GET("dbgroup/show.htm")
    Observable<String> typedGirls(
            @Query("cid") int cid,
            @Query("pager_offset") int pagerOffset);

    //视频栏目
    @GET("dbgroup/videos.htm")
    Observable<String> videoGirls(@Query("pager_offset") int pagerOffset);


    //约炮栏目
    @GET("dbgroup/topics.htm")
    Observable<String> ypGroup(@Query("pager_offset") int pagerOffset);



    //约炮栏目
    @GET("dbgroup/rank.htm")
    Observable<String> fancyGirls(@Query("pager_offset") int pagerOffset);

}

