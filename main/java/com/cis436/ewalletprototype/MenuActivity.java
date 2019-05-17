package com.cis436.ewalletprototype;

import android.app.Activity;
import android.content.Intent;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.widget.Button;
public class MenuActivity extends Activity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        Button btnMakePayment = findViewById(R.id.btnMakePayment);
        Button btnSendMoney = findViewById(R.id.btnSendMoney);
        Button btnContact = findViewById(R.id.btnContact);
        Button btnReport = findViewById(R.id.btnReport);


        btnMakePayment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent makePayment = new Intent(MenuActivity.this,MakePaymentActivity.class);
                startActivity(makePayment);
            }
        });

        btnSendMoney.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent sendMoney = new Intent(MenuActivity.this ,P2PActivity.class);
                startActivity(sendMoney);
            }
        });
        /*
        btnContact.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent contact = new Intent(MenuActivity.this,ContactActivity.class);
                startActivity(contact);
            }
        });
        btnReport.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent report = new Intent(MenuActivity.this,ReportActivity.class);
                startActivity(report);
            }
        });*/

    }
}


