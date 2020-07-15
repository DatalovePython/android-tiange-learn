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

    private TextView mTvTitle;
    private Button mBtnFinish;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lifecycle);
        final Bundle bundle = getIntent().getExtras();
        String name = bundle.getString("name");
        int age = bundle.getInt("age");
        mTvTitle = (TextView) findViewById(R.id.tv_title);
        mTvTitle.setText(name + "," + age);
        Log.d("Lifecycle", "---onCreate---");

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
