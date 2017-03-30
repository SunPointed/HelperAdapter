package com.sunpointed.lqy.helperadapter.test;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;

import com.sunpointed.lqy.helperadapter.R;

import java.util.ArrayList;

/**
 * Created by luoqiuyu on 2017/3/30.
 */

public class TestActivity extends AppCompatActivity {

    ListView listView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listView = (ListView) findViewById(R.id.lv);

        ArrayList list = new ArrayList();
        for(int i = 0; i < 100; i++){
            if(Math.random() * 100 < 50){
                TestBean bean = new TestBean();
                bean.test = "TestBean " + i;
                list.add(bean);
            } else {
                TestBean2 bean2 = new TestBean2();
                bean2.test = "TestBean2 " + i;
                list.add(bean2);
            }
        }

        TestAdapter2 adapter2 = new TestAdapter2(this, list);
        listView.setAdapter(adapter2);
    }
}
