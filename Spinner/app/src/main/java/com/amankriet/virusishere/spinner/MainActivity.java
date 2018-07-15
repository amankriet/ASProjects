package com.amankriet.virusishere.spinner;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener{

    Spinner sp;
    String Country[]={"India", "America", "China"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        sp=findViewById(R.id.spn);
        sp.setOnItemSelectedListener(this);
        ArrayAdapter<String> aa=new ArrayAdapter<>(this,android.R.layout.simple_spinner_item, Country);
        aa.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        sp.setAdapter(aa);

    }
    public void onItemSelected(AdapterView<?>arg0, View arg1, int position, long id)
    {
        Toast.makeText(getApplicationContext(), Country[position], Toast.LENGTH_LONG).show();
    }
    public void onNothingSelected(AdapterView<?>arg0)
    {}
}
