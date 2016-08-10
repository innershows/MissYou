package com.innershows.findwhatyoulike.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.innershows.findwhatyoulike.R;
import com.innershows.findwhatyoulike.girls_pictures.model.ImageFuli;
import com.squareup.picasso.Picasso;

import java.util.List;

/**
 * Created by innershows on 16/8/10.
 *
 * @author innershows
 * @date 16/8/10
 * @e_mail innershow@gmail.com
 */
public class RecycleAdapter extends RecyclerView.Adapter<ItemViewHolder> {

    List<ImageFuli> mImageFulis;
    Context mContext;

    public RecycleAdapter(List<ImageFuli> mImageFulis, Context mContext) {
        this.mImageFulis = mImageFulis;
        this.mContext = mContext;
    }

    @Override
    public ItemViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        //ImageView imageView = new ImageView(mContext);

        View view = LayoutInflater.from(mContext).inflate(R.layout.item, parent, false);

        ItemViewHolder viewHolder = new ItemViewHolder(view);


        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ItemViewHolder holder, int position) {
        String url = mImageFulis.get(position).getUrl();
        Picasso.with(mContext).load(url)
                //.resize(DensityUtils.screenWidth(mContext) >> 1, DensityUtils.dp2px(200, mContext))
                .into(holder.imageView);

    }

    @Override
    public int getItemCount() {
        return mImageFulis == null ? 0 : mImageFulis.size();
    }
}
