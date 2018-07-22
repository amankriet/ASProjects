package com.amankriet.virusishere.sendmessage;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.telephony.SmsManager;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = MainActivity.class.getSimpleName();
    private static final int MY_PERMISSIONS_REQUEST_SEND_SMS = 1;
    Button sendb;
    ImageButton send_smsib;
    EditText mob_num, message;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        checkForSmsPermission();

        sendb = findViewById(R.id.bsend);
        send_smsib = findViewById(R.id.ibsend_sms);
        mob_num = findViewById(R.id.etmob_num);
        message = findViewById(R.id.etmessage);

        sendb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                sendMessage();

            }
        });

        send_smsib.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                sendSMS();

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
                Log.d(TAG, "Can't resolve app for ACTION_SENDTO Intent");
            }
        } catch (Exception e) {
            Toast.makeText(getApplicationContext(), "Message failed try again!",
                    Toast.LENGTH_SHORT).show();
        }
    }

    protected void sendSMS() {
        try {
            Log.i("hint", "Send in app Message");
            String smsMessage = message.getText().toString();
            String dest_addr = mob_num.getText().toString();
            SmsManager smsManager = SmsManager.getDefault();
            smsManager.sendTextMessage(dest_addr, null, smsMessage, null, null);
            Toast.makeText(getApplicationContext(), getString(R.string.sms_sent), Toast.LENGTH_SHORT).show();
        } catch (Exception e) {
            Toast.makeText(getApplicationContext(), getString(R.string.sms_not_sent), Toast.LENGTH_SHORT).show();
        }
    }

    private void checkForSmsPermission() {
        if (ActivityCompat.checkSelfPermission(this,
                Manifest.permission.SEND_SMS) !=
                PackageManager.PERMISSION_GRANTED) {
            Log.d(TAG, getString(R.string.permission_not_granted));
            ActivityCompat.requestPermissions(this,
                    new String[]{Manifest.permission.SEND_SMS}, MY_PERMISSIONS_REQUEST_SEND_SMS);
        } else {
            enableSmsButton();
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode,
                                           @NonNull String permissions[], @NonNull int[] grantResults) {
        switch (requestCode) {
            case MY_PERMISSIONS_REQUEST_SEND_SMS: {
                if (permissions[0].equalsIgnoreCase
                        (Manifest.permission.SEND_SMS)
                        && grantResults[0] ==
                        PackageManager.PERMISSION_GRANTED) {
                    enableSmsButton();
                } else {
                    Log.d(TAG, getString(R.string.failure_permission));
                    Toast.makeText(this, getString(R.string.failure_permission),
                            Toast.LENGTH_LONG).show();
                    disableSmsButton();
                }
            }
        }
    }

    private void disableSmsButton() {
        Toast.makeText(this, "SMS usage disabled", Toast.LENGTH_SHORT).show();
        ImageButton smsButton = findViewById(R.id.ibsend_sms);
        smsButton.setVisibility(View.INVISIBLE);
        Button retryButton = findViewById(R.id.bretry);
        retryButton.setVisibility(View.VISIBLE);
    }

    private void enableSmsButton() {
        ImageButton smsButton = findViewById(R.id.ibsend_sms);
        smsButton.setVisibility(View.VISIBLE);
    }

    public void retryApp(View view) {
        Intent intent = getPackageManager().getLaunchIntentForPackage(getPackageName());
        startActivity(intent);
    }

}
