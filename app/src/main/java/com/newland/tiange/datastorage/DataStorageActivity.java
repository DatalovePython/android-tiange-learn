package com.newland.tiange.datastorage;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.newland.tiange.R;

public class DataStorageActivity extends AppCompatActivity implements View.OnClickListener {

    Button mBtnSharedPreference,mFile;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_data_storage);
        mBtnSharedPreference = findViewById(R.id.btn_shared_preference);
        mBtnSharedPreference.setOnClickListener(this);
        mFile = findViewById(R.id.btn_file);
        mFile.setOnClickListener(this);
    }


    @Override
    public void onClick(View v) {
        Intent intent = null;

        switch (v.getId()){
            case R.id.btn_shared_preference:
                intent = new Intent(DataStorageActivity.this,SharedPreferenceActivity.class);
                break;

            case R.id.btn_file:
                intent = new Intent(DataStorageActivity.this,FileActivity.class);
                break;
        }
        startActivity(intent);
    }
}
