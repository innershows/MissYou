package com.innershows.findwhatyoulike.girls_pictures.view;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.innershows.findwhatyoulike.R;
import com.innershows.findwhatyoulike.adapter.ViewPagerAdapter;
import com.innershows.findwhatyoulike.utils.Constants;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

public class OuterGirlsFragment extends Fragment {

    @BindView(R.id.tab_layout)
    TabLayout tabLayout;
    @BindView(R.id.view_pager)
    ViewPager viewPager;

    ArrayList<Fragment> fragments = new ArrayList<>();

    public static OuterGirlsFragment newInstance() {
        OuterGirlsFragment fragment = new OuterGirlsFragment();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (fragments.size() == 0) {
            for (int index = 0; index < Constants.TITLES.length; index++) {
                fragments.add(InnerGirlsFragment.newInstance(Constants.IDS[index]));
            }
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_outer_girls, container, false);
        ButterKnife.bind(this, view);
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        initView();
    }

    private void initView() {
        tabLayout.setTabMode(TabLayout.MODE_SCROLLABLE);

        ViewPagerAdapter adapter = new ViewPagerAdapter(getChildFragmentManager(), fragments);
        viewPager.setAdapter(adapter);

        tabLayout.setupWithViewPager(viewPager);
    }


    public void doChildRefresh() {
        InnerGirlsFragment fragment = (InnerGirlsFragment) fragments.get(tabLayout.getSelectedTabPosition());
        fragment.doRefresh();
    }


}
