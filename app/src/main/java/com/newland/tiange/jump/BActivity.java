package com.newland.tiange.jump;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.util.Log;
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
        Log.d("BActivity", "----onCreate----");
        Log.d("BActivity", "taskId" + getTaskId() + " ,hash" + hashCode());
        try {
            logTaskName();
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
        }
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

    @Override
    protected void onNewIntent(Intent intent) {
        Log.d("BActivity", "----onCreate----");
        Log.d("BActivity", "taskId" + getTaskId() + " ,hash" + hashCode());
        try {
            logTaskName();
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
        }
        super.onNewIntent(intent);
    }

    private void logTaskName() throws PackageManager.NameNotFoundException {
        ActivityInfo activityInfo = getPackageManager().getActivityInfo(getComponentName(), PackageManager.GET_META_DATA);
        Log.d("BActivity", activityInfo.taskAffinity);
    }
}
