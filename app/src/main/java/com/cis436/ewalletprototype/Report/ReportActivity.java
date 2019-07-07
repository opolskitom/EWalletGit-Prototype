package com.cis436.ewalletprototype.Report;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.MenuItem;
import android.widget.ListView;

import com.cis436.ewalletprototype.MakePaymentActivity;
import com.cis436.ewalletprototype.MenuActivity;
import com.cis436.ewalletprototype.P2P.P2PActivity;
import com.cis436.ewalletprototype.R;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.Charset;
import java.util.ArrayList;

public class ReportActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_report);

        ListView mListView = findViewById(R.id.listView);

        //Bottom Navigation Menu
        BottomNavigationView bottomNavigationView = findViewById(R.id.bottom_navigation);
        bottomNavigationView.setSelectedItemId(R.id.action_report);
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {

            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                switch(menuItem.getItemId()) {

                    case R.id.action_makePayment:
                        finish();
                        Intent makePayment = new Intent(ReportActivity.this, MakePaymentActivity.class);
                        startActivity(makePayment);
                        break;

                    case R.id.action_p2pTransaction:
                        finish();
                        Intent p2pTransaction = new Intent(ReportActivity.this, P2PActivity.class);
                        startActivity(p2pTransaction);
                        break;

                    case R.id.action_report:
                        break;
                }

                return true;
            }
        });

        readTestData();

        ReportListAdapter adapter = new ReportListAdapter(this, R.layout.adapter_view_layout, reportSamples);
        mListView.setAdapter(adapter);
    }

    protected ArrayList<ReportSample> reportSamples = new ArrayList<>();

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

                    //Split by '|'
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

}

