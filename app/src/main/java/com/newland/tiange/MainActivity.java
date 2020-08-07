package com.newland.tiange;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.newland.tiange.datastorage.DataStorageActivity;

public class MainActivity extends AppCompatActivity {

    private Button mBtnUI;
    private Button mBtnSNMS;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mBtnUI = (Button) findViewById(R.id.btn_ui);
        mBtnSNMS = (Button) findViewById(R.id.btn_file);


        Onclick onclick = new Onclick();

        mBtnUI.setOnClickListener(onclick);
        mBtnSNMS.setOnClickListener(onclick);

    }

    class Onclick implements View.OnClickListener{
        @Override
        public void onClick(View v) {
            Intent intent = null;
            switch (v.getId()){
                case R.id.btn_ui:
                    intent = new Intent(MainActivity.this, UIActivity.class);
                    break;

                case R.id.btn_file:
                    intent = new Intent(MainActivity.this, DataStorageActivity.class);
                    break;
            }
            startActivity(intent);

        }
    }
}
