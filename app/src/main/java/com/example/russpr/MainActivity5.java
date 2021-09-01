package com.example.russpr;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;

public class MainActivity5 extends AppCompatActivity {

    private ImageView picture_1;
    private ImageView picture_2;
    private ImageView picture_3;
    private ImageView picture_4;
    private ImageView picture_5;
    private ImageView picture_6;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main5);

        picture_1 = (ImageView)findViewById(R.id.picture_1);
        picture_2 = (ImageView)findViewById(R.id.picture_2);
        picture_3 = (ImageView)findViewById(R.id.picture_3);
        picture_4 = (ImageView)findViewById(R.id.picture_4);
        picture_5 = (ImageView)findViewById(R.id.picture_5);
        picture_6 = (ImageView)findViewById(R.id.picture_6);

    }
}