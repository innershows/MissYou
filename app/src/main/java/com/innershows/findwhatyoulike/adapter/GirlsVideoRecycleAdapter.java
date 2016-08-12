package com.innershows.findwhatyoulike.adapter;

import android.content.Context;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.innershows.findwhatyoulike.adapter.viewholder.ItemVideoViewHolder;
import com.innershows.findwhatyoulike.girls_pictures.model.ImageFuli;
import com.squareup.picasso.Picasso;

import java.util.List;

/**
 * Created by innershows on 16/8/11.
 *
 * @author innershows
 * @date 16/8/11
 * @e_mail innershow@gmail.com
 */
public class GirlsVideoRecycleAdapter extends BaseRecycleAdapter<ImageFuli, ItemVideoViewHolder> {


    public GirlsVideoRecycleAdapter(List<ImageFuli> data, Context mContext) {
        super(data, mContext);
    }

    @Override
    public ItemVideoViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        ImageView textView = new ImageView(mContext);
        return new ItemVideoViewHolder(textView, onItemClickListener);
    }

    @Override
    public void onBindViewHolder(ItemVideoViewHolder holder, int position) {
        //((TextView) holder.itemView).setText("呵呵哒");
        Picasso.with(mContext).load(data.get(position).getUrl()).into((ImageView) holder.itemView);
    }
}
