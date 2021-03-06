package com.amankriet.virusishere.listview;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    String[] str = {"Health", "Wealth", "Wisdom", "Luck", "Strength", "Love", "Eternal Life"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ListAdapter la = new MyAdapter(this, str);

        ListView lv = findViewById(R.id.listview);

        lv.setAdapter(la);
        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {

                String optionPicked = "You selected " + String.valueOf(adapterView.getItemAtPosition(position));
                Toast.makeText(MainActivity.this, optionPicked, Toast.LENGTH_SHORT).show();

            }
        });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        switch (id)
        {
            case R.id.action_settings:
                Toast.makeText(MainActivity.this, "You clicked Settings", Toast.LENGTH_SHORT).show();
                MyDialogFragment settingsdialog = new MyDialogFragment();
                settingsdialog.setNames("Settings", "Are you done?", "settingsCancelMethod",
                        "settingsYesMethod", "setings");
                settingsdialog.show(getFragmentManager(), "ddialog");
                return true;
            case R.id.action_exit:
                Toast.makeText(MainActivity.this, "You choosed Exit", Toast.LENGTH_SHORT).show();
                MyDialogFragment exitdialog =new MyDialogFragment();
                exitdialog.setNames("Exit", "Are You Sure?", "exitCancelMethod",
                        "exitYesMethod", "exit_app");
                exitdialog.show(getFragmentManager(), "ddialog");
                return true;
                default:
                    Toast.makeText(MainActivity.this, "You choosed none", Toast.LENGTH_SHORT).show();
                    return true;
        }
    }
}
