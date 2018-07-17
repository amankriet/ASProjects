package com.amankriet.virusishere.dviews;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends Activity implements View.OnClickListener {

    Button bttextview, btedittext, btbuttonview, btradiobuttonview, btcheckboxview, btimgbuttonview, bttogglebuttonview,
    btratingbarview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        bttextview=findViewById(R.id.textview);
        btedittext=findViewById(R.id.edittext);
        btbuttonview=findViewById(R.id.buttonview);
        btradiobuttonview=findViewById(R.id.radiobutton);
        btcheckboxview=findViewById(R.id.checkboxview);
        btimgbuttonview=findViewById(R.id.imagebuttonview);
        bttogglebuttonview=findViewById(R.id.togglebuttonview);
        btratingbarview=findViewById(R.id.ratingbarview);

        bttextview.setOnClickListener(this);
        btedittext.setOnClickListener(this);
        btbuttonview.setOnClickListener(this);
        btradiobuttonview.setOnClickListener(this);
        btcheckboxview.setOnClickListener(this);
        btimgbuttonview.setOnClickListener(this);
        bttogglebuttonview.setOnClickListener(this);
        btratingbarview.setOnClickListener(this);

    }

    public void onClick(View view) {

        if (view==findViewById(R.id.textview))
        {
            Intent i=new Intent(this, TextView.class);
            startActivity(i);
        }
        else if (view==findViewById(R.id.edittext))
        {
            Intent i=new Intent(this, EditText.class);
            startActivity(i);
        }
        else if (view==findViewById(R.id.buttonview))
        {
            Intent i=new Intent(this, ButtonView.class);
            startActivity(i);
        }
        else if (view==findViewById(R.id.radiobutton))
        {
            Intent i=new Intent(this, RadioButton.class);
            startActivity(i);
        }
        else if (view==findViewById(R.id.checkboxview))
        {
            Intent i=new Intent(this, CheckBoxXView.class);
            startActivity(i);
        }
        else if (view==findViewById(R.id.imagebuttonview))
        {
            Intent i=new Intent(this, ImageButtonview.class);
            startActivity(i);
        }
        else if (view==findViewById(R.id.togglebuttonview))
        {
            Intent i=new Intent(this, ToggleButtonView.class);
            startActivity(i);
        }
        else if (view==findViewById(R.id.ratingbarview))
        {
            Intent i=new Intent(this, RatingBarView.class);
            startActivity(i);
        }

    }
}
