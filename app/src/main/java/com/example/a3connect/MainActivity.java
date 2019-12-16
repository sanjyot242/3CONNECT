package com.example.a3connect;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    int counter=1;

    public void check(View view) {
        if ((counter % 2) == 0) {
            dropInX(view);
        } else {
            dropInY(view);
        }
    }


    public void dropInX(View view){
        ImageView imageView= (ImageView) view;
        imageView.setTranslationY((-1500));
        imageView.setImageResource(R.drawable.zero);
        imageView.animate().translationYBy(1500).rotation(3600).setDuration(300);
        counter++;
    }

    public void dropInY(View view){
        ImageView imageView= (ImageView) view;
        imageView.setTranslationY((-1500));
        imageView.setImageResource(R.drawable.cross);
        imageView.animate().translationYBy(1500).rotation(3600).setDuration(300);
        counter++;
    }



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}
