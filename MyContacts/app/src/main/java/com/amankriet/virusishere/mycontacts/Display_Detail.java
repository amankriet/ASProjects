package com.amankriet.virusishere.mycontacts;

import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Display_Detail extends AppCompatActivity {
    public ArrayList<String> conNames = new ArrayList<>();
    public ArrayList<String> conNumbers = new ArrayList<>();
    public ArrayList<String> emlRecs = new ArrayList<>();
    public ArrayList<String> list = new ArrayList<>();
    int indx = 0;
    String cName = "";

    TextView tvName;
    ListView contactDetails;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display__detail);

        conNames = new ArrayList<>();
        conNumbers = new ArrayList<>();
        emlRecs = new ArrayList<>();
        tvName = findViewById(R.id.cdname);
        contactDetails = findViewById(R.id.cdlist);
        Intent intent = getIntent();

        if (isIntentAvailable(intent)) {

            Bundle extras = intent.getExtras();
            assert extras != null;
            cName = extras.getString("cName");
            conNames.addAll(Objects.requireNonNull(extras.getStringArrayList("allNames")));
            conNumbers.addAll(Objects.requireNonNull(extras.getStringArrayList("allNumbers")));
            emlRecs.addAll(Objects.requireNonNull(extras.getStringArrayList("allEmails")));
            tvName.setText(cName);
            indx = conNames.indexOf(cName);
            list.add(conNumbers.get(indx));
            list.add(emlRecs.get(indx));
            ArrayAdapter arrayAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, list);
            contactDetails.setAdapter(arrayAdapter);

        } else {
            Log.d(Display_Detail.class.getSimpleName(), "ArrayList Empty!");
        }

    }

    private boolean isIntentAvailable(Intent intent) {
        List<ResolveInfo> list = getPackageManager().queryIntentActivities(intent,
                PackageManager.MATCH_DEFAULT_ONLY);
        return list.size() > 0;
    }

}
