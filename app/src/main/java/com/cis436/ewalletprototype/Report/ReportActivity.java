package com.cis436.ewalletprototype.Report;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v4.widget.NestedScrollView;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.ScrollView;
import android.widget.SeekBar;
import android.widget.TextView;

import com.cis436.ewalletprototype.CalendarActivity;
import com.cis436.ewalletprototype.Contact.ContactActivity;
import com.cis436.ewalletprototype.NotificationsActivity;
import com.cis436.ewalletprototype.R;
import com.cis436.ewalletprototype.SideBarItems.HelpActivity;
import com.cis436.ewalletprototype.SideBarItems.ProfileActivity;
import com.cis436.ewalletprototype.SideBarItems.SettingsActivity;
import com.github.mikephil.charting.charts.LineChart;
import com.github.mikephil.charting.components.AxisBase;
import com.github.mikephil.charting.components.LimitLine;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.components.YAxis;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.LineData;
import com.github.mikephil.charting.data.LineDataSet;
import com.github.mikephil.charting.formatter.IAxisValueFormatter;
import com.github.mikephil.charting.formatter.IndexAxisValueFormatter;
import com.github.mikephil.charting.interfaces.datasets.ILineDataSet;
import com.github.mikephil.charting.listener.OnChartGestureListener;
import com.github.mikephil.charting.listener.OnChartValueSelectedListener;
import com.ittianyu.bottomnavigationviewex.BottomNavigationViewEx;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.Charset;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Locale;
import java.util.Map;

