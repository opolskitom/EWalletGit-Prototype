package com.cis436.ewalletprototype.onStartUp;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.cis436.ewalletprototype.MenuActivity;
import com.cis436.ewalletprototype.R;

//Page Creators/Modifiers: Thomas Opolski, ...
//Main Sign In page, users are redirected here upon selection of account log in

public class signInActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_in);

        Button btnSignIn = findViewById(R.id.sign_in);
        Button btnSignUp = findViewById(R.id.sign_up);
        Button btnSignInGoogle = findViewById(R.id.sign_in_google);
        Button btnSignInFacebook = findViewById(R.id.sign_in_facebook);

        EditText txtEmailInput = findViewById(R.id.txtEmailAddressInput);
        EditText txtPasswordInput = findViewById(R.id.txtPasswordInput);

        TextView btnForgotPassword = findViewById(R.id.txtForgotPassword);

        //Click Listeners for buttons
        btnSignIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent signIn = new Intent(signInActivity.this, MenuActivity.class);
                //Sign In check
                //REQUIRED USAGE: EDITTEXTS USED FOR SIGNIN (txtEmailInput txtPasswordInput)
                startActivity(signIn);
                finishAffinity();
            }
        });

        btnSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent signUp = new Intent(signInActivity.this, signUpActivity.class);
                finish();
                startActivity(signUp);
            }
        });

    }
}
