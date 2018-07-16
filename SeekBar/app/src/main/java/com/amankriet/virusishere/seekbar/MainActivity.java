package com.amankriet.virusishere.seekbar;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    SeekBar seek;
    DatePicker date_picker;
    Button button;
    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        date_picker = findViewById(R.id.dp);
        button = findViewById(R.id.btn);
        textView = findViewById(R.id.tv);

        seek = findViewById(R.id.seekBar);
        seek.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean b) {
                Toast.makeText(getApplicationContext(), "SeekBar Progress = " + progress, Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
                Toast.makeText(getApplicationContext(), "SeekBar Started", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                Toast.makeText(getApplicationContext(), "SeekBar Stopped", Toast.LENGTH_SHORT).show();
            }
        });

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                textView.setText(getCurrentDate());
            }
        });
    }
        public String getCurrentDate()
        {
            StringBuilder builder=new StringBuilder();
            builder.append("currentDate()= ");
            builder.append(date_picker.getMonth()+1+"/");
            builder.append(date_picker.getDayOfMonth()+"/");
            builder.append(date_picker.getYear());

            return  builder.toString();
        }



    }





