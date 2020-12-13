package com.example.fastdoctor;

import androidx.appcompat.app.AppCompatActivity;
import android.app.ActivityOptions;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.util.Pair;
import android.view.View;
import android.widget.Button;

public class SignUpPatient extends AppCompatActivity {
    Button backBtn,next;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up_patient);

        next = findViewById(R.id.btn_signup_next);
        backBtn = findViewById(R.id.btn_back);

        backBtn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                Intent intent = new Intent(SignUpPatient.this, SignUp.class);
                startActivity(intent);
            }
        });

    }
    public void callNextScreen(View view) {
        Intent intent = new Intent(getApplicationContext(), SignUp2nd.class);
        // Add transition
        Pair[] pairs = new Pair[2];
        pairs[0] = new Pair<View, String>(backBtn, "transition_back");
        pairs[1] = new Pair<View, String>(next, "transition_next_btn");
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            ActivityOptions options = ActivityOptions.makeSceneTransitionAnimation(SignUpPatient.this, pairs);
            startActivity(intent, options.toBundle());
        } else {
            startActivity(intent);
        }

    }
}