package com.example.alecksjohanssen.newyorktimes;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.DialogFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.EditText;
import android.widget.Toast;

public class DialogSettings extends DialogFragment {
    String selection;

    private EditText mEditText;
    final String[] items = {"Search by Book","Search by Item","Search by Items"};
    @Override
    @NonNull
    public Dialog onCreateDialog(Bundle savedInstanceState) {

        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(getActivity());
        alertDialogBuilder.setTitle("Choose").setSingleChoiceItems(items, -1, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface arg0, int arg1) {
                switch (arg1) {
                    case 0:
                        selection = (String) items[arg1];
                        if(selection.equals(items)) {
                            Intent myIntent = new Intent(DialogSettings.this.getActivity(), MainActivity.class);
                            startActivity(myIntent);
                        }

                        break;
                    case 1:
                        selection = (String) items[arg1];
                        break;
                    case 2:
                        selection = (String) items[arg1];
                        break;
                }
            }
        }).setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

                Toast.makeText(getActivity(), "Your choice is " + selection, Toast.LENGTH_SHORT).show();
            }

        });
        alertDialogBuilder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
            }
        });

        return alertDialogBuilder.create();
    }


}