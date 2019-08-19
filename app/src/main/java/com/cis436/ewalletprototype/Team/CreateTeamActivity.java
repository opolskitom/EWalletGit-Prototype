package com.cis436.ewalletprototype.Team;

import android.os.Bundle;
import android.support.constraint.ConstraintLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.ScrollView;

import com.cis436.ewalletprototype.R;


//Page Creators/Modifiers: Thomas Opolski, ...
//Team creation activity

public class CreateTeamActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_team_create);

        //Toolbar back
        ImageButton btnBack = findViewById(R.id.tb_back);
        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        //Upload Image
        FloatingActionButton upload = findViewById(R.id.fab);
        upload.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });


        //Adding more members to invite (Not created)
        final ConstraintLayout addInvitee = findViewById(R.id.add_member_view);

        addInvitee.setOnClickListener(new View.OnClickListener() {
            int numInvitees = 1;

            @Override
            public void onClick(View v) {

            }
        });

        //Create Team
        Button createTeam = findViewById(R.id.create_team_btn);
        createTeam.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });


    }

}
