package com.amankriet.virusishere.listview;

import android.support.v7.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.DialogFragment;
import android.widget.Toast;

import java.util.Objects;

public class MyDialogFragment extends DialogFragment {


    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {

        AlertDialog.Builder thedialog = new AlertDialog.Builder(Objects.requireNonNull(getActivity()));
        thedialog.setTitle("Exit");
        thedialog.setMessage("Are you sure?");
        thedialog.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {

                Toast.makeText(getActivity(), "You choosed Yes", Toast.LENGTH_SHORT).show();

            }
        }).setNegativeButton("No", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {

                Toast.makeText(getActivity(), "You choosed No", Toast.LENGTH_SHORT).show();

            }
        });
        thedialog.show();
        return super.onCreateDialog(savedInstanceState);

    }
}
