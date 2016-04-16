package com.buaa.yuan.interview;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.buaa.yuan.util.BaseActivity;

public class MainActivity extends BaseActivity {

    private Button btn_02;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        super.init("程序员面试宝典",0);
        btn_02 = (Button)findViewById(R.id.btn_02);
        btn_02.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,QuestionActivity.class);
                startActivity(intent);
            }
        });
    }
}
