package com.newland.tiange;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;

//引入外部包后报错
//import com.bumptech.glide.Glide;

public class ImageViewActivity extends AppCompatActivity {

    private ImageView mIv4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_image_view);
        mIv4 = (ImageView) findViewById(R.id.iv_4);

//        Glide.with(this).load("https://www.baidu.com/img/dong_54209c0ff3da32eecc31f340c08a18f6.gif").into(mIv4);


    }
}
