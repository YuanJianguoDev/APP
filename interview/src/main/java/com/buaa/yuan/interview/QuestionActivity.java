package com.buaa.yuan.interview;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;

import com.buaa.yuan.util.BaseActivity;
import com.buaa.yuan.util.Global;

import java.util.List;
import java.util.Map;

public class QuestionActivity extends BaseActivity {
    private ListView list;
    private List<Map<String,Object>> values;
    private SimpleAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question);

        super.init("全部问题",1);

        list = (ListView) findViewById(R.id.list);
        values = Global.values;
        adapter = new SimpleAdapter(this,values,R.layout.question_list,
                new String[]{"question"}, new int[]{R.id.question});
        list.setAdapter(adapter);

        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Map<String,Object> map = values.get(position);
                LinearLayout lin = (LinearLayout)view;
                if(lin.getChildCount()==1) {
                    TextView answerView = new TextView(QuestionActivity.this);
                    answerView.setText(map.get("answer").toString());
                    answerView.setTextColor(Color.RED);
                    answerView.setTextSize(14);
                    lin.addView(answerView);
                }else {
                    lin.removeViewAt(1);
                }
            }
        });

    }
}
