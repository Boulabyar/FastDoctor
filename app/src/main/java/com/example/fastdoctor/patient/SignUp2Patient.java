package com.example.fastdoctor.patient;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.fastdoctor.R;

import de.hdodenhof.circleimageview.CircleImageView;

import static com.example.fastdoctor.R.layout;

public class SignUp2Patient extends AppCompatActivity {
    CircleImageView imageProfil;
    Button backBtn;
    Uri imageUri;
    public static final int IMAGE_CODE = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(layout.activity_signup2_patient);
        //Action back button
        backBtn = findViewById(R.id.btn_back);
        backBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(SignUp2Patient.this, SignUp1Patient.class);
                startActivity(intent);
            }
        });

        //Action boutton change profil image
        imageProfil = findViewById(R.id.btn_change_img_profil);
        imageProfil.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View vw) {
                openImageFrom();
            }
        });

    }

    private void openImageFrom() {
        Intent intent = new Intent();
        intent.setType("image/*");
        intent.setAction(Intent.ACTION_GET_CONTENT);
        startActivityForResult(intent, IMAGE_CODE);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == IMAGE_CODE && resultCode == RESULT_OK && data != null && data.getData() != null) {
            imageUri = data.getData();
            imageProfil.setImageURI(imageUri);
        }
    }
}