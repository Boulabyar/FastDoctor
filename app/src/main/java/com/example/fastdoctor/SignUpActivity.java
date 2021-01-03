package com.example.fastdoctor;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.fastdoctor.doctor.SignUp1Doctor;
import com.example.fastdoctor.patient.SignUp1Patient;

import static com.example.fastdoctor.R.*;

public class SignUpActivity extends AppCompatActivity {
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
                Intent intent = new Intent(SignUpActivity.this, SignUp1Doctor.class);
                startActivity(intent);
            }
        });

        callSignUpPatient = findViewById(R.id.signUp_patient);
        callSignUpPatient.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                Intent intent = new Intent(SignUpActivity.this, SignUp1Patient.class);
                startActivity(intent);
            }
        });

        callIdentifier = findViewById(R.id.back_identification);
        callIdentifier.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                Intent intent = new Intent(SignUpActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });
    }
}

