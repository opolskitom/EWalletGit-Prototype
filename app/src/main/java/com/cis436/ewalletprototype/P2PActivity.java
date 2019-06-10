package com.cis436.ewalletprototype;

import android.content.Intent;
import android.net.Uri;
import android.support.customtabs.CustomTabsIntent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class P2PActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_p2p);

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
