package com.sunpointed.lqy.helperadapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import java.util.List;

/**
 * Created by luoqiuyu on 2017/3/30.
 */

public abstract class HelperAdapter2<holder1, holder2> extends BaseAdapter {

    protected Context mContext;
    protected List mDatas;

    private Class<holder1> mClass1;
    private Class<holder2> mClass2;

    @Override
    public int getItemViewType(int position) {
        return getItemType(position);
    }

    @Override
    public int getViewTypeCount() {
        return 2;
    }

    public HelperAdapter2(Context context, List datas, Class<holder1> clazz1, Class<holder2> clazz2) {
        mDatas = datas;
        mContext = context;
        mClass1 = clazz1;
        mClass2 = clazz2;
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
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        holder1 h1 = null;
        holder2 h2 = null;
        int type = getItemViewType(position);
        if(convertView == null){
            if(type == 0){
                try {
                    h1 = mClass1.newInstance();
                } catch (InstantiationException e) {
                    e.printStackTrace();
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                }
                convertView = inflateForItem1(mContext);
                findViews1(h1, convertView);
                convertView.setTag(h1);
            } else {
                try {
                    h2 = mClass2.newInstance();
                } catch (InstantiationException e) {
                    e.printStackTrace();
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                }
                convertView = inflateForItem2(mContext);
                findViews2(h2, convertView);
                convertView.setTag(h2);
            }
        } else {
            if(type == 0){
                h1 = (holder1) convertView.getTag();
            } else {
                h2 = (holder2) convertView.getTag();
            }
        }

        if(type == 0){
            showPerformance1(position, convertView, parent, h1);
        } else {
            showPerformance2(position, convertView, parent, h2);
        }

        return convertView;
    }

    protected abstract View inflateForItem1(Context context);

    protected abstract View inflateForItem2(Context context);

    protected abstract int getItemType(int position);

    protected abstract void findViews1(holder1 holder, View convertView);

    protected abstract void findViews2(holder2 holder, View convertView);

    protected abstract void showPerformance1(int position, View convertView, ViewGroup parent, holder1 holder);

    protected abstract void showPerformance2(int position, View convertView, ViewGroup parent, holder2 holder);
}
