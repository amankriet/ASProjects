package com.amankriet.virusishere.mycontacts;

import android.Manifest;
import android.app.AlertDialog;
import android.content.ContentResolver;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;

public class MainActivity extends AppCompatActivity {
    public static final int MULTIPLE_PERMISSIONS_CODE = 10;

    public ArrayList<String> conNames = new ArrayList<>();
    public ArrayList<String> conID = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if (checkPermissionRequest()) {
            Log.d(MainActivity.class.getSimpleName(), "Permission check complete");

            getNameEmailDetails();
            ArrayAdapter arrayadapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, conNames);
            final ListView obj = findViewById(R.id.contactlist);
            obj.setAdapter(arrayadapter);

            obj.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

                    Intent intent = new Intent(getApplicationContext(), Display_Detail.class);
                    intent.putExtra("cName", obj.getItemAtPosition(i).toString().trim());
                    intent.putExtra("allNames", conNames);
                    intent.putExtra("c_id", conID);
                    startActivity(intent);

                }
            });
        }
    }

    public void getNameEmailDetails() {
        HashSet<String> nameRecHS = new HashSet<>();
        Context context = MainActivity.this;
        ContentResolver cr = context.getContentResolver();
        Cursor cur = cr.query(ContactsContract.Contacts.CONTENT_URI, null, null,
                null, ContactsContract.Contacts.DISPLAY_NAME + " ASC");

        assert cur != null;
        if (cur.getCount() > 0) {
            while (cur.moveToNext()) {
                String c_id = cur.getString(cur.getColumnIndex(ContactsContract.Contacts._ID));
                String name = cur.getString(cur.getColumnIndex(ContactsContract.Contacts.DISPLAY_NAME));
                if (nameRecHS.add(name)) {
                    conNames.add(name);
                    conID.add(c_id);
                }
            }
        }

        cur.close();

    }

    private boolean checkPermissionRequest() {
        int permissionReadContacts = ContextCompat.checkSelfPermission(this, Manifest.permission.READ_CONTACTS);
        int permissionWriteContacts = ContextCompat.checkSelfPermission(this, Manifest.permission.WRITE_CONTACTS);

        List<String> listPermissionsNeeded = new ArrayList<>();

        if (permissionReadContacts != PackageManager.PERMISSION_GRANTED) {
            listPermissionsNeeded.add(Manifest.permission.READ_CONTACTS);
        }
        if (permissionWriteContacts != PackageManager.PERMISSION_GRANTED) {
            listPermissionsNeeded.add(Manifest.permission.WRITE_CONTACTS);
        }
        if (!listPermissionsNeeded.isEmpty()) {
            ActivityCompat.requestPermissions(this, listPermissionsNeeded.toArray(new String[0]), MULTIPLE_PERMISSIONS_CODE);
            return false;
        }
        return true;
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        switch (requestCode) {
            case MULTIPLE_PERMISSIONS_CODE: {

                Map<String, Integer> perms = new HashMap<>();
                if (grantResults.length > 0) {
                    for (int i = 0; i < permissions.length; i++) {
                        perms.put(permissions[i], grantResults[i]);
                    }
                    //noinspection ConstantConditions
                    if (perms.get(Manifest.permission.READ_CONTACTS) == PackageManager.PERMISSION_GRANTED
                            && perms.get(Manifest.permission.WRITE_CONTACTS) == PackageManager.PERMISSION_GRANTED) {
                        Log.d(MainActivity.class.getSimpleName(), "Contacts Access Granted!");
                        startApp();
                    } else {
                        if (ActivityCompat.shouldShowRequestPermissionRationale(this,
                                Manifest.permission.READ_CONTACTS) || ActivityCompat.
                                shouldShowRequestPermissionRationale(this, Manifest.permission.WRITE_CONTACTS)) {
                            new AlertDialog.Builder(this).setTitle("Permission Required").setMessage
                                    ("Read and write access to contacts is required to manage contacts!").
                                    setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                                        @Override
                                        public void onClick(DialogInterface dialogInterface, int i) {
                                            checkPermissionRequest();
                                        }
                                    }).setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialogInterface, int i) {
                                    dialogInterface.dismiss();
                                }
                            }).create().show();
                        } else {
                            Toast.makeText(this, "Go to settings and enable permissions", Toast.LENGTH_LONG).show();
                        }
                    }
                }
            }
        }
    }

    private void startApp() {
        Intent intent = new Intent(this, MainActivity.class);
        finish();
        startActivity(intent);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.cdmenu, menu);
        return super.onCreateOptionsMenu(menu);
    }

}