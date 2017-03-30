package com.example.liviu.login_windows;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

public class profile_activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile_activity);

        // obtinere Intent (text cu username)
        Intent intent = getIntent();
        String message = intent.getStringExtra(MainActivity.EXTRA_MESSAGE);

        // obtinere TextView si inserare mesaj (username)
        TextView textView = (TextView) findViewById(R.id.text0);
        textView.setText(message);
    }

    @Override
    public void onBackPressed() {
        finish();
    }
}
