package com.cis436.ewalletprototype.P2P;

import android.content.Intent;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.customtabs.CustomTabsIntent;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;

import com.cis436.ewalletprototype.MakePaymentActivity;
import com.cis436.ewalletprototype.MenuActivity;
import com.cis436.ewalletprototype.R;
import com.cis436.ewalletprototype.Report.ReportActivity;

public class P2PActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_p2p);

        //Bottom Navigation Menu
        BottomNavigationView bottomNavigationView = findViewById(R.id.bottom_navigation);
        bottomNavigationView.setSelectedItemId(R.id.action_p2pTransaction);
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {

            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                switch(menuItem.getItemId()) {

                    case R.id.action_makePayment:
                        finish();
                        Intent makePayment = new Intent(P2PActivity.this, MakePaymentActivity.class);
                        startActivity(makePayment);
                        break;

                    case R.id.action_p2pTransaction:
                        break;

                    case R.id.action_report:
                        finish();
                        Intent report = new Intent(P2PActivity.this, ReportActivity.class);
                        startActivity(report);
                        break;
                }

                return true;
            }
        });

        findViewById(R.id.ppOpen).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openChromeCustomTabs("https://www.paypal.com/myaccount/transfer/homepage");
            }
        });

        findViewById(R.id.manualOpen).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent P2PManualActivity = new Intent(P2PActivity.this ,P2PManualActivity.class);
                startActivity(P2PManualActivity);
            }
        });
    }

    public void openChromeCustomTabs(String url) {
        CustomTabsIntent.Builder builder = new CustomTabsIntent.Builder();

        CustomTabsIntent intent = builder.build();
        intent.launchUrl(this, Uri.parse(url));
    }

}
