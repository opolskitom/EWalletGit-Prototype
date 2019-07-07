package com.cis436.ewalletprototype;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class signUpActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        Button btnSignUp = findViewById(R.id.sign_up);
        Button btnSignUpGoogle = findViewById(R.id.sign_up_google);
        Button btnSignUpFacebook = findViewById(R.id.sign_up_facebook);
        Button btnSignIn = findViewById(R.id.sign_in);

        EditText txtNameInput = findViewById(R.id.txtNameInput);
        EditText txtEmailInput = findViewById(R.id.txtEmailAddressInput);
        EditText txtPasswordInput = findViewById(R.id.txtPasswordInput);
        EditText txtPasswordReInput = findViewById(R.id.txtPasswordInput2);

        //Click Listeners for buttons
        btnSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent signUpP2 = new Intent(signUpActivity.this,MenuActivity.class);
                finish();
                startActivity(signUpP2);
            }
        });

        btnSignIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent signIn = new Intent(signUpActivity.this,signInActivity.class);
                finish();
                startActivity(signIn);
            }
        });
    }

}

