package com.cis436.ewalletprototype.Team;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

import com.cis436.ewalletprototype.R;


//Page Creators/Modifiers: Thomas Opolski, ...
//Help to FAQ Page

public class TeamSettingsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_team_settings);

        //Toolbar back
        ImageButton btnBack = findViewById(R.id.tb_back);
        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });



    }

}
