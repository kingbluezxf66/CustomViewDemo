package com.zxf.customviewdemo.QQBadge;

import android.graphics.PointF;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;
import android.widget.Toast;

import com.zxf.customviewdemo.R;

/**
 * Created by zxf on 2019/3/29.
 */

public class QQBadgeActivity extends AppCompatActivity {
    private TextView mTvPoint;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_qq);
        initView();
    }
    private void initView() {
        mTvPoint = (TextView) findViewById(R.id.point_conversation);
        mTvPoint.setText("10");
        mTvPoint.setTag(10);
        GooViewListener listener = new GooViewListener(this, mTvPoint) {
            @Override
            public void onDisappear(PointF mDragCenter) {
                super.onDisappear(mDragCenter);
                Toast.makeText(QQBadgeActivity.this, "消失了", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onReset(boolean isOutOfRange) {
                super.onReset(isOutOfRange);
                Toast.makeText(QQBadgeActivity.this, "重置了", Toast.LENGTH_SHORT).show();
            }
        };
        mTvPoint.setOnTouchListener(listener);
    }
}
