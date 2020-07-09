package com.newland.tiange;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.newland.tiange.recyclerview.RecyclerViewActivity;

public class MainActivity extends AppCompatActivity {

    private Button mBtnTextView;
    private Button mBtnButton;
    private Button mBtnEdit;
    private Button mBtnRadioButton;
    private Button mBtnCheckBox;
    private Button mBtnImageView;
    private Button mRV;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //textview 点击跳转演示
        mBtnTextView = (Button) findViewById(R.id.btn_textview);

        //button 点击跳转演示
        mBtnButton = (Button) findViewById(R.id.btn_button);

        //Editbutton 演示
        mBtnEdit = (Button) findViewById(R.id.btn_edittext);

        //RadioButton演示
        mBtnRadioButton = (Button) findViewById(R.id.btn_radiobutton);

        mBtnCheckBox = (Button) findViewById(R.id.btn_checkbox);

        mBtnImageView = (Button) findViewById(R.id.btn_imageview);

        mRV = (Button) findViewById(R.id.btn_recyclerview);

        setListeners();

    }

    private void setListeners(){
        Onclick onclick = new Onclick();
        mBtnRadioButton.setOnClickListener(onclick);
        mBtnTextView.setOnClickListener(onclick);
        mBtnEdit.setOnClickListener(onclick);
        mBtnButton.setOnClickListener(onclick);
        mBtnCheckBox.setOnClickListener(onclick);
        mBtnImageView.setOnClickListener(onclick);
        mRV.setOnClickListener(onclick);
    }

    private class Onclick implements View.OnClickListener{
        @Override
        public void onClick(View view) {
            Intent intent = null;
            switch (view.getId()){
                case R.id.btn_textview:
                    intent = new Intent(MainActivity.this,TextViewActivity.class);
                    break;

                case R.id.btn_button:
                    intent = new Intent(MainActivity.this,ButtonActivity.class);
                    break;

                case R.id.btn_edittext:
                    intent = new Intent(MainActivity.this,EditTextActivity.class);
                    break;

                case R.id.btn_radiobutton:
                    intent = new Intent(MainActivity.this,RadioButtonActivity.class);
                    break;

                case R.id.btn_checkbox:
                    intent = new Intent(MainActivity.this,CheckboxActivity.class);
                    break;

                case R.id.btn_imageview:
                    intent = new Intent(MainActivity.this,ImageViewActivity.class);
                    break;

                case R.id.btn_recyclerview:
                    intent = new Intent(MainActivity.this, RecyclerViewActivity.class);
                    break;

            }
            startActivity(intent);
        }
    }
}
