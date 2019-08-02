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
import android.widget.TextView;

import com.cis436.ewalletprototype.Contact.ContactActivity;
import com.cis436.ewalletprototype.NotificationsActivity;
import com.cis436.ewalletprototype.R;
import com.cis436.ewalletprototype.Report.ReportActivity;
import com.ittianyu.bottomnavigationviewex.BottomNavigationViewEx;

import java.util.MissingResourceException;


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

        //Get user's name and phone from prev activity
        Bundle extras = getIntent().getExtras();
        final String userFullName = extras.getString("navUserName");
        final String userPhoneNumber = extras.getString("navPhoneNum");

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
                        report.putExtra("navUserName", userFullName);
                        report.putExtra("navPhoneNum", userPhoneNumber);
                        startActivity(report);
                        break;

                    case R.id.contactAction:
                        Intent contact = new Intent(SettingsActivity.this, ContactActivity.class);
                        finish();
                        contact.putExtra("navUserName", userFullName);
                        contact.putExtra("navPhoneNum", userPhoneNumber);
                        startActivity(contact);
                        break;

                    case R.id.notificationsAction:
                        Intent notifications = new Intent(SettingsActivity.this, NotificationsActivity.class);
                        finish();
                        notifications.putExtra("navUserName", userFullName);
                        notifications.putExtra("navPhoneNum", userPhoneNumber);
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
        View headerView = navigationView.getHeaderView(0);
        TextView navUserName = headerView.findViewById(R.id. nav_user_name);    //Navigation bar user items
        TextView navPhoneNum = headerView.findViewById(R.id.nav_user_phone);
        navUserName.setText(userFullName);
        navPhoneNum.setText(userPhoneNumber);
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                switch(menuItem.getItemId()) {
                    case R.id.dm_profile:
                        Intent profile = new Intent(SettingsActivity.this, ProfileActivity.class);
                        finish();
                        profile.putExtra("navUserName", userFullName);
                        profile.putExtra("navPhoneNum", userPhoneNumber);
                        startActivity(profile);
                        break;

                    case R.id.dm_settings:
                        Intent settings = new Intent(SettingsActivity.this, SettingsActivity.class);
                        finish();
                        settings.putExtra("navUserName", userFullName);
                        settings.putExtra("navPhoneNum", userPhoneNumber);
                        startActivity(settings);
                        break;

                    case R.id.dm_help:
                        Intent help = new Intent(SettingsActivity.this, HelpActivity.class);
                        finish();
                        help.putExtra("navUserName", userFullName);
                        help.putExtra("navPhoneNum", userPhoneNumber);
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
