package com.innershows.findwhatyoulike.adapter;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;

import java.util.List;

/**
 * Created by innershows on 16/10/14.
 *
 * @author innershows
 * @date 16/10/14
 * @e_mail innershow@gmail.com
 */

public class SimplePagerAdapter extends PagerAdapter {
    private List<String> imgs;

    private Context ctx;

    public SimplePagerAdapter(List<String> imgs, Context ctx) {
        this.imgs = imgs;
        this.ctx = ctx;
    }

    @Override
    public int getCount() {
        return imgs.size();
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == object;
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        ImageView iv = new ImageView(ctx);
        Picasso.with(ctx).load(imgs.get(position)).into(iv);

        container.addView(iv);

        return iv;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        //super.destroyItem(container, position, object);
        container.removeView((View) object);

    }
}
