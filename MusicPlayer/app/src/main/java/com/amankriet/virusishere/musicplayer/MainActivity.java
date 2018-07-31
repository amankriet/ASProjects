package com.amankriet.virusishere.musicplayer;

import android.content.Context;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    Button Vibrate, Ring, Silent, Mode;
    TextView Status;
    private AudioManager myaudiomanager;
    MediaPlayer mp1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Vibrate=findViewById(R.id.vibrate);
        Ring=findViewById(R.id.ring);
        Silent=findViewById(R.id.silent);
        Mode=findViewById(R.id.mode);
        Status=findViewById(R.id.textView);
        myaudiomanager = (AudioManager)getSystemService(Context.AUDIO_SERVICE);

    }

    public void vibrate(View view)
    {

        myaudiomanager.setRingerMode(AudioManager.RINGER_MODE_VIBRATE);

    }

    public void silent(View view)
    {
        myaudiomanager.setRingerMode(AudioManager.RINGER_MODE_SILENT);
    }

    public void ring(View view)
    {
        myaudiomanager.setRingerMode(AudioManager.RINGER_MODE_NORMAL);
    }

    public void mode(View view)
    {
        int mod = myaudiomanager.getRingerMode();
        if (mod==AudioManager.RINGER_MODE_NORMAL)
        {
            Status.setText("NORMAL");
        }
        else if (mod==AudioManager.RINGER_MODE_SILENT)
        {
            Status.setText("SILENT");
        }
        else if (mod==AudioManager.RINGER_MODE_VIBRATE)
        {
            Status.setText("VIBRATE");
        }
    }

    public void onMusicPause(View view) {
        mp1.pause();
    }

    public void onMusicPlay(View view) {
        if (mp1 == null) {
            mp1 = MediaPlayer.create(this, R.raw.dil_dooba);
            mp1.start();
        }
    }

    public void onMusicStop(View view) {
        mp1.stop();
        mp1 = null;
    }
}
