package com.example.fastdoctor;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class ChatActivity extends AppCompatActivity {
    TextView userName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chat);

        //Recuper username and image profil
        Intent i = getIntent();
        if (i.hasExtra("userID")) {
            String str_userId = i.getStringExtra("userID");
            userName = findViewById(R.id.username);
            userName.setText(str_userId);
        }
        String str_urlImg = i.getStringExtra("userImg");

        //getSupportActionBar().setDisplayHomeAsUpEnabled(true);


        /*Button backBtn = findViewById(R.id.btn_back);
        backBtn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                Intent intent = new Intent(ChatActivity.this, HomePatient.class);
                startActivity(intent); }
        });*/

    }

   /* @Override
    public boolean onSupportNavigateUp() {
        finish();
        return super.onSupportNavigateUp();
    }*/
}