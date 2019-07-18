package com.cis436.ewalletprototype;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.cis436.ewalletprototype.SignUpActivities.signUpActivity;

//Page Creators/Modifiers: Thomas Opolski, ...
//Initial start page, users will be directed here upon first launching the application

public class StartingActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_starting);

        Button btnSignIn = findViewById(R.id.sign_in);
        Button btnSignUp = findViewById(R.id.sign_up);

        //Click Listeners for buttons
        btnSignIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent signIn = new Intent(StartingActivity.this,signInActivity.class);
                finish();
                startActivity(signIn);
            }
        });

        btnSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent signUp = new Intent(StartingActivity.this, signUpActivity.class);
                finish();
                startActivity(signUp);
            }
        });
    }
}
