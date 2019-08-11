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
//Fifth Sign up page, asks for team creation now or later

public class signUpP5Activity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up_p5);

        //Manager vs Agent Buttons
        final Button createNowBtn = findViewById(R.id.create_now_btn);
        final Button createLaterBtn = findViewById(R.id.create_later_btn);

        createNowBtn.setSelected(true);
        createNowBtn.setTextColor(getResources().getColor(R.color.colorPrimary));
        createLaterBtn.setTextColor(getResources().getColor(R.color.colorWhite));


        createNowBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                createNowBtn.setSelected(true);
                createLaterBtn.setSelected(false);
                createNowBtn.setTextColor(getResources().getColor(R.color.colorPrimary));
                createLaterBtn.setTextColor(getResources().getColor(R.color.colorWhite));
            }
        });

        createLaterBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                createLaterBtn.setSelected(true);
                createNowBtn.setSelected(false);
                createNowBtn.setTextColor(getResources().getColor(R.color.colorWhite));
                createLaterBtn.setTextColor(getResources().getColor(R.color.colorPrimary));
            }
        });

        Button continueBtn = findViewById(R.id.continueBtn);

        continueBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(createNowBtn.isSelected()) {
                    Intent menuActivity = new Intent(signUpP5Activity.this, MenuActivity.class);
                    startActivity(menuActivity);
                    finishAffinity();
                }
                else {
                    Intent menuActivity = new Intent(getApplicationContext(), MenuActivity.class);
                    startActivity(menuActivity);
                    finishAffinity();
                }
            }
        });
    }
}
