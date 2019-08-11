package com.cis436.ewalletprototype;

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
import android.widget.TextView;

import com.cis436.ewalletprototype.Contact.ContactActivity;
import com.cis436.ewalletprototype.Report.ReportActivity;
import com.cis436.ewalletprototype.SideBarItems.Help.HelpActivity;
import com.cis436.ewalletprototype.SideBarItems.ProfileActivity;
import com.cis436.ewalletprototype.SideBarItems.SettingsActivity;
import com.ittianyu.bottomnavigationviewex.BottomNavigationViewEx;

//Page Creators/Modifiers: Thomas Opolski, ...
//Calendar Page

public class CalendarActivity extends AppCompatActivity {
    private DrawerLayout drawer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calendar);

        //Toolbar back
        setToolbar();

        //Set navigation menus
        setNavViews();

    }

    private void setToolbar() {
        //Toolbar back
        ImageButton btnBack = findViewById(R.id.tb_back);
        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

    private void setNavViews() {
        //Get user name and phone from prev activity
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
                        Intent report = new Intent(CalendarActivity.this, ReportActivity.class);
                        finish();
                        report.putExtra("navUserName", userFullName);
                        report.putExtra("navPhoneNum", userPhoneNumber);
                        startActivity(report);
                        break;

                    case R.id.contactAction:
                        Intent contact = new Intent(CalendarActivity.this, ContactActivity.class);
                        finish();
                        contact.putExtra("navUserName", userFullName);
                        contact.putExtra("navPhoneNum", userPhoneNumber);
                        startActivity(contact);
                        break;

                    case R.id.notificationsAction:
                        Intent notifications = new Intent(CalendarActivity.this, NotificationsActivity.class);
                        finish();
                        notifications.putExtra("navUserName", userFullName);
                        notifications.putExtra("navPhoneNum", userPhoneNumber);
                        startActivity(notifications);
                        break;

                    case R.id.settingsAction:
                        Intent settings = new Intent(CalendarActivity.this, SettingsActivity.class);
                        finish();
                        settings.putExtra("navUserName", userFullName);
                        settings.putExtra("navPhoneNum", userPhoneNumber);
                        startActivity(settings);
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
                        Intent profile = new Intent(CalendarActivity.this, ProfileActivity.class);
                        finish();
                        profile.putExtra("navUserName", userFullName);
                        profile.putExtra("navPhoneNum", userPhoneNumber);
                        startActivity(profile);
                        break;

                    case R.id.dm_settings:
                        Intent settings = new Intent(CalendarActivity.this, SettingsActivity.class);
                        finish();
                        settings.putExtra("navUserName", userFullName);
                        settings.putExtra("navPhoneNum", userPhoneNumber);
                        startActivity(settings);
                        break;

                    case R.id.dm_help:
                        Intent help = new Intent(CalendarActivity.this, HelpActivity.class);
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


    @Override
    public void onBackPressed() {
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }
}
