package com.innershows.findwhatyoulike;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.IdRes;
import android.support.design.widget.CoordinatorLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.FrameLayout;

import com.innershows.findwhatyoulike.girls_pictures.view.OuterGirlsFragment;
import com.innershows.findwhatyoulike.girls_video.view.VideoFragment;
import com.innershows.findwhatyoulike.girls_yp.view.YPFragment;
import com.innershows.findwhatyoulike.utils.UITools;
import com.roughike.bottombar.BottomBar;
import com.roughike.bottombar.OnMenuTabClickListener;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import fm.jiecao.jcvideoplayer_lib.JCVideoPlayer;

public class MainActivity extends AppCompatActivity implements OnMenuTabClickListener {

    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.fl_container)
    FrameLayout tabLayout;
    private BottomBar mBottomBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
        initBottombar(savedInstanceState);

        //设置沉浸式状态栏
        UITools.setStatusBarColor(this, 0x58bc3a3a);
        ButterKnife.bind(this);
    }

    private void initBottombar(Bundle savedInstanceState) {
        mBottomBar = BottomBar.attachShy((CoordinatorLayout) findViewById(R.id.coo_layout),
                findViewById(R.id.fl_container), savedInstanceState);

        mBottomBar.setItems(R.menu.bottom);

        mBottomBar.setOnMenuTabClickListener(this);

        mBottomBar.mapColorForTab(0, ContextCompat.getColor(this, R.color.colorAccent));
        mBottomBar.mapColorForTab(1, "#5D4037");
        mBottomBar.mapColorForTab(2, "#ab616e");
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    private void init() {
        //设置为toolbar
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        fragments.add(OuterGirlsFragment.newInstance());
        fragments.add(VideoFragment.newInstance());
        fragments.add(YPFragment.newInstance());
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);

        // Necessary to restore the BottomBar's state, otherwise we would
        // lose the current tab on orientation change.
        mBottomBar.onSaveInstanceState(outState);
    }

    private List<Fragment> fragments = new ArrayList<>();

    int lastCheckedPosition = -1;

    @Override
    public void onMenuTabSelected(@IdRes int menuItemId) {
        showFragment(menuItemId);
    }

    private void showFragment(@IdRes int menuItemId) {
        FragmentTransaction transaction = getSupportFragmentManager()
                .beginTransaction();

        int checked = R.id.beauty_image == menuItemId ? 0
                : R.id.beauty_video == menuItemId ? 1 : 2;

        Fragment fragment = fragments.get(
                checked);

        if (fragment.isAdded()) {
            transaction.show(fragment);
        } else {
            transaction.add(R.id.fl_container, fragment);
        }

        //隐藏上一次的fragment
        if (-1 != lastCheckedPosition) {
            transaction.hide(fragments.get(lastCheckedPosition));
        }

        lastCheckedPosition = checked;

        transaction.commit();
    }

    @Override
    public void onBackPressed() {
        if (JCVideoPlayer.backPress()) {
            return;
        }
        super.onBackPressed();
    }

    /**
     * 选择了菜单按钮
     *
     * @param item
     * @return
     */
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.about:
                startActivity(new Intent(this, AboutActivity.class));

                break;
            default:
                break;
        }


        return super.onOptionsItemSelected(item);

    }

    @Override
    public void onMenuTabReSelected(@IdRes int menuItemId) {
        switch (menuItemId) {
            case R.id.beauty_image:
                OuterGirlsFragment outerGirlsFragment = (OuterGirlsFragment) fragments.get(0);
                outerGirlsFragment.doChildRefresh();
                break;
            case R.id.beauty_video:
                VideoFragment videoFragment = (VideoFragment) fragments.get(1);
                videoFragment.doRefresh();
                break;
            case R.id.beauty_mime:
                YPFragment ypFragment = (YPFragment) fragments.get(2);
                ypFragment.doRefresh();
                break;
        }
    }
}