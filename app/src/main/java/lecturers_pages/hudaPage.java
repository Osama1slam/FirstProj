package lecturers_pages;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;

import com.osamaislam.auxiliarit.AboutApp;
import com.osamaislam.auxiliarit.R;

public class hudaPage extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_huda_page);
    }
    public void sendHuda(View view) {
        Intent intent = new Intent();
        intent.setAction(Intent.ACTION_SEND);
        intent.putExtra(Intent.EXTRA_EMAIL, new String[] {"huda.jameel@limkokwing.edu.my"});
        intent.putExtra(Intent.EXTRA_TEXT, "Hello Ms. Huda\n\n\n\n" +
                "\n" +
                "\n" +
                "\n~ Sent from AuxiliarIT App");
        intent.setType("message/rfc822");
        startActivity(intent);
    }

    public void hudaFace(View view) {
        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.facebook.com/huda.alhassany?ref=ts"));
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

