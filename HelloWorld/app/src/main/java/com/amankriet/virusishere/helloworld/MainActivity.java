package com.amankriet.virusishere.helloworld;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;



public class MainActivity extends Activity {

    TextView t1;
    Button b1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        t1= findViewById(R.id.input);
        //t1.setText("Welcome ");
       b1=findViewById(R.id.button2);

    }

    public void clickhere(View view) {
        t1.setText("Welcome ");
    }
}
