package com.innershows.findwhatyoulike.adapter.viewholder;

import android.support.v7.widget.CardView;
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
public class ItemImageViewHolder extends BaseItemViewHolder {

    public final TextView textView;
    public CardView cardView;
    public ImageView imageView;

    public ItemImageViewHolder(View itemView, GirlsImgRecycleAdapter.OnItemClickListener listener) {
        super(itemView, listener);
        cardView = (CardView) itemView.findViewById(R.id.card_view);
        imageView = (ImageView) itemView.findViewById(R.id.iv);
        textView = (TextView) itemView.findViewById(R.id.tv);
    }

}
