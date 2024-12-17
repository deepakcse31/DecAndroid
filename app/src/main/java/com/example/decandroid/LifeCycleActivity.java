package com.example.decandroid;

import android.os.Bundle;
import android.util.Log;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class LifeCycleActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_life_cycle);
        Log.e("LifeCycleActivity","LifeCycleActivity onCreate"+"On Create");
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.e("LifeCycleActivity","LifeCycleActivity onStart"+"On Start");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.e("LifeCycleActivity","LifeCycleActivity onResume"+"On Resume");

    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.e("LifeCycleActivity","LifeCycleActivity onPause"+"On Pause");
    }
    @Override
    protected void onStop() {
        super.onStop();
        Log.e("LifeCycleActivity","LifeCycleActivity onStop"+"On Stop");
    }
}