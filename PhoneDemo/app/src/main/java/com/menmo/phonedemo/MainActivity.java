package com.menmo.phonedemo;
import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button btn = (Button) findViewById(R.id.bt_call);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText number = (EditText) findViewById(R.id.et_phone);
                String str = number.getText().toString().trim();
                if("".equals(str)){
                    Toast.makeText(MainActivity.this,"请输入内容",Toast.LENGTH_SHORT).show();
                    return;
                }
                if(TextUtils.isEmpty(str)){
                    Toast.makeText(MainActivity.this,"请输入内容",Toast.LENGTH_SHORT).show();
                    return;
                }
                Intent intent = new Intent();
                intent.setAction(Intent.ACTION_CALL);
                intent.setData(Uri.parse("tel:"+str));
                startActivity(intent);
            }
        });
    }
}
