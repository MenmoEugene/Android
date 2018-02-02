package com.menmo.sendmessage;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        Button btn = (Button) findViewById(R.id.bt1);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String data = "atleast a mouth";
                Toast.makeText(MainActivity.this,"you clicked button",Toast.LENGTH_SHORT).show();
                Intent intent =new Intent(MainActivity.this,SecondActivity.class);
                intent.putExtra("extra_data",data);
                startActivityForResult(intent,1);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        switch (requestCode){
            case 1:
                if (resultCode==RESULT_OK){
                    String returnedata =data.getStringExtra("extra_data");
                    //是不是一样的。是就是对的
                    //查看日志的时候，LOG类型要选成一样的才看的见
                    //你这里选d。
                    Log.d("FirstActivity",returnedata);
                }
                break;
            default:
        }
    }
}
