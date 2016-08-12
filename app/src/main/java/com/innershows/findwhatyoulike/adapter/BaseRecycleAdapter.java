package com.innershows.findwhatyoulike.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.innershows.findwhatyoulike.girls_pictures.model.ImageFuli;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by innershows on 16/8/11.
 *
 * @author innershows
 * @date 16/8/11
 * @e_mail innershow@gmail.com
 */
public abstract class BaseRecycleAdapter<T, VH extends RecyclerView.ViewHolder> extends RecyclerView.Adapter<VH> {
    protected OnItemClickListener onItemClickListener;
    List<T> data;
    Context mContext;

    public BaseRecycleAdapter(List<T> data, Context mContext) {
        this.data = data;
        this.mContext = mContext;
    }

    public void setOnItemClickListener(OnItemClickListener onItemClickListener) {
        this.onItemClickListener = onItemClickListener;
    }

    public void addData(List<T> data) {
        if (this.data == null) {
            this.data = new ArrayList<>();
        }

        this.data.addAll(data);
        notifyDataSetChanged();
    }

    public void clear() {
        if (this.data != null) {
            this.data.clear();
            notifyDataSetChanged();
        }
    }

    @Override
    public int getItemCount() {
        return data == null ? 0 : data.size();
    }

    public ArrayList<ImageFuli> getData() {
        return (ArrayList) this.data;
    }

    public static interface OnItemClickListener {
        void onItemClick(View v, int position);
    }
}
