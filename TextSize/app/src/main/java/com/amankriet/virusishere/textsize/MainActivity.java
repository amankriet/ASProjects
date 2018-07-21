package com.amankriet.virusishere.textsize;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.TypedValue;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    EditText txt;
    Button incr, decr;
    String str = "";
    Float txt_size = 0f;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        txt = findViewById(R.id.editText);
        incr = findViewById(R.id.incr_font);
        decr = findViewById(R.id.decr_font);

        incr.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                str = txt.getText().toString();
                txt_size = txt.getTextSize();
                float sp = txt_size / getResources().getDisplayMetrics().scaledDensity; //px/
                txt.setTextSize(TypedValue.COMPLEX_UNIT_SP, sp + 2);

            }
        });

        decr.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                txt_size = txt.getTextSize();
                float sp = txt_size / getResources().getDisplayMetrics().scaledDensity;
                txt.setTextSize(TypedValue.COMPLEX_UNIT_SP, sp - 1);

            }
        });

    }
}
