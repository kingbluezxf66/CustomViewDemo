package com.zxf.customviewdemo;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by zxf on 2019/3/28.
 */

public class BezercurveActivity extends AppCompatActivity implements CompoundButton.OnCheckedChangeListener {
    private BezierCurve mBezierCurve;
    private TextView mTextView;
    private Switch mLoop, mTangent;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bezier_curve);
        initView();
    }

    private void initView() {
        mBezierCurve = (BezierCurve) findViewById(R.id.bezier);
        mTextView = (TextView) findViewById(R.id.textview);
        mLoop = (Switch) findViewById(R.id.loop);
        mTangent = (Switch) findViewById(R.id.tangent);
        mTextView.setText(mBezierCurve.getOrderStr() + "阶贝塞尔曲线");
        mLoop.setOnCheckedChangeListener(this);
        mTangent.setOnCheckedChangeListener(this);
        mLoop.setChecked(false);
        mTangent.setChecked(true);
    }

    public void start(View view) {
        mBezierCurve.start();
    }

    public void stop(View view) {
        mBezierCurve.stop();
    }

    public void add(View view) {
        mBezierCurve.addPoint();
    }

    public void del(View view) {
        mBezierCurve.delPoint();
    }

    @Override
    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
        switch (buttonView.getId()) {
            case R.id.loop:
                mBezierCurve.setLoop(isChecked);
                break;
            case R.id.tangent:
                mBezierCurve.setTangent(isChecked);
                break;
        }
    }
}
