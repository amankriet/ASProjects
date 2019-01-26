package com.amankriet.samplecontacts;

import android.Manifest;
import android.app.AlertDialog;
import android.app.ListActivity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MainActivity extends ListActivity {
    public static final int MULTIPLE_PERMISSIONS_CODE = 10;

    private ArrayList<String> conNames;
    private ArrayList<String> conNumbers;
    private Cursor crContacts;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        if (checkPermissionRequest()) {

            conNames = new ArrayList<>();
            conNumbers = new ArrayList<>();

            crContacts = ContactHelper.getContactCursor(getContentResolver(), "");
            crContacts.moveToFirst();

            while (!crContacts.isAfterLast()) {
                conNames.add(crContacts.getString(1));
                conNumbers.add(crContacts.getString(2));
                crContacts.moveToNext();
            }

            setListAdapter(new MyAdapter(this, android.R.layout.simple_list_item_1,
                    R.id.tvNameMain, conNames));

        }

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
            ActivityCompat.requestPermissions(this, listPermissionsNeeded.toArray(new String[listPermissionsNeeded.size()]), MULTIPLE_PERMISSIONS_CODE);
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

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater imf = getMenuInflater();
        imf.inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == R.id.item1) {
            Intent intent = new Intent(MainActivity.this, AddContact.class);
            startActivity(intent);
        } else if (item.getItemId() == R.id.item2) {
            Intent intent = new Intent(MainActivity.this, DeleteContacts.class);
            startActivity(intent);
        }
        return super.onOptionsItemSelected(item);
    }

    private void startApp() {
        Intent intent = new Intent(this, MainActivity.class);
        finish();
        startActivity(intent);
    }

    private class MyAdapter extends ArrayAdapter<String> {

        public MyAdapter(Context context, int resource, int textViewResourceId,
                         ArrayList<String> conNames) {
            super(context, resource, textViewResourceId, conNames);

        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {

            return setList(position, parent);
        }

        private View setList(int position, ViewGroup parent) {
            LayoutInflater inf = (LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE);

            assert inf != null;
            View row = inf.inflate(R.layout.liststyle, parent, false);

            TextView tvName = row.findViewById(R.id.tvNameMain);
            TextView tvNumber = row.findViewById(R.id.tvNumberMain);

            tvName.setText(conNames.get(position));
            tvNumber.setText(conNumbers.get(position));

            return row;
        }
    }

}
