package com.zxf.customviewdemo.GuideviewExample;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;


import com.zxf.customviewdemo.R;

import java.util.ArrayList;

public class GuideViewActivity extends AppCompatActivity {

    private ViewPager viewPager;
    private SpringIndicator springIndicator;

    private ArrayList fragList;
    private String[] titles = {"1", "2", "3", "4"};
    private ArrayList list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_guide_view);
        initData();
        initView();
    }

    private void initData() {
        fragList = new ArrayList<Fragment>();
        fragList.add(new MyFragment(R.drawable.dog1));
        fragList.add(new MyFragment(R.drawable.dog2));
        fragList.add(new MyFragment(R.drawable.dog3));
        fragList.add(new MyFragment(R.drawable.dog4));
        list = new ArrayList<String>();
        for (String str : titles) {
            list.add(str);
        }
    }

    private void initView() {
        viewPager = (ViewPager) findViewById(R.id.view_pager);
        springIndicator = (SpringIndicator) findViewById(R.id.indicator);
        MyAdapter adapter = new MyAdapter(getSupportFragmentManager(), fragList, list);
        viewPager.setAdapter(adapter);
        viewPager.setOffscreenPageLimit(4);
        springIndicator.setViewPager(viewPager);

    }

}
