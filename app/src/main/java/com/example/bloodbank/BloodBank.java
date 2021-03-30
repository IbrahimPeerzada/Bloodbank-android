package com.example.bloodbank;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
public class BloodBank extends AppCompatActivity {
    EditText editTextupate;
    Button viewneedy,viewdonated,upneedy,updonated;
    Spinner spinnerNeedy;
    FirebaseDatabase  database = FirebaseDatabase.getInstance();
    DatabaseReference mDatabaseRef = database.getReference();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_blood_bank);
        viewneedy=findViewById(R.id.button_vNeedy);
        viewdonated=findViewById(R.id.button_vDonated);
        upneedy=findViewById(R.id.button_updateneedy);
        updonated=findViewById(R.id.button_updatedonated);
        editTextupate=findViewById(R.id.editTextupate);
        spinnerNeedy=findViewById(R.id.nSpinner);

        viewneedy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent t = new Intent(BloodBank.this, ShowactivityNeedBlood.class);
                startActivity(t);
            }
        });

        viewdonated.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent t = new Intent(BloodBank.this, showDonateBlood.class);
                startActivity(t);
            }
        });

        upneedy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                update();


            }


        });

        updonated.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                updatedonated();
            }
        });



    }

    public void update(){

        mDatabaseRef.child("Needblodd").child(editTextupate.getText().toString()).child("status").setValue(spinnerNeedy.getSelectedItem().toString());
        // mDatabaseRef.child("Students").child(etRollno.getText().toString()).child("course").setValue(spinnerCourses.getSelectedItem().toString());

        //  mDatabaseRef.child("Students").child(etRollno.getText().toString()).removeValue();

    }

    public void updatedonated(){

        mDatabaseRef.child("DonateBlood").child(editTextupate.getText().toString()).child("statuss").setValue(spinnerNeedy.getSelectedItem().toString());
        // mDatabaseRef.child("Students").child(etRollno.getText().toString()).child("course").setValue(spinnerCourses.getSelectedItem().toString());

        //  mDatabaseRef.child("Students").child(etRollno.getText().toString()).removeValue();

    }
}