package com.example.arif.anjumanev5;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class VisaActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_visa);
    }

    public void onBackPressed() {
        Intent intent = new Intent(VisaActivity.this, DonationActivity.class);
        startActivity(intent);
        finish();
        super.onBackPressed();
    }
}
