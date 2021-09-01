package com.example.russpr; // Код первого экрана с кнопками: "Каталог заданий" и "Теория к заданиям"

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity implements OnClickListener{

    private Button katZadaniy;
    private Button teoriaKzadaniyam;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        katZadaniy = (Button)findViewById(R.id.katZadaniy);
        katZadaniy.setOnClickListener(this);
        teoriaKzadaniyam = (Button)findViewById(R.id.teoriaKzadaniyam);
        teoriaKzadaniyam.setOnClickListener(this);
    }
   @Override
    public void onClick(View v){  // Код перехода к спискам заданий и теории
        switch (v.getId()){
            case R.id.katZadaniy:
               Intent intent = new Intent (this,MainActivity2.class);
               startActivity(intent);
               break;
            case R.id.teoriaKzadaniyam:
                Intent intent1  = new Intent(this,MainActivity3.class);
                startActivity(intent1);
                break;
                }

        }

    }

