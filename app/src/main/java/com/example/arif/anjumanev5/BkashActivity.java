package com.example.arif.anjumanev5;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class BkashActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bkash);
    }

    public void onBackPressed() {
        Intent intent = new Intent(BkashActivity.this, DonationActivity.class);
        startActivity(intent);
        finish();
        super.onBackPressed();
    }
}
