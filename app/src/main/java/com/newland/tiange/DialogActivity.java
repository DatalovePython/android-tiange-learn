package com.newland.tiange;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.newland.tiange.util.ToastUtil;

public class DialogActivity extends AppCompatActivity {

    private Button mBtnDialog1;
    private Button mBtnDialog2;
    private Button mBtnDialog3;
    private Button mBtnDialog4;
    private Button mBtnDialog5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dialog);
        mBtnDialog1 = (Button) findViewById(R.id.btn_dialog1);
        mBtnDialog2 = (Button) findViewById(R.id.btn_dialog2);
        mBtnDialog3 = (Button) findViewById(R.id.btn_dialog3);
        mBtnDialog4 = (Button) findViewById(R.id.btn_dialog4);
        mBtnDialog5 = (Button) findViewById(R.id.btn_dialog5);
        Onclick onclick = new Onclick();
        mBtnDialog1.setOnClickListener(onclick);
        mBtnDialog2.setOnClickListener(onclick);
        mBtnDialog3.setOnClickListener(onclick);
        mBtnDialog4.setOnClickListener(onclick);
        mBtnDialog5.setOnClickListener(onclick);


    }

    class Onclick implements View.OnClickListener{
        @Override
        public void onClick(View v) {
            switch (v.getId()){
                case R.id.btn_dialog1:
                    AlertDialog.Builder builder = new AlertDialog.Builder(DialogActivity.this);
                    builder.setTitle("请回答1988");
                    builder.setMessage("好看吗？").setPositiveButton("棒", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            ToastUtil.showMsg(DialogActivity.this,"谢谢！");
                        }
                    }).setNeutralButton("还行", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            ToastUtil.showMsg(DialogActivity.this,"没关系！");
                        }
                    }).setNegativeButton("不好", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            ToastUtil.showMsg(DialogActivity.this,"我们会加油的");
                        }
                    }).show();
                    break;
                case R.id.btn_dialog2:
                    final String[] array2 = new String[]{"男", "女"};
                    AlertDialog.Builder builder2 = new AlertDialog.Builder(DialogActivity.this);
                    builder2.setTitle("请选择性别").setItems(array2, new DialogInterface.OnClickListener()
                    {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i)
                        {
                            ToastUtil.showMsg(DialogActivity.this, array2[i]);
                        }
                    }).show();
                    break;
                case R.id.btn_dialog3:
                    final String[] array3 = new String[]{"男", "女"};
                    AlertDialog.Builder builder3 = new AlertDialog.Builder(DialogActivity.this);
                    builder3.setTitle("请选择性别").setSingleChoiceItems(array3, 0, new DialogInterface.OnClickListener()
                    {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i)
                        {
                            ToastUtil.showMsg(DialogActivity.this, array3[i]);
                            dialogInterface.dismiss();
                        }
                    }).setCancelable(false).show();
                    break;
                case R.id.btn_dialog4:
                    final String[] array4 = new String[]{"唱歌", "跳舞", "写代码"};
                    final boolean[] isCheckd = new boolean[]{false, false, true};
                    AlertDialog.Builder builder4 = new AlertDialog.Builder(DialogActivity.this);
                    builder4.setTitle("选择兴趣").setMultiChoiceItems(array4, isCheckd, new DialogInterface.OnMultiChoiceClickListener()
                    {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i, boolean b)
                        {
                            ToastUtil.showMsg(DialogActivity.this, array4[i] + ": " + isCheckd[i]);
                        }
                    }).setPositiveButton("确定", new DialogInterface.OnClickListener()
                    {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i)
                        {
                            //回调函数
                        }
                    }).setNegativeButton("取消", new DialogInterface.OnClickListener()
                    {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i)
                        {

                        }
                    }).show();
                    break;
                case R.id.btn_dialog5:
                    AlertDialog.Builder builder5 = new AlertDialog.Builder(DialogActivity.this);
                    View loginView = LayoutInflater.from(DialogActivity.this).inflate(R.layout.layout_dialog, null);
                    EditText username = loginView.findViewById(R.id.et_username);
                    EditText password = loginView.findViewById(R.id.et_password);
                    Button btnLogin = loginView.findViewById(R.id.btn_login);
                    btnLogin.setOnClickListener(new View.OnClickListener()
                    {
                        @Override
                        public void onClick(View view)
                        {
                            //
                        }
                    });
                    builder5.setTitle("请先登录").setView(loginView).show();
                    break;

            }
        }
    }

}
