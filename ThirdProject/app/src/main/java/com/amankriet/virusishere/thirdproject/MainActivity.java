package com.amankriet.virusishere.thirdproject;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    CheckBox c1, c2, c3;
    Button b1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        c1=findViewById(R.id.iapple);
        c2=findViewById(R.id.iorange);
        c3=findViewById(R.id.igrapes);
        b1=findViewById(R.id.ibutton);

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                 StringBuilder list=new StringBuilder();
                 int total=0;

                if (c1.isChecked())
                {
                    list.append("Apple=Rs.120/Kg; ");
                    total=total+120;
                }
                if (c2.isChecked())
                {
                    list.append("Orange=Rs.50/Kg; ");
                    total=total+50;
                }
                if (c3.isChecked())
                {
                    list.append("Grapes=Rs.40/Kg; ");
                    total=total+40;
                }
                list.append("Total amount is "+total);
                Toast.makeText(getApplicationContext(),list.toString(),Toast.LENGTH_LONG).show();

            }
        });

    }
}
