package com.amankriet.virusishere.alertdialog;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

public class ActivityAlertYesPage extends AppCompatActivity {

    TextView tv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alert_yes_page);
        tv = findViewById(R.id.textView);
        tv.setText("You selected Yes!!");
    }
}
