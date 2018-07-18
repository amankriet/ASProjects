package com.amankriet.virusishere.dviews;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.Toast;

public class CheckBoxXView extends Activity {

    CheckBox chkbx1, chkbx2, chkbx3;
    Button btn;
    String str = "";
    StringBuilder sb = new StringBuilder("");

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.checkboxviewe);

        chkbx1 = findViewById(R.id.aman);
        chkbx2 = findViewById(R.id.abhishek);
        chkbx3 = findViewById(R.id.raj_sir);
        btn = findViewById(R.id.chkbtn);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (chkbx1.isChecked()) {
                    sb.append(chkbx1.getText().toString());
                    if (chkbx2.isChecked()) {
                        sb.append(" and " + chkbx2.getText().toString());
                        if (chkbx3.isChecked()) {
                            sb.delete(sb.indexOf("and") - 1, sb.indexOf("and") + 3);
                            sb.insert(sb.indexOf(chkbx1.getText().toString()) + 4, ",");
                            sb.append(" and " + chkbx3.getText().toString() + " are UPTEC teacher and students!");
                            str = sb.toString();
                        } else {
                            sb.append(" are UPTEC students!");
                            str = sb.toString();
                        }
                    } else if (chkbx3.isChecked()) {
                        sb.append(" and " + chkbx3.getText().toString() + " are UPTEC teacher and students!");
                        str = sb.toString();
                    } else {
                        sb.append(" is a UPTEC student!");
                        str = sb.toString();
                    }
                } else if (chkbx2.isChecked()) {
                    sb.append(chkbx2.getText().toString());
                    if (chkbx3.isChecked()) {
                        sb.append(" and " + chkbx3.getText().toString() + " are UPTEC teacher and students!");
                        str = sb.toString();
                    } else {
                        sb.append(" is a UPTEC student!");
                        str = sb.toString();
                    }
                } else if (chkbx3.isChecked()) {
                    sb.append(chkbx3.getText().toString() + " is a UPTEC teacher!");
                    str = sb.toString();
                } else {
                    str = "Nothing Selected!";
                }
                Toast.makeText(getApplicationContext(), str, Toast.LENGTH_SHORT).show();
                str = "";
                sb.replace(0, sb.length(), "");

            }
        });

    }
}
