package com.example.arif.anjumanev5;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.support.v7.widget.ViewStubCompat;
import android.view.View;

public class ManuActivity extends AppCompatActivity {

    CardView news,ambulance,donation,burial,profile,contact;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_manu);

        news = (CardView)findViewById(R.id.news);
        ambulance = (CardView)findViewById(R.id.ambulance);
        donation = (CardView)findViewById(R.id.donation);
        burial = (CardView)findViewById(R.id.burial);
        profile = (CardView)findViewById(R.id.profile);
        contact = (CardView)findViewById(R.id.contact);

        profile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               /* SharedPreferences sharedPref = getSharedPreferences("userInfo", Context.MODE_PRIVATE);

                String loginStatus = sharedPref.getString("loginStatus","");

                if (loginStatus.equals("loggedin")){
                    Intent intent = new Intent(ManuActivity.this, ProfileActivity.class);
                    startActivity(intent);
                    finish();
                }

                else {*/
                    Intent intent = new Intent(ManuActivity.this, LoginActivity.class);
                    startActivity(intent);
                    finish();
               // }
            }
        });

        donation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ManuActivity.this, DonationActivity.class);
                startActivity(intent);
                finish();
            }
        });

        ambulance.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ManuActivity.this, MapsActivity.class);
                startActivity(intent);
                finish();
            }
        });

        news.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ManuActivity.this, NewsActivity.class);
                startActivity(intent);
                finish();
            }
        });

    }
}
