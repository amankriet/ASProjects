package com.amankriet.virusishere.dviews;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.ImageButton;

public class ButtonView extends Activity {

    ImageButton bimgb;
    int count = 0;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.buttonview);

        bimgb = findViewById(R.id.imgb);

        bimgb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (count == 0) {
                    count = 1;
                    bimgb.setBackground(getDrawable(R.drawable.new_mario));
                } else {
                    count = 0;
                    bimgb.setBackground(getDrawable(R.drawable.mario));
                }

            }
        });

    }
}
