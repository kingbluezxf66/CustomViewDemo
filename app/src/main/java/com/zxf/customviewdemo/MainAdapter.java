package com.zxf.customviewdemo;

import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;

import java.util.List;

/**
 * Created by zxf on 2019/3/27.
 */

public class MainAdapter extends BaseQuickAdapter<String,BaseViewHolder>{

    public MainAdapter(@Nullable List<String> data) {
        super(R.layout.item_main,data);
    }

    @Override
    protected void convert(BaseViewHolder helper, String item) {
        helper.setText(R.id.tv_name,item);
    }
}
