package com.newland.tiange;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.Toast;

public class CheckboxActivity extends AppCompatActivity {

    private CheckBox mCb3,mCb4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_checkbox);
        mCb3 = (CheckBox) findViewById(R.id.cb_3);
        mCb4 = (CheckBox) findViewById(R.id.cb_4);

        mCb3.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                Toast.makeText(CheckboxActivity.this,b ?"3选中":"3未选中",Toast.LENGTH_SHORT).show();
            }
        });

        mCb4.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                Toast.makeText(CheckboxActivity.this,b ?"4选中":"4未选中",Toast.LENGTH_SHORT).show();
            }
        });

    }
}
