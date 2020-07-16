package com.newland.tiange.jump;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.newland.tiange.R;
import com.newland.tiange.UIActivity;

public class AActivity extends AppCompatActivity {

    private Button mBtnJump;
    private Button mBtnJump2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_a);
        Log.d("AActivity", "----onCreate----");
        Log.d("AActivity", "taskId" + getTaskId() + " ,hash" + hashCode());
        try {
            logTaskName();
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
        }
        mBtnJump = (Button) findViewById(R.id.btn_jump);

        mBtnJump.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(AActivity.this, BActivity.class);
                //演示A页面的数据传递给B页面
                Bundle bundle = new Bundle();
                bundle.putString("name", "卢中川");
                bundle.putInt("age", 118);
                intent.putExtras(bundle);
                startActivity(intent);
//                startActivityForResult(intent,0);
            }
        });
        mBtnJump2 = (Button) findViewById(R.id.btn_jump2);
        mBtnJump2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(AActivity.this, AActivity.class);
                startActivity(intent);

            }
        });
    }

    //取得下一个页面传回的数据
    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        Toast.makeText(AActivity.this, data.getExtras().getString("title"), Toast.LENGTH_LONG).show();
    }

    @Override
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        Log.d("AActivity", "----onCreate----");
        Log.d("AActivity", "taskId" + getTaskId() + " ,hash" + hashCode());
        try {
            logTaskName();
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
        }

    }

    private void logTaskName() throws PackageManager.NameNotFoundException {
        ActivityInfo activityInfo = getPackageManager().getActivityInfo(getComponentName(), PackageManager.GET_META_DATA);
        Log.d("AActivity", activityInfo.taskAffinity);
    }
}
