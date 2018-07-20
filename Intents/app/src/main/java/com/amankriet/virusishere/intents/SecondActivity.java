package com.amankriet.virusishere.intents;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.widget.TextView;

public class SecondActivity extends Activity {

    TextView tv2;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        tv2=findViewById(R.id.textView2);

        tv2.setText("Explcit Intent call successful!");

    }
}
