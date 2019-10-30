package com.example.arif.anjumanev5;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class DonationActivity extends AppCompatActivity {

    CardView bkash,visa,mastercard;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_donation);

        bkash = (CardView) findViewById(R.id.bkash);
        visa = (CardView)findViewById(R.id.visa);
        mastercard = (CardView)findViewById(R.id.master);

        bkash.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(DonationActivity.this, BkashActivity.class);
                startActivity(intent);
                finish();
            }
        });

        visa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(DonationActivity.this, VisaActivity.class);
                startActivity(intent);
                finish();
            }
        });

        mastercard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(DonationActivity.this, VisaActivity.class);
                startActivity(intent);
                finish();
            }
        });
    }


    public void onBackPressed() {
        Intent intent = new Intent(DonationActivity.this, ManuActivity.class);
        startActivity(intent);
        finish();
        super.onBackPressed();
    }
}
