package com.example.bloodbank;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class Login extends AppCompatActivity   {


    transient TextView txtsignup;
    Button btn_login,btn_adminlogin;
    EditText passwor;
    EditText email;
    private FirebaseAuth mAuth,aAuth;

    private DatabaseReference dfReference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        txtsignup = findViewById(R.id.txt_signup);
        btn_login = findViewById(R.id.button_login);

        passwor = findViewById(R.id.editTextTextPassword);
        email = findViewById(R.id.editTextTextEmailAddress);


        mAuth=FirebaseAuth.getInstance();

        txtsignup.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method
                Intent t = new Intent(Login.this, signup.class);
                startActivity(t);
            }
        });


    }
    public void submitclick(View view) {
        if (!checkvalidation()) {
            return;
        } else {
            String emails=email.getText().toString();
            String passwords=passwor.getText().toString();

            mAuth.signInWithEmailAndPassword(emails,passwords).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                @Override
                public void onComplete(@NonNull Task<AuthResult> task) {
                    if(task.isSuccessful()){
                        //redirect to user file


                        startActivity(new Intent(Login.this,Selection.class));

                    }else{
                        Toast.makeText(Login.this, "Failed To Login", Toast.LENGTH_LONG).show();
                    }
                }
            });

        }
    }
    public void click(View view) {

        if (!checkvalidation()) {
            return;
        } else {

            String emails = email.getText().toString();
            String passwords = passwor.getText().toString();

                mAuth.signInWithEmailAndPassword(emails, passwords).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            //redirect to user file


                         //   startActivity(new Intent(Login.this, Admin.class));

                            Intent t=new Intent(Login.this,BloodBank.class);

                            startActivity(t);

                        } else {
                            Toast.makeText(Login.this, "Failed To Login", Toast.LENGTH_LONG).show();
                        }
                    }
                });

            }
        }

    private boolean checkvalidation() {

         if (TextUtils.isEmpty(email.getText().toString())) {
            email.setError("Please Enter Email Id");
            return false;
        }else if (passwor.length()<6){
            passwor.setText("Please Enter 6 Digit");
            passwor.requestFocus();
            return false;
        }
        else {
            return true;
        }
    }
}