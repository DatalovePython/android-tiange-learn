package com.newland.tiange.jump;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.newland.tiange.R;
import com.newland.tiange.UIActivity;

public class AActivity extends AppCompatActivity {

    private Button mBtnJump;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_a);
        mBtnJump = (Button) findViewById(R.id.btn_jump);
        mBtnJump.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(AActivity.this, BActivity.class);
                //演示A页面的数据传递给B页面
                Bundle bundle = new Bundle();
                bundle.putString("name","卢中川");
                bundle.putInt("age",18);
                intent.putExtras(bundle);
//                startActivity(intent);
                startActivityForResult(intent,0);
            }
        });
    }

    //取得下一个页面传回的数据
    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        Toast.makeText(AActivity.this, data.getExtras().getString("title"),Toast.LENGTH_LONG).show();
    }
}
