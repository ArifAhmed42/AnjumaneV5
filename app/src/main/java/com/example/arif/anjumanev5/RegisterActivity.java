package com.example.arif.anjumanev5;

import android.app.DatePickerDialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.Calendar;

public class RegisterActivity extends AppCompatActivity {

    EditText name,phone,remail,rpassword,cpassword;
    EditText dateofbirth;//cpassword is the "Confirm Password"
    private DatePickerDialog.OnDateSetListener mDateSetListener;
    Button register;
    private DatabaseReference refdatabase;
    private FirebaseAuth mAuth;
    String Sname,Sphone,Spassword,Semail,Scpassword,Sdateofbrith;
    private UserRegisterInfo userinfo; //userinfo in the user data containing class

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        mAuth = FirebaseAuth.getInstance();
        refdatabase = FirebaseDatabase.getInstance().getReference();


        name = (EditText)findViewById(R.id.name);
        phone = (EditText)findViewById(R.id.phone);
        remail = (EditText)findViewById(R.id.remail);
        dateofbirth = (EditText) findViewById(R.id.dateofbirth);
        rpassword = (EditText)findViewById(R.id.rpassword);
        cpassword = (EditText)findViewById(R.id.cpassword);

        register = (Button)findViewById(R.id.register);

        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getAllInputData();
               // if (Spassword.equals(Scpassword)) {
                    createUser();
                    createAccountAndStudentInfo();
               //}



            }
        });

    }

    void getAllInputData()
    {
        Sname = name.getText().toString();
        Sphone = phone.getText().toString();
        Semail = remail.getText().toString();
        Spassword = rpassword.getText().toString();
        Scpassword = rpassword.getText().toString();
        /*dateofbirth.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Calendar cal = Calendar.getInstance();
                int year = cal.get(Calendar.YEAR);
                int month = cal.get(Calendar.MONTH);
                int day = cal.get(Calendar.DATE);

                DatePickerDialog dialog = new  DatePickerDialog(
                        RegisterActivity.this,
                        android.R.style.Theme_Holo_Light_Dialog_MinWidth,
                        mDateSetListener,
                        year,month,day);

                dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                dialog.show();
            }
        });

        mDateSetListener = new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker datePicker, int year, int month, int day) {
                month = month +1;
                String date = day + "/" + month + "/" + year;

                Sdateofbrith = date;
            }
        };*/



    }

    void createUser(){
        userinfo = new UserRegisterInfo(Sname,Sphone,Semail,Sdateofbrith,Spassword);
    }

    void createAccountAndStudentInfo(){
        mAuth.createUserWithEmailAndPassword(Semail, Spassword)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            FirebaseUser user = mAuth.getCurrentUser();
                            refdatabase = FirebaseDatabase.getInstance().getReference("UserInfo");
                            refdatabase.child(user.getUid()).setValue(userinfo);

                            saveUserInfo();

                            Intent intent = new Intent(RegisterActivity.this, ManuActivity.class);
                            startActivity(intent);
                            finish();

                        }

                        else {

                            Toast.makeText(RegisterActivity.this, "Authentication failed.",
                                    Toast.LENGTH_SHORT).show();

                        }
                    }
                });

    }

    public void saveUserInfo(){
        SharedPreferences sharedPref = getSharedPreferences("userInfo", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPref.edit();
        editor.putString("name",Sname);
        editor.putString("email",Semail);
        editor.putString("phone",Sphone);
        editor.putString("loginStatus","loggedin");
        editor.apply();
    }



    public void onBackPressed() {
        Intent intent = new Intent(RegisterActivity.this, LoginActivity.class);
        startActivity(intent);
        finish();
        super.onBackPressed();
    }
}
