package com.example.arif.anjumanev5;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class ProfileActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
    }

    @Override
    public void onBackPressed() {
        Intent intent = new Intent(ProfileActivity.this, ManuActivity.class);
        startActivity(intent);
        finish();
        super.onBackPressed();
    }
}
