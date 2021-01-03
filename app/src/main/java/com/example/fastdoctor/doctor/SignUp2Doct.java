package com.example.fastdoctor.doctor;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.example.fastdoctor.R;

import de.hdodenhof.circleimageview.CircleImageView;

public class SignUp2Doct extends AppCompatActivity {
    CircleImageView imageProfil;
    Uri imageUri;
    Button backBtn;

    public static final int PERMISSION_CODE = 1001;
    public static final int IMAGE_CODE = 1000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup2_doctor);

        backBtn = findViewById(R.id.btn_back);
        backBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(SignUp2Doct.this, SignUp1Doctor.class);
                startActivity(intent);
            }
        });

        //Action boutton change profil image
        imageProfil = findViewById(R.id.btn_change_img_profil);
        imageProfil.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View vw) {
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                    if (checkSelfPermission(Manifest.permission.READ_EXTERNAL_STORAGE) == PackageManager.PERMISSION_DENIED) {
                        String[] permissions = {Manifest.permission.READ_EXTERNAL_STORAGE};
                        requestPermissions(permissions, PERMISSION_CODE);
                    } else {
                        openImageFrom();
                    }
                } else {
                    openImageFrom();
                }
            }
        });
    }

    private void openImageFrom() {
        Intent intent = new Intent(Intent.ACTION_GET_CONTENT);
        intent.setType("image/*");
        startActivityForResult(intent, IMAGE_CODE);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == IMAGE_CODE && resultCode == RESULT_OK && data != null && data.getData() != null) {
            imageUri = data.getData();
            imageProfil.setImageURI(imageUri);
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        switch (requestCode) {
            case PERMISSION_CODE: {
                if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    openImageFrom();
                } else {
                    Toast.makeText(this, "Permission denided...!", Toast.LENGTH_SHORT).show();
                }
            }
        }
    }
}
