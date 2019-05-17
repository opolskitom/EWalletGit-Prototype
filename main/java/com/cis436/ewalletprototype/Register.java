package com.cis436.ewalletprototype;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class Register extends AppCompatActivity {
    EditText firstname, lastname, username, password, phonenumber;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        firstname = findViewById(R.id.et_firstname);
        lastname = findViewById(R.id.et_lastname);
        username = findViewById(R.id.et_username);
        password = findViewById(R.id.et_password);
        phonenumber = findViewById(R.id.et_phonenumber);


    }

    public void OnReg(View view)
    {
        String str_firstname = firstname. getText().toString();
        String str_lastname = lastname. getText().toString();
        String str_username = username. getText().toString();
        String str_password = password. getText().toString();
        String str_phonenumber = phonenumber. getText().toString();
        String type = "registration";


        BackgroundWorker backgroundWorker = new BackgroundWorker(this);
        backgroundWorker.execute(type, str_firstname, str_lastname, str_username, str_password, str_phonenumber);
    }
}
