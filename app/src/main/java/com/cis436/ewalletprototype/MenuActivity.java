package com.cis436.ewalletprototype;

import android.app.Activity;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.os.Bundle;
import android.support.design.widget.BottomNavigationView;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

import com.cis436.ewalletprototype.Contact.ContactActivity;
import com.cis436.ewalletprototype.Report.ReportActivity;
import com.cis436.ewalletprototype.SideBarItems.Help.HelpActivity;
import com.cis436.ewalletprototype.SideBarItems.ProfileActivity;
import com.cis436.ewalletprototype.SideBarItems.SettingsActivity;
import com.cis436.ewalletprototype.Team.TeamActivity;
import com.cis436.ewalletprototype.onStartUp.StartingActivity;
import com.ittianyu.bottomnavigationviewex.BottomNavigationViewEx;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

//Page Creators/Modifiers: Thomas Opolski, ...
//Main home menu page, NECESSARY FOR DRAWER: PUTEXTRA username and number
        // so there isn't repeated database calls and instead just one.
//DataBase items: Full and First Name & Phone Number

public class MenuActivity extends Activity {
    private DrawerLayout drawer;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        //Set Texts for Name/Phone Numbers (NEED to PULL NAMES and NUMBER)
                String userFirstName = "Zaina";
                String userLastName = "Temporary";
                final String userFullName = userFirstName + " " + userLastName;
                final String userPhoneNumber = "(123) 123-1234";

        //Toolbar pfp
        ImageButton btnBack = findViewById(R.id.tb_pfp);
        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent profile = new Intent(MenuActivity.this, ProfileActivity.class);
                drawer.closeDrawer(GravityCompat.START);
                profile.putExtra("navUserName", userFullName);
                profile.putExtra("navPhoneNum", userPhoneNumber);
                startActivity(profile);
            }
        });

        //Toolbar welcome message
        TextView welcomeMessage = findViewById(R.id.tb_welcomeMessage);        //Welcome message
        String welcome_message = getString(R.string.user_welcomemessage, userFirstName);
        welcomeMessage.setText(welcome_message);

        //Toolbar date message
        String currentDate = "Today is " + new SimpleDateFormat("MMM dd, yyyy", Locale.getDefault()).format(new Date());
        TextView currentTime = findViewById(R.id.tb_todayDate);
        currentTime.setText(currentDate);

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
                        Intent report = new Intent(MenuActivity.this, ReportActivity.class);
                        report.putExtra("navUserName", userFullName);
                        report.putExtra("navPhoneNum", userPhoneNumber);
                        startActivity(report);
                        break;

                    case R.id.contactAction:
                        Intent contact = new Intent(MenuActivity.this, ContactActivity.class);
                        contact.putExtra("navUserName", userFullName);
                        contact.putExtra("navPhoneNum", userPhoneNumber);
                        startActivity(contact);
                        break;

                    case R.id.notificationsAction:
                        Intent notifications = new Intent(MenuActivity.this, NotificationsActivity.class);
                        notifications.putExtra("navUserName", userFullName);
                        notifications.putExtra("navPhoneNum", userPhoneNumber);
                        startActivity(notifications);
                        break;

                    case R.id.settingsAction:
                        Intent settings = new Intent(MenuActivity.this, SettingsActivity.class);
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
                        Intent profile = new Intent(MenuActivity.this, ProfileActivity.class);
                        drawer.closeDrawer(GravityCompat.START);
                        profile.putExtra("navUserName", userFullName);
                        profile.putExtra("navPhoneNum", userPhoneNumber);
                        startActivity(profile);
                        break;

                    case R.id.dm_settings:
                        Intent settings = new Intent(MenuActivity.this, SettingsActivity.class);
                        drawer.closeDrawer(GravityCompat.START);
                        settings.putExtra("navUserName", userFullName);
                        settings.putExtra("navPhoneNum", userPhoneNumber);
                        startActivity(settings);
                        break;

                    case R.id.dm_help:
                        Intent help = new Intent(MenuActivity.this, HelpActivity.class);
                        drawer.closeDrawer(GravityCompat.START);
                        help.putExtra("navUserName", userFullName);
                        help.putExtra("navPhoneNum", userPhoneNumber);
                        startActivity(help);
                        break;

                    case R.id.dm_logout:
                        Intent logout = new Intent(MenuActivity.this, StartingActivity.class);
                        drawer.closeDrawer(GravityCompat.START);
                        startActivity(logout);
                        finishAffinity();

                        //Logout of account

                        break;
                }
                return true;
            }
        });

        //Main Menu Buttons
        Button btnMakePayment = findViewById(R.id.btnMakePayment);
        Button btnSendMoney = findViewById(R.id.btnSendMoney);
        Button btnContact = findViewById(R.id.btnContact);
        Button btnReport = findViewById(R.id.btnReport);
        Button btnSettings = findViewById(R.id.btnSettings);
        Button btnCalendar = findViewById(R.id.btnCalendar);

        btnMakePayment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent myAccounts = new Intent(MenuActivity.this, AccountsActivity.class);
                myAccounts.putExtra("navUserName", userFullName);
                myAccounts.putExtra("navPhoneNum", userPhoneNumber);
                startActivity(myAccounts);
            }
        });

        btnSendMoney.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent teams = new Intent(MenuActivity.this , TeamActivity.class);
                teams.putExtra("navUserName", userFullName);
                teams.putExtra("navPhoneNum", userPhoneNumber);
                startActivity(teams);
            }
        });

        btnContact.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent contact = new Intent(MenuActivity.this, ContactActivity.class);
                contact.putExtra("navUserName", userFullName);
                contact.putExtra("navPhoneNum", userPhoneNumber);
                startActivity(contact);
            }
        });

        btnReport.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent report = new Intent(MenuActivity.this, ReportActivity.class);
                report.putExtra("navUserName", userFullName);
                report.putExtra("navPhoneNum", userPhoneNumber);
                startActivity(report);
            }
        });

        btnSettings.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent settings = new Intent(MenuActivity.this, SettingsActivity.class);
                settings.putExtra("navUserName", userFullName);
                settings.putExtra("navPhoneNum", userPhoneNumber);
                startActivity(settings);
            }
        });

        btnCalendar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent calendar = new Intent(MenuActivity.this, CalendarActivity.class);
                calendar.putExtra("navUserName", userFullName);
                calendar.putExtra("navPhoneNum", userPhoneNumber);
                startActivity(calendar);
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

