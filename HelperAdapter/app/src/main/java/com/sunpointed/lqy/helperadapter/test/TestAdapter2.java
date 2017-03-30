package com.sunpointed.lqy.helperadapter.test;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.sunpointed.lqy.helperadapter.HelperAdapter2;
import com.sunpointed.lqy.helperadapter.R;

import java.util.List;

/**
 * Created by luoqiuyu on 2017/3/30.
 */

public class TestAdapter2 extends HelperAdapter2<TestAdapter2.ViewHolder1, TestAdapter2.ViewHolder2> {


    public TestAdapter2(Context context, List datas) {
        super(context, datas, ViewHolder1.class, ViewHolder2.class);
    }

    @Override
    protected View inflateForItem1(Context context) {
        return LayoutInflater.from(context).inflate(R.layout.list_item_1, null);
    }

    @Override
    protected View inflateForItem2(Context context) {
        return LayoutInflater.from(context).inflate(R.layout.list_item_2, null);
    }

    @Override
    protected int getItemType(int position) {
        return mDatas.get(position) instanceof TestBean ? 0 : 1;
    }

    @Override
    protected void findViews1(ViewHolder1 holder, View convertView) {
        holder.tv = (TextView) convertView.findViewById(R.id.list_item_1_tv);
    }

    @Override
    protected void findViews2(ViewHolder2 holder, View convertView) {
        holder.tv = (TextView) convertView.findViewById(R.id.list_item_2_tv);
    }

    @Override
    protected void showPerformance1(int position, View convertView, ViewGroup parent, ViewHolder1 holder) {
        TestBean item = (TestBean) mDatas.get(position);
        holder.tv.setText(item.test);
    }

    @Override
    protected void showPerformance2(int position, View convertView, ViewGroup parent, ViewHolder2 holder) {
        TestBean2 item = (TestBean2) mDatas.get(position);
        holder.tv.setText(item.test);
    }

    public static class ViewHolder1{
        TextView tv;
    }

    public static class ViewHolder2{
        TextView tv;
    }
}
