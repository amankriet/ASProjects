package com.amankriet.virusishere.progressbar;

import android.app.ProgressDialog;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;

public class MainActivity extends AppCompatActivity {

    Button btn;
    ProgressDialog progressbar;
    private int progressbarstatus=0;
    private Handler progressbarHandler=new Handler();
    private long filesize=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        addListenerOnButtonClick();
    }
    public void addListenerOnButtonClick()
    {
        btn=findViewById(R.id.btn);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                progressbar=new ProgressDialog(view.getContext());
                progressbar.setCancelable(true);
                progressbar.setMessage("File Download");
                progressbar.setProgress(ProgressDialog.STYLE_SPINNER);
                progressbar.setProgress(0);
                progressbar.setMax(100);
                progressbar.show();
                progressbarstatus=0;
                filesize=0;
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        while (progressbarstatus<100)
                        {
                            progressbarstatus=doOperation();
                            try
                            {
                                Thread.sleep(2000);
                            }
                            catch (InterruptedException ie)
                            {}

                            progressbarHandler.post(new Runnable() {
                                @Override
                                public void run() {
                                    progressbar.setProgress(progressbarstatus);
                                }
                            });
                        }
                        if(progressbarstatus>=100)
                        {
                            try
                            {
                                Thread.sleep(100);
                            }
                            catch (Exception ie)
                            {}
                            progressbar.dismiss();
                        }
                    }
                }).start();
            }
        });
    }
    public int doOperation()
    {
        int temp=0;
        while (filesize <= 1000) {

            filesize++;
            if(filesize==1000)
            {
                temp=10;
            }
            if(filesize==2000)
            {
                temp=20;
            }
    /*        if(filesize==3000)
            {
                temp=30;
            }
            if(filesize==4000)
            {
                temp=40;
            }*/
        }
        return temp;
    }
}
