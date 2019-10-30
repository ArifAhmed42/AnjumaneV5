package com.example.arif.anjumanev5;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;


public class LoginActivity extends AppCompatActivity {

    EditText email,password;
    Button learnmore,join,login;
    TextInputLayout inputLayout;

    String Spassword,Semail;

    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        email = (EditText)findViewById(R.id.email);
        password = (EditText)findViewById(R.id.password);
        learnmore = (Button)findViewById(R.id.learnmore);
        join = (Button)findViewById(R.id.join);
        login = (Button)findViewById(R.id.login);

        mAuth = FirebaseAuth.getInstance();

        inputLayout = (TextInputLayout) findViewById(R.id.inputLayout);

       // inputLayout.setError("First name is required"); // show error
        //inputLayout.setError(null); // hide error

        join.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LoginActivity.this, RegisterActivity.class);
                startActivity(intent);
                finish();
            }
        });

       // getInputData();

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                final String Semail = email.getText().toString();
                final String Spassword = password.getText().toString();

                mAuth.signInWithEmailAndPassword(Semail, Spassword).addOnCompleteListener(LoginActivity.this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (!task.isSuccessful()) {
                            Toast.makeText(LoginActivity.this, "LogIn Error", Toast.LENGTH_SHORT).show();
                        } else {
                            Intent intent = new Intent(LoginActivity.this, ProfileActivity.class);
                            startActivity(intent);
                            finish();
                            return;
                        }
                    }
                });
                // Toast.makeText(DriverLoginActivity.this, Semail, Toast.LENGTH_SHORT).show();
                //Toast.makeText(DriverLoginActivity.this, Spassword, Toast.LENGTH_SHORT).show();
            }
        });


    }

    private void getInputData(){
        Semail = email.getText().toString();
        Spassword = password.getText().toString();
    }


    @Override
    public void onBackPressed() {
        Intent intent = new Intent(LoginActivity.this, ManuActivity.class);
        startActivity(intent);
        finish();
        super.onBackPressed();
    }
}
