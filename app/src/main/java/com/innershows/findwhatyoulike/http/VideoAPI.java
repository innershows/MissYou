package com.innershows.findwhatyoulike.http;

import retrofit2.http.GET;
import retrofit2.http.Path;
import rx.Observable;

/**
 * Created by innershows on 16/8/12.
 *
 * @author innershows
 * @date 16/8/12
 * @e_mail innershow@gmail.com
 */
public interface VideoAPI {

    @GET("dbgroup/{id}")
    Observable<String> videoGirls(@Path("id") String id);
}
