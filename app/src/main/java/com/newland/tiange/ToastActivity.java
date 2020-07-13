package com.newland.tiange;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.newland.tiange.util.ToastUtil;

public class ToastActivity extends AppCompatActivity {

    private Button mBtnToast1;
    private Button mBtnToast2;
    private Button mBtnToast3;
    private Button mBtnToast4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_toast);
        mBtnToast1 = findViewById(R.id.btn_toast_1);
        mBtnToast2 = findViewById(R.id.btn_toast_2);
        mBtnToast3 = findViewById(R.id.btn_toast_3);
        mBtnToast4 = findViewById(R.id.btn_toast_4);
        Onclick onclick = new Onclick();
        mBtnToast1.setOnClickListener(onclick);
        mBtnToast2.setOnClickListener(onclick);
        mBtnToast3.setOnClickListener(onclick);
        mBtnToast4.setOnClickListener(onclick);

    }

    class Onclick implements View.OnClickListener {
        @Override
        public void onClick(View v) {
            switch (v.getId()) {
                case R.id.btn_toast_1:
                    //第二个参数代表显示多久
                    Toast.makeText(getApplicationContext(), "Toast:", Toast.LENGTH_SHORT).show();
                    break;

                case R.id.btn_toast_2:
                    Toast toastCenter = Toast.makeText(getApplicationContext(), "居中:", Toast.LENGTH_SHORT);
                    toastCenter.setGravity(Gravity.CENTER, 0, 0);
                    toastCenter.show();
                    break;

                case R.id.btn_toast_3:
                    Toast toastCustom = new Toast(getApplicationContext());
                    LayoutInflater inflater = LayoutInflater.from(ToastActivity.this);
                    inflater.inflate(R.layout.layout_toast, null);
                    View viewCustom = inflater.inflate(R.layout.layout_toast, null);
                    ImageView imageView = (ImageView) viewCustom.findViewById(R.id.iv_toast);
                    TextView textView = (TextView) viewCustom.findViewById(R.id.tv_toast);
                    imageView.setImageResource(R.drawable.xinyuanjieyi);
                    textView.setText("自定义toast");
                    toastCustom.setView(viewCustom);
                    toastCustom.show();

                    break;

                case R.id.btn_toast_4:
                    ToastUtil.showMsg(getApplicationContext(),"包装过的Toast");
                    break;

            }
        }
    }
}
