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
    /**
     * "http://www.dbmeinv.com/dbgroup/show.htm?pager_offset=";
     * "http://www.dbmeinv.com/dbgroup/show.htm?cid=2&pager_offset=";
     * "http://www.dbmeinv.com/dbgroup/show.htm?cid=6&pager_offset=";
     * "http://www.dbmeinv.com/dbgroup/show.htm?cid=7&pager_offset=";
     * "http://www.dbmeinv.com/dbgroup/show.htm?cid=3&pager_offset=";
     * "http://www.dbmeinv.com/dbgroup/show.htm?cid=4&pager_offset=";
     */
    @GET("dbgroup/show.htm")
    Observable<String> allGirls(
            @Query("pager_offset") int pageOffset);

    @GET("dbgroup/show.htm")
    Observable<String> typedGirls(
            @Query("cid") int cid,
            @Query("pager_offset") int pagerOffset);

    @GET("dbgroup/show.htm?cid=6&pager_offset=2")
    Observable<String> test(
    );

    @GET("dbgroup/videos.htm?pager_offset=2")
    Observable<String> videoGirls(@Query("pager_offset") int pagerOffset);


}
