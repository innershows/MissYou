package com.innershows.findwhatyoulike.adapter.viewholder;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.innershows.findwhatyoulike.R;
import com.innershows.findwhatyoulike.adapter.GirlsImgRecycleAdapter;

/**
 * Created by innershows on 16/8/10.
 *
 * @author innershows
 * @date 16/8/10
 * @e_mail innershow@gmail.com
 */
public class ItemYPHolder extends BaseItemViewHolder {

    public TextView tvGroupName, tvNickname, tvDate, tvTitle;
    public ImageView imageView;

    public ItemYPHolder(View itemView, GirlsImgRecycleAdapter.OnItemClickListener listener) {
        super(itemView, listener);
        imageView = (ImageView) itemView.findViewById(R.id.yp_item_iv);
        tvTitle = (TextView) itemView.findViewById(R.id.yp_tv_title);
        tvGroupName = (TextView) itemView.findViewById(R.id.yp_tv_group_name);
        tvNickname = (TextView) itemView.findViewById(R.id.yp_nickname);
        tvDate = (TextView) itemView.findViewById(R.id.yp_tv_date);
    }

}
