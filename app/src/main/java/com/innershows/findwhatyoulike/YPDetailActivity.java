package com.innershows.findwhatyoulike;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.TextUtils;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.innershows.findwhatyoulike.adapter.SimplePagerAdapter;
import com.innershows.findwhatyoulike.girls_yp.model.YP;
import com.innershows.findwhatyoulike.girls_yp.model.YPDetail;
import com.innershows.findwhatyoulike.http.HtmlParser;
import com.innershows.findwhatyoulike.http.RetrofitUtils;

import butterknife.BindView;
import butterknife.ButterKnife;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

public class YPDetailActivity extends AppCompatActivity {

    public static final String DETAIL = "detail";
    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.pb)
    ProgressBar pb;
    @BindView(R.id.vp)
    ViewPager vp;
    @BindView(R.id.content)
    TextView content;
    @BindView(R.id.content_ypdetail)
    RelativeLayout contentYpdetail;

    private YP yp;
    private SimplePagerAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ypdetail);
        ButterKnife.bind(this);

        Intent intent = getIntent();
        yp = (YP) intent.getSerializableExtra(DETAIL);

        ab();


        String segment = Uri.parse(yp.getContentDetailUrl()).getLastPathSegment();
        if (TextUtils.isEmpty(segment)) {
            Toast.makeText(YPDetailActivity.this, "出错啦...", Toast.LENGTH_SHORT).show();
            return;
        }
        RetrofitUtils
                .getAPI()
                .getYPDetail(segment)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.newThread())
                .onErrorReturn(Throwable::getMessage)
                .doOnError(throwable1 ->
                        Toast.makeText(MyApp.getApp(), "请求失败", Toast.LENGTH_SHORT).show()
                )
                .subscribe(s -> {
                    YPDetail data = HtmlParser.handleYPDetail(s);

                    content.setText(data.getContent());
                    adapter = new SimplePagerAdapter(data.getImgs(), YPDetailActivity.this);
                    vp.setAdapter(adapter);
                    //wv.loadDataWithBaseURL(yp.getUserDetailUrl() , data , "text/html","utf-8" , null);
                });
        //wv.loadUrl(yp.getContentDetailUrl());
    }

    private void ab() {
        setSupportActionBar(toolbar);
        ActionBar ab = getSupportActionBar();
        if (ab != null) {
            ab.setDisplayOptions(ActionBar.DISPLAY_HOME_AS_UP);
            ab.setTitle(yp.getTitle());
            toolbar.setTitle(yp.getTitle());
        }
    }

}
