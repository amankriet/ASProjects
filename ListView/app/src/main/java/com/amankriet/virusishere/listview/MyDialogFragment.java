package com.amankriet.virusishere.listview;

import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.app.DialogFragment;
import android.app.AlertDialog;
import android.widget.Toast;
import java.util.Objects;

public class MyDialogFragment extends DialogFragment {

    String dtitle, dmsg, dcancelmethod, dyesmethod;

    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {
        AlertDialog.Builder ddialog = new AlertDialog.Builder(Objects.requireNonNull(getActivity()));
        ddialog.setTitle(dtitle);
        ddialog.setMessage(dmsg);
        ddialog.setNegativeButton("No", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {

                if (dcancelmethod.equals("exitCancelMethod"))
                {
                    exitCancelMethod();
                }
                else
                {
                    settingsCancelMethod();
                }

            }
        }).setPositiveButton("Yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {

                if (dyesmethod.equals("exitYesMethod"))
                {
                    exitYesMethod();
                }
                else
                {
                    settingsYesMethod();
                }

            }
        });
        return ddialog.show();
    }

    public void setNames(String dtitle, String dmsg, final String dcancelmethod, final String dyesmethod)
    {
        this.dtitle = dtitle;
        this.dmsg=dmsg;
        this.dcancelmethod=dcancelmethod;
        this.dyesmethod=dyesmethod;
    }

    private void exitYesMethod()
    {
        Toast.makeText(getContext(), "You clicked Yes", Toast.LENGTH_SHORT).show();
        getActivity().finish();
    }

    private void exitCancelMethod()
    {
        Toast.makeText(getContext(), "You clicked No", Toast.LENGTH_SHORT).show();
    }

    private void settingsYesMethod()
    {
        Toast.makeText(getContext(), "You clicked Yes", Toast.LENGTH_SHORT).show();
    }

    private void settingsCancelMethod()
    {
        Toast.makeText(getContext(), "You clicked No", Toast.LENGTH_SHORT).show();
    }

}
