package com.sunpointed.lqy.helperadapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import java.util.List;

/**
 * Created by luoqiuyu on 2017/3/28.
 */

public abstract class HelperAdapter<model, holder> extends BaseAdapter {

    protected List<model> mDatas;
    protected Context mContext;
    private Class<holder> mClass;

    public HelperAdapter(Context context, List<model> datas, Class<holder> clazz) {
        mDatas = datas;
        mContext = context;
        mClass = clazz;
    }

    @Override
    public int getCount() {
        return mDatas == null ? 0 : mDatas.size();
    }

    @Override
    public Object getItem(int position) {
        return mDatas == null ? null : mDatas.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        holder holder = null;

        if (convertView == null) {
            try {
                holder = mClass.newInstance();
            } catch (InstantiationException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }

            convertView = inflate(mContext);
            findViews(holder, convertView);
            convertView.setTag(holder);
        } else {
            holder = (holder) convertView.getTag();
        }

        showPerformance(position, convertView, parent, holder);

        return convertView;
    }

    protected abstract View inflate(Context context);

    protected abstract void findViews(holder holder, View convertView);

    protected abstract void showPerformance(int position, View convertView, ViewGroup parent, holder holder);
}
