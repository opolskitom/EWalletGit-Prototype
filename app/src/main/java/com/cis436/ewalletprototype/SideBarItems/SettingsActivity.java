package com.cis436.ewalletprototype.SideBarItems;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.BottomNavigationView;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageButton;

import com.cis436.ewalletprototype.Contact.ContactActivity;
import com.cis436.ewalletprototype.NotificationsActivity;
import com.cis436.ewalletprototype.R;
import com.cis436.ewalletprototype.Report.ReportActivity;
import com.ittianyu.bottomnavigationviewex.BottomNavigationViewEx;


//Page Creators/Modifiers: Thomas Opolski, ...
//User settings page

public class SettingsActivity extends AppCompatActivity {
    private DrawerLayout drawer;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);

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
                        Intent report = new Intent(SettingsActivity.this, ReportActivity.class);
                        finish();
                        startActivity(report);
                        break;

                    case R.id.contactAction:
                        Intent contact = new Intent(SettingsActivity.this, ContactActivity.class);
                        finish();
                        startActivity(contact);
                        break;

                    case R.id.notificationsAction:
                        Intent notifications = new Intent(SettingsActivity.this, NotificationsActivity.class);
                        startActivity(notifications);
                        break;

                    case R.id.settingsAction:
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
                        Intent profile = new Intent(SettingsActivity.this, ProfileActivity.class);
                        finish();
                        startActivity(profile);
                        break;

                    case R.id.dm_settings:
                        Intent settings = new Intent(SettingsActivity.this, SettingsActivity.class);
                        finish();
                        startActivity(settings);
                        break;

                    case R.id.dm_help:
                        Intent help = new Intent(SettingsActivity.this, HelpActivity.class);
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


    //Back Pressed Closes Drawer Menu
    @Override
    public void onBackPressed() {
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

}
