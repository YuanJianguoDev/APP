package com.buaa.yuan.interview;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.BaseAdapter;

import com.buaa.yuan.util.BaseActivity;
import com.buaa.yuan.util.Global;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class IndexActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_index);
        Thread t = new Thread(){
            @Override
            public void run() {
                try {
                    InputStream is = getAssets().open("mianshi.txt");
                    Global.values = loadInputStream(is);
                    sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                Intent intent = new Intent(IndexActivity.this,MainActivity.class);
                startActivity(intent);
                finish();
            }
        };
        t.start();
    }

    public List<Map<String, Object>> loadInputStream(InputStream is) throws IOException {
        List<Map<String,Object>> values = new ArrayList<>();
        BufferedReader buf = new BufferedReader(new InputStreamReader(is,"GBK"));

        String line=null;
        StringBuffer question = new StringBuffer();
        StringBuffer answer = new StringBuffer();
        boolean questionFlag = false;

        while((line=buf.readLine())!=null){
            if(line.equals("question_start_flag ")){
                //问题开始
                questionFlag = true ;
            }else if(line.equals("answer_start_flag")){
                //答案开始
                questionFlag = false;
            }else if(line.equals("end_flag")){
                //答案结束,整合问题答案
                Map<String,Object> map = new HashMap<>();
                map.put("question",question.toString());
                map.put("answer", answer.toString());
                values.add(map);
                //清空问题和答案变量
                question = new StringBuffer();
                answer = new StringBuffer();

            }else{
                //读取数据
                if(questionFlag) {
                    question.append(line);
                }else {
                    answer.append(line);
                }
            }
        }
        return values;
    }
}
