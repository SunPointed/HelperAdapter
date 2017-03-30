package com.sunpointed.lqy.helperadapter.test;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.sunpointed.lqy.helperadapter.HelperAdapter;
import com.sunpointed.lqy.helperadapter.R;

import java.util.ArrayList;

/**
 * Created by luoqiuyu on 2017/3/30.
 */

public class TestAdapter extends HelperAdapter<TestBean, TestAdapter.ViewHolder>{

    public TestAdapter(Context context, ArrayList<TestBean> datas) {
        super(context, datas, ViewHolder.class);
    }

    @Override
    protected View inflate(Context context) {
        return LayoutInflater.from(context).inflate(R.layout.list_item_test, null);
    }

    @Override
    protected void findViews(ViewHolder viewHolder, View convertView) {
        viewHolder.tv = (TextView) convertView.findViewById(R.id.list_item_test_tv);
    }

    @Override
    protected void showPerformance(int position, View convertView, ViewGroup parent, ViewHolder viewHolder) {
        TestBean item = mDatas.get(position);
        viewHolder.tv.setText(item.test);
    }

    public static class ViewHolder{
       TextView tv;
    }
}
