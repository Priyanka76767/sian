package com.example.imagepro;


import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import com.google.firebase.auth.FirebaseAuth;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.opencv.android.OpenCVLoader;

import java.io.IOException;

import kotlin.jvm.internal.Intrinsics;

public class  MainActivity extends AppCompatActivity {
    static {
        if(OpenCVLoader.initDebug()){
            Log.d("MainActivity: ","Opencv is loaded");
        }
        else {
            Log.d("MainActivity: ","Opencv failed to load");
        }
    }

    private Button camera_button;
    private String email;
    //new button
    private Button combine_letter_button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Intent intent = getIntent();
        email = intent.getStringExtra("email");
        getSupportActionBar().setTitle("SIAN");

        // select device and run
        // we successfully loaded model
        // before next tutorial
        // as we are going to predict in Camera Activity
        // Next tutorial will be about predicting using Interpreter


        camera_button=findViewById(R.id.button);
        camera_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this,CameraActivity.class).addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_CLEAR_TOP));
            }
        });
//        combine_letter_button=findViewById(R.id.combine_letter_button);
//           combine_letter_button.setOnClickListener(new View.OnClickListener() {
//               @Override
//               public void onClick(View v) {
//                   //when this button is clicked navigate to combineLettersActivity
//                     startActivity(new Intent(MainActivity.this,CombineLettersActivity.class).addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK| Intent.FLAG_ACTIVITY_CLEAR_TOP));
//               }
//           });
    }
    public boolean onCreateOptionsMenu(@Nullable Menu menu) {
        this.getMenuInflater().inflate(R.menu.menu, menu);
        return true;
    }

    public boolean onOptionsItemSelected(@NotNull MenuItem item) {
        Intrinsics.checkNotNullParameter(item, "item");
        if (item.getItemId() == R.id.signoutitem) {
            FirebaseAuth.getInstance().signOut();
            Intent intent = new Intent((Context)this, HomeActivity.class);
            this.startActivity(intent);
            this.finish();
        }
        if (item.getItemId() == R.id.profile) {
            Intent intent = new Intent((Context)this, ProfileActivity.class);
            intent.putExtra("email",email);
            this.startActivity(intent);
        }

        return super.onOptionsItemSelected(item);
    }
}