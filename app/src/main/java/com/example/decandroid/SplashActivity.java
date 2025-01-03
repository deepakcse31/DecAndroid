package com.example.decandroid;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.Locale;

public class SplashActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_splash);

        new Handler(Looper.getMainLooper()).postDelayed(new Runnable() {
            @Override
            public void run() {
                SharedPreferences sharedPreferences=getSharedPreferences("onx",MODE_PRIVATE);
                String loginstatus = sharedPreferences.getString("loginstatus", "");
                if (loginstatus.equals("true")) {
                    Intent intent = new Intent(SplashActivity.this, RecyclerViewActivity.class);
                    startActivity(intent);
                }
                else {

                Intent intent=new Intent(SplashActivity.this,LoginActivity.class);
                startActivity(intent);
                }

//                Intent intent=new Intent(SplashActivity.this,LoginActivity.class);
//                startActivity(intent);
//
            }
        },2000);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
}