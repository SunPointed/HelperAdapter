package com.sunpointed.lqy.helperadapter.test;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.sunpointed.lqy.helperadapter.R;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listView = (ListView) findViewById(R.id.lv);

        ArrayList<TestBean> list = new ArrayList<>();
        for(int i = 0; i < 50; i++){
            TestBean testBean = new TestBean();
            testBean.test = "TestBean " + i;
            list.add(testBean);
        }

        TestAdapter testAdapter = new TestAdapter(this, list);
        listView.setAdapter(testAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(MainActivity.this, TestActivity.class);
                startActivity(intent);
            }
        });
    }
}
