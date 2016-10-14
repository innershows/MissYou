package com.innershows.findwhatyoulike.http;

import retrofit2.http.GET;
import retrofit2.http.Query;
import rx.Observable;

/**
 * Created by innershows on 16/8/12.
 *
 * @author innershows
 * @date 16/8/12
 * @e_mail innershow@gmail.com
 */
public interface VideoListAPI {

    @GET("output/channels_topics_timeline.json/")
    //?id=19&count=10&page=1
    Observable<String> videoGirls(@Query("count") int count , @Query("page") int page , @Query("id") int type);
}
