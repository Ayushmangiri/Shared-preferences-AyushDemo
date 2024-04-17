package com.example.sharedpre;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.WindowCompat;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.P) {
            new Handler().postDelayed(new Runnable() {
                @Override
                public void run() {
                    SharedPreferences preferences = getSharedPreferences("login", MODE_PRIVATE);
                    boolean check = preferences.getBoolean("flag", false);
                    Intent nextIntent;
                    if (check) {// for user log in
                        nextIntent = new Intent(MainActivity.this, HomeActivity.class);
                    } else { // for user is logout
                        nextIntent = new Intent(MainActivity.this, LoginActivity.class);
                    }
                    startActivity(nextIntent);
                    finish();
                }
            }, 2000);
        }
    }
}
