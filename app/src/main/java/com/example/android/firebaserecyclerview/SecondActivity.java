package com.example.android.firebaserecyclerview;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;
import java.util.Random;
import java.util.UUID;

public class SecondActivity extends AppCompatActivity {

    private DatabaseReference schoolReference = FirebaseDatabase.getInstance().getReference("school");
    private ArrayList<SchoolOfEducation> schools = new ArrayList<>();
    private EditText schoolName;
    private EditText totalEnrollment;
    private EditText yearOfFoundation;
    private SchoolOfEducation school;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        if (getIntent() != null)
            school = (SchoolOfEducation) getIntent().getSerializableExtra(Keys.GSE);

        schoolName = (EditText) findViewById(R.id.school_name);
        totalEnrollment = (EditText) findViewById(R.id.total_enrollment);
        yearOfFoundation = (EditText) findViewById(R.id.school_year_of_foundation);

        if (school != null) {
            schoolName.setText(school.name);
            totalEnrollment.setText(String.valueOf(school.totalEnrollment));
            yearOfFoundation.setText(String.valueOf(school.yearOfFoundation));
        }

    }

    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_second, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()) {
            case R.id.menu_item_save:
                if (school == null) {
                    String id = UUID.randomUUID().toString();
                    Random random = new Random();
                    String schoolName1 = schoolName.getText().toString();
                    int enrollment = Integer.parseInt(totalEnrollment.getText().toString());
                    int foundation = Integer.parseInt(yearOfFoundation.getText().toString());

                    schoolReference.child(id).setValue(new SchoolOfEducation(id, schoolName1, enrollment, foundation));
                } else {
                    saveSchool();
                }

                Intent intent = new Intent(this, MainActivity.class);
                startActivity(intent);
                return true;
            case R.id.menu_item_delete:
                if (school != null)
                    schoolReference.child(school.id).removeValue();
                finish();
//        Intent intent2 = new Intent(this, MainActivity.class);
//        startActivity(intent2);
                return true;
            default:
                return super.onOptionsItemSelected(item);


        }
    }

    public void addSchool() {
        String id = UUID.randomUUID().toString();
        SchoolOfEducation s = new SchoolOfEducation(id, schoolName.getText().toString(), Integer.parseInt(totalEnrollment.getText().toString()), Integer.parseInt(yearOfFoundation.getText().toString()));
        schoolReference.child(id).setValue(s);
    }


    public void saveSchool() {

        school.name = schoolName.getText().toString();
        school.totalEnrollment = Integer.parseInt(totalEnrollment.getText().toString());
        school.yearOfFoundation = Integer.parseInt(yearOfFoundation.getText().toString());
        schoolReference.child(school.id).setValue(school);
    }
}


