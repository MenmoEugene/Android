package com.example.menmo.uilayouttest;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class FourthActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fourth_layout);
        ActivityCollector.addActivity(FourthActivity.this);
        Button button3 = (Button) findViewById(R.id.button3);
        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                Intent intent = new Intent(FourthActivity.this, ActivityCollector.class);
//                startActivity(intent);
                ActivityCollector ac = new ActivityCollector();
                ac.finishAll();
            }
        });
        ActivityCollector.addActivity(FourthActivity.this);

    }
}
