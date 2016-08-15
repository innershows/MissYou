package com.innershows.findwhatyoulike.adapter;

import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.innershows.findwhatyoulike.R;
import com.innershows.findwhatyoulike.adapter.viewholder.ItemVideoViewHolder;
import com.innershows.findwhatyoulike.girls_video.model.VideoFuli;
import com.innershows.findwhatyoulike.http.HtmlParser;
import com.innershows.findwhatyoulike.http.RetrofitUtils;
import com.squareup.picasso.Picasso;

import java.util.List;

import fm.jiecao.jcvideoplayer_lib.JCVideoPlayerStandard;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by innershows on 16/8/11.
 *
 * @author innershows
 * @date 16/8/11
 * @e_mail innershow@gmail.com
 */
public class GirlsVideoRecycleAdapter extends BaseRecycleAdapter<VideoFuli, ItemVideoViewHolder> {


    public GirlsVideoRecycleAdapter(List<VideoFuli> data, Context mContext) {
        super(data, mContext);
    }

    @Override
    public ItemVideoViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(mContext).inflate(R.layout.item_video, parent, false);
        return new ItemVideoViewHolder(view, onItemClickListener);
    }

    @Override
    public void onBindViewHolder(ItemVideoViewHolder holder, int position) {

        VideoFuli videoFuli = data.get(position);

        Picasso.with(mContext)
                .load(videoFuli.getImageUrl())
                .into(holder.jcVideoPlayerStandard.thumbImageView);

        holder.jcVideoPlayerStandard.setTag(videoFuli);


        holder.jcVideoPlayerStandard.setUp(
                videoFuli.getVideoUrl()
                , JCVideoPlayerStandard.SCREEN_LAYOUT_LIST,
                videoFuli.getTitle());

        if (TextUtils.isEmpty(videoFuli.getVideoUrl()) && !videoFuli.isLoading()) {
            videoFuli.setLoading(true);
            holder.jcVideoPlayerStandard.setUp(
                    videoFuli.getVideoUrl()
                    , JCVideoPlayerStandard.SCREEN_LAYOUT_LIST,
                    videoFuli.getTitle());

            loadVideoPath(
                    holder.jcVideoPlayerStandard,
                    videoFuli.getLinkUrl());
        }
    }

    private void loadVideoPath(final JCVideoPlayerStandard jcVideoPlayerStandard, final String path) {

        RetrofitUtils.getVideoApi()
                .videoGirls(path)
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .onErrorReturn(throwable -> "出错了")
                .onErrorReturn(throwable2 -> "返回值")
                .doOnError(throwable1 -> System.out.println("====>下载失败"))
                .subscribe(s -> {
                            Object tag = jcVideoPlayerStandard.getTag();

                            if (tag == null || !(tag instanceof VideoFuli)) {
                                return;
                            }
                            VideoFuli videoFuli = (VideoFuli) tag;

                            if (path.equals(videoFuli.getLinkUrl())) {
                                HtmlParser.handleVideoDetail(s, videoFuli);
                                videoFuli.setLoading(false);

                                String videoUrl = videoFuli.getVideoUrl();

                                jcVideoPlayerStandard.setUp(videoUrl
                                        , JCVideoPlayerStandard.SCREEN_LAYOUT_LIST, videoFuli.getTitle());
                            }

                        }
                );


    }

}
