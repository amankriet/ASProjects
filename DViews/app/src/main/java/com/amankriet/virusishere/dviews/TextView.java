package com.amankriet.virusishere.dviews;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;

public class TextView extends Activity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.textview);
    }
}
