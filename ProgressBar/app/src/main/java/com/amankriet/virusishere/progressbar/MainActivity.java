package com.amankriet.virusishere.progressbar;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;

public class MainActivity extends AppCompatActivity {

    int progress=0;
    Button btn;
    ProgressBar pbar, hpbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn=findViewById(R.id.btn);
        pbar=findViewById(R.id.progressBar);
        hpbar=findViewById(R.id.progressBar2);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                pbar.setVisibility(View.VISIBLE);
                setProgressValue(progress);

            }
        });
    }

    private void setProgressValue(final int progress)
    {
        hpbar.setProgress(progress);
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {

                try
                {
                    Thread.sleep(1000);
                }
                catch (InterruptedException e)
                {
                    e.printStackTrace();
                }

                setProgressValue(progress + 10);

            }
        });

        thread.start();

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.action_settings)
        {
            return true;
        }

        return super.onOptionsItemSelected(item);

    }
}