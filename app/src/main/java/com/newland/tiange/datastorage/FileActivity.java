package com.newland.tiange.datastorage;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.newland.tiange.R;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/*
 * 轻量级文件储存，存储在xml文件中
 * 存储目录：/data/data/<applicationId>/shared_prefs
 *
 * */

public class FileActivity extends AppCompatActivity {

    EditText mEtName;
    Button mBtnSave, mBtnShow;
    TextView mTvContent;
    private SharedPreferences sharedPreferences;
    private SharedPreferences.Editor editor;
    private final String fileName = "test.txt";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_file);

        mEtName = findViewById(R.id.et_name);
        mBtnSave = findViewById(R.id.btn_save);
        mBtnShow = findViewById(R.id.btn_show);
        mTvContent = findViewById(R.id.tv_content);


        mBtnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                save(mEtName.getText().toString());
            }
        });

        mBtnShow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mTvContent.setText(read());

            }
        });
    }

    //存储数据
    void save(String content) {
        FileOutputStream fileOutputStream = null;
        try {
            fileOutputStream = openFileOutput(fileName, MODE_PRIVATE);
            fileOutputStream.write(content.getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (fileOutputStream != null) {
                try {
                    fileOutputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

        }
    }

    String read() {
        FileInputStream fileInputStream = null;
        try {
            fileInputStream = openFileInput(fileName);
            byte[] buff = new byte[1024];
            StringBuilder sb = new StringBuilder("");
            int len = 0;
            while ((len = fileInputStream.read(buff)) > 0) {
                sb.append(new String(buff, 0, len));
            }
            return sb.toString();


        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (fileInputStream != null) {
                try {
                    fileInputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return null;

    }
}
