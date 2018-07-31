package com.amankriet.virusishere.slideshow;

import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    ViewPager viewpager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        viewpager=findViewById(R.id.viewpage);
        ImageAdapter adapter = new ImageAdapter(this);
        viewpager.setAdapter(adapter);
    }
}
