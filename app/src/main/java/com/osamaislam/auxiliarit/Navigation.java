package com.osamaislam.auxiliarit;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

public class Navigation extends Activity {

    TextView block;
    TextView level;
    TextView venue;
    EditText LTLabClass;
    int ven = 1;

    Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_navigation);


    }

    public void chooseVenue(View view) {


        venue = (TextView) findViewById(R.id.venue);
        block = (TextView) findViewById(R.id.block);
        level = (TextView) findViewById(R.id.level);
        LinearLayout search = (LinearLayout) findViewById(R.id.search);



        switch(view.getId()) {
            case R.id.cls: venue.setText("Enter class number:"); ven = 1; break;

            case R.id.lt: search.setEnabled(false); block.setText("3"); level.setText("Ground Floor"); ven = 2; break;

            case R.id.faculty: block.setText("4"); level.setText("1"); ven = 3; break;

            case R.id.bursary: block.setText("4"); level.setText("Ground Floor"); ven =4; break;

            case R.id.visa: block.setText("1"); level.setText("1"); ven = 5; break;

            case R.id.stdser: block.setText("1"); level.setText("2"); ven =6; break;

            case R.id.fame: block.setText("1"); level.setText("3"); ven =7;




        }



    }

    public void fetch(View view) {

        block = (TextView) findViewById(R.id.block);
        level = (TextView) findViewById(R.id.level);
        LTLabClass = (EditText) findViewById(R.id.LTLabClass);

        if(LTLabClass.getText().toString().isEmpty()) {
            Toast.makeText(this, "Enter Class/LT number", Toast.LENGTH_SHORT).show(); return;
        }

        int v = Integer.parseInt(LTLabClass.getText().toString());

        if (ven == 1) {

            if (v <1 || v >115) {
                Toast.makeText(this, "Enter a valid number", Toast.LENGTH_SHORT).show(); return;
            }

            else if (v >=1 && v <=10) {
                block.setText("3");
                level.setText("Ground Floor");
            }

            else if (v >=11 && v <=12) {
                block.setText("4");
                level.setText("Ground Floor");
            }

            else if (v >=13 && v <=23) {
                block.setText("4");
                level.setText("1");
            }

            else if (v >=24 && v <=42) {
                block.setText("4");
                level.setText("2");
            }

            else if (v >=43 && v <=67) {
                block.setText("3");
                level.setText("2");
            }

            else if (v >=68 && v <=81) {
                block.setText("2");
                level.setText("3");
            }

            else if (v >=82 && v <=96) {
                block.setText("3");
                level.setText("3");
            }

            else if (v >=97 && v <=115) {
                block.setText("4");
                level.setText("3");
            }



        }

        else Toast.makeText(this, "You have to select *Class* first", Toast.LENGTH_SHORT).show();


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
}
