package com.amankriet.samplecontacts;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class AddContact extends Activity implements OnClickListener {

    private EditText edtContactName, edtContactNumber;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.addcontact);

        edtContactName = findViewById(R.id.edtContactName);
        edtContactNumber = findViewById(R.id.edtContactNumber);

        Button btnAddContact = findViewById(R.id.btnAddContact);
        Button btnCancel = findViewById(R.id.btnCancel);

        btnAddContact.setOnClickListener(this);
        btnCancel.setOnClickListener(this);

    }

    public void onClick(View v) {

        Intent intent = new Intent(this, MainActivity.class);
        if (v.getId() == R.id.btnAddContact) {
            if (edtContactName.getText().toString().equals("")
                    && edtContactNumber.getText().toString().equals("")) {
                Toast.makeText(this, "Please fill name and number fields...",
                        Toast.LENGTH_SHORT).show();
            } else if (ContactHelper.insertContact(getContentResolver(),
                    edtContactName.getText().toString(), edtContactNumber
                            .getText().toString())) {
                edtContactName.setText("");
                edtContactNumber.setText("");

                startActivity(intent);
            }

        } else if (v.getId() == R.id.btnCancel) {
            startActivity(intent);
        }

    }
}
