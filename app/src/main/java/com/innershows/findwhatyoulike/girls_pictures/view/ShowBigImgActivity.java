package com.innershows.findwhatyoulike.girls_pictures.view;

import android.os.Bundle;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.innershows.findwhatyoulike.R;
import com.innershows.findwhatyoulike.girls_pictures.model.ImageFuli;
import com.squareup.picasso.Callback;
import com.squareup.picasso.Picasso;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import uk.co.senab.photoview.PhotoViewAttacher;

/**
 * An example full-screen activity that shows and hides the system UI (i.e.
 * status bar and navigation/system bar) with user interaction.
 */
public class ShowBigImgActivity extends AppCompatActivity implements PhotoViewAttacher.OnViewTapListener {

    @BindView(R.id.view_pager)
    ViewPager viewPager;

    int currentPosition = 0;
    List<ImageFuli> mImageFuli;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_big_img);
        ButterKnife.bind(this);
        //UITools.setStatusBarColor(this, Color.TRANSPARENT);

        //设置沉浸式状态栏
        //UITools.setStatusBarColor(this, 0x58bc3a3a);
        mImageFuli = (List<ImageFuli>) getIntent().getSerializableExtra("data");
        currentPosition = getIntent().getIntExtra("position", 0);

        initViewPager();
    }


    private void initViewPager() {


        viewPager.setSystemUiVisibility(View.SYSTEM_UI_FLAG_LOW_PROFILE
                | View.SYSTEM_UI_FLAG_FULLSCREEN
                | View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                | View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY
                | View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
                | View.SYSTEM_UI_FLAG_HIDE_NAVIGATION);

        viewPager.setAdapter(new PagerAdapter() {

            ImageView[] imageViews = new ImageView[]
                    {
                            new ImageView(ShowBigImgActivity.this),
                            new ImageView(ShowBigImgActivity.this),
                            new ImageView(ShowBigImgActivity.this),
                            new ImageView(ShowBigImgActivity.this),
                            new ImageView(ShowBigImgActivity.this),
                            new ImageView(ShowBigImgActivity.this),
                    };

            @Override
            public int getCount() {
                return mImageFuli == null ? 0 : mImageFuli.size();
            }

            @Override
            public boolean isViewFromObject(View view, Object object) {
                return view == object;
            }

            @Override
            public Object instantiateItem(ViewGroup container, int position) {
                final ImageView iv;
                iv = imageViews[position % imageViews.length];

                Picasso.with(ShowBigImgActivity.this)
                        .load(mImageFuli.get(position).getUrl())
                        .into(iv, new Callback() {
                            @Override
                            public void onSuccess() {
                                PhotoViewAttacher photoViewAttacher = new PhotoViewAttacher(iv);
                                photoViewAttacher.setOnViewTapListener(ShowBigImgActivity.this);
                            }

                            @Override
                            public void onError() {
                            }
                        });

                container.addView(iv);

                //return super.instantiateItem(container, position);
                return iv;
            }

            @Override
            public void destroyItem(ViewGroup container, int position, Object object) {
                //super.destroyItem(container, position, object);
                ImageView iv = (ImageView) object;
                container.removeView(iv);
            }
        });


        viewPager.setCurrentItem(currentPosition, false);

    }


    @Override
    public void onViewTap(View view, float x, float y) {
        onBackPressed();
    }
}
