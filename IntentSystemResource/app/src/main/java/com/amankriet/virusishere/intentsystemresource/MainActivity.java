package com.amankriet.virusishere.intentsystemresource;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends Activity {

    Button b1, b2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        b1=findViewById(R.id.bdial);
        b2=findViewById(R.id.bshowbrowser);

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent i=new Intent(Intent.ACTION_DIAL, Uri.parse("tel:7897772709"));
                startActivity(i);

            }
        });

        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent i=new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.google.co.in"));
                startActivity(i);

            }
        });

    }
}
