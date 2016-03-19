package com.example.alecksjohanssen.newyorktimes;

import android.app.DatePickerDialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;

public class Settings extends AppCompatActivity {
 EditText xEditText;
    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        xEditText = (EditText) findViewById(R.id.etDate);
        button = (Button) findViewById(R.id.button);
        onClickListener();
        onButtonClickListener();
    }
    private void onClickListener() {
        xEditText.setOnClickListener(
                new View.OnClickListener() {
                    public void onClick(View v) {
                        datePicker();
                    }

                });
    }

        private void onButtonClickListener()
    {
        button.setOnClickListener( new View.OnClickListener()
        {
            public void onClick(View v)
            {
                Intent intent = new Intent(getActivity(),DialogSettings.class);
                startActivity(intent);

            }
        });
    }
    private void datePicker() {

        final Calendar calendar = Calendar.getInstance();
        final SimpleDateFormat dateFormatter = new SimpleDateFormat("yyyy-MM-dd", Locale.US);
        final DatePickerDialog datePickerDialog = new DatePickerDialog(Settings.this, new DatePickerDialog.OnDateSetListener() {

            public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                Calendar newDate = Calendar.getInstance();
                newDate.set(year, monthOfYear, dayOfMonth);
                System.out.print(dateFormatter.format(newDate.getTime()));
                xEditText.setText(new StringBuilder().append(year).append("/")
                        .append(monthOfYear).append("/").append(dayOfMonth));
            }
        }


                , calendar.get(Calendar.YEAR), calendar.get(Calendar.MONTH), calendar.get(Calendar.DAY_OF_MONTH));
        datePickerDialog.show();


    }
}

