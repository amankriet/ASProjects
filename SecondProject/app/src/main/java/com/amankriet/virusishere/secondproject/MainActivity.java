package com.amankriet.virusishere.secondproject;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText uid, pswd;
    Button sv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        uid=findViewById(R.id.enter_email);
        pswd=findViewById(R.id.enter_pwd);
        sv=findViewById(R.id.save);
        sv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (uid.getText().toString().equals(""))
                {
                    Toast.makeText(MainActivity.this, "Please Enter the Email ID", Toast.LENGTH_LONG).show();
                }
                else if (pswd.getText().toString().equals(""))
                {
                    Toast.makeText(MainActivity.this, "Please Enter the Password", Toast.LENGTH_LONG).show();
                }
                else
                {
                    Toast.makeText(MainActivity.this, "Email: " + uid.getText().toString() + " Password: " + pswd.getText().toString(), Toast.LENGTH_LONG).show();
                    Intent go=new Intent(MainActivity.this,Second_Activity.class);
                    startActivity(go);
                }

            }
        });
    }
}
