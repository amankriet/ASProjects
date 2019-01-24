package com.amankriet.virusishere.sendmessage;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.telephony.PhoneStateListener;
import android.telephony.SmsManager;
import android.telephony.TelephonyManager;
import android.text.method.ScrollingMovementMethod;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private static MainActivity ins;
    private MyPhoneCallListener mListener;
    private static final String TAG = MainActivity.class.getSimpleName();
    private static final int MY_PERMISSIONS_REQUEST_SEND_SMS = 1;
    private static final int MY_PERMISSIONS_REQUEST_CALL_PHONE = 2;
    int phone_permission=10;
    Button sendb;
    ImageButton send_smsib;
    EditText mob_num, message;
    TelephonyManager mTelephonyManager;
    public TextView recieved_sms;

    public static MainActivity getInstace() {
        return ins;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        checkForSmsPermission();
        ins = this;
        sendb = findViewById(R.id.bsend);
        send_smsib = findViewById(R.id.ibsend_sms);
        mob_num = findViewById(R.id.etmob_num);
        message = findViewById(R.id.etmessage);
        recieved_sms = findViewById(R.id.tv_recieve_sms);

        mTelephonyManager = (TelephonyManager) getSystemService(TELEPHONY_SERVICE);

        if (isTelephonyEnabled()) {
            Log.d(TAG, "Telephony enabled");
            mListener = new MyPhoneCallListener();
            mTelephonyManager.listen(mListener,
                    PhoneStateListener.LISTEN_CALL_STATE);
            checkForPhonePermission();
        } else {
            Toast.makeText(this,
                    "Telephony not enabled",
                    Toast.LENGTH_SHORT).show();
            Log.d(TAG, "Telephony not enabled");
            // Disable the call button.
            disableCallButton();
        }

        recieved_sms.setMovementMethod(new ScrollingMovementMethod());

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

    public void updateTheTextView(final String t) {

        MainActivity.this.runOnUiThread(new Runnable() {
            @Override
            public void run() {
                recieved_sms.append("\n" + t);
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
                message.setText("");
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
            recieved_sms.append("\nTo " + dest_addr + ": " + smsMessage);
            message.setText("");
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
            case 10: {
                if (permissions[0].equalsIgnoreCase
                        (Manifest.permission.CALL_PHONE)
                        && grantResults[0] ==
                        PackageManager.PERMISSION_GRANTED) {
                    // Permission was granted.
                    Log.d(TAG, "Permission Granted");
                    Toast.makeText(this, "Permission Granted", Toast.LENGTH_SHORT).show();
                    phone_permission=1;

                } else {
                    // Permission denied. Stop the app.
                    Log.d(TAG, getString(R.string.failure_permission));
                    Toast.makeText(this, getString(R.string.failure_permission),
                            Toast.LENGTH_SHORT).show();
                    phone_permission=10;
                    // Disable the call button
                    disableCallButton();
                }
            }
        }
    }

    private void disableSmsButton() {
        Toast.makeText(this, "SMS usage disabled", Toast.LENGTH_SHORT).show();
        ImageButton smsButton = findViewById(R.id.ibsend_sms);
        smsButton.setVisibility(View.GONE);
        Button retryButton = findViewById(R.id.bretry);
        retryButton.setVisibility(View.VISIBLE);
        Button sb = findViewById(R.id.bsend);
        sb.setVisibility(View.GONE);
    }

    private void enableSmsButton() {
        ImageButton smsButton = findViewById(R.id.ibsend_sms);
        smsButton.setVisibility(View.VISIBLE);
        Button sb = findViewById(R.id.bsend);
        sb.setVisibility(View.VISIBLE);
    }

    public void retryApp(View view) {
        ActivityCompat.requestPermissions(this,
                new String[]{Manifest.permission.SEND_SMS}, MY_PERMISSIONS_REQUEST_SEND_SMS);
    }

    private boolean isTelephonyEnabled() {
        if (mTelephonyManager != null) {
            if (mTelephonyManager.getSimState() ==
                    TelephonyManager.SIM_STATE_READY) {
                return true;
            }
        }
        return false;
    }

    private void checkForPhonePermission() {
        if (ActivityCompat.checkSelfPermission(this,
                Manifest.permission.CALL_PHONE) !=
                PackageManager.PERMISSION_GRANTED) {
            Log.d(TAG, getString(R.string.permission_not_granted));
            phone_permission=10;
            ActivityCompat.requestPermissions(this,
                    new String[]{Manifest.permission.CALL_PHONE},
                    MY_PERMISSIONS_REQUEST_CALL_PHONE);
        } else {
            // Permission already granted.
            //enableCallButton();
            phone_permission=1;
        }
    }

        public void calling (View view){
            Intent call = new Intent(Intent.ACTION_CALL);
            String phoneNumber = String.format("tel: %s",
                    mob_num.getText().toString());
            call.setData(Uri.parse(phoneNumber));
            if (call.resolveActivity(getPackageManager()) != null) {
                checkForPhonePermission();
                startActivity(call);
            } else {
                Log.e(TAG, "Can't resolve app for ACTION_CALL Intent.");
            }
        }

    private void disableCallButton() {
        Toast.makeText(this, "Call usage disabled", Toast.LENGTH_SHORT).show();
        ImageButton ibcall = findViewById(R.id.bcall);
        ibcall.setVisibility(View.GONE);
        Button retryButton = findViewById(R.id.bretry);
        retryButton.setVisibility(View.VISIBLE);
        Button sb = findViewById(R.id.bsend);
        sb.setVisibility(View.GONE);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (isTelephonyEnabled()) {

            mTelephonyManager.listen(mListener,
                    PhoneStateListener.LISTEN_NONE);
        }
    }

}
