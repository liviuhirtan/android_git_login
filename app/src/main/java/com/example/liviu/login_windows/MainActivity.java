package com.example.liviu.login_windows;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    public static final String EXTRA_MESSAGE = "com.example.liviu.login_windows";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Reading preferences
        SharedPreferences preferences1 = PreferenceManager.getDefaultSharedPreferences(MainActivity.this);
        if(preferences1.getBoolean("logged_in", false));

        // Writing preferences
        SharedPreferences preferences2 = PreferenceManager.getDefaultSharedPreferences(MainActivity.this);
        preferences2.edit().putBoolean("logged_in", true).apply();

        Button button = (Button) findViewById(R.id.button1);

        button.setOnClickListener(new OnClickListener()
        {
            public void onClick(View v)
            {
                EditText username_txt = (EditText) findViewById(R.id.username_id);
                String string = username_txt.getText().toString();
                if(string.isEmpty()) {
                    Toast.makeText(MainActivity.this, "Insert username!", Toast.LENGTH_SHORT).show();
                }
                else {
                    EditText password_txt = (EditText) findViewById(R.id.password_id);
                    string = password_txt.getText().toString();
                    if(string.isEmpty()) {
                        Toast.makeText(MainActivity.this, "Insert password!", Toast.LENGTH_SHORT).show();
                    }
                    else {
                        Toast.makeText(MainActivity.this, "Successful login!", Toast.LENGTH_SHORT).show();

                        // trimitere text cu username-ul introdus la urmatorul Activity
                        Intent intent = new Intent(MainActivity.this, profile_activity.class);
                        intent.putExtra(EXTRA_MESSAGE, username_txt.getText().toString());

                        // pentru a preveni aparitia ferestrei initiale la apasarea butonului BACK din fereastra secundara
                        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
                        intent.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);

                        // start new activity - ecran cu informatii
                        startActivity(intent);
                    }
                }
            }
        });
    }
}
