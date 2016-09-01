package com.osamaislam.auxiliarit;

import android.app.Activity;
import android.content.Intent;
import android.graphics.PorterDuff;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;

public class Bus extends Activity {

    TextView busName;
    TextView busRoute;
    TextView stops;
    Button busStop;
    Spinner spinner;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bus);

        ArrayAdapter<CharSequence> adapter;

        spinner = (Spinner) findViewById(R.id.spinner);
        spinner.getBackground().setColorFilter(getResources().getColor(android.R.color.holo_blue_dark), PorterDuff.Mode.SRC_ATOP);
        adapter = ArrayAdapter.createFromResource(this, R.array.places, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                busName = (TextView) findViewById(R.id.busName);
                busRoute = (TextView) findViewById(R.id.routine);
                busStop = (Button)findViewById(R.id.busStop);
                stops = (TextView) findViewById(R.id.stops);

                switch (i) {
                    case 0: busName.setText("T520"); busRoute.setText("Every 40 minutes"); break;
                    case 1: busName.setText("T520"); busRoute.setText("Every 40 minutes"); break;
                    case 2: busName.setText("T520"); busRoute.setText("Every 40 minutes"); break;
                    case 3: busName.setText("T520"); busRoute.setText("Every 40 minutes"); break;
                }

                String x = busName.getText().toString();

                if (x == "T520") {stops.setText("Dpulze - Domain - Cyberia A-B - Crescent - Arc");}
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
    }

    public void map(View view) {
        String textOnSpinner = spinner.getSelectedItem().toString();
        Intent intent;
        switch (textOnSpinner) {
            case "Domain": intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://goo.gl/maps/ZvrNBG8YSNC2")); startActivity(intent); break;
            case "Arc":    intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://goo.gl/maps/sfSYsZZCcMm")); startActivity(intent); break;
            case "Cyberia A-B": intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://goo.gl/maps/EqFe5TBdfX12")); startActivity(intent); break;
            case "Cyberia C": intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://goo.gl/maps/sfSYsZZCcMm")); startActivity(intent); break;
            case "Dpulze": intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://goo.gl/maps/Ef8gEFYHdBL2")); startActivity(intent); break;
            case "Crescent": intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://goo.gl/maps/EqFe5TBdfX12")); startActivity(intent);
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
