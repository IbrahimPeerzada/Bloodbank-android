package com.example.bloodbank;

import androidx.annotation.NonNull;
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

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
public class Needblood extends AppCompatActivity {
    EditText cnic;
    EditText pname;
    Spinner spinner;
    EditText phone;
    private RadioGroup radioGroup;
    Button submit,show;
    EditText Hname;
    EditText aname;
    EditText aphone;

    DatabaseReference studentDbRef;
    FirebaseDatabase database=FirebaseDatabase.getInstance();
    DatabaseReference mDatabaseRef=database.getReference();

    private FirebaseAuth mAuth;
    private DatabaseReference dfReference;
    private long backpressedtime;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_needblood);
        pname = findViewById(R.id.Pname);
        cnic = findViewById(R.id.cnic);
        spinner = findViewById(R.id.spinner);
        phone = findViewById(R.id.Phoneid);
        Hname = findViewById(R.id.HName);
        aname = findViewById(R.id.AName);
        aphone = findViewById(R.id.APhone);


        submit =findViewById(R.id.btn);
        radioGroup =findViewById(R.id.radiogroup1);

        studentDbRef=FirebaseDatabase.getInstance().getReference().child("Needblodd");


    }
    public void submitclick(View view) {

        if (!checkvalidation()) {
            return;
        } else {
            String pnames= pname.getText().toString();
            String cnics=cnic.getText().toString();
            String spineers=spinner.getSelectedItem().toString();
            String phones=phone.getText().toString();
            String hnames=Hname.getText().toString();
            String anames=aname.getText().toString();
            String aphoness=aphone.getText().toString();
            String status="";

           Mneedblood mneedblood=new Mneedblood(pnames,cnics,spineers,phones,hnames,anames,aphoness,status);
            studentDbRef.child(cnics).setValue(mneedblood);
            Toast.makeText(this, "data inserted", Toast.LENGTH_SHORT).show();


        }
    }
    private boolean checkvalidation() {

        if (TextUtils.isEmpty(pname.getText().toString())) {
            pname.setError("Please Enter Patients Name");
            return false;
        } else if (TextUtils.isEmpty(cnic.getText().toString())) {
            cnic.setError("Please Enter Patients CNIC");
            return false;
        } else if (spinner.getSelectedItem().toString().trim().equalsIgnoreCase("Pick one")) {
            Toast.makeText(this, "Error", Toast.LENGTH_SHORT).show();
            return false;
        } else if (TextUtils.isEmpty(phone.getText().toString())) {
            phone.setError("Please Enter Patients Phone number");
            return false;
        }else if (TextUtils.isEmpty(Hname.getText().toString())){
            Hname.setError("Please Enter Hospital Name ");
            return false;
        }else if (TextUtils.isEmpty(aname.getText().toString())){
            aname.setError("Please Enter Attendants Name");
            return false;
        }else if (TextUtils.isEmpty(aphone.getText().toString())){
            aphone.setError("Please Enter Attendants contact number");
            return false;
        }else if(radioGroup.getCheckedRadioButtonId()==-1){//No Radio Button Is Checked
            Toast.makeText(getApplicationContext(), "Please Select Gender", Toast.LENGTH_LONG).show();
            return false;
        }
        else {
            return true;
        }
    }
}