package com.example.fastdoctor;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

import com.example.fastdoctor.doctor.HomeDoctor;
import com.example.fastdoctor.patient.HomePatient;

public class MainActivity extends AppCompatActivity {
    Button callSignUp, callHomePatient;
    EditText login, passwd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_main);


        callSignUp = findViewById(R.id.signUp_screen);
        callSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, SignUpActivity.class);
                startActivity(intent);
            }
        });

        //Test login and password
        login = findViewById(R.id.username);
        passwd = findViewById(R.id.psswd);
        callHomePatient = findViewById(R.id.identifier);

        callHomePatient.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (login.getText().toString().equals("patient")) {
                    Intent intent = new Intent(MainActivity.this, HomePatient.class);
                    startActivity(intent);
                }
                if (login.getText().toString().equals("")) {
                    Intent intent = new Intent(MainActivity.this, HomeDoctor.class);
                    startActivity(intent);
                }
            }
        });


    }
}