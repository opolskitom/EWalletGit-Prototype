package com.cis436.ewalletprototype.onStartUp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.cis436.ewalletprototype.Payment.MakePaymentActivity;
import com.cis436.ewalletprototype.R;

//Page Creators/Modifiers: Thomas Opolski, ...
//Main startup page, used for checking any necessary information on application start

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button loginBtn = findViewById(R.id.startBtn);

        loginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent StartingActivity = new Intent(MainActivity.this , StartingActivity.class);
                startActivity(StartingActivity);
            }
        });

    }
}
