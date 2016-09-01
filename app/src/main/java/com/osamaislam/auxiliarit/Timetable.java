package com.osamaislam.auxiliarit;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.PorterDuff;
import android.net.Uri;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class Timetable extends Activity {

    ArrayAdapter<String> adapterDays;
    ArrayAdapter<String> adapter;
    ArrayAdapter<String> adapterSubName;
    ArrayAdapter<CharSequence> adapterTime;

    Spinner spinnerDays;
    Spinner spinnerLects;
    Spinner spinnerSubName;
    Spinner spinnerTime;
    String subName;
    String time;
    String venue;
    String ChosenLect;
    int mrow = 0, turow = 0, wrow = 0, thrrow = 0, frow = 0;


    SharedPreferences shared;
    SharedPreferences subShared;
    SubjectsPage subjectsPage = new SubjectsPage();

    String[] Lecturers = {"Mr. Wael (TBR)", "Mr. Matthew", "Mr. Vinod", "Mr. Mutaz", "Dr. Marwan", "Mr. Tony",
            "Mr. Kelvin", "Mr. Hemant", "Ms. Izan", "Ms. Norhayati", "Ms. Noris", "Ms. Huda", "Ms. Shaliken", "Mr. Jason",
            "Ms. Rawia", "Mr. Hafiz", "Mr. Eissa", "Ms. Suhaila", "Jaganath","Mr. Sohail", "Mr. Kashif"};

    String[] Time = {"09:00 am", "12:30 pm", "03:00 pm"};

    String[] Days = {"Monday", "Tuesday", "Wednesday", "Thursday", "Friday"};

    int day;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_timetable);

        shared = getSharedPreferences("TimetableDatabase", MODE_PRIVATE);

        subShared = getSharedPreferences("SubjectsDatabase", MODE_PRIVATE);

        subjectsPage.Subjects[0] = subShared.getString("Subject1", "");
        subjectsPage.Subjects[1] = subShared.getString("Subject2", "");
        subjectsPage.Subjects[2] = subShared.getString("Subject3", "");
        subjectsPage.Subjects[3] = subShared.getString("Subject4", "");
        subjectsPage.Subjects[4] = subShared.getString("Subject5", "");
        subjectsPage.Subjects[5] = subShared.getString("Subject6", "");
        subjectsPage.Subjects[6] = subShared.getString("Subject7", "");
        subjectsPage.Subjects[7] = subShared.getString("Subject8", "");
        subjectsPage.Subjects[8] = subShared.getString("Subject9", "");
        subjectsPage.Subjects[9] = subShared.getString("Subject10", "");



        // Get Pref

        TextView ms1 = (TextView) findViewById(R.id.ms1);
        TextView ms2 = (TextView) findViewById(R.id.ms2);
        TextView ms3 = (TextView) findViewById(R.id.ms3);
        TextView mtime1 = (TextView) findViewById(R.id.mtime1);
        TextView mtime2 = (TextView) findViewById(R.id.mtime2);
        TextView mtime3 = (TextView) findViewById(R.id.mtime3);
        TextView mven1 = (TextView) findViewById(R.id.mven1);
        TextView mven2 = (TextView) findViewById(R.id.mven2);
        TextView mven3 = (TextView) findViewById(R.id.mven3);
        TextView mLect1 = (TextView) findViewById(R.id.mlect1);
        TextView mLect2 = (TextView) findViewById(R.id.mlect2);
        TextView mLect3 = (TextView) findViewById(R.id.mlect3);

        TextView tus1 = (TextView) findViewById(R.id.tus1);
        TextView tus2 = (TextView) findViewById(R.id.tus2);
        TextView tus3 = (TextView) findViewById(R.id.tus3);
        TextView tutime1 = (TextView) findViewById(R.id.tutime1);
        TextView tutime2 = (TextView) findViewById(R.id.tutime2);
        TextView tutime3 = (TextView) findViewById(R.id.tutime3);
        TextView tuven1 = (TextView) findViewById(R.id.tuven1);
        TextView tuven2 = (TextView) findViewById(R.id.tuven2);
        TextView tuven3 = (TextView) findViewById(R.id.tuven3);
        TextView tuLect1 = (TextView) findViewById(R.id.tulect1);
        TextView tuLect2 = (TextView) findViewById(R.id.tulect2);
        TextView tuLect3 = (TextView) findViewById(R.id.tulect3);

        TextView ws1 = (TextView) findViewById(R.id.ws1);
        TextView ws2 = (TextView) findViewById(R.id.ws2);
        TextView ws3 = (TextView) findViewById(R.id.ws3);
        TextView wtime1 = (TextView) findViewById(R.id.wtime1);
        TextView wtime2 = (TextView) findViewById(R.id.wtime2);
        TextView wtime3 = (TextView) findViewById(R.id.wtime3);
        TextView wven1 = (TextView) findViewById(R.id.wven1);
        TextView wven2 = (TextView) findViewById(R.id.wven2);
        TextView wven3 = (TextView) findViewById(R.id.wven3);
        TextView wLect1 = (TextView) findViewById(R.id.wlect1);
        TextView wLect2 = (TextView) findViewById(R.id.wlect2);
        TextView wLect3 = (TextView) findViewById(R.id.wlect3);

        TextView ths1 = (TextView) findViewById(R.id.ths1);
        TextView ths2 = (TextView) findViewById(R.id.ths2);
        TextView ths3 = (TextView) findViewById(R.id.ths3);
        TextView thtime1 = (TextView) findViewById(R.id.thtime1);
        TextView thtime2 = (TextView) findViewById(R.id.thtime2);
        TextView thtime3 = (TextView) findViewById(R.id.thtime3);
        TextView thven1 = (TextView) findViewById(R.id.thven1);
        TextView thven2 = (TextView) findViewById(R.id.thven2);
        TextView thven3 = (TextView) findViewById(R.id.thven3);
        TextView thLect1 = (TextView) findViewById(R.id.thlect1);
        TextView thLect2 = (TextView) findViewById(R.id.thlect2);
        TextView thLect3 = (TextView) findViewById(R.id.thlect3);

        TextView fs1 = (TextView) findViewById(R.id.fs1);
        TextView fs2 = (TextView) findViewById(R.id.fs2);
        TextView fs3 = (TextView) findViewById(R.id.fs3);
        TextView ftime1 = (TextView) findViewById(R.id.ftime1);
        TextView ftime2 = (TextView) findViewById(R.id.ftime2);
        TextView ftime3 = (TextView) findViewById(R.id.ftime3);
        TextView fven1 = (TextView) findViewById(R.id.fven1);
        TextView fven2 = (TextView) findViewById(R.id.fven2);
        TextView fven3 = (TextView) findViewById(R.id.fven3);
        TextView fLect1 = (TextView) findViewById(R.id.flect1);
        TextView fLect2 = (TextView) findViewById(R.id.flect2);
        TextView fLect3 = (TextView) findViewById(R.id.flect3);



        String mondaySubject1 = shared.getString("mondaySubject1", "");
        String mondayTime1 = shared.getString("mondayTime1", "");
        String mondayVenue1 = shared.getString("mondayVenue1", "");
        String mondayLect1 = shared.getString("mondayLect1", "");

        String mondaySubject2 = shared.getString("mondaySubject2", "");
        String mondayTime2 = shared.getString("mondayTime2", "");
        String mondayVenue2 = shared.getString("mondayVenue2", "");
        String mondayLect2 = shared.getString("mondayLect2", "");

        String mondaySubject3 = shared.getString("mondaySubject3", "");
        String mondayTime3 = shared.getString("mondayTime3", "");
        String mondayVenue3 = shared.getString("mondayVenue3", "");
        String mondayLect3 = shared.getString("mondayLect3", "");

        String tuesdaySubject1 = shared.getString("tuesdaySubject1", "");
        String tuesdayTime1 = shared.getString("tuesdayTime1", "");
        String tuesdayVenue1 = shared.getString("tuesdayVenue1", "");
        String tuesdayLect1 = shared.getString("tuesdayLect1", "");

        String tuesdaySubject2 = shared.getString("tuesdaySubject2", "");
        String tuesdayTime2 = shared.getString("tuesdayTime2", "");
        String tuesdayVenue2 = shared.getString("tuesdayVenue2", "");
        String tuesdayLect2 = shared.getString("tuesdayLect2", "");

        String tuesdaySubject3 = shared.getString("tuesdaySubject3", "");
        String tuesdayTime3 = shared.getString("tuesdayTime3", "");
        String tuesdayVenue3 = shared.getString("tuesdayVenue3", "");
        String tuesdayLect3 = shared.getString("tuesdayLect3", "");

        String wedSubject1 = shared.getString("wedSubject1", "");
        String wedTime1 = shared.getString("wedTime1", "");
        String wedVenue1 = shared.getString("wedVenue1", "");
        String wedLect1 = shared.getString("wedLect1", "");

        String wedSubject2 = shared.getString("wedSubject2", "");
        String wedTime2 = shared.getString("wedTime2", "");
        String wedVenue2 = shared.getString("wedVenue2", "");
        String wedLect2 = shared.getString("wedLect2", "");

        String wedSubject3 = shared.getString("wedSubject3", "");
        String wedTime3 = shared.getString("wedTime3", "");
        String wedVenue3 = shared.getString("wedVenue3", "");
        String wedLect3 = shared.getString("wedLect3", "");

        String thursdaySubject1 = shared.getString("thursdaySubject1", "");
        String thursdayTime1 = shared.getString("thursdayTime1", "");
        String thursdayVenue1 = shared.getString("thursdayVenue1", "");
        String thursdayLect1 = shared.getString("thursdayLect1", "");

        String thursdaySubject2 = shared.getString("thursdaySubject2", "");
        String thursdayTime2 = shared.getString("thursdayTime2", "");
        String thursdayVenue2 = shared.getString("thursdayVenue2", "");
        String thursdayLect2 = shared.getString("thursdayLect2", "");

        String thursdaySubject3 = shared.getString("thursdaySubject3", "");
        String thursdayTime3 = shared.getString("thursdayTime3", "");
        String thursdayVenue3 = shared.getString("thursdayVenue3", "");
        String thursdayLect3 = shared.getString("thursdayLect3", "");

        String fridaySubject1 = shared.getString("fridaySubject1", "");
        String fridayTime1 = shared.getString("fridayTime1", "");
        String fridayVenue1 = shared.getString("fridayVenue1", "");
        String fridayLect1 = shared.getString("fridayLect1", "");

        String fridaySubject2 = shared.getString("fridaySubject2", "");
        String fridayTime2 = shared.getString("fridayTime2", "");
        String fridayVenue2 = shared.getString("fridayVenue2", "");
        String fridayLect2 = shared.getString("fridayLect2", "");

        String fridaySubject3 = shared.getString("fridaySubject3", "");
        String fridayTime3 = shared.getString("fridayTime3", "");
        String fridayVenue3 = shared.getString("fridayVenue3", "");
        String fridayLect3 = shared.getString("fridayLect3", "");




        ms1.setText(mondaySubject1);
        mtime1.setText(mondayTime1);
        mven1.setText(mondayVenue1);
        mLect1.setText(mondayLect1);

        ms2.setText(mondaySubject2);
        mtime2.setText(mondayTime2);
        mven2.setText(mondayVenue2);
        mLect2.setText(mondayLect2);

        ms3.setText(mondaySubject3);
        mtime3.setText(mondayTime3);
        mven3.setText(mondayVenue3);
        mLect3.setText(mondayLect3);



        tus1.setText(tuesdaySubject1);
        tutime1.setText(tuesdayTime1);
        tuven1.setText(tuesdayVenue1);
        tuLect1.setText(tuesdayLect1);

        tus2.setText(tuesdaySubject2);
        tutime2.setText(tuesdayTime2);
        tuven2.setText(tuesdayVenue2);
        tuLect2.setText(tuesdayLect2);

        tus3.setText(tuesdaySubject3);
        tutime3.setText(tuesdayTime3);
        tuven3.setText(tuesdayVenue3);
        tuLect3.setText(tuesdayLect3);



        ws1.setText(wedSubject1);
        wtime1.setText(wedTime1);
        wven1.setText(wedVenue1);
        wLect1.setText(wedLect1);

        ws2.setText(wedSubject2);
        wtime2.setText(wedTime2);
        wven2.setText(wedVenue2);
        wLect2.setText(wedLect2);

        ws3.setText(wedSubject3);
        wtime3.setText(wedTime3);
        wven3.setText(wedVenue3);
        wLect3.setText(wedLect3);



        ths1.setText(thursdaySubject1);
        thtime1.setText(thursdayTime1);
        thven1.setText(thursdayVenue1);
        thLect1.setText(thursdayLect1);

        ths2.setText(thursdaySubject2);
        thtime2.setText(thursdayTime2);
        thven2.setText(thursdayVenue2);
        thLect2.setText(thursdayLect2);

        ths3.setText(thursdaySubject3);
        thtime3.setText(thursdayTime3);
        thven3.setText(thursdayVenue3);
        thLect3.setText(thursdayLect3);



        fs1.setText(fridaySubject1);
        ftime1.setText(fridayTime1);
        fven1.setText(fridayVenue1);
        fLect1.setText(fridayLect1);

        fs2.setText(fridaySubject2);
        ftime2.setText(fridayTime2);
        fven2.setText(fridayVenue2);
        fLect2.setText(fridayLect2);

        fs3.setText(fridaySubject3);
        ftime3.setText(fridayTime3);
        fven3.setText(fridayVenue3);
        fLect3.setText(fridayLect3);







        spinnerDays = (Spinner) findViewById(R.id.spinnerDays);
        spinnerDays.getBackground().setColorFilter(getResources().getColor(android.R.color.holo_blue_dark), PorterDuff.Mode.SRC_ATOP);
        adapterDays = new ArrayAdapter<>(this, R.layout.spinner_small, R.id.customSpinner, Days);
        adapterDays.setDropDownViewResource(R.layout.spinner_norm);
        spinnerDays.setAdapter(adapterDays);

        spinnerDays.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int item, long l) {

                switch (item) {
                    case 0: day = 1; break;
                    case 1: day = 2; break;
                    case 2: day = 3; break;
                    case 3: day = 4; break;
                    case 4: day = 5;
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });


        spinnerLects = (Spinner) findViewById(R.id.spinnerLects);
        spinnerLects.getBackground().setColorFilter(getResources().getColor(android.R.color.holo_blue_dark), PorterDuff.Mode.SRC_ATOP);
        adapter = new ArrayAdapter<>(this, R.layout.spinner_small, R.id.customSpinner, Lecturers);
        adapter.setDropDownViewResource(R.layout.spinner_norm);
        spinnerLects.setAdapter(adapter);

        spinnerLects.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int item, long l) {

                switch (item) {
                    case 0: ChosenLect = Lecturers[0]; break;
                    case 1: ChosenLect = Lecturers[1]; break;
                    case 2: ChosenLect = Lecturers[2]; break;
                    case 3: ChosenLect = Lecturers[3]; break;
                    case 4: ChosenLect = Lecturers[4]; break;
                    case 5: ChosenLect = Lecturers[5]; break;
                    case 6: ChosenLect = Lecturers[6]; break;
                    case 7: ChosenLect = Lecturers[7]; break;
                    case 8: ChosenLect = Lecturers[8]; break;
                    case 9: ChosenLect = Lecturers[9]; break;
                    case 10: ChosenLect = Lecturers[10]; break;
                    case 11: ChosenLect = Lecturers[11]; break;
                    case 12: ChosenLect = Lecturers[12]; break;
                    case 13: ChosenLect = Lecturers[13]; break;
                    case 14: ChosenLect = Lecturers[14]; break;
                    case 15: ChosenLect = Lecturers[15]; break;
                    case 16: ChosenLect = Lecturers[16]; break;
                    case 17: ChosenLect = Lecturers[17]; break;
                    case 18: ChosenLect = Lecturers[18]; break;
                    case 19: ChosenLect = Lecturers[19]; break;
                    case 20: ChosenLect = Lecturers[20]; break;
                    case 21: ChosenLect = Lecturers[21];


                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        spinnerSubName = (Spinner) findViewById(R.id.subName);
        spinnerSubName.getBackground().setColorFilter(getResources().getColor(android.R.color.holo_blue_dark), PorterDuff.Mode.SRC_ATOP);
        adapterSubName = new ArrayAdapter<>(this, R.layout.spinner_small, R.id.customSpinner, subjectsPage.Subjects);
        adapterSubName.setDropDownViewResource(R.layout.spinner_norm);
        spinnerSubName.setAdapter(adapterSubName);
        spinnerSubName.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int item, long l) {

                switch (item) {
                    case 0: subName = subjectsPage.Subjects[0]; break;
                    case 1: subName = subjectsPage.Subjects[1]; break;
                    case 2: subName = subjectsPage.Subjects[2]; break;
                    case 3: subName = subjectsPage.Subjects[3]; break;
                    case 4: subName = subjectsPage.Subjects[4]; break;
                    case 5: subName = subjectsPage.Subjects[5]; break;
                    case 6: subName = subjectsPage.Subjects[6]; break;
                    case 7: subName = subjectsPage.Subjects[7]; break;
                    case 8: subName = subjectsPage.Subjects[8]; break;
                    case 9: subName = subjectsPage.Subjects[9];
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        spinnerTime = (Spinner) findViewById(R.id.time);
        spinnerTime.getBackground().setColorFilter(getResources().getColor(android.R.color.holo_blue_dark), PorterDuff.Mode.SRC_ATOP);
        adapterTime = new ArrayAdapter<CharSequence>(this, R.layout.spinner_small, R.id.customSpinner, Time);
        adapterTime.setDropDownViewResource(R.layout.spinner_norm);
        spinnerTime.setAdapter(adapterTime);

        spinnerTime.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int item, long l) {

                switch (item) {
                    case 0: time = "09:00 am"; break;
                    case 1: time = "12:30 pm"; break;
                    case 2: time = "03:00 pm";

                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });


        registerForContextMenu(ms1);
        registerForContextMenu(mtime1);
        registerForContextMenu(mven1);
        registerForContextMenu(mLect1);

        registerForContextMenu(ms2);
        registerForContextMenu(mtime2);
        registerForContextMenu(mven2);
        registerForContextMenu(mLect2);

        registerForContextMenu(ms3);
        registerForContextMenu(mtime3);
        registerForContextMenu(mven3);
        registerForContextMenu(mLect3);



        registerForContextMenu(tus1);
        registerForContextMenu(tutime1);
        registerForContextMenu(tuven1);
        registerForContextMenu(tuLect1);

        registerForContextMenu(tus2);
        registerForContextMenu(tutime2);
        registerForContextMenu(tuven2);
        registerForContextMenu(tuLect2);

        registerForContextMenu(tus3);
        registerForContextMenu(tutime3);
        registerForContextMenu(tuven3);
        registerForContextMenu(tuLect3);



        registerForContextMenu(ws1);
        registerForContextMenu(wtime1);
        registerForContextMenu(wven1);
        registerForContextMenu(wLect1);

        registerForContextMenu(ws2);
        registerForContextMenu(wtime2);
        registerForContextMenu(wven2);
        registerForContextMenu(wLect2);

        registerForContextMenu(ws3);
        registerForContextMenu(wtime3);
        registerForContextMenu(wven3);
        registerForContextMenu(wLect3);



        registerForContextMenu(ths1);
        registerForContextMenu(thtime1);
        registerForContextMenu(thven1);
        registerForContextMenu(thLect1);

        registerForContextMenu(ths2);
        registerForContextMenu(thtime2);
        registerForContextMenu(thven2);
        registerForContextMenu(thLect2);

        registerForContextMenu(ths3);
        registerForContextMenu(thtime3);
        registerForContextMenu(thven3);
        registerForContextMenu(thLect3);



        registerForContextMenu(fs1);
        registerForContextMenu(ftime1);
        registerForContextMenu(fven1);
        registerForContextMenu(fLect1);

        registerForContextMenu(fs2);
        registerForContextMenu(ftime2);
        registerForContextMenu(fven2);
        registerForContextMenu(fLect2);

        registerForContextMenu(fs3);
        registerForContextMenu(ftime3);
        registerForContextMenu(fven3);
        registerForContextMenu(fLect3);


    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {


        this.getMenuInflater().inflate(R.menu.popup, menu);


        if(v.getId() == R.id.ms1 || v.getId() == R.id.mtime1 || v.getId() == R.id.mven1 || v.getId() == R.id.mlect1){
            mrow = 1;}

        else if(v.getId() == R.id.ms2 || v.getId() == R.id.mtime2 || v.getId() == R.id.mven2 || v.getId() == R.id.mlect2){
            mrow = 2;}

        else if(v.getId() == R.id.ms3 || v.getId() == R.id.mtime3 || v.getId() == R.id.mven3 || v.getId() == R.id.mlect3){
            mrow = 3;}



        else if(v.getId() == R.id.tus1 || v.getId() == R.id.tutime1 || v.getId() == R.id.tuven1 || v.getId() == R.id.tulect1){
            turow = 1;}

        else if(v.getId() == R.id.tus2 || v.getId() == R.id.tutime2 || v.getId() == R.id.tuven2 || v.getId() == R.id.tulect2){
            turow = 2;}

        else if(v.getId() == R.id.tus3 || v.getId() == R.id.tutime3 || v.getId() == R.id.tuven3 || v.getId() == R.id.tulect3){
            turow = 3;}



        else if(v.getId() == R.id.ws1 || v.getId() == R.id.wtime1 || v.getId() == R.id.wven1 || v.getId() == R.id.wlect1){
            wrow = 1;}

        else if(v.getId() == R.id.ws2 || v.getId() == R.id.wtime2 || v.getId() == R.id.wven2 || v.getId() == R.id.wlect2){
            wrow = 2;}

        else if(v.getId() == R.id.ws3 || v.getId() == R.id.wtime3 || v.getId() == R.id.wven3 || v.getId() == R.id.wlect3){
            wrow = 3;}



        else if(v.getId() == R.id.ths1 || v.getId() == R.id.thtime1 || v.getId() == R.id.thven1 || v.getId() == R.id.thlect1){
            thrrow = 1;}

        else if(v.getId() == R.id.ths2 || v.getId() == R.id.thtime2 || v.getId() == R.id.thven2 || v.getId() == R.id.thlect2){
            thrrow = 2;}

        else if(v.getId() == R.id.ths3 || v.getId() == R.id.thtime3 || v.getId() == R.id.thven3 || v.getId() == R.id.thlect3){
            thrrow = 3;}



        else if(v.getId() == R.id.fs1 || v.getId() == R.id.ftime1 || v.getId() == R.id.fven1 || v.getId() == R.id.flect1){
            frow = 1;}

        else if(v.getId() == R.id.fs2 || v.getId() == R.id.ftime2 || v.getId() == R.id.fven2 || v.getId() == R.id.flect2){
            frow = 2;}

        else if(v.getId() == R.id.fs3 || v.getId() == R.id.ftime3 || v.getId() == R.id.fven3 || v.getId() == R.id.flect3){
            frow = 3;}


        super.onCreateContextMenu(menu, v, menuInfo);



    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {

        int selectedId = item.getItemId();

        switch (selectedId) {

            case R.id.n1: delFromDatabase("Delete"); break;

           // case R.id.n2: delFromDatabase("Modify");

        }
        return super.onContextItemSelected(item);
    }




    public void addToDatabase(View view) {

        shared = getSharedPreferences("TimetableDatabase", MODE_PRIVATE);
        SharedPreferences.Editor editor = shared.edit();

        TextView ms1 = (TextView) findViewById(R.id.ms1);
        TextView ms2 = (TextView) findViewById(R.id.ms2);
        TextView ms3 = (TextView) findViewById(R.id.ms3);
        TextView mtime1 = (TextView) findViewById(R.id.mtime1);
        TextView mtime2 = (TextView) findViewById(R.id.mtime2);
        TextView mtime3 = (TextView) findViewById(R.id.mtime3);
        TextView mven1 = (TextView) findViewById(R.id.mven1);
        TextView mven2 = (TextView) findViewById(R.id.mven2);
        TextView mven3 = (TextView) findViewById(R.id.mven3);
        TextView mLect1 = (TextView) findViewById(R.id.mlect1);
        TextView mLect2 = (TextView) findViewById(R.id.mlect2);
        TextView mLect3 = (TextView) findViewById(R.id.mlect3);

        TextView tus1 = (TextView) findViewById(R.id.tus1);
        TextView tus2 = (TextView) findViewById(R.id.tus2);
        TextView tus3 = (TextView) findViewById(R.id.tus3);
        TextView tutime1 = (TextView) findViewById(R.id.tutime1);
        TextView tutime2 = (TextView) findViewById(R.id.tutime2);
        TextView tutime3 = (TextView) findViewById(R.id.tutime3);
        TextView tuven1 = (TextView) findViewById(R.id.tuven1);
        TextView tuven2 = (TextView) findViewById(R.id.tuven2);
        TextView tuven3 = (TextView) findViewById(R.id.tuven3);
        TextView tuLect1 = (TextView) findViewById(R.id.tulect1);
        TextView tuLect2 = (TextView) findViewById(R.id.tulect2);
        TextView tuLect3 = (TextView) findViewById(R.id.tulect3);

        TextView ws1 = (TextView) findViewById(R.id.ws1);
        TextView ws2 = (TextView) findViewById(R.id.ws2);
        TextView ws3 = (TextView) findViewById(R.id.ws3);
        TextView wtime1 = (TextView) findViewById(R.id.wtime1);
        TextView wtime2 = (TextView) findViewById(R.id.wtime2);
        TextView wtime3 = (TextView) findViewById(R.id.wtime3);
        TextView wven1 = (TextView) findViewById(R.id.wven1);
        TextView wven2 = (TextView) findViewById(R.id.wven2);
        TextView wven3 = (TextView) findViewById(R.id.wven3);
        TextView wLect1 = (TextView) findViewById(R.id.wlect1);
        TextView wLect2 = (TextView) findViewById(R.id.wlect2);
        TextView wLect3 = (TextView) findViewById(R.id.wlect3);

        TextView ths1 = (TextView) findViewById(R.id.ths1);
        TextView ths2 = (TextView) findViewById(R.id.ths2);
        TextView ths3 = (TextView) findViewById(R.id.ths3);
        TextView thtime1 = (TextView) findViewById(R.id.thtime1);
        TextView thtime2 = (TextView) findViewById(R.id.thtime2);
        TextView thtime3 = (TextView) findViewById(R.id.thtime3);
        TextView thven1 = (TextView) findViewById(R.id.thven1);
        TextView thven2 = (TextView) findViewById(R.id.thven2);
        TextView thven3 = (TextView) findViewById(R.id.thven3);
        TextView thLect1 = (TextView) findViewById(R.id.thlect1);
        TextView thLect2 = (TextView) findViewById(R.id.thlect2);
        TextView thLect3 = (TextView) findViewById(R.id.thlect3);

        TextView fs1 = (TextView) findViewById(R.id.fs1);
        TextView fs2 = (TextView) findViewById(R.id.fs2);
        TextView fs3 = (TextView) findViewById(R.id.fs3);
        TextView ftime1 = (TextView) findViewById(R.id.ftime1);
        TextView ftime2 = (TextView) findViewById(R.id.ftime2);
        TextView ftime3 = (TextView) findViewById(R.id.ftime3);
        TextView fven1 = (TextView) findViewById(R.id.fven1);
        TextView fven2 = (TextView) findViewById(R.id.fven2);
        TextView fven3 = (TextView) findViewById(R.id.fven3);
        TextView fLect1 = (TextView) findViewById(R.id.flect1);
        TextView fLect2 = (TextView) findViewById(R.id.flect2);
        TextView fLect3 = (TextView) findViewById(R.id.flect3);


        EditText editVenue = (EditText) findViewById(R.id.venue);

        venue = editVenue.getText().toString();

        if (venue.isEmpty()) {
            Toast.makeText(this, "Add the venue", Toast.LENGTH_SHORT).show();
            return;
        }



     // Ensuring an empty slot

        if (day == 1) {



                        if (time == mtime1.getText().toString() || time == mtime2.getText().toString() || time == mtime3.getText().toString()) {
                                Toast.makeText(this, "There is CLASH!!", Toast.LENGTH_SHORT).show();
                         }





            if (ms1.getText().toString() == "") {




                editor.putString("mondaySubject1", subName);
                editor.putString("mondayTime1", time);
                editor.putString("mondayVenue1", venue);
                editor.putString("mondayLect1", ChosenLect);
                editor.apply();

                ms1.setText(subName);
                mtime1.setText(time);
                mven1.setText(venue);
                mLect1.setText(ChosenLect);
            }


            else if (ms2.getText().toString() == "") {

                editor.putString("mondaySubject2", subName);
                editor.putString("mondayTime2", time);
                editor.putString("mondayVenue2", venue);
                editor.putString("mondayLect2", ChosenLect);

                editor.apply();

                ms2.setText(subName);
                mtime2.setText(time);
                mven2.setText(venue);
                mLect2.setText(ChosenLect);
            }


            else if (ms3.getText().toString() == "") {

                editor.putString("mondaySubject3", subName);
                editor.putString("mondayTime3", time);
                editor.putString("mondayVenue3", venue);
                editor.putString("mondayLect3", ChosenLect);
                editor.apply();

                ms3.setText(subName);
                mtime3.setText(time);
                mven3.setText(venue);
                mLect3.setText(ChosenLect);

            }

            else {
                Toast.makeText(this, "There's no room in Monday", Toast.LENGTH_SHORT).show();
                return;
            }

        }
        else if (day == 2) {

            if (time == tutime1.getText().toString() || time == tutime2.getText().toString() || time == tutime3.getText().toString()) {
                Toast.makeText(this, "There is CLASH!!", Toast.LENGTH_SHORT).show();
            }

            if (tus1.getText().toString() == "") {

                editor.putString("tuesdaySubject1", subName);
                editor.putString("tuesdayTime1", time);
                editor.putString("tuesdayVenue1", venue);
                editor.putString("tuesdayLect1", ChosenLect);
                editor.apply();

                tus1.setText(subName);
                tutime1.setText(time);
                tuven1.setText(venue);
                tuLect1.setText(ChosenLect);

            } else if (tus2.getText().toString() == "") {

                editor.putString("tuesdaySubject2", subName);
                editor.putString("tuesdayTime2", time);
                editor.putString("tuesdayVenue2", venue);
                editor.putString("tuesdayLect2", ChosenLect);
                editor.apply();

                tus2.setText(subName);
                tutime2.setText(time);
                tuven2.setText(venue);
                tuLect2.setText(ChosenLect);

            } else if (tus3.getText().toString() == "") {

                editor.putString("tuesdaySubject3", subName);
                editor.putString("tuesdayTime3", time);
                editor.putString("tuesdayVenue3", venue);
                editor.putString("tuesdayLect3", ChosenLect);
                editor.apply();

                tus3.setText(subName);
                tutime3.setText(time);
                tuven3.setText(venue);
                tuLect3.setText(ChosenLect);

            }
            else {
                Toast.makeText(this, "There's no room in Tuesday", Toast.LENGTH_SHORT).show();
                return;
            }
        }

        else if (day == 3) {

            if (time == wtime1.getText().toString() || time == wtime2.getText().toString() || time == wtime3.getText().toString()) {
                Toast.makeText(this, "There is CLASH!!", Toast.LENGTH_SHORT).show();
            }


            if (ws1.getText().toString() == "") {

                editor.putString("wedSubject1", subName);
                editor.putString("wedTime1", time);
                editor.putString("wedVenue1", venue);
                editor.putString("wedLect1", ChosenLect);
                editor.apply();

                ws1.setText(subName);
                wtime1.setText(time);
                wven1.setText(venue);
                wLect1.setText(ChosenLect);

            }


            else if (ws2.getText().toString() == "") {

                editor.putString("wedSubject2", subName);
                editor.putString("wedTime2", time);
                editor.putString("wedVenue2", venue);
                editor.putString("wedLect2", ChosenLect);
                editor.apply();

                ws2.setText(subName);
                wtime2.setText(time);
                wven2.setText(venue);
                wLect2.setText(ChosenLect);

            }


            else if (ws3.getText().toString() == "") {

                editor.putString("wedSubject3", subName);
                editor.putString("wedTime3", time);
                editor.putString("wedVenue3", venue);
                editor.putString("wedLect3", ChosenLect);
                editor.apply();

                ws3.setText(subName);
                wtime3.setText(time);
                wven3.setText(venue);
                wLect3.setText(ChosenLect);

            }
            else {
                Toast.makeText(this, "There's no room in Wednesday", Toast.LENGTH_SHORT).show();
                return;
            }

        }


        else if (day == 4) {

            if (time == thtime1.getText().toString() || time == thtime2.getText().toString() || time == thtime3.getText().toString()) {
                Toast.makeText(this, "There is CLASH!!", Toast.LENGTH_SHORT).show();
            }


            if (ths1.getText().toString() == "") {

                editor.putString("thursdaySubject1", subName);
                editor.putString("thursdayTime1", time);
                editor.putString("thursdayVenue1", venue);
                editor.putString("thursdayLect1", ChosenLect);
                editor.apply();

                ths1.setText(subName);
                thtime1.setText(time);
                thven1.setText(venue);
                thLect1.setText(ChosenLect);

            }

            else if (ths2.getText().toString() == "") {

                editor.putString("thursdaySubject2", subName);
                editor.putString("thursdayTime2", time);
                editor.putString("thursdayVenue2", venue);
                editor.putString("thursdayLect2", ChosenLect);
                editor.apply();

                ths2.setText(subName);
                thtime2.setText(time);
                thven2.setText(venue);
                thLect2.setText(ChosenLect);

            }

            else if (ths3.getText().toString() == "") {

                editor.putString("thursdaySubject3", subName);
                editor.putString("thursdayTime3", time);
                editor.putString("thursdayVenue3", venue);
                editor.putString("thursdayLect3", ChosenLect);
                editor.apply();

                ths3.setText(subName);
                thtime3.setText(time);
                thven3.setText(venue);
                thLect3.setText(ChosenLect);

            }
            else {
                Toast.makeText(this, "There's no room in Thursday", Toast.LENGTH_SHORT).show();
                return;
            }

        }


        else if (day == 5) {

            if (time == ftime1.getText().toString() || time == ftime2.getText().toString() || time == ftime3.getText().toString()) {
                Toast.makeText(this, "There is CLASH!!", Toast.LENGTH_SHORT).show();
            }


            if (fs1.getText().toString() == "") {

                editor.putString("fridaySubject1", subName);
                editor.putString("fridayTime1", time);
                editor.putString("fridayVenue1", venue);
                editor.putString("fridayLect1", ChosenLect);
                editor.apply();

                fs1.setText(subName);
                ftime1.setText(time);
                fven1.setText(venue);
                fLect1.setText(ChosenLect);

            }


            else if (fs2.getText().toString() == "") {

                editor.putString("fridaySubject2", subName);
                editor.putString("fridayTime2", time);
                editor.putString("fridayVenue2", venue);
                editor.putString("fridayLect2", ChosenLect);
                editor.apply();

                fs2.setText(subName);
                ftime2.setText(time);
                fven2.setText(venue);
                fLect2.setText(ChosenLect);

            }


            else if (fs3.getText().toString() == "") {

                editor.putString("fridaySubject3", subName);
                editor.putString("fridayTime3", time);
                editor.putString("fridayVenue3", venue);
                editor.putString("fridayLect3", ChosenLect);
                editor.apply();

                fs3.setText(subName);
                ftime3.setText(time);
                fven3.setText(venue);
                fLect3.setText(ChosenLect);

            }
            else {
                Toast.makeText(this, "There's no room in Friday", Toast.LENGTH_SHORT).show();
                return;
            }

        }

        editVenue.setText("");








    }


    public void delFromDatabase(String S) {

        shared = getSharedPreferences("TimetableDatabase", MODE_PRIVATE);

        SharedPreferences.Editor editor = shared.edit();

        TextView ms1 = (TextView) findViewById(R.id.ms1);
        TextView ms2 = (TextView) findViewById(R.id.ms2);
        TextView ms3 = (TextView) findViewById(R.id.ms3);
        TextView mtime1 = (TextView) findViewById(R.id.mtime1);
        TextView mtime2 = (TextView) findViewById(R.id.mtime2);
        TextView mtime3 = (TextView) findViewById(R.id.mtime3);
        TextView mven1 = (TextView) findViewById(R.id.mven1);
        TextView mven2 = (TextView) findViewById(R.id.mven2);
        TextView mven3 = (TextView) findViewById(R.id.mven3);
        TextView mLect1 = (TextView) findViewById(R.id.mlect1);
        TextView mLect2 = (TextView) findViewById(R.id.mlect2);
        TextView mLect3 = (TextView) findViewById(R.id.mlect3);

        TextView tus1 = (TextView) findViewById(R.id.tus1);
        TextView tus2 = (TextView) findViewById(R.id.tus2);
        TextView tus3 = (TextView) findViewById(R.id.tus3);
        TextView tutime1 = (TextView) findViewById(R.id.tutime1);
        TextView tutime2 = (TextView) findViewById(R.id.tutime2);
        TextView tutime3 = (TextView) findViewById(R.id.tutime3);
        TextView tuven1 = (TextView) findViewById(R.id.tuven1);
        TextView tuven2 = (TextView) findViewById(R.id.tuven2);
        TextView tuven3 = (TextView) findViewById(R.id.tuven3);
        TextView tuLect1 = (TextView) findViewById(R.id.tulect1);
        TextView tuLect2 = (TextView) findViewById(R.id.tulect2);
        TextView tuLect3 = (TextView) findViewById(R.id.tulect3);

        TextView ws1 = (TextView) findViewById(R.id.ws1);
        TextView ws2 = (TextView) findViewById(R.id.ws2);
        TextView ws3 = (TextView) findViewById(R.id.ws3);
        TextView wtime1 = (TextView) findViewById(R.id.wtime1);
        TextView wtime2 = (TextView) findViewById(R.id.wtime2);
        TextView wtime3 = (TextView) findViewById(R.id.wtime3);
        TextView wven1 = (TextView) findViewById(R.id.wven1);
        TextView wven2 = (TextView) findViewById(R.id.wven2);
        TextView wven3 = (TextView) findViewById(R.id.wven3);
        TextView wLect1 = (TextView) findViewById(R.id.wlect1);
        TextView wLect2 = (TextView) findViewById(R.id.wlect2);
        TextView wLect3 = (TextView) findViewById(R.id.wlect3);

        TextView ths1 = (TextView) findViewById(R.id.ths1);
        TextView ths2 = (TextView) findViewById(R.id.ths2);
        TextView ths3 = (TextView) findViewById(R.id.ths3);
        TextView thtime1 = (TextView) findViewById(R.id.thtime1);
        TextView thtime2 = (TextView) findViewById(R.id.thtime2);
        TextView thtime3 = (TextView) findViewById(R.id.thtime3);
        TextView thven1 = (TextView) findViewById(R.id.thven1);
        TextView thven2 = (TextView) findViewById(R.id.thven2);
        TextView thven3 = (TextView) findViewById(R.id.thven3);
        TextView thLect1 = (TextView) findViewById(R.id.thlect1);
        TextView thLect2 = (TextView) findViewById(R.id.thlect2);
        TextView thLect3 = (TextView) findViewById(R.id.thlect3);

        TextView fs1 = (TextView) findViewById(R.id.fs1);
        TextView fs2 = (TextView) findViewById(R.id.fs2);
        TextView fs3 = (TextView) findViewById(R.id.fs3);
        TextView ftime1 = (TextView) findViewById(R.id.ftime1);
        TextView ftime2 = (TextView) findViewById(R.id.ftime2);
        TextView ftime3 = (TextView) findViewById(R.id.ftime3);
        TextView fven1 = (TextView) findViewById(R.id.fven1);
        TextView fven2 = (TextView) findViewById(R.id.fven2);
        TextView fven3 = (TextView) findViewById(R.id.fven3);
        TextView fLect1 = (TextView) findViewById(R.id.flect1);
        TextView fLect2 = (TextView) findViewById(R.id.flect2);
        TextView fLect3 = (TextView) findViewById(R.id.flect3);



        if (S == "Delete") {

            if (mrow !=0) {

                switch (mrow) {
                    case 1: editor.remove("mondaySubject1"); editor.remove("mondayTime1"); editor.remove("mondayVenue1"); editor.remove("mondayLect1");
                            ms1.setText(""); mtime1.setText(""); mven1.setText(""); mLect1.setText(""); break;

                    case 2: editor.remove("mondaySubject2"); editor.remove("mondayTime2"); editor.remove("mondayVenue2"); editor.remove("mondayLect2");
                            ms2.setText(""); mtime2.setText(""); mven2.setText(""); mLect2.setText(""); break;

                    case 3: editor.remove("mondaySubject3"); editor.remove("mondayTime3"); editor.remove("mondayVenue3"); editor.remove("mondayLect3");
                            ms3.setText(""); mtime3.setText(""); mven3.setText(""); mLect3.setText("");
                }

            }



            else if (turow != 0) {

                switch (turow) {
                    case 1: editor.remove("tuesdaySubject1"); editor.remove("tuesdayTime1"); editor.remove("tuesdayVenue1"); editor.remove("tuesdayLect1");
                        tus1.setText(""); tutime1.setText(""); tuven1.setText(""); tuLect1.setText(""); break;

                    case 2: editor.remove("tuesdaySubject2"); editor.remove("tuesdayTime2"); editor.remove("tuesdayVenue2"); editor.remove("tuesdayLect2");
                        tus2.setText(""); tutime2.setText(""); tuven2.setText(""); tuLect2.setText(""); break;

                    case 3: editor.remove("tuesdaySubject3"); editor.remove("tuesdayTime3"); editor.remove("tuesdayVenue3"); editor.remove("tuesdayLect3");
                        tus3.setText(""); tutime3.setText(""); tuven3.setText(""); tuLect3.setText("");
                }

            }



            else if (wrow != 0) {

                switch (wrow) {
                    case 1: editor.remove("wedSubject1"); editor.remove("wedTime1"); editor.remove("wedVenue1"); editor.remove("wedLect1");
                        ws1.setText(""); wtime1.setText(""); wven1.setText(""); wLect1.setText(""); break;

                    case 2: editor.remove("wedSubject2"); editor.remove("wedTime2"); editor.remove("wedVenue2"); editor.remove("wedLect2");
                        ws2.setText(""); wtime2.setText(""); wven2.setText(""); wLect2.setText(""); break;

                    case 3: editor.remove("wedSubject3"); editor.remove("wedTime3"); editor.remove("wedVenue3"); editor.remove("wedLect3");
                        ws3.setText(""); wtime3.setText(""); wven3.setText(""); wLect3.setText("");
                }

            }



            else if (thrrow != 0) {

                switch (thrrow) {
                    case 1: editor.remove("thursdaySubject1"); editor.remove("thursdayTime1"); editor.remove("thursdayVenue1"); editor.remove("thursdayLect1");
                        ths1.setText(""); thtime1.setText(""); thven1.setText(""); thLect1.setText(""); break;

                    case 2: editor.remove("thursdaySubject2"); editor.remove("thursdayTime2"); editor.remove("thursdayVenue2"); editor.remove("thursdayLect2");
                        ths2.setText(""); thtime2.setText(""); thven2.setText(""); thLect2.setText(""); break;

                    case 3: editor.remove("thursdaySubject3"); editor.remove("thursdayTime3"); editor.remove("thursdayVenue3"); editor.remove("thursdayLect3");
                        ths3.setText(""); thtime3.setText(""); thven3.setText(""); thLect3.setText("");
                }

            }


            else if (frow != 0) {

                switch (frow) {
                    case 1: editor.remove("fridaySubject1"); editor.remove("fridayTime1"); editor.remove("fridayVenue1"); editor.remove("fridayLect1");
                        fs1.setText(""); ftime1.setText(""); fven1.setText(""); fLect1.setText(""); break;

                    case 2: editor.remove("fridaySubject2"); editor.remove("fridayTime2"); editor.remove("fridayVenue2"); editor.remove("fridayLect2");
                        fs2.setText(""); ftime2.setText(""); fven2.setText(""); fLect2.setText(""); break;

                    case 3: editor.remove("fridaySubject3"); editor.remove("fridayTime3"); editor.remove("fridayVenue3"); editor.remove("fridayLect3");
                        fs3.setText(""); ftime3.setText(""); fven3.setText(""); fLect3.setText("");
                }

            }


            editor.apply();



        }

    }




    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.main, menu);


        return super.onCreateOptionsMenu(menu);


    }

    public void reportIT(MenuItem item) {

        Intent intent = new Intent();
        intent.setAction(Intent.ACTION_SEND);
        intent.setData(Uri.parse("mailto:"));
        intent.putExtra(Intent.EXTRA_EMAIL, new String[] {"osama40441@gmail.com"});
        intent.putExtra(Intent.EXTRA_SUBJECT, "BUG REPORT - AuxiliarIT");
        intent.setType("message/rfc822");
        startActivity(intent);
    }

    public void shareIT(MenuItem item) {

        String url = "AuxiliarIT is an app for FICT students to help managing their semester, so far it helped me in my semester. I highly recommend you to try it\n" +
                "\n(Download link) https://goo.gl/HEjx55";

        Intent sendIntent = new Intent();
        sendIntent.setAction(Intent.ACTION_SEND);
        sendIntent.putExtra(Intent.EXTRA_TEXT, url);
        sendIntent.setType("text/plain");
        Intent.createChooser(sendIntent,"Share via");
        startActivity(sendIntent);
    }

    public void about(MenuItem item) {

        startActivity(new Intent(this, AboutApp.class));
    }
}
