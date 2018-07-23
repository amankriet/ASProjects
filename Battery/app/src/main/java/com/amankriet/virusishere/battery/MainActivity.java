package com.amankriet.virusishere.battery;

import android.content.Intent;
import android.content.IntentFilter;
import android.os.BatteryManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    Button check;
    ImageButton imgbtn;
    private BatteryManager battery;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        imgbtn=findViewById(R.id.imgbutton);
        check =findViewById(R.id.button);
        check.setOnClickListener(this);
        imgbtn.setOnClickListener(this);

    }

    @Override
    public void onClick(View view)
    {
        IntentFilter ifilter = new IntentFilter(Intent.ACTION_BATTERY_CHANGED);
        Intent batteryStatus = registerReceiver(null, ifilter);
        int status = batteryStatus.getIntExtra(BatteryManager.EXTRA_STATUS, -1);
        boolean isCharging = false;
        if (status == BatteryManager.BATTERY_STATUS_CHARGING)
        {
            isCharging = status == BatteryManager.BATTERY_STATUS_CHARGING;
        }
        else if (status == BatteryManager.BATTERY_STATUS_FULL)
        {
            isCharging = status == BatteryManager.BATTERY_STATUS_FULL;
        }
        int chargePlug = batteryStatus.getIntExtra(BatteryManager.EXTRA_PLUGGED, -1);
        boolean usbCharger = chargePlug == BatteryManager.BATTERY_PLUGGED_USB;

        if (isCharging)
        {
            if (usbCharger)
            {
                Toast.makeText(MainActivity.this, "Mobile is connected to USB charging", Toast.LENGTH_SHORT).show();
            }
            else
            {
                Toast.makeText(MainActivity.this, "Mobile is connected to AC charging", Toast.LENGTH_SHORT).show();
            }
        }
        else
        {
            Toast.makeText(MainActivity.this, "Mobile is not connected and discharging", Toast.LENGTH_SHORT).show();
        }
    }

}
