package com.newland.tiange;

import androidx.annotation.IdRes;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class RadioButtonActivity extends AppCompatActivity {

    private RadioGroup mRg1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_radio_button);
        mRg1 = (RadioGroup) findViewById(R.id.rg_2);
        mRg1.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup,@IdRes int i) {
                RadioButton radioButton = (RadioButton)radioGroup.findViewById(i);
                Toast.makeText(RadioButtonActivity.this,radioButton.getText().toString(),Toast.LENGTH_SHORT).show();
            }
        });
    }
}
