package com.newland.tiange;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.PopupWindow;
import android.widget.TextView;

import com.newland.tiange.util.ToastUtil;

public class PopupWindowActivity extends AppCompatActivity
{

    private Button mBtnPop;
    private PopupWindow mPop;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_popup_window);
        mBtnPop = findViewById(R.id.btn_pop);
        mBtnPop.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                View popview = getLayoutInflater().inflate(R.layout.layout_pop, null);
                TextView textView = popview.findViewById(R.id.tv_good);
                textView.setOnClickListener(new View.OnClickListener()
                {
                    @Override
                    public void onClick(View view)
                    {
                        mPop.dismiss();
                        ToastUtil.showMsg(PopupWindowActivity.this, "妙啊");
                    }
                });

                DisplayMetrics dm = new DisplayMetrics();
                getWindowManager().getDefaultDisplay().getMetrics(dm);
                int screenWidth = dm.widthPixels;
                mPop = new PopupWindow(popview,screenWidth, ViewGroup.LayoutParams.WRAP_CONTENT);
                mPop.setOutsideTouchable(true);
                mPop.setFocusable(true);
                mPop.showAtLocation(view, Gravity.BOTTOM,0,0);
//                mPop.showAsDropDown(mBtnPop);
            }
        });
    }
}
