package com.amankriet.virusishere.userdatabaase;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    public final static String EXTRA_MESSAGE="com.amankriet.virusishere.userdatabaase.MESSAGE";
    private ListView obj;
    DBHelper mydb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mydb=new DBHelper(this);
        ArrayList array_list = mydb.getAllContacts();
        ArrayAdapter arrayadapter = new ArrayAdapter(this,android.R.layout.simple_list_item_1,array_list);
        obj=findViewById(R.id.listview1);
        obj.setAdapter(arrayadapter);

        obj.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View arg1, int arg2, long arg3) {

                int id_To_Search = arg2+1;
                Bundle databundle = new Bundle();
                databundle.putInt("id",id_To_Search);

                Intent intent = new Intent(getApplicationContext(),DisplayDetail.class);
                intent.putExtras(databundle);
                startActivity(intent);

            }
        });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        super.onOptionsItemSelected(item);
        switch (item.getItemId())
        {
            case R.id.item1:
                Bundle databundle = new Bundle();
                databundle.putInt("id",0);
                Intent intent = new Intent(getApplicationContext(), com.amankriet.virusishere.userdatabaase.DisplayDetail.class);
                intent.putExtras(databundle);
                startActivity(intent);
                return true;

                default:
                    return onOptionsItemSelected(item);
        }

    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK)
        {
            moveTaskToBack(true);
        }
        return super.onKeyDown(keyCode, event);
    }
}
