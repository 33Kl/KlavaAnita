package com.example.russpr; // Теория

import androidx.appcompat.app.AppCompatActivity;


import android.os.Bundle;
import android.widget.ImageView;


public class MainActivity4 extends AppCompatActivity {

    private ImageView photo_1;
    private ImageView photo_2;
    private ImageView photo_3;
    private ImageView photo_4;




    @Override
    protected void onCreate(Bundle savedInstanceState) { // Здесь прописаны картинки табличек с теорией
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main4);

        photo_1 = (ImageView)findViewById(R.id.photo_1);
        photo_2 = (ImageView)findViewById(R.id.photo_2);
        photo_3 = (ImageView)findViewById(R.id.photo_3);
        photo_4 = (ImageView)findViewById(R.id.photo_4);





    }
    
}