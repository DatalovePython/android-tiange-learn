package com.newland.tiange;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class LifeActivity extends AppCompatActivity {



    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lifecycle);

        Log.d("Lifecycle", "---onCreate---");


    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d("Lifecycle", "---onStart---");
    }

    //电话结束.状态恢复
    @Override
    protected void onResume() {
        super.onResume();
        Log.d("Lifecycle", "---onResume---");
    }

    //例如突然来电话
    @Override
    protected void onPause() {
        super.onPause();
        Log.d("Lifecycle", "---onPause---");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d("Lifecycle", "---onStop---");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d("Lifecycle", "---onRestart---");

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d("Lifecycle", "---onDestroy---");
    }
}
