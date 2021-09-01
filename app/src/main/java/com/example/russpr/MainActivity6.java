package com.example.russpr;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;

public class MainActivity6 extends AppCompatActivity {

    private ImageView view_1;
    private ImageView view_2;
    private ImageView view_3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main6);

        view_1 = (ImageView)findViewById(R.id.view_1);
        view_2 = (ImageView)findViewById(R.id.view_2);
        view_3 = (ImageView)findViewById(R.id.view_3);
    }
}