package com.amankriet.virusishere.mycontacts;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class Display_Detail extends AppCompatActivity {
    public ArrayList<String> conNames = new ArrayList<>();
    public ArrayList<String> conNumbers = new ArrayList<>();
    public ArrayList<String> emlRecs = new ArrayList<>();

    TextView tvName;
    ListView contactDetails;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display__detail);
        MainActivity newobj = new MainActivity();

        conNames = new ArrayList<>();
        conNumbers = new ArrayList<>();
        emlRecs = new ArrayList<>();
        tvName = findViewById(R.id.cdname);
        contactDetails = findViewById(R.id.cdlist);

        String cName = getIntent().getStringExtra("cName");
        if (newobj.sendConNames() && newobj.sendConEmails() && newobj.sendConNumbers()) {

            int indx = conNames.indexOf(cName);
            tvName.setText(cName);
            ArrayList<String> list = new ArrayList<>();
            list.add(conNames.get(indx));
            list.add(emlRecs.get(indx));
            ArrayAdapter arrayAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, list);
            contactDetails.setAdapter(arrayAdapter);

        } else {
            Log.d(Display_Detail.class.getSimpleName(), "ArrayList Empty!");
        }

    }

    public boolean getConNames(ArrayList<String> getNames) {
        return this.conNames.addAll(getNames);
    }

    public boolean getConNumbers(ArrayList<String> getNumbers) {
        return this.conNumbers.addAll(getNumbers);
    }

    public boolean getConEmails(ArrayList<String> getEmails) {
        return this.emlRecs.addAll(getEmails);
    }

}
