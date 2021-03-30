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

public class signup<dfReference> extends AppCompatActivity  {

    EditText password;
    EditText firstname;
    EditText lastname;
    EditText phone;
    EditText email;
    Button submit;
    TextView txtsign;
    private FirebaseAuth mAuth;
    private DatabaseReference  dfReference;
    private long backpressedtime;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);


        mAuth=FirebaseAuth.getInstance();
        firstname = findViewById(R.id.Fname);
        lastname = findViewById(R.id.Lname);
        phone = findViewById(R.id.Phoneid);
        email = findViewById(R.id.emailid);
        submit = findViewById(R.id.button222);
        txtsign = findViewById(R.id.txt_login);
        password = findViewById(R.id.Password);

        txtsign.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method

                Intent t = new Intent(signup.this, Login.class);
                startActivity(t);


            }
        });
    }
    @Override
    protected void onDestroy() {
        super.onDestroy();
        onBackPressed();
    }

    public void submitclick(View view) {
        String emails= email.getText().toString();
        String passwords=password.getText().toString();
        String fnames=firstname.getText().toString();
        String lnames=lastname.getText().toString();
        String phones=phone.getText().toString();
        if (!checkvalidation() | !validateemail()) {
            return;
        } else {
            mAuth.createUserWithEmailAndPassword(emails,passwords)
                    .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if(task.isSuccessful()){
                                User user=new User(fnames,lnames,emails,phones);

                              dfReference=  FirebaseDatabase.getInstance().getReference("Users");
                                        dfReference.child(phones)
                                        .setValue(user).addOnCompleteListener(new OnCompleteListener<Void>() {
                                    @Override
                                    public void onComplete(@NonNull Task<Void> task) {
                                        if(task.isSuccessful()){
                                            Toast.makeText(signup.this, "User Has Been Registerd", Toast.LENGTH_SHORT).show();
                                            startActivity(new Intent(signup.this,Login.class));
                                        }else{
                                            Toast.makeText(signup.this, "Failed Registerd", Toast.LENGTH_SHORT).show();
                                        }
                                    }
                                });
                            }else{
                                Toast.makeText(signup.this, "Failed Registerd", Toast.LENGTH_SHORT).show();
                            }
                        }
                    });


        }
    }
    private boolean checkvalidation() {




        if (TextUtils.isEmpty(firstname.getText().toString())) {
            firstname.setError("Please Enter Email Id");
            return false;
        } else if (TextUtils.isEmpty(lastname.getText().toString())) {
            lastname.setError("Please Enter Last Name");
            return false;
        } else if (TextUtils.isEmpty(phone.getText().toString())) {
            phone.setError("Please Enter Valid Phone Number");
            return false;
        } else if (TextUtils.isEmpty(email.getText().toString())) {
            email.setError("Please Enter Email Id");
            return false;
        }else if ( TextUtils.isEmpty(password.getText().toString())|| password.length()<6) {
            password.setError("Please Enter password");
            return false;
        }
        else {
            return true;
        }
    }

    private boolean validateemail() {
        String val = email.getText().toString().trim();
        String checkemail = "[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+";

        if (!val.matches(checkemail)) {
            email.setError("No White Spaces are Allowed");
            return false;
        } else {
            email.setError(null);
            email.setEnabled(false);
            return true;
        }
    }

}