package com.osamaislam.auxiliarit;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;

import lecturers_pages.hemantPage;
import lecturers_pages.hudaPage;
import lecturers_pages.izanPage;
import lecturers_pages.kelvinPage;
import lecturers_pages.mahdiPage;
import lecturers_pages.marwanPage;
import lecturers_pages.matthewPage;
import lecturers_pages.mutazPage;
import lecturers_pages.norhayatiPage;
import lecturers_pages.norisPage;
import lecturers_pages.shalikenPage;
import lecturers_pages.tonyPage;
import lecturers_pages.vinodPage;
import lecturers_pages.waelPage;

public class Lecturers extends Activity {


    Intent intent;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lecturers);



    }




    public void mProfile(View view) {
        intent = new Intent(this, mahdiPage.class);
        startActivity(intent);
    }

    public void mattProfile(View view) {
        intent = new Intent(this, matthewPage.class);
        startActivity(intent);
    }

    public void vProfile(View view) {
        intent = new Intent(this, vinodPage.class);
        startActivity(intent);
    }

    public void muProfile(View view) {
        intent = new Intent(this, mutazPage.class);
        startActivity(intent);
    }

    public void marwanProfile(View view) {
        intent = new Intent(this, marwanPage.class);
        startActivity(intent);
    }


    public void tonyProfile(View view) {
        intent = new Intent(this, tonyPage.class);
        startActivity(intent);
    }

    public void kelvinProfile(View view) {
        intent = new Intent(this, kelvinPage.class);
        startActivity(intent);
    }

    public void hemantProfile(View view) {
        intent = new Intent(this, hemantPage.class);
        startActivity(intent);
    }

    public void izanProfile(View view) {
        intent = new Intent(this, izanPage.class);
        startActivity(intent);
    }

    public void hayatiProfile(View view) {
        intent = new Intent(this, norhayatiPage.class);
        startActivity(intent);
    }

    public void norisProfile(View view) {
        intent = new Intent(this, norisPage.class);
        startActivity(intent);
    }

    public void hudaProfile(View view) {
        intent = new Intent(this, hudaPage.class);
        startActivity(intent);
    }


    public void shaProfile(View view) {
        intent = new Intent(this, shalikenPage.class);
        startActivity(intent);
    }

    public void waelProfile(View view) {
        intent = new Intent(this, waelPage.class);
        startActivity(intent);
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
