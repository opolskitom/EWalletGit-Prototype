package com.cis436.ewalletprototype.onStartUp;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.cis436.ewalletprototype.MenuActivity;
import com.cis436.ewalletprototype.R;

//Page Creators/Modifiers: Thomas Opolski, ...
//Third Sign up page, asks for manager or agent account type

public class signUpP3Activity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up_p3);

        //Manager vs Agent Buttons
        final Button managerSelectBtn = findViewById(R.id.sign_up_manager);
        final Button agentSelectBtn = findViewById(R.id.sign_up_agent);
        managerSelectBtn.setSelected(true);
        checkSelected(managerSelectBtn.isSelected());
        managerSelectBtn.setTextColor(getResources().getColor(R.color.colorPrimary));
        agentSelectBtn.setTextColor(getResources().getColor(R.color.colorWhite));


        managerSelectBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                managerSelectBtn.setSelected(true);
                agentSelectBtn.setSelected(false);
                managerSelectBtn.setTextColor(getResources().getColor(R.color.colorPrimary));
                agentSelectBtn.setTextColor(getResources().getColor(R.color.colorWhite));

                checkSelected(managerSelectBtn.isSelected());
            }
        });

        agentSelectBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                agentSelectBtn.setSelected(true);
                managerSelectBtn.setSelected(false);
                managerSelectBtn.setTextColor(getResources().getColor(R.color.colorWhite));
                agentSelectBtn.setTextColor(getResources().getColor(R.color.colorPrimary));

                checkSelected(managerSelectBtn.isSelected());
            }
        });

        Button continueBtn = findViewById(R.id.continueBtn);

        continueBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(managerSelectBtn.isSelected()) {
                    //Set account type to manager
                }
                else {
                    //Set account type to agent
                }

                Intent signUpP4Activity = new Intent(signUpP3Activity.this, signUpP4Activity.class);
                finish();
                startActivity(signUpP4Activity);
            }
        });
    }

    private void checkSelected(boolean managerSelected) {
        ImageView selectionImage = findViewById(R.id.img_manager_agent);

        if (managerSelected) {
            selectionImage.setImageResource(R.drawable.signup_manager);

        }
        else {
            selectionImage.setImageResource(R.drawable.signup_agent);

        }
    }
}
