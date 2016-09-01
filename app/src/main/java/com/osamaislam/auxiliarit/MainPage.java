package com.osamaislam.auxiliarit;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.RequiresApi;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.osamaislam.auxiliarit.AboutApp;
import com.osamaislam.auxiliarit.AboutMe;
import com.osamaislam.auxiliarit.Assignments;
import com.osamaislam.auxiliarit.Bus;
import com.osamaislam.auxiliarit.Lecturers;
import com.osamaislam.auxiliarit.Navigation;
import com.osamaislam.auxiliarit.News;
import com.osamaislam.auxiliarit.R;
import com.osamaislam.auxiliarit.SubjectsPage;
import com.osamaislam.auxiliarit.Timetable;

import java.util.Calendar;

public class MainPage extends Activity {

    Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_page);

    }


    public void timeTable(View view) {


        intent = new Intent(this, Timetable.class);
        startActivity(intent);
    }

    public void lects(View view) {

        intent = new Intent(this, Lecturers.class);

        startActivity(intent);
    }


    public void News(View view) {
        intent = new Intent(this, News.class);
        startActivity(intent);
    }

    public void busInfo(View view) {
        intent = new Intent(this, Bus.class);
        startActivity(intent);
    }

    public void settings(View view) {

        intent = new Intent(this, Assignments.class);
        startActivity(intent);
    }


    public void about(View view) {

        intent = new Intent(this, AboutMe.class);
        startActivity(intent);
    }

    public void subs(View view) {

        intent = new Intent(this, SubjectsPage.class);
        startActivity(intent);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.main, menu);


        return super.onCreateOptionsMenu(menu);


    }

    public void reportIT(MenuItem item) {

        intent = new Intent();
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


    public void Navigation(View view) {

        intent = new Intent(this, Navigation.class);
        startActivity(intent);
    }
}


