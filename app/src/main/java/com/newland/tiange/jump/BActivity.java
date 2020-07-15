package com.newland.tiange.jump;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.newland.tiange.R;

public class BActivity extends AppCompatActivity {

    private Button mBtnFinish;
    private TextView mTvTitle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_b);
        final Bundle bundle = getIntent().getExtras();
        String name = bundle.getString("name");
        int age = bundle.getInt("age");
        mTvTitle = (TextView) findViewById(R.id.tv_title);
        mTvTitle.setText(name + "," + age);

        mBtnFinish = (Button) findViewById(R.id.btn_finish);
        mBtnFinish.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                Bundle bundle1 = new Bundle();
                bundle1.putString("title","我回来了");
                intent.putExtras(bundle1);
                setResult(Activity.RESULT_OK,intent);
                //关闭当前页面
                finish();
            }
        });
    }
}
