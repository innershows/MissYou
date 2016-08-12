package com.innershows.findwhatyoulike.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.innershows.findwhatyoulike.R;
import com.innershows.findwhatyoulike.adapter.viewholder.ItemImageViewHolder;
import com.innershows.findwhatyoulike.girls_pictures.model.ImageFuli;
import com.innershows.findwhatyoulike.utils.view.NoIconTransformation;
import com.squareup.picasso.Picasso;

import java.util.List;

/**
 * Created by innershows on 16/8/10.
 *
 * @author innershows
 * @date 16/8/10
 * @e_mail innershow@gmail.com
 */
public class GirlsImgRecycleAdapter extends BaseRecycleAdapter<ImageFuli, ItemImageViewHolder> {


    public GirlsImgRecycleAdapter(List<ImageFuli> mImageFulis, Context mContext) {
        super(mImageFulis, mContext);
    }


    @Override
    public ItemImageViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        //ImageView imageView = new ImageView(mContext);

        View view = LayoutInflater.from(mContext).inflate(R.layout.item, parent, false);

        ItemImageViewHolder viewHolder = new ItemImageViewHolder(view, onItemClickListener);

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ItemImageViewHolder holder, int position) {
        String url = data.get(position).getUrl();
        Picasso.with(mContext).load(url).transform(new NoIconTransformation())
                //.resize(DensityUtils.screenWidth(mContext) >> 1, DensityUtils.dp2px(200, mContext))
                .into(holder.imageView);
        holder.textView.setText(data.get(position).getTitle());
    }


}
