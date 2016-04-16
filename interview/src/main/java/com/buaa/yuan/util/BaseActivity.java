package com.buaa.yuan.util;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.buaa.yuan.interview.MainActivity;
import com.buaa.yuan.interview.QuestionActivity;
import com.buaa.yuan.interview.R;
import com.buaa.yuan.interview.SearchActivity;

/**
 * Created by yuan on 2016/4/16.
 */
public class BaseActivity extends AppCompatActivity{
    private TextView topTitle;
    private Class[] targetActivities = new Class[]{MainActivity.class, QuestionActivity.class, SearchActivity.class};
    private Button[] bottomBtns= new Button[3];
    private int[] bottomImgs = new int[]{R.drawable.buttom01_b,R.drawable.buttom02_b,R.drawable.buttom03_b};
    private int[] bottomImgsSelected = new int[]{R.drawable.buttom01_a,R.drawable.buttom02_a,R.drawable.buttom03_a};
    private int i;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    protected void init(String title,int index){
        topTitle = (TextView)findViewById(R.id.title);
        topTitle.setText(title);

        //拿到按钮对象
        bottomBtns[0] = (Button) findViewById(R.id.btn_01);
        bottomBtns[1] = (Button) findViewById(R.id.btn_02);
        bottomBtns[2] = (Button) findViewById(R.id.btn_03);

        for(i=0;i<bottomBtns.length;i++){
            final int temp = i ;
            if(i==index){
                bottomBtns[i].setBackgroundResource(bottomImgsSelected[i]);
            }else{
                bottomBtns[i].setBackgroundResource(bottomImgs[i]);
                //设置点击跳转事件
                bottomBtns[i].setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent = new Intent(BaseActivity.this,targetActivities[temp]);
                        startActivity(intent);
                    }
                });

            }
        }
    }
}
