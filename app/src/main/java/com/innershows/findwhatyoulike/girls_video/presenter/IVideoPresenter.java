package com.innershows.findwhatyoulike.girls_video.presenter;

import com.innershows.findwhatyoulike.adapter.BaseRecycleAdapter;

/**
 * Created by innershows on 16/8/11.
 *
 * @author innershows
 * @date 16/8/11
 * @e_mail innershow@gmail.com
 */
public interface IVideoPresenter {
    void doLoading(int pagerOffset, BaseRecycleAdapter adapter);
}
