package com.innershows.findwhatyoulike.girls_pictures.presenter;

import com.innershows.findwhatyoulike.adapter.BaseRecycleAdapter;

/**
 * Created by innershows on 16/8/10.
 *
 * @author innershows
 * @date 16/8/10
 * @e_mail innershow@gmail.com
 */
public interface IInnerPresenter {
    void doLoading(int cid, int pagerOffset, BaseRecycleAdapter adapter);
}