public class ReportActivity extends AppCompatActivity {
    private DrawerLayout drawer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_report);

        //Toolbar back
        ImageButton btnBack = findViewById(R.id.tb_back);
        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

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
                        break;

                    case R.id.contactAction:
                        Intent contact = new Intent(ReportActivity.this, ContactActivity.class);
                        finish();
                        contact.putExtra("navUserName", userFullName);
                        contact.putExtra("navPhoneNum", userPhoneNumber);
                        startActivity(contact);
                        break;

                    case R.id.notificationsAction:
                        Intent notifications = new Intent(ReportActivity.this, NotificationsActivity.class);
                        finish();
                        notifications.putExtra("navUserName", userFullName);
                        notifications.putExtra("navPhoneNum", userPhoneNumber);
                        startActivity(notifications);
                        break;

                    case R.id.settingsAction:
                        Intent settings = new Intent(ReportActivity.this, SettingsActivity.class);
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
                        Intent profile = new Intent(ReportActivity.this, ProfileActivity.class);
                        finish();
                        profile.putExtra("navUserName", userFullName);
                        profile.putExtra("navPhoneNum", userPhoneNumber);
                        startActivity(profile);
                        break;

                    case R.id.dm_settings:
                        Intent settings = new Intent(ReportActivity.this, SettingsActivity.class);
                        finish();
                        settings.putExtra("navUserName", userFullName);
                        settings.putExtra("navPhoneNum", userPhoneNumber);
                        startActivity(settings);
                        break;

                    case R.id.dm_help:
                        Intent help = new Intent(ReportActivity.this, HelpActivity.class);
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

        //Allowing Scroll for both ListView and ScrollView
        NestedScrollView parentScroll = findViewById(R.id.parent_scroll);
        final ListView mListView = findViewById(R.id.listView);
        parentScroll.setOnTouchListener(new View.OnTouchListener() {
            public boolean onTouch(View v, MotionEvent event) {
                findViewById(R.id.listView).getParent().getParent().requestDisallowInterceptTouchEvent(false);
                return false;
            }
        });
        mListView.setOnTouchListener(new View.OnTouchListener() {
            public boolean onTouch(View v, MotionEvent event)
            {
                v.getParent().requestDisallowInterceptTouchEvent(true);
                return false;
            }
        });

        //Click Transactions to return to top
        TextView transactionTxt = findViewById(R.id.transactions_text);
        transactionTxt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mListView.smoothScrollToPosition(0);
            }
        });


        //Reading the data
        readTestData();


        //-----------------------------------------------------------------------------
        // Graphing the data
        LineChart reportChart = findViewById(R.id.main_linechart);

        //reportChart.setOnChartGestureListener(ReportActivity.this);
       // reportChart.setOnChartValueSelectedListener(ReportActivity.this);
        reportChart.setDragEnabled(true);
        reportChart.setScaleEnabled(false);

        ArrayList<Entry> yValues = new ArrayList<>();

        yValues.add(new Entry(0, 60f));
        yValues.add(new Entry(1, 40f));
        yValues.add(new Entry(2, 70f));
        yValues.add(new Entry(3, 50f));
        yValues.add(new Entry(4, 40f));
        yValues.add(new Entry(5, 80f));
        yValues.add(new Entry(6, 70f));

        LineDataSet set1 = new LineDataSet(yValues, "Data Set 1");
        set1.setColor(getResources().getColor(R.color.colorPrimary));
        set1.setCircleColor(getResources().getColor(R.color.colorPrimary));
        set1.setLineWidth(3f);
        set1.setValueTextSize(15f);
        set1.setValueTextColor(getResources().getColor(android.R.color.transparent));

        ArrayList<ILineDataSet> dataSets = new ArrayList<>();
        dataSets.add(set1);

        LineData data = new LineData(dataSets);
        reportChart.setViewPortOffsets(0,0,0,50);
        reportChart.getAxisRight().setEnabled(false);

        reportChart.getDescription().setEnabled(false);
        reportChart.getLegend().setEnabled(false);

        XAxis xAxis = reportChart.getXAxis();
        xAxis.setPosition(XAxis.XAxisPosition.BOTTOM);
        xAxis.setDrawGridLines(false);
        xAxis.setTextSize(12f);
        xAxis.setSpaceMin(-0.5f);
        xAxis.setSpaceMax(-0.5f);
        xAxis.setGranularity(1f);
        xAxis.setValueFormatter(new IndexAxisValueFormatter(getXAxisValues()));
        xAxis.setTextColor(getResources().getColor(R.color.blackTransparent));

        YAxis yAxis = reportChart.getAxisLeft();
        yAxis.setPosition(YAxis.YAxisLabelPosition.INSIDE_CHART);
        yAxis.setDrawAxisLine(false);
        yAxis.setYOffset(-12f);
        yAxis.setXOffset(20f);
        yAxis.setTextSize(12f);
        yAxis.setSpaceTop(20f);
        yAxis.setSpaceBottom(20f);
        xAxis.setGranularity(1f);
        yAxis.setTextColor(getResources().getColor(R.color.blackTransparent));


        reportChart.setData(data);
        reportChart.notifyDataSetChanged();
        reportChart.invalidate();


        //----------------------------------------------------------------------------

        ReportListAdapter adapter = new ReportListAdapter(this, R.layout.adapter_view_layout, reportSamples);
        mListView.setAdapter(adapter);
    }

    protected ArrayList<ReportSample> reportSamples = new ArrayList<>();

    private ArrayList<String> getXAxisValues()
    {
        ArrayList<String> labels = new ArrayList<String> ();

        labels.add("Sun");
        labels.add("Mon");
        labels.add("Tues");
        labels.add("Wed");
        labels.add("Thur");
        labels.add("Fri");
        labels.add("Sat");
        return labels;
    }

    private void readTestData() {
        InputStream is = getResources().openRawResource(R.raw.testsalesdata);
        BufferedReader reader = new BufferedReader(
                new InputStreamReader(is, Charset.forName("UTF-8"))
        );

        String line = "";
            try {
                //Step over header
                reader.readLine();

                while ((line = reader.readLine()) != null) {

                    //Split by '~'
                    String[] tokens = line.split("~");

                    //Reading data
                    ReportSample sample = new ReportSample();
                    sample.setContactName(tokens[0]);
                    sample.setContactPhone(tokens[1]);
                    sample.setContactEmail(tokens[2]);
                    sample.setContactCompany(tokens[3]);
                    sample.setSalesDate(tokens[4]);
                    sample.setTransactionAmt(tokens[5]);
                    sample.setTransactionId(tokens[6]);

                    reportSamples.add(sample);

                    Log.d("ReportActivity", "Just created: " + sample);
                }

            } catch (IOException e) {
                Log.wtf("ReportActivity", "Error reading data file on line " + line, e);
                e.printStackTrace();

            }

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

