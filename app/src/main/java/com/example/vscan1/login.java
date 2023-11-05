package com.example.vscan1;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class login extends AppCompatActivity {
    private FirebaseAuth auth;
    private EditText loginuser,loginpass;
    private Button loginbuttonn;
    private TextView signinpr;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        auth = FirebaseAuth.getInstance();
        loginuser = findViewById(R.id.Logintext);
        loginpass = findViewById(R.id.loginpassword);
        loginbuttonn = findViewById(R.id.loginbutton);
        signinpr = findViewById(R.id.signupprompt);

        loginbuttonn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String email = loginuser.getText().toString().trim();
                String pass = loginpass.getText().toString().trim();
                if(!email.isEmpty() && Patterns.EMAIL_ADDRESS.matcher(email).matches()){
                     if(!pass.isEmpty()){
                         auth.signInWithEmailAndPassword(email, pass).addOnSuccessListener(new OnSuccessListener<AuthResult>() {
                             @Override
                             public void onSuccess(AuthResult authResult) {
                                 Toast.makeText(login.this, "Login Successfull!", Toast.LENGTH_SHORT).show();
                                 startActivity(new Intent(login.this,DummyMainActivity.class)); //nextactivityhere
                                 finish();
                             }
                         }).addOnFailureListener(new OnFailureListener() {
                             @Override
                             public void onFailure(@NonNull Exception e) {
                                 Toast.makeText(login.this,"Login Failed",Toast.LENGTH_SHORT).show();
                             }
                         });
                     }else{
                         loginpass.setError("Password cannot be empty!!!");
                     }
                }else if(email.isEmpty()){
                    loginuser.setError("Username cannot be empty");
                }else{
                    loginuser.setError("Please enter valid Email-ID!!");
                }
            }
        });

        signinpr.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(login.this, register.class));
            }
        });
    }
}