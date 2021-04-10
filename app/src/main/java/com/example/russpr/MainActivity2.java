package com.example.russpr;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.view.View.OnClickListener;

public class MainActivity2 extends AppCompatActivity implements OnClickListener {

    private Button num9;
    private Button num10;
    private Button num11;
    private Button num12;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        num9 = (Button)findViewById(R.id.num9);
        num9.setOnClickListener(this);
        num10 = (Button)findViewById(R.id.num10);
        num10.setOnClickListener(this);
        num11 = (Button)findViewById(R.id.num11);
        num11.setOnClickListener(this);
        num12 = (Button)findViewById(R.id.num12);
        num12.setOnClickListener(this);


    }
    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.num9:
                Intent intent2 = new Intent(this, MainActivity4.class);
                startActivity(intent2);
                break;
            case R.id.num10:
                Intent intent3 = new Intent(this, MainActivity4.class);
                startActivity(intent3);
                break;
            case R.id.num11:
                Intent intent4 = new Intent(this, MainActivity4.class);
                startActivity(intent4);
                break;
        }
    }
}