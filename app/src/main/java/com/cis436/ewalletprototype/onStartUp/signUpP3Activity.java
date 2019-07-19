package com.cis436.ewalletprototype.onStartUp;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.cis436.ewalletprototype.MenuActivity;
import com.cis436.ewalletprototype.R;

//Page Creators/Modifiers: Thomas Opolski, ...
//Secondary Sign Up page, users are redirected here upon finishing the first part of account
    //  creation. Used for SMS/Email verification. (Currently undecided)

public class signUpP3Activity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up_p3);

        Button continueBtn = findViewById(R.id.continueBtn);

        continueBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent menuActivity = new Intent(signUpP3Activity.this, MenuActivity.class);
                finish();
                startActivity(menuActivity);
            }
        });
    }

}
