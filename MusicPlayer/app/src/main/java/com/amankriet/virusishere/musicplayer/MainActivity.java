package com.amankriet.virusishere.musicplayer;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    MediaPlayer mp1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
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
