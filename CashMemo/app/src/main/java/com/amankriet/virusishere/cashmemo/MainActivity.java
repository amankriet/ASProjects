package com.amankriet.virusishere.cashmemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    EditText qty;
    TextView rate, total_amt;
    Button calc, reset;
    Double x, amt;
    String str;
    String name[]={"Parle G", "Tea", "Lays", "Maaza", "Kurkure", "Sprite"};
    Spinner sp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        qty=findViewById(R.id.iqty);
        rate=findViewById(R.id.irate);
        total_amt=findViewById(R.id.itotal_amt);
        calc=findViewById(R.id.icalc);
        reset=findViewById(R.id.ireset);
        sp=findViewById(R.id.iname);
        sp.setOnItemSelectedListener(this);
        final ArrayAdapter<String> aa=new ArrayAdapter<>(this,android.R.layout.simple_spinner_item, name);
        aa.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        sp.setAdapter(aa);

        calc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (str.equals("Parle G"))
                {
                    rate.setText("2 Rupees each");
                    if (qty.getText().toString().equals(""))
                    {
                        x=1.0;
                        qty.setText("1");
                    }
                    else
                    {
                        x=Double.parseDouble(qty.getText().toString());
                    }
                    amt=2*x;
                    total_amt.setText(amt+" Rupees Only/-");
                }
                else if (str.equals("Tea"))
                {
                    rate.setText("5 Rupees each");
                    if (qty.getText().toString().equals(""))
                    {
                        x=1.0;
                        qty.setText("1");
                    }
                    else
                    {
                        x=Double.parseDouble(qty.getText().toString());
                    }
                    amt=5*x;
                    total_amt.setText(amt+" Rupees Only/-");
                }
                else if (str.equals("Lays"))
                {
                    rate.setText("10 Rupees each");
                    if (qty.getText().toString().equals(""))
                    {
                        x=1.0;
                        qty.setText("1");
                    }
                    else
                    {
                        x=Double.parseDouble(qty.getText().toString());
                    }
                    amt=10*x;
                    total_amt.setText(amt+" Rupees Only/-");
                }
                else if (str.equals("Kurkure"))
                {
                    rate.setText("10 Rupees each");
                    if (qty.getText().toString().equals(""))
                    {
                        x=1.0;
                        qty.setText("1");
                    }
                    else
                    {
                        x=Double.parseDouble(qty.getText().toString());
                    }
                    amt=10*x;
                    total_amt.setText(amt+" Rupees Only/-");
                }
                else if (str.equals("Maaza"))
                {
                    rate.setText("12 Rupees each");
                    if (qty.getText().toString().equals(""))
                    {
                        x=1.0;
                        qty.setText("1");
                    }
                    else
                    {
                        x=Double.parseDouble(qty.getText().toString());
                    }
                    amt=12*x;
                    total_amt.setText(amt+" Rupees Only/-");
                }
                else if (str.equals("Sprite"))
                {
                    rate.setText("12 Rupees each");
                    if (qty.getText().toString().equals(""))
                    {
                        x=1.0;
                        qty.setText("1");
                    }
                    else
                    {
                        x=Double.parseDouble(qty.getText().toString());
                    }
                    amt=12*x;
                    total_amt.setText(amt+" Rupees Only/-");
                }

            }
        });

        reset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                sp.setAdapter(aa);
                qty.setText("");
                rate.setText("");
                total_amt.setText("");

            }
        });

    }
    public void onItemSelected(AdapterView<?>arg0, View arg1, int position, long id)
    {
        str=name[position];
    }
    public void onNothingSelected(AdapterView<?>arg0)
    {}
}
