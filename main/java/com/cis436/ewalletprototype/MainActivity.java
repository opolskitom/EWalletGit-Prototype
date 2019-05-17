package com.cis436.ewalletprototype;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;


public class MainActivity extends AppCompatActivity {
    interface OnClassClickListener{
        void onClassSelected(String option);
    }
    private OnClassClickListener mCallback;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        Button loginBtn = findViewById(R.id.loginBtn);
        EditText usernameTxt = findViewById(R.id.usernameEditText);
        EditText passwordTxt = findViewById(R.id.passwordEditText);

        loginBtn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                login();
            }
        });
    }
    public void login() {
        Intent goMenu = new Intent(this, MenuActivity.class);
        startActivity(goMenu);
    }
}
