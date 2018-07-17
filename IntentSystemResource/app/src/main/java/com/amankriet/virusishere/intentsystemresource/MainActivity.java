package com.amankriet.virusishere.intentsystemresource;

import android.app.Activity;
import android.content.Intent;
import android.media.MediaRecorder;
import android.net.Uri;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

public class MainActivity extends Activity {

    Button b1, b2;
    ImageButton bi1, bi2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        b1=findViewById(R.id.bdial);
        b2=findViewById(R.id.bshowbrowser);
        bi1=findViewById(R.id.bimg);
        bi2=findViewById(R.id.bvid);

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

        bi1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent i=new Intent(MediaStore.ACTION_IMAGE_CAPTURE_SECURE);
                startActivity(i);

            }
        });

        bi2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent i=new Intent(MediaStore.ACTION_VIDEO_CAPTURE);
                startActivity(i);

            }
        });

    }
}
