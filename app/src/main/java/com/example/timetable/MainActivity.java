package com.example.timetable;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.HashMap;

public class MainActivity extends AppCompatActivity {

    private Spinner daySpinner;
    private ListView periodsListView;
    private Timetable timetable;
    private ArrayAdapter<String> periodsAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Initialize UI components
        daySpinner = findViewById(R.id.daySpinner);
        periodsListView = findViewById(R.id.periodsListView);
        TextView titleTextView = findViewById(R.id.titleTextView);

        // Set the title of the app
        titleTextView.setText("Timetable");

        // Create an instance of the Timetable class
        timetable = new Timetable();

        // Set up the spinner with days of the week
        ArrayAdapter<String> daysAdapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, timetable.getDaysOfWeek());
        daySpinner.setAdapter(daysAdapter);

        // Set up the ListView adapter
        periodsAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, new ArrayList<>());
        periodsListView.setAdapter(periodsAdapter);

        // Set up spinner selection listener
        daySpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int position, long l) {
                // Get the selected day
                String selectedDay = daySpinner.getSelectedItem().toString();
                // Get the periods for the selected day
                String[] periods = timetable.getPeriodsForDay(selectedDay);
                // Update the ListView adapter with the periods
                periodsAdapter.clear();
                periodsAdapter.addAll(periods);
                periodsAdapter.notifyDataSetChanged();
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {
                // Do nothing
            }
        });
    }

}