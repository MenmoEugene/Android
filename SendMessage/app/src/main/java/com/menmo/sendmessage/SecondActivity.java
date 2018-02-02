package com.menmo.sendmessage;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import static android.R.attr.data;

public class SecondActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.second);
        Button btn = (Button) findViewById(R.id.bt2);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               /* //在手机屏幕弹出吐司（上下文，提示内容CharSequence，弹出内容显示时间）并显示出来
                Toast.makeText(SecondActivity.this,"you clicked btn2",Toast.LENGTH_SHORT).show();
                //通过上一个活动获得一个意图并赋给一个名为l 的意图对象
                Intent l = getIntent();
                //通过一个名为l 的意图，使用getStringExtra的方法获得一个键为extra_data的字符串，同时赋给一个名为data的引用类型
               String data = l.getStringExtra("extra_data");
                //打印一个Debug类型的日志，传入两个参数，第一个是tag String引用类型，第二个是message
                Log.d("SecondActivity","SecondActivity --- onClick --- data:"+data);
                //在手机屏幕上弹出吐司,传入三个参数，第一个参数是上下文Context，上下文，提示内容CharSequence,弹出内容显示时间，并显示出来
                Toast.makeText(SecondActivity.this,"SecondActivity --- onClick --- data:"+data,Toast.LENGTH_SHORT).show();
                //开启一个活动，传入名为l的意图
                startActivity(l);*/
                Toast.makeText(SecondActivity.this, "you onclick button2", Toast.LENGTH_SHORT).show();
                //你这是要回调给第一个界面Activity，所以不是指定跳转
                //没有指定跳转的活动Activity
//                Intent l = new Intent(SecondActivity.this, MainActivity.class);
                //通过上一个活动Activity获得传过来的数据getIntent()
                Intent intent =getIntent();
                //src
                String str = intent.getStringExtra("extra_data");
                //这个data是什么？你要打印的是第一个界面Activity传过来的值
                //这个值通过意图获得。并赋给引用对象str
//                Log.d("SecondActivity", "SecondActivity --- onClick --- data:" + data);
                //这里写了e
                Log.e("SecondActivity", "SecondActivity --- onClick --- str : " + str);
                Toast.makeText(SecondActivity.this, "SecondActivity --- onClick -- str : " + str, Toast.LENGTH_SHORT).show();
//                Toast.makeText(SecondActivity.this, "SecondActivity --- onClick --- data:" + data, Toast.LENGTH_SHORT).show();
                //你这是要回调给第一个界面Activity，所以不是跳转
//                startActivity(intent);
                setResult(RESULT_OK, intent);
                finish();
            }
        });
    }
}
