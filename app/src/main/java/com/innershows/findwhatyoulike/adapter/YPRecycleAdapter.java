package com.innershows.findwhatyoulike.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.innershows.findwhatyoulike.R;
import com.innershows.findwhatyoulike.adapter.viewholder.ItemYPHolder;
import com.innershows.findwhatyoulike.girls_yp.model.YP;
import com.innershows.findwhatyoulike.utils.view.CircleTransformation;
import com.squareup.picasso.Picasso;

import java.util.List;

/**
 * Created by innershows on 16/8/11.
 *
 * @author innershows
 * @date 16/8/11
 * @e_mail innershow@gmail.com
 */
public class YPRecycleAdapter extends BaseRecycleAdapter<YP, ItemYPHolder> {

    private CircleTransformation transformation;

    public YPRecycleAdapter(List<YP> data, Context mContext) {
        super(data, mContext);
        transformation = new CircleTransformation();
    }

    @Override
    public ItemYPHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(mContext).inflate(R.layout.item_yp, parent, false);
        return new ItemYPHolder(view, onItemClickListener);
    }

    @Override
    public void onBindViewHolder(ItemYPHolder holder, int position) {
        YP yp = data.get(position);


        Picasso.with(mContext)
                .load(yp.getAvatarUrl())
                .transform(transformation)
                .into(holder.imageView);

        holder.tvGroupName.setText(yp.getGroup());
        holder.tvDate.setText(yp.getDate());
        holder.tvNickname.setText(yp.getUserName());
        holder.tvTitle.setText(yp.getTitle());
    }
}
