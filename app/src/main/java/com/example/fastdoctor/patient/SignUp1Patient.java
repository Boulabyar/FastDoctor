package com.example.fastdoctor.patient;

import android.app.ActivityOptions;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.util.Pair;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.example.fastdoctor.R;
import com.example.fastdoctor.SignUpActivity;

public class SignUp1Patient extends AppCompatActivity {
    Button backBtn, next;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup1_patient);

        next = findViewById(R.id.btn_signup_next);
        backBtn = findViewById(R.id.btn_back);

        backBtn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                Intent intent = new Intent(SignUp1Patient.this, SignUpActivity.class);
                startActivity(intent);
            }
        });

    }
    public void callNextScreen(View view) {
        Intent intent = new Intent(getApplicationContext(), SignUp2Patient.class);
        // Add transition
        Pair[] pairs = new Pair[2];
        pairs[0] = new Pair<View, String>(backBtn, "transition_back");
        pairs[1] = new Pair<View, String>(next, "transition_next_btn");
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            ActivityOptions options = ActivityOptions.makeSceneTransitionAnimation(SignUp1Patient.this, pairs);
            startActivity(intent, options.toBundle());
        } else {
            startActivity(intent);
        }

    }
}