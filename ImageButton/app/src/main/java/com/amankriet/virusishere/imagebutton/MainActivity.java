package com.amankriet.virusishere.imagebutton;

import android.app.Activity;
import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ToggleButton;

public class MainActivity extends Activity {

    ImageButton img;
    ToggleButton tbtn;
    TextView textview;
    AutoCompleteTextView actextview;
    String languages[]={"English", "Hindi", "Arabic", "Urdu", "Bhojpuri", "Gujrati", "Tamil", "Marathi", "French", "Italian"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ((InputMethodManager)getSystemService(Context.INPUT_METHOD_SERVICE)).toggleSoftInput(InputMethodManager.SHOW_FORCED,InputMethodManager.HIDE_IMPLICIT_ONLY);
        img=findViewById(R.id.imgb);
        tbtn=findViewById(R.id.toggleButton);
        textview=findViewById(R.id.tv);
        actextview=findViewById(R.id.actv);

        img.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Toast.makeText(getApplicationContext(), "Image Button Click", Toast.LENGTH_SHORT).show();

            }
        });

        tbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (tbtn.isChecked())
                {
                    Toast.makeText(getApplicationContext(), "Toggle Button is On", Toast.LENGTH_SHORT).show();
                }
                else
                {
                    Toast.makeText(getApplicationContext(), "Toggle Button is Off", Toast.LENGTH_SHORT).show();
                }

            }
        });

        ArrayAdapter<String> adapterview = new ArrayAdapter<>(this, android.R.layout.simple_dropdown_item_1line,languages);
        actextview.setThreshold(3);
        actextview.setAdapter(adapterview);



    }
    //@Override
    public boolean onKeydown(int keyCode, KeyEvent event)
    {
        switch(keyCode)
        {

            case KeyEvent.KEYCODE_0:
                    Toast.makeText(getApplicationContext(),"Key 0 Press",Toast.LENGTH_LONG).show();
                    break;

            case KeyEvent.KEYCODE_1:
                Toast.makeText(getApplicationContext(),"Key 1 Press",Toast.LENGTH_LONG).show();
                break;
            case KeyEvent.KEYCODE_2:
                Toast.makeText(getApplicationContext(),"Key 2 Press",Toast.LENGTH_LONG).show();
                break;
        }
        return  false;
    }
}
