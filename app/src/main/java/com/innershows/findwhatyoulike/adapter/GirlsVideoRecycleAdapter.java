package com.innershows.findwhatyoulike.adapter;

import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.innershows.findwhatyoulike.R;
import com.innershows.findwhatyoulike.adapter.viewholder.ItemVideoViewHolder;
import com.innershows.findwhatyoulike.girls_video.model.VideoFuli;
import com.squareup.picasso.Picasso;

import java.util.List;

import static fm.jiecao.jcvideoplayer_lib.JCVideoPlayer.SCREEN_LAYOUT_LIST;

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
                .load(videoFuli.getCover_pic())
                .into(holder.jcVideoPlayerStandard.thumbImageView);

        holder.jcVideoPlayerStandard.setTag(videoFuli);


        holder.jcVideoPlayerStandard.setUp("",
                SCREEN_LAYOUT_LIST,
                videoFuli.getCaption()
        );

        if (TextUtils.isEmpty(videoFuli.getVideoUrl())) {
            holder.jcVideoPlayerStandard.onClick(holder.jcVideoPlayerStandard.startButton);
        }
//
//        holder.jcVideoPlayerStandard.setUp(
//                "http://mvvideo5.meitudata.com/57fdd8fa9a7d23528.mp4"
//                , JCVideoPlayerStandard.SCREEN_LAYOUT_LIST,
//                videoFuli.getCaption());
    }

}
