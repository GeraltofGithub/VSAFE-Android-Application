package com.example.vscan1;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class register extends AppCompatActivity {

    private FirebaseAuth auth;
    private EditText signupusername, signuppass;
    private Button signinbutton;
    private TextView loginredirecttxt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        auth = FirebaseAuth.getInstance();
        signupusername = findViewById(R.id.signuptext);
        signuppass = findViewById(R.id.signuppassword);
        signinbutton = findViewById(R.id.Signupbutton);
        loginredirecttxt = findViewById(R.id.loginprompt);

        signinbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String user = signupusername.getText().toString().trim();
                String password = signuppass.getText().toString().trim();
                if(user.isEmpty()){
                    signupusername.setError("Email cannot be empty!");
                } else if (password.isEmpty()) {
                    signuppass.setError("Password cannot be empty!");
                }else{
                    auth.createUserWithEmailAndPassword(user,password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if(task.isSuccessful()){
                                Toast.makeText(register.this, "Registration Successful!", Toast.LENGTH_SHORT).show();
                                startActivity(new Intent(register.this,login.class));
                            }else{
                                Toast.makeText(register.this, "Registration Failed!"+task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                            }
                        }
                    });
                }
            }
        });

        loginredirecttxt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(register.this,login.class));
            }
        });
    }


}