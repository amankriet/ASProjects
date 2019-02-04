package com.amankriet.virusishere.mycontacts;

import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.database.Cursor;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Display_Detail extends AppCompatActivity {
    public ArrayList<String> conID = new ArrayList<>();
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
            conID.addAll(Objects.requireNonNull(extras.getStringArrayList("c_id")));
            Log.d(Display_Detail.class.getSimpleName(), conNames.size() + "");
            tvName.setText(cName);
            indx = conNames.indexOf(cName);
            Log.d(Display_Detail.class.getSimpleName(), indx + " indx");
            String c_id = conID.get(indx);
            getConNumbers(c_id);
            getConEmails(c_id);
            if (emlRecs.size() > 0) {
                list.addAll(conNumbers);
                list.addAll(emlRecs);
            } else {
                list.addAll(conNumbers);
            }
            ArrayAdapter arrayAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, list);
            contactDetails.setAdapter(arrayAdapter);

        } else {
            Log.d(Display_Detail.class.getSimpleName(), "ArrayList Empty!");
        }

    }

    public void getConNumbers(String c_id) {
        Cursor pcur = getApplication().getContentResolver().query(ContactsContract.CommonDataKinds.Phone.CONTENT_URI,
                null, ContactsContract.CommonDataKinds.Phone.
                        CONTACT_ID + " = ?", new String[]{c_id}, null);
        assert pcur != null;
        while (pcur.moveToNext()) {
            String number = pcur.getString(pcur.getColumnIndex(ContactsContract.CommonDataKinds.Phone.NUMBER));
            conNumbers.add(number);
        }
        pcur.close();
        for (int i = 0; i < conNumbers.size(); i++) {
            for (int j = i + 1; j < conNumbers.size(); j++) {
                if (conNumbers.get(i).equals(conNumbers.get(j))) {
                    conNumbers.remove(j);
                    j--;
                }
            }
        }
    }

    public void getConEmails(String c_id) {
        Cursor ecur = getApplication().getContentResolver().query(ContactsContract.CommonDataKinds.Email.CONTENT_URI,
                null, ContactsContract.CommonDataKinds.Email.
                        CONTACT_ID + " = ?", new String[]{c_id}, null);
        if (ecur != null) {
            while (ecur.moveToNext()) {
                String email = ecur.getString(ecur.getColumnIndex(ContactsContract.CommonDataKinds.Email.DATA));
                emlRecs.add(email);
            }
            ecur.close();
        }
        for (int i = 0; i < emlRecs.size(); i++) {
            for (int j = i + 1; j < emlRecs.size(); j++) {
                if (emlRecs.get(i).equals(emlRecs.get(j))) {
                    emlRecs.remove(j);
                    j--;
                }
            }
        }
    }

    private boolean isIntentAvailable(Intent intent) {
        List<ResolveInfo> list = getPackageManager().queryIntentActivities(intent,
                PackageManager.MATCH_DEFAULT_ONLY);
        return list.size() > 0;
    }

}
