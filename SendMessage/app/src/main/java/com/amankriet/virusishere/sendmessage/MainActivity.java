package com.amankriet.virusishere.sendmessage;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Button sendb;
    EditText mob_num, message;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        sendb = findViewById(R.id.bsend);
        mob_num = findViewById(R.id.etmob_num);
        message = findViewById(R.id.etmessage);

        sendb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                sendMessage();

            }
        });

    }

    protected void sendMessage() {
        Log.i("hint", "Send Message");
        String phone_num = String.format("smsto: %s",
                mob_num.getText().toString());
        String msg = message.getText().toString();
        try {
            Intent smsIntent = new Intent(Intent.ACTION_SENDTO);
            smsIntent.setData(Uri.parse(phone_num));
            smsIntent.putExtra("sms_body", msg);
            if (smsIntent.resolveActivity(getPackageManager()) != null) {
                startActivity(smsIntent);
            } else {
                Log.d("else", "Can't resolve app for ACTION_SENDTO Intent");
            }
        } catch (Exception e) {
            Toast.makeText(getApplicationContext(), "Message failed try again!", Toast.LENGTH_SHORT).show();
        }
    }

}
