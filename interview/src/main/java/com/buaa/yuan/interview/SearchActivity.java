package com.buaa.yuan.interview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.buaa.yuan.util.BaseActivity;

public class SearchActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);
        super.init("搜索问题",2);
    }
}
