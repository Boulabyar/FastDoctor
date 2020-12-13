package com.example.fastdoctor;

import androidx.appcompat.app.AppCompatActivity;
import android.app.ActivityOptions;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.util.Pair;
import android.view.View;
import android.widget.Button;

public class SignUpDoctor extends AppCompatActivity {
    Button backBtn,next;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up_doctor);

        next = findViewById(R.id.btn_signup_next2);
        backBtn = findViewById(R.id.btn_back2);

        backBtn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                Intent intent = new Intent(SignUpDoctor.this, SignUp.class);
                startActivity(intent);
            }
        });

    }
    public void callNextScreen2(View view) {
            Intent intent = new Intent(getApplicationContext(), SignUp2ndDoct.class);
            // Add transition
            Pair[] pairs = new Pair[2];
            pairs[0] = new Pair<View, String>(backBtn, "transition_back_btn2");
            pairs[1] = new Pair<View, String>(next, "transition_next_btn2");
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                ActivityOptions options = ActivityOptions.makeSceneTransitionAnimation(SignUpDoctor.this, pairs);
                startActivity(intent, options.toBundle());
            } else {
                startActivity(intent);
            }
        }
}