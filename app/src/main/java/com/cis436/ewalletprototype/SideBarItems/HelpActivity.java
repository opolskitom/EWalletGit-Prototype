package com.cis436.ewalletprototype.SideBarItems;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageButton;

import com.cis436.ewalletprototype.NotificationsActivity;
import com.cis436.ewalletprototype.R;
import com.cis436.ewalletprototype.Report.ReportActivity;
import com.ittianyu.bottomnavigationviewex.BottomNavigationViewEx;


//Page Creators/Modifiers: Thomas Opolski, ...
//Help Page

public class HelpActivity extends AppCompatActivity {
    private DrawerLayout drawer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_help);

        //Toolbar back
        ImageButton btnBack = findViewById(R.id.tb_back);
        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        //Bottom Navigation
        BottomNavigationViewEx bottomNavigationViewEx = findViewById(R.id.bottom_bar);
        bottomNavigationViewEx.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                switch (menuItem.getItemId()) {
                    case R.id.hamburgerAction:
                        drawer.openDrawer(GravityCompat.START);
                        break;

                    case R.id.reportAction:
                        Intent report = new Intent(HelpActivity.this, ReportActivity.class);
                        finish();
                        startActivity(report);
                        break;

                    case R.id.contactAction:
                        Intent contact = new Intent(HelpActivity.this, HelpActivity.class);
                        finish();
                        startActivity(contact);
                        break;

                    case R.id.notificationsAction:
                        Intent notifications = new Intent(HelpActivity.this, NotificationsActivity.class);
                        startActivity(notifications);
                        break;

                    case R.id.settingsAction:
                        Intent settings = new Intent(HelpActivity.this, SettingsActivity.class);
                        finish();
                        startActivity(settings);
                        break;
                }
                return true;
            }
        });

        //Drawer Navigation
        drawer = findViewById(R.id.drawer_layout);
        NavigationView navigationView = findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                switch(menuItem.getItemId()) {
                    case R.id.dm_profile:
                        Intent profile = new Intent(HelpActivity.this, ProfileActivity.class);
                        finish();
                        startActivity(profile);
                        break;

                    case R.id.dm_settings:
                        Intent settings = new Intent(HelpActivity.this, SettingsActivity.class);
                        finish();
                        startActivity(settings);
                        break;

                    case R.id.dm_help:
                        Intent help = new Intent(HelpActivity.this, HelpActivity.class);
                        finish();
                        startActivity(help);
                        break;

                    case R.id.dm_logout:

                        //Logout of account

                        break;
                }

                return true;
            }
        });


    }

    @Override
    public void onBackPressed() {
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }
}
