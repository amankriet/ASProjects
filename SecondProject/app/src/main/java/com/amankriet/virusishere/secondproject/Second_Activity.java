package com.amankriet.virusishere.secondproject;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.widget.TextView;

public class Second_Activity extends Activity {

    TextView tv;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        tv=findViewById(R.id.login_msg);
        tv.setText("Hello User!");
    }
}
