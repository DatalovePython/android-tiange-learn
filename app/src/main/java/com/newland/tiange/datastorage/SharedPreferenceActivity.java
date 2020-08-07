package com.newland.tiange.datastorage;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.newland.tiange.R;

import org.w3c.dom.Text;

/*
* 轻量级文件储存，存储在xml文件中
* 存储目录：/data/data/<applicationId>/shared_prefs
*
* */

public class SharedPreferenceActivity extends AppCompatActivity {

    EditText mEtName;
    Button mBtnSave,mBtnShow;
    TextView mTvContent;
    private SharedPreferences sharedPreferences;
    private SharedPreferences.Editor editor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shared_preference);

        mEtName = findViewById(R.id.et_name);
        mBtnSave = findViewById(R.id.btn_save);
        mBtnShow = findViewById(R.id.btn_show);
        mTvContent = findViewById(R.id.tv_content);

        //只有本应用才能读写
        sharedPreferences = this.getSharedPreferences("data",MODE_PRIVATE);
        editor = sharedPreferences.edit();

        mBtnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                editor.putString("name",mEtName.getText().toString());
                editor.apply();
            }
        });

        mBtnShow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mTvContent.setText(sharedPreferences.getString("name",""));
            }
        });

    }
}
