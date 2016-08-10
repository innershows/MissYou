package com.innershows.findwhatyoulike.http;

import com.innershows.findwhatyoulike.utils.Constants;

import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.converter.scalars.ScalarsConverterFactory;

/**
 * Created by innershows on 16/8/10.
 *
 * @author innershows
 * @date 16/8/10
 * @e_mail innershow@gmail.com
 */
public class RetrofitUtils {
    private static Retrofit retrofit;
    private static API api;

    static {
        retrofit = new Retrofit.Builder().baseUrl(Constants.DOMAIN)
                //用于获取到String类型的数据
                .addConverterFactory(ScalarsConverterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .build();
        //创建一个获取对象
        api = retrofit.create(API.class);
    }

    public static API getAPI() {
        return api;
    }


}
