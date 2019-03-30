package com.zxf.customviewdemo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.zxf.customviewdemo.GuideviewExample.GuideViewActivity;
import com.zxf.customviewdemo.QQBadge.QQBadgeActivity;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "MainActivity";
    private List<String> dataList = new ArrayList<>();
    private RecyclerView recyclerView;
    private MainAdapter mainAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView = findViewById(R.id.recyclerview);
        initData();
    }

    private void initData() {
        dataList.add("贝塞尔曲线");
        dataList.add("QQ消息提示小红点");
        dataList.add("ViewPage滑动引导动画");
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        mainAdapter = new MainAdapter(dataList);
        recyclerView.setAdapter(mainAdapter);
        mainAdapter.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
                Intent intent;
                switch (position) {
                    case 0:
                        //贝塞尔曲线展示
                        intent = new Intent(MainActivity.this, BezercurveActivity.class);
                        startActivity(intent);
                        break;
                    case 1:
                        intent = new Intent(MainActivity.this, QQBadgeActivity.class);
                        startActivity(intent);
                        break;
                    case 2:
                        intent = new Intent(MainActivity.this, GuideViewActivity.class);
                        startActivity(intent);
                        break;
                }
            }
        });
    }

}
