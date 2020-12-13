package com.example.fastdoctor;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import static com.example.fastdoctor.R.*;

public class SignUp extends AppCompatActivity {
    Button callSignUpDoctor;
    Button callSignUpPatient;
    Button callIdentifier;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(layout.activity_sign_up);

        callSignUpDoctor = findViewById(R.id.signUp_doctor);
        callSignUpDoctor.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                Intent intent = new Intent(SignUp.this, SignUpDoctor.class);
                startActivity(intent);
            }
        });

        callSignUpPatient = findViewById(R.id.signUp_patient);
        callSignUpPatient.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                Intent intent = new Intent(SignUp.this, SignUpPatient.class);
                startActivity(intent);
            }
        });

        callIdentifier = findViewById(R.id.back_identification);
        callIdentifier.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                Intent intent = new Intent(SignUp.this, MainActivity.class);
                startActivity(intent);
            }
        });
    }
}

