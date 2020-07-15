package com.newland.tiange;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.newland.tiange.recyclerview.RecyclerViewActivity;

public class UIActivity extends AppCompatActivity {

    private Button mBtnTextView;
    private Button mBtnButton;
    private Button mBtnEdit;
    private Button mBtnRadioButton;
    private Button mBtnCheckBox;
    private Button mBtnImageView;
    private Button mRV;
    private Button mBtnWebView;
    private Button mBtnToast;
    private Button mBtnDialog;
    private Button mBtnProgress;
    private Button mBtnCustomDialog;
    private Button mBtnPopupWindow;
    private Button mBtnLifeCycle;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ui);

        //textview 点击跳转演示
        mBtnTextView = (Button) findViewById(R.id.btn_textview);

        //button 点击跳转演示
        mBtnButton = (Button) findViewById(R.id.btn_button);

        //Editbutton 演示
        mBtnEdit = (Button) findViewById(R.id.btn_edittext);

        //RadioButton演示
        mBtnRadioButton = (Button) findViewById(R.id.btn_radiobutton);

        mBtnCheckBox = (Button) findViewById(R.id.btn_checkbox);

        mBtnImageView = (Button) findViewById(R.id.btn_imageview);

        mRV = (Button) findViewById(R.id.btn_recyclerview);

        mBtnWebView = (Button) findViewById(R.id.btn_webview);

        mBtnToast = (Button) findViewById(R.id.btn_toast);

        mBtnDialog = (Button) findViewById(R.id.btn_dialog);

        mBtnProgress = (Button)findViewById(R.id.btn_progress);

        mBtnCustomDialog = (Button) findViewById(R.id.btn_custom_dialog);

        mBtnPopupWindow = (Button) findViewById(R.id.btn_popup_window);

        mBtnLifeCycle = (Button) findViewById(R.id.btn_lifecycle);

        setListeners();

    }

    private void setListeners() {
        Onclick onclick = new Onclick();
        mBtnRadioButton.setOnClickListener(onclick);
        mBtnTextView.setOnClickListener(onclick);
        mBtnEdit.setOnClickListener(onclick);
        mBtnButton.setOnClickListener(onclick);
        mBtnCheckBox.setOnClickListener(onclick);
        mBtnImageView.setOnClickListener(onclick);
        mRV.setOnClickListener(onclick);
        mBtnWebView.setOnClickListener(onclick);
        mBtnToast.setOnClickListener(onclick);
        mBtnDialog.setOnClickListener(onclick);
        mBtnProgress.setOnClickListener(onclick);
        mBtnCustomDialog.setOnClickListener(onclick);
        mBtnPopupWindow.setOnClickListener(onclick);
        mBtnLifeCycle.setOnClickListener(onclick);
    }

    private class Onclick implements View.OnClickListener {
        @Override
        public void onClick(View view) {
            Intent intent = null;
            switch (view.getId()) {
                case R.id.btn_textview:
                    intent = new Intent(UIActivity.this, TextViewActivity.class);
                    break;

                case R.id.btn_button:
                    intent = new Intent(UIActivity.this, ButtonActivity.class);
                    break;

                case R.id.btn_edittext:
                    intent = new Intent(UIActivity.this, EditTextActivity.class);
                    break;

                case R.id.btn_radiobutton:
                    intent = new Intent(UIActivity.this, RadioButtonActivity.class);
                    break;

                case R.id.btn_checkbox:
                    intent = new Intent(UIActivity.this, CheckboxActivity.class);
                    break;

                case R.id.btn_imageview:
                    intent = new Intent(UIActivity.this, ImageViewActivity.class);
                    break;

                case R.id.btn_recyclerview:
                    intent = new Intent(UIActivity.this, RecyclerViewActivity.class);
                    break;
                case R.id.btn_webview:
                    intent = new Intent(UIActivity.this, WebViewActivity.class);
                    break;

                case R.id.btn_toast:
                    intent = new Intent(UIActivity.this, ToastActivity.class);
                    break;

                case R.id.btn_dialog:
                    intent = new Intent(UIActivity.this, DialogActivity.class);
                    break;

                case R.id.btn_progress:
                    intent = new Intent(UIActivity.this, ProgressActivity.class);
                    break;
                case R.id.btn_custom_dialog:
                    intent = new Intent(UIActivity.this, CustomDialogActivity.class);
                    break;
                case R.id.btn_popup_window:
                    intent = new Intent(UIActivity.this, PopupWindowActivity.class);
                    break;

                case R.id.btn_lifecycle:
                    intent = new Intent(UIActivity.this, LifeActivity.class);

                    //演示A页面的数据传递给B页面
                    Bundle bundle = new Bundle();
                    bundle.putString("name","卢中川");
                    bundle.putInt("age",18);
                    intent.putExtras(bundle);
                    break;
            }

            if(view.getId()==R.id.btn_lifecycle){
                startActivityForResult(intent,0);
            }else {
                startActivity(intent);
            }
        }
    }
//取得下一个页面传回的数据
    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        Toast.makeText(UIActivity.this, data.getExtras().getString("title"),Toast.LENGTH_LONG).show();
    }
}
