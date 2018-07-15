package com.amankriet.virusishere.firstproject;


import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;



public class MainActivity extends AppCompatActivity {

    EditText e1,e2;
    TextView tv;
    Button b1,b2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        e1=findViewById(R.id.first);
        e2=findViewById(R.id.second);
        tv=findViewById(R.id.result);
        b1=findViewById(R.id.add);
        b2=findViewById(R.id.swap);
        Toast.makeText(MainActivity.this,"Welcome In My App",Toast.LENGTH_SHORT).show();
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int a,b,c;

                 if(e1.getText().toString().equals("") )
                 {

                     Toast.makeText(MainActivity.this,"Please Enter First Number",Toast.LENGTH_SHORT).show();
                 }
                 else if (e2.getText().toString().equals(""))
                 {

                     Toast.makeText(MainActivity.this,"Please Enter Second Number",Toast.LENGTH_SHORT).show();
                 }
                 else
                 {

                     a=Integer.parseInt(e1.getText().toString());
                     b=Integer.parseInt(e2.getText().toString());
                     c=a+b;
                     tv.setText("Add= "+c);

                 }


            }
        }); //First Button Action


        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int a, b;
                if(e1.getText().toString().equals("") )
                {

                    Toast.makeText(MainActivity.this,"Please Enter First Number",Toast.LENGTH_SHORT).show();
                }
                else if (e2.getText().toString().equals(""))
                {

                    Toast.makeText(MainActivity.this,"Please Enter Second Number",Toast.LENGTH_SHORT).show();
                }
                else {
                    a = Integer.parseInt(e1.getText().toString());
                    b = Integer.parseInt(e2.getText().toString());
                    e1.setText(String.valueOf(b));
                    e2.setText(String.valueOf(a));
                }
            }
        });

    }// onCreate Method
}//Main Class
