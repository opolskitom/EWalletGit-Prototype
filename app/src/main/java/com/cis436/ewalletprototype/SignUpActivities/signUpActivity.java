package com.cis436.ewalletprototype.SignUpActivities;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import org.apache.commons.validator.routines.EmailValidator;

import com.cis436.ewalletprototype.MenuActivity;
import com.cis436.ewalletprototype.R;
import com.cis436.ewalletprototype.signInActivity;

//Page Creators/Modifiers: Thomas Opolski, ...
//Main Sign Up page, users are redirected here upon selection of account creation

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
        final EditText txtEmailInput = findViewById(R.id.txtEmailAddressInput);
        final EditText txtPasswordInput = findViewById(R.id.txtPasswordInput);
        final EditText txtPasswordReInput = findViewById(R.id.txtPasswordInput2);


        //Click Listeners for buttons
        btnSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                boolean valid = EmailValidator.getInstance().isValid(txtEmailInput.getText().toString()); //Validate Email
                if (!txtPasswordInput.getText().toString().equals(txtPasswordReInput.getText().toString())) {valid = false;} //Validate Password

                //If fields are valid, proceed, if not, create dialog
                if (valid) {
                    Intent signUpP2 = new Intent(signUpActivity.this, signUpP2Activity.class);
                    finish();
                    startActivity(signUpP2);
                }
                else {
                    new AlertDialog.Builder(signUpActivity.this, R.style.alertDialog)
                            .setTitle("Incorrect Information!")
                            .setMessage("Your e-mail address or password is incorrect!")
                            .setNegativeButton(android.R.string.no, null)
                            .setIcon(R.drawable.ic_alert)
                            .show();
                }
            }
        });

        btnSignIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent signIn = new Intent(signUpActivity.this, signInActivity.class);
                finish();
                startActivity(signIn);
            }
        });


        //REQUIRED USAGE: EDITTEXTS USED FOR SIGNUP (txtNameInput txtEmailInput txtPasswordInput txtPasswordReInput)
            //After creation, redirecting to email verification

    }

}

