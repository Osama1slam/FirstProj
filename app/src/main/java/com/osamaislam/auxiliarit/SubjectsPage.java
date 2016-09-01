package com.osamaislam.auxiliarit;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
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
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Arrays;

public class SubjectsPage extends Activity {

    EditText editText;
    ListView listView;
    ArrayAdapter arrayAdapter;
    SharedPreferences shared;


    String[] Subjects = {"", "", "", "", "", "", "", "", "", ""};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_subjects_page);


        refresh();
        registerForContextMenu(listView);

    }

    public void addSub(View view) {

        editText = (EditText) findViewById(R.id.subjectName);

        if (editText.getText().toString().isEmpty()) {
            Toast.makeText(this, "Enter the subject name", Toast.LENGTH_SHORT).show();
            return;
        }



            if (Subjects[0] == "") {
                Subjects[0] = editText.getText().toString(); setShared(0, Subjects[0]);
            }

            else if (Subjects[1] == "") {
                Subjects[1] = editText.getText().toString(); setShared(1, Subjects[1]);
            }

            else if (Subjects[2] == "") {
                Subjects[2] = editText.getText().toString(); setShared(2, Subjects[2]);
            }

            else if (Subjects[3] == "") {
                Subjects[3] = editText.getText().toString(); setShared(3, Subjects[3]);
            }

            else if (Subjects[4] == "") {
                Subjects[4] = editText.getText().toString(); setShared(4, Subjects[4]);
            }

            else if (Subjects[5] == "") {
                Subjects[5] = editText.getText().toString(); setShared(5, Subjects[5]);
            }

            else if (Subjects[6] == "") {
                Subjects[6] = editText.getText().toString(); setShared(6, Subjects[6]);
            }

            else if (Subjects[7] == "") {
                Subjects[7] = editText.getText().toString(); setShared(7, Subjects[7]);
            }

            else if (Subjects[8] == "") {
                Subjects[8] = editText.getText().toString(); setShared(8, Subjects[8]);
            }

            else if (Subjects[9] == "") {
                Subjects[9] = editText.getText().toString(); setShared(9, Subjects[9]);
            }

            editText.setText("");


        }




    private void refresh() {

        shared = getSharedPreferences("SubjectsDatabase", MODE_PRIVATE);


        Subjects[0] = shared.getString("Subject1", "");
        Subjects[1] = shared.getString("Subject2", "");
        Subjects[2] = shared.getString("Subject3", "");
        Subjects[3] = shared.getString("Subject4", "");
        Subjects[4] = shared.getString("Subject5", "");
        Subjects[5] = shared.getString("Subject6", "");
        Subjects[6] = shared.getString("Subject7", "");
        Subjects[7] = shared.getString("Subject8", "");
        Subjects[8] = shared.getString("Subject9", "");
        Subjects[9] = shared.getString("Subject10", "");



        listView = (ListView) findViewById(R.id.listView);

        arrayAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, Subjects);

        listView.setAdapter(arrayAdapter);
        listView.setClickable(false);



    }

    private void setShared(int item,String Name) {
        shared = getSharedPreferences("SubjectsDatabase", MODE_PRIVATE);
        SharedPreferences.Editor editor = shared.edit();

        if(item == 0){editor.putString("Subject1", Name);}

        else if (item == 1) {editor.putString("Subject2", Name);}

        else if (item == 2) {editor.putString("Subject3", Name);}

        else if (item == 3) {editor.putString("Subject4", Name);}

        else if (item == 4) {editor.putString("Subject5", Name);}

        else if (item == 5) {editor.putString("Subject6", Name);}

        else if (item == 6) {editor.putString("Subject7", Name);}

        else if (item == 7) {editor.putString("Subject8", Name);}

        else if (item == 8) {editor.putString("Subject9", Name);}

        else if (item == 9) {editor.putString("Subject10", Name);}


        editor.apply();




        refresh();







    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.popup, menu);
    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {
        shared = getSharedPreferences("SubjectsDatabase", MODE_PRIVATE);
        SharedPreferences.Editor editor = shared.edit();

            AdapterView.AdapterContextMenuInfo info = (AdapterView.AdapterContextMenuInfo) item.getMenuInfo();

        switch(item.getItemId()) {
            case R.id.n1:   if(info.position == 0) {editor.remove("Subject1");}
                                                            else if(info.position == 1) {editor.remove("Subject2");}
                                                            else if(info.position == 2) {editor.remove("Subject3");}
                                                            else if(info.position == 3) {editor.remove("Subject4");}
                                                            else if(info.position == 4) {editor.remove("Subject5");}
                                                            else if(info.position == 5) {editor.remove("Subject6");}
                                                            else if(info.position == 6) {editor.remove("Subject7");}
                                                            else if(info.position == 7) {editor.remove("Subject8");}
                                                            else if(info.position == 8) {editor.remove("Subject9");}
                                                            else if(info.position == 9) {editor.remove("Subject10");}
                                                            editor.apply();
                arrayAdapter.notifyDataSetChanged();
                refresh();
                return true;

            default: return super.onContextItemSelected(item);
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
