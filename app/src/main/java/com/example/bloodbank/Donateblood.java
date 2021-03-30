package com.example.bloodbank;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class Donateblood extends AppCompatActivity {


    EditText fname;
    EditText phone;
    EditText name;
    EditText age;
    EditText address;

    DatabaseReference studentDbRef;
    FirebaseDatabase database=FirebaseDatabase.getInstance();
    DatabaseReference mDatabaseRef=database.getReference();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_donateblood);

        fname = findViewById(R.id.fName);


        phone = findViewById(R.id.Phone);
        name = findViewById(R.id.name);
        address = findViewById(R.id.Address);
        age = findViewById(R.id.Age);

        studentDbRef=FirebaseDatabase.getInstance().getReference().child("DonateBlood");




    }
    public void submitclick1(View view) {
        if (!checkvalidation()) {
            return;
        } else {

            String names=name.getText().toString();
            String fnames=fname.getText().toString();
            String ages=age.getText().toString();
            String phones=phone.getText().toString();
            String addres=address.getText().toString();
            String statuss=" ";


            Mdonateblood mdonateblood=new Mdonateblood(names,fnames,ages,phones,addres,statuss);
            studentDbRef.child(phones).setValue(mdonateblood);
            Toast.makeText(this, "data inserted", Toast.LENGTH_SHORT).show();


        }
    }
    private boolean checkvalidation() {

        if (TextUtils.isEmpty(name.getText().toString())) {
            name.setError("Please Enter Name");
            return false;
        } else if (TextUtils.isEmpty(fname.getText().toString())) {
            fname.setError("Please Enter Father's Name");
            return false;
        } else if (TextUtils.isEmpty(phone.getText().toString())) {
            phone.setError("Please Enter Patients Phone number");
            return false;
        }else if (TextUtils.isEmpty(age.getText().toString())){
            age.setError("Please Enter Your Age");
            return false;
        }else if (TextUtils.isEmpty(address.getText().toString())){
            address.setError("Please Enter Your Address");
            return false;
        }
        else {
            return true;
        }
    }

}