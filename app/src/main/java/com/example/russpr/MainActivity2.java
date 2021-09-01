package com.example.russpr; // Здесь описывается код списков вариантов заданий/теории

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
    private Button num13;
    private Button num14;
    private Button num15;
    private Button num16;
    private Button num17;
    private Button num18;
    private Button num19;
    private Button num20;
    private Button num21;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        num9 = (Button) findViewById(R.id.num9);
        num9.setOnClickListener(this);
        num10 = (Button) findViewById(R.id.num10);
        num10.setOnClickListener(this);
        num11 = (Button) findViewById(R.id.num11);
        num11.setOnClickListener(this);
        num12 = (Button) findViewById(R.id.num12);
        num12.setOnClickListener(this);
        num13 = (Button) findViewById(R.id.num13);
        num13.setOnClickListener(this);
        num14 = (Button) findViewById(R.id.num14);
        num14.setOnClickListener(this);
        num15 = (Button) findViewById(R.id.num15);
        num15.setOnClickListener(this);
        num16 = (Button) findViewById(R.id.num16);
        num16.setOnClickListener(this);
        num17 = (Button) findViewById(R.id.num17);
        num17.setOnClickListener(this);
        num18 = (Button) findViewById(R.id.num18);
        num18.setOnClickListener(this);
        num19 = (Button) findViewById(R.id.num19);
        num19.setOnClickListener(this);
        num20 = (Button) findViewById(R.id.num20);
        num20.setOnClickListener(this);
        num21 = (Button) findViewById(R.id.num21);
        num21.setOnClickListener(this);


    }

    @Override
    public void onClick(View v) { // Код перехода
        switch (v.getId()) {
            case R.id.num9:
                Intent intent2 = new Intent(this, MainActivity4.class);
                startActivity(intent2);
                break;
            case R.id.num10:
                Intent intent3 = new Intent(this, MainActivity5.class);
                startActivity(intent3);
                break;
            case R.id.num11:
                Intent intent4 = new Intent(this, MainActivity6.class);
                startActivity(intent4);
                break;
        }
    }
}




