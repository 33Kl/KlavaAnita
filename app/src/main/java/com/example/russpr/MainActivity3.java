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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);

        ex9 = (Button)findViewById(R.id.ex9);
        ex9.setOnClickListener(this);
        ex10 = (Button)findViewById(R.id.ex10);
        ex10.setOnClickListener(this);

    }
    @Override
    public void onClick(View v){
        switch (v.getId()){
            case R.id.ex9:
                Intent intent5 = new Intent (this,MainActivity5.class);
                startActivity(intent5);
                break;
            case R.id.ex10:
                Intent intent6  = new Intent(this,MainActivity5.class);
                startActivity(intent6);
                break;
        }
    }
}