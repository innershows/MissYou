package com.innershows.findwhatyoulike.adapter.viewholder;

import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.innershows.findwhatyoulike.adapter.BaseRecycleAdapter;
import com.innershows.findwhatyoulike.adapter.GirlsImgRecycleAdapter;

/**
 * Created by innershows on 16/8/11.
 *
 * @author innershows
 * @date 16/8/11
 * @e_mail innershow@gmail.com
 */
public class BaseItemViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
    protected BaseRecycleAdapter.OnItemClickListener listener;

    public BaseItemViewHolder(View itemView, GirlsImgRecycleAdapter.OnItemClickListener listener) {
        super(itemView);
        if (listener != null) {
            this.listener = listener;
            itemView.setOnClickListener(this);
        }

    }

    @Override
    public void onClick(View view) {
        this.listener.onItemClick(view, getAdapterPosition());
    }
}
