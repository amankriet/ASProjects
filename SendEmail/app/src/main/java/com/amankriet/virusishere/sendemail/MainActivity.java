package com.amankriet.virusishere.sendemail;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends Activity {

    Button sendmail;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        sendmail=findViewById(R.id.send);
        sendmail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                sendEmail();

            }
        });

    }

    public void sendEmail()
    {
        String[] To = {"rcpandey.edu@gmail.com"};
        String[] Cc = {"rajpandey.vns@gmail.com"};
        Intent emailIntent = new Intent(Intent.ACTION_SEND);
        emailIntent.setData(Uri.parse("mail to:"));
        emailIntent.setType("Text/Plain");
        emailIntent.putExtra(Intent.EXTRA_EMAIL, To);
        emailIntent.putExtra(Intent.EXTRA_CC, Cc);
        emailIntent.putExtra(Intent.EXTRA_SUBJECT, "Your Subject:");
        emailIntent.putExtra(Intent.EXTRA_TEXT, "Email message goes here");

        try
        {
            startActivity(Intent.createChooser(emailIntent, "Sending mail..."));
            finish();
            Log.i("Final Message","Finished sending message");
        }
        catch (Exception e)
        {
            Toast.makeText(getApplicationContext(), "There is no mail", Toast.LENGTH_SHORT).show();
        }
    }

}
