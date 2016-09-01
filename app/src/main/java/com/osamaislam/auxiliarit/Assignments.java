 package com.osamaislam.auxiliarit;

import android.app.Activity;
import android.app.DatePickerDialog;
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
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Calendar;

 public class Assignments extends Activity {

     Intent intent;

     SubjectsPage subjectsPage;

        SharedPreferences shared;
     SharedPreferences subShared;

     EditText assignmentName;
     TextView assignmentDate;
     Spinner spinner;
     ArrayAdapter adapter;
     String sName;

     TextView asName1;
     TextView asName2;
     TextView asName3;
     TextView asName4;
     TextView asName5;

     TextView asSub1;
     TextView asSub2;
     TextView asSub3;
     TextView asSub4;
     TextView asSub5;

     TextView dueDate1;
     TextView dueDate2;
     TextView dueDate3;
     TextView dueDate4;
     TextView dueDate5;

     int row;




     final Calendar c = Calendar.getInstance();
     TextView dateOfAssignment;
















     @Override
     protected void onCreate(Bundle savedInstanceState) {
         super.onCreate(savedInstanceState);
         setContentView(R.layout.activity_assignments);



         dateOfAssignment = (TextView) findViewById(R.id.dateOfAssignment);

         subjectsPage = new SubjectsPage();
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




         spinner = (Spinner) findViewById(R.id.spinner);
         spinner.getBackground().setColorFilter(getResources().getColor(android.R.color.holo_blue_dark), PorterDuff.Mode.SRC_ATOP);
         adapter = new ArrayAdapter<>(this, R.layout.spinner_small, R.id.customSpinner, subjectsPage.Subjects);
         adapter.setDropDownViewResource(R.layout.spinner_norm);
         spinner.setAdapter(adapter);

         spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
             @Override
             public void onItemSelected(AdapterView<?> adapterView, View view, int item, long l) {

                 switch(item) {
                     case 0: sName = subjectsPage.Subjects[0]; break;
                     case 1: sName = subjectsPage.Subjects[1]; break;
                     case 2: sName = subjectsPage.Subjects[2]; break;
                     case 3: sName = subjectsPage.Subjects[3]; break;
                     case 4: sName = subjectsPage.Subjects[4]; break;
                     case 5: sName = subjectsPage.Subjects[5]; break;
                     case 6: sName = subjectsPage.Subjects[6]; break;
                     case 7: sName = subjectsPage.Subjects[7]; break;
                     case 8: sName = subjectsPage.Subjects[8]; break;
                     case 9: sName = subjectsPage.Subjects[9];


                 }

             }

             @Override
             public void onNothingSelected(AdapterView<?> adapterView) {

             }
         });

            shared = getSharedPreferences("AssignmentDatabase", MODE_PRIVATE);

         asName1 = (TextView) findViewById(R.id.asName1);
         asName2 = (TextView) findViewById(R.id.asName2);
         asName3 = (TextView) findViewById(R.id.asName3);
         asName4 = (TextView) findViewById(R.id.asName4);
         asName5 = (TextView) findViewById(R.id.asName5);

         asSub1 = (TextView) findViewById(R.id.subName1);
         asSub2 = (TextView) findViewById(R.id.subName2);
         asSub3 = (TextView) findViewById(R.id.subName3);
         asSub4 = (TextView) findViewById(R.id.subName4);
         asSub5 = (TextView) findViewById(R.id.subName5);

         dueDate1 = (TextView) findViewById(R.id.dueDate1);
         dueDate2 = (TextView) findViewById(R.id.dueDate2);
         dueDate3 = (TextView) findViewById(R.id.dueDate3);
         dueDate4 = (TextView) findViewById(R.id.dueDate4);
         dueDate5 = (TextView) findViewById(R.id.dueDate5);


         String AssignmentName1 = shared.getString("AssignmentName1", "");
         String AssignmentSubject1 = shared.getString("AssignmentSubject1", "");
         String AssignmentDate1 = shared.getString("AssignmentDate1", "");

         String AssignmentName2 = shared.getString("AssignmentName2", "");
         String AssignmentSubject2 = shared.getString("AssignmentSubject2", "");
         String AssignmentDate2 = shared.getString("AssignmentDate2", "");

         String AssignmentName3 = shared.getString("AssignmentName3", "");
         String AssignmentSubject3 = shared.getString("AssignmentSubject3", "");
         String AssignmentDate3 = shared.getString("AssignmentDate3", "");

         String AssignmentName4 = shared.getString("AssignmentName4", "");
         String AssignmentSubject4 = shared.getString("AssignmentSubject4", "");
         String AssignmentDate4 = shared.getString("AssignmentDate4", "");

         String AssignmentName5 = shared.getString("AssignmentName5", "");
         String AssignmentSubject5 = shared.getString("AssignmentSubject5", "");
         String AssignmentDate5 = shared.getString("AssignmentDate5", "");


         if (AssignmentName1 != "") {
             asName1.setText(AssignmentName1);
             asSub1.setText(AssignmentSubject1);
             dueDate1.setText(AssignmentDate1);
         }

         if (AssignmentName2 != "") {
             asName2.setText(AssignmentName2);
             asSub2.setText(AssignmentSubject2);
             dueDate2.setText(AssignmentDate2);
         }

         if (AssignmentName3 != "") {
             asName3.setText(AssignmentName3);
             asSub3.setText(AssignmentSubject3);
             dueDate3.setText(AssignmentDate3);
         }

         if (AssignmentName4 != "") {
             asName4.setText(AssignmentName4);
             asSub4.setText(AssignmentSubject4);
             dueDate4.setText(AssignmentDate4);
         }

         if (AssignmentName5 != "") {
             asName5.setText(AssignmentName5);
             asSub5.setText(AssignmentSubject5);
             dueDate5.setText(AssignmentDate5);
         }


         LinearLayout l1 = (LinearLayout) findViewById(R.id.v1);
         LinearLayout l2 = (LinearLayout) findViewById(R.id.v2);
         LinearLayout l3 = (LinearLayout) findViewById(R.id.v3);
         LinearLayout l4 = (LinearLayout) findViewById(R.id.v4);
         LinearLayout l5 = (LinearLayout) findViewById(R.id.v5);
         LinearLayout l6 = (LinearLayout) findViewById(R.id.v6);
         LinearLayout l7 = (LinearLayout) findViewById(R.id.v7);
         LinearLayout l8 = (LinearLayout) findViewById(R.id.v8);
         LinearLayout l9 = (LinearLayout) findViewById(R.id.v9);
         LinearLayout l10 = (LinearLayout) findViewById(R.id.v10);
         LinearLayout l11 = (LinearLayout) findViewById(R.id.v11);
         LinearLayout l12 = (LinearLayout) findViewById(R.id.v12);
         LinearLayout l13 = (LinearLayout) findViewById(R.id.v13);
         LinearLayout l14 = (LinearLayout) findViewById(R.id.v14);
         LinearLayout l15 = (LinearLayout) findViewById(R.id.v15);



         registerForContextMenu(l1);
         registerForContextMenu(l2);
         registerForContextMenu(l3);
         registerForContextMenu(l4);
         registerForContextMenu(l5);
         registerForContextMenu(l6);
         registerForContextMenu(l7);
         registerForContextMenu(l8);
         registerForContextMenu(l9);
         registerForContextMenu(l10);
         registerForContextMenu(l11);
         registerForContextMenu(l12);
         registerForContextMenu(l13);
         registerForContextMenu(l14);
         registerForContextMenu(l15);

     }





     public void addToDatabase(View view) {



         shared = getSharedPreferences("AssignmentDatabase", MODE_PRIVATE);

         assignmentName = (EditText) findViewById(R.id.assignmentName);

         if (assignmentName.getText().toString().isEmpty()) {
             Toast.makeText(this, "Add the Assignment name", Toast.LENGTH_SHORT).show();
             return;
         }


         assignmentDate = (TextView) findViewById(R.id.dateOfAssignment);


         if (assignmentDate.getText().toString().isEmpty()) {
             Toast.makeText(this, "Choose the due date", Toast.LENGTH_SHORT).show();
             return;
         }

         asName1 = (TextView) findViewById(R.id.asName1);
         asName2 = (TextView) findViewById(R.id.asName2);
         asName3 = (TextView) findViewById(R.id.asName3);
         asName4 = (TextView) findViewById(R.id.asName4);
         asName5 = (TextView) findViewById(R.id.asName5);

         asSub1 = (TextView) findViewById(R.id.subName1);
         asSub2 = (TextView) findViewById(R.id.subName2);
         asSub3 = (TextView) findViewById(R.id.subName3);
         asSub4 = (TextView) findViewById(R.id.subName4);
         asSub5 = (TextView) findViewById(R.id.subName5);

         dueDate1 = (TextView) findViewById(R.id.dueDate1);
         dueDate2 = (TextView) findViewById(R.id.dueDate2);
         dueDate3 = (TextView) findViewById(R.id.dueDate3);
         dueDate4 = (TextView) findViewById(R.id.dueDate4);
         dueDate5 = (TextView) findViewById(R.id.dueDate5);

         SharedPreferences.Editor editor = shared.edit();

         if (asName1.getText().toString() == ""){




             editor.putString("AssignmentName1", assignmentName.getText().toString());
             editor.putString("AssignmentSubject1", sName);
             editor.putString("AssignmentDate1", assignmentDate.getText().toString());
             editor.apply();

             asName1.setText(assignmentName.getText().toString());
             asSub1.setText(sName);
             dueDate1.setText(assignmentDate.getText().toString());
         }

         else if (asName2.getText().toString() == ""){


             editor.putString("AssignmentName2", assignmentName.getText().toString());
             editor.putString("AssignmentSubject2", sName);
             editor.putString("AssignmentDate2", assignmentDate.getText().toString());
             editor.apply();

             asName2.setText(assignmentName.getText().toString());
             asSub2.setText(sName);
             dueDate2.setText(assignmentDate.getText().toString());

         }

         else if (asName3.getText().toString() == ""){


             editor.putString("AssignmentName3", assignmentName.getText().toString());
             editor.putString("AssignmentSubject3", sName);
             editor.putString("AssignmentDate3", assignmentDate.getText().toString());
             editor.apply();

             asName3.setText(assignmentName.getText().toString());
             asSub3.setText(sName);
             dueDate3.setText(assignmentDate.getText().toString());

         }

         else if (asName4.getText().toString() == ""){


             editor.putString("AssignmentName4", assignmentName.getText().toString());
             editor.putString("AssignmentSubject4", sName);
             editor.putString("AssignmentDate4", assignmentDate.getText().toString());
             editor.apply();

             asName4.setText(assignmentName.getText().toString());
             asSub4.setText(sName);
             dueDate4.setText(assignmentDate.getText().toString());

         }

         else if (asName5.getText().toString() == ""){


             editor.putString("AssignmentName5", assignmentName.getText().toString());
             editor.putString("AssignmentSubject5", sName);
             editor.putString("AssignmentDate5", assignmentDate.getText().toString());
             editor.apply();

             asName5.setText(assignmentName.getText().toString());
             asSub5.setText(sName);
             dueDate5.setText(assignmentDate.getText().toString());

         }

         else Toast.makeText(Assignments.this, "No enough space :(", Toast.LENGTH_SHORT).show();



         assignmentName.setText("");
         assignmentDate.setText("");
     }


     @Override
     public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {


         this.getMenuInflater().inflate(R.menu.popup, menu);


         if(v.getId() == R.id.v1 || v.getId() == R.id.v2 || v.getId() == R.id.v3){
             row = 1;}
         else if (v.getId() == R.id.v4 || v.getId() == R.id.v5 || v.getId() == R.id.v6){
             row = 2;}
         else if (v.getId() == R.id.v7 || v.getId() == R.id.v8 || v.getId() == R.id.v9){
             row = 3;}
         else if (v.getId() == R.id.v10 || v.getId() == R.id.v11 || v.getId() == R.id.v12){
             row = 4;}
         else if (v.getId() == R.id.v13 || v.getId() == R.id.v14 || v.getId() == R.id.v15){
             row = 5;}


         super.onCreateContextMenu(menu, v, menuInfo);





     }


     @Override
     public boolean onContextItemSelected(MenuItem item) {

         int selectedId = item.getItemId();

         switch (selectedId) {

             case R.id.n1: delFromDatabase("Delete"); break;

             //case R.id.n2: delFromDatabase("Modify");

         }
         return super.onContextItemSelected(item);
     }




        public void delFromDatabase(String S) {


            shared = getSharedPreferences("AssignmentDatabase", MODE_PRIVATE);

            SharedPreferences.Editor editor = shared.edit();

            asName1 = (TextView) findViewById(R.id.asName1);
            asName2 = (TextView) findViewById(R.id.asName2);
            asName3 = (TextView) findViewById(R.id.asName3);
            asName4 = (TextView) findViewById(R.id.asName4);
            asName5 = (TextView) findViewById(R.id.asName5);

            asSub1 = (TextView) findViewById(R.id.subName1);
            asSub2 = (TextView) findViewById(R.id.subName2);
            asSub3 = (TextView) findViewById(R.id.subName3);
            asSub4 = (TextView) findViewById(R.id.subName4);
            asSub5 = (TextView) findViewById(R.id.subName5);

            dueDate1 = (TextView) findViewById(R.id.dueDate1);
            dueDate2 = (TextView) findViewById(R.id.dueDate2);
            dueDate3 = (TextView) findViewById(R.id.dueDate3);
            dueDate4 = (TextView) findViewById(R.id.dueDate4);
            dueDate5 = (TextView) findViewById(R.id.dueDate5);

            if (S == "Delete") {

                switch(row) {
                    case 1: editor.remove("AssignmentName1"); editor.remove("AssignmentSubject1"); editor.remove("AssignmentDate1");
                        asName1.setText(""); asSub1.setText(""); dueDate1.setText("");  break;

                    case 2: editor.remove("AssignmentName2"); editor.remove("AssignmentSubject2"); editor.remove("AssignmentDate2");
                        asName2.setText(""); asSub2.setText(""); dueDate2.setText(""); break;

                    case 3: editor.remove("AssignmentName3"); editor.remove("AssignmentSubject3"); editor.remove("AssignmentDate3");
                        asName3.setText(""); asSub3.setText(""); dueDate3.setText(""); break;

                    case 4: editor.remove("AssignmentName4"); editor.remove("AssignmentSubject4"); editor.remove("AssignmentDate4");
                        asName4.setText(""); asSub4.setText(""); dueDate4.setText(""); break;

                    case 5: editor.remove("AssignmentName5"); editor.remove("AssignmentSubject5"); editor.remove("AssignmentDate5");
                        asName5.setText(""); asSub5.setText(""); dueDate5.setText("");

                }

                editor.apply();



            }


        }



     public void chooseDate(View view) {



         new DatePickerDialog(this, listener, c.get(Calendar.YEAR), c.get(Calendar.MONTH), c.get(Calendar.DAY_OF_MONTH)).show();

     }

        DatePickerDialog.OnDateSetListener listener = new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker datePicker, int year, int month, int day) {
                   dateOfAssignment.setText(day + "/" + (month+1));






            }
        };


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
