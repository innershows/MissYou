package com.innershows.findwhatyoulike.adapter;

import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;

import com.innershows.findwhatyoulike.R;

/**
 * Created by innershows on 16/8/10.
 *
 * @author innershows
 * @date 16/8/10
 * @e_mail innershow@gmail.com
 */
public class ItemViewHolder extends RecyclerView.ViewHolder {

    public CardView cardView;
    public ImageView imageView;

    public ItemViewHolder(View itemView) {

        super(itemView);
        cardView = (CardView) itemView.findViewById(R.id.card_view);
        imageView = (ImageView) itemView.findViewById(R.id.iv);

    }
}
