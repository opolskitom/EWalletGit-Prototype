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

import com.cis436.ewalletprototype.Contact.ContactActivity;
import com.cis436.ewalletprototype.P2P.P2PActivity;
import com.cis436.ewalletprototype.Payment.MakePaymentActivity;
import com.cis436.ewalletprototype.Report.ReportActivity;
import com.cis436.ewalletprototype.SideBarItems.HelpActivity;
import com.cis436.ewalletprototype.SideBarItems.ProfileActivity;
import com.cis436.ewalletprototype.SideBarItems.SettingsActivity;
import com.ittianyu.bottomnavigationviewex.BottomNavigationViewEx;

//Page Creators/Modifiers: Thomas Opolski, ...
//Main home menu page

public class MenuActivity extends Activity {
    private DrawerLayout drawer;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

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
                        startActivity(report);
                        break;

                    case R.id.contactAction:
                        Intent contact = new Intent(MenuActivity.this, ContactActivity.class);
                        startActivity(contact);
                        break;

                    case R.id.notificationsAction:
                        Intent notifications = new Intent(MenuActivity.this, NotificationsActivity.class);
                        startActivity(notifications);
                        break;

                    case R.id.settingsAction:
                        Intent settings = new Intent(MenuActivity.this, SettingsActivity.class);
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
                        Intent profile = new Intent(MenuActivity.this, ProfileActivity.class);
                        drawer.closeDrawer(GravityCompat.START);
                        startActivity(profile);
                        break;

                    case R.id.dm_settings:
                        Intent settings = new Intent(MenuActivity.this, ContactActivity.class);
                        drawer.closeDrawer(GravityCompat.START);
                        startActivity(settings);
                        break;
                    case R.id.dm_help:
                        Intent help = new Intent(MenuActivity.this, HelpActivity.class);
                        drawer.closeDrawer(GravityCompat.START);
                        startActivity(help);
                        break;

                    case R.id.dm_logout:

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
                Intent makePayment = new Intent(MenuActivity.this, MakePaymentActivity.class);
                startActivity(makePayment);
            }
        });

        btnSendMoney.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent sendMoney = new Intent(MenuActivity.this , P2PActivity.class);
                startActivity(sendMoney);
            }
        });

        btnContact.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent contact = new Intent(MenuActivity.this, ContactActivity.class);
                startActivity(contact);
            }
        });

        btnReport.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent report = new Intent(MenuActivity.this, ReportActivity.class);
                startActivity(report);
            }
        });

        btnSettings.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent settings = new Intent(MenuActivity.this, SettingsActivity.class);
                startActivity(settings);
            }
        });

        btnCalendar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent calendar = new Intent(MenuActivity.this, CalendarActivity.class);
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


