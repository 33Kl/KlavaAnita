package com.example.russpr;

import androidx.appcompat.app.AppCompatActivity;


import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.view.View.OnClickListener;
public class MainActivity3 extends AppCompatActivity implements OnClickListener{

    private Button ex9;
    private Button ex10;
    private Button ex11;
    private Button ex12;
    private Button ex13;
    private Button ex14;
    private Button ex15;
    private Button ex16;
    private Button ex17;
    private Button ex18;
    private Button ex19;
    private Button ex20;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);

        ex9 = (Button)findViewById(R.id.ex9);
        ex9.setOnClickListener(this);
        ex10 = (Button)findViewById(R.id.ex10);
        ex10.setOnClickListener(this);
        ex11 = (Button)findViewById(R.id.ex11);
        ex11.setOnClickListener(this);
        ex12 = (Button)findViewById(R.id.ex12);
        ex12.setOnClickListener(this);
        ex13 = (Button)findViewById(R.id.ex13);
        ex13.setOnClickListener(this);
        ex14 = (Button)findViewById(R.id.ex14);
        ex14.setOnClickListener(this);
        ex15 = (Button)findViewById(R.id.ex15);
        ex15.setOnClickListener(this);
        ex16 = (Button)findViewById(R.id.ex16);
        ex16.setOnClickListener(this);
        ex17 = (Button)findViewById(R.id.ex17);
        ex17.setOnClickListener(this);
        ex18 = (Button)findViewById(R.id.ex18);
        ex18.setOnClickListener(this);
        ex19 = (Button)findViewById(R.id.ex19);
        ex19.setOnClickListener(this);
        ex20 = (Button)findViewById(R.id.ex20);
        ex20.setOnClickListener(this);

    }
    @Override
    public void onClick(View v){
        switch (v.getId()){
            case R.id.ex9:

                break;
            case R.id.ex10:

        }
    }
}