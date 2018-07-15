package com.amankriet.virusishere.fourthproject;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Button btn;
    RadioButton rb;
    RadioGroup rgb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn=findViewById(R.id.click);
        rgb=findViewById(R.id.rg);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int selectid=rgb.getCheckedRadioButtonId();
                rb=findViewById(selectid);
                if(selectid==-1)
                {
                    Toast.makeText(getApplicationContext(),"Nothing Select ",Toast.LENGTH_LONG).show();
               }
               else
                {
                    Toast.makeText(getApplicationContext(),"Selected Value is  "+rb.getText().toString(),Toast.LENGTH_LONG).show();
                }
            }
        });
    }
}
