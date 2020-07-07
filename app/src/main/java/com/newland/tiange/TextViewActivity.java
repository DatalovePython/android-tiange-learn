package com.newland.tiange;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Paint;
import android.os.Bundle;
import android.text.Html;
import android.view.View;
import android.widget.TextView;

import org.w3c.dom.Text;

public class TextViewActivity extends AppCompatActivity {

    private TextView mTV4,mTV5;
    private TextView mTV6;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_textview);
        mTV4 = (TextView)findViewById(R.id.tv_4);
        mTV4.getPaint().setFlags(Paint.STRIKE_THRU_TEXT_FLAG);//中划线
//        mTV4.getPaint().setFlags(Paint.UNDERLINE_TEXT_FLAG);//下划线
        mTV4.getPaint().setAntiAlias(true);//去除锯齿

        mTV5 = (TextView)findViewById(R.id.tv_5);
        mTV5.setText(Html.fromHtml("<u>测试HTML</u>"));




    }
}
