package com.innershows.findwhatyoulike.adapter.viewholder;

import android.view.View;

import com.innershows.findwhatyoulike.R;
import com.innershows.findwhatyoulike.adapter.GirlsImgRecycleAdapter;

import fm.jiecao.jcvideoplayer_lib.JCVideoPlayerStandard;

/**
 * Created by innershows on 16/8/11.
 *
 * @author innershows
 * @date 16/8/11
 * @e_mail innershow@gmail.com
 */
public class ItemVideoViewHolder extends BaseItemViewHolder {

    public JCVideoPlayerStandard jcVideoPlayerStandard;

    public ItemVideoViewHolder(View itemView, GirlsImgRecycleAdapter.OnItemClickListener listener) {
        super(itemView, listener);
        jcVideoPlayerStandard = (JCVideoPlayerStandard) itemView.findViewById(R.id.jc_video);
        jcVideoPlayerStandard.titleTextView.setMaxLines(2);
        jcVideoPlayerStandard.titleTextView.setTextColor(0xc8eef1f0);

    }
}
