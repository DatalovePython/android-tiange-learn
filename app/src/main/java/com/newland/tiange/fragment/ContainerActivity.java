package com.newland.tiange.fragment;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.newland.tiange.R;

public class ContainerActivity extends AppCompatActivity {

    private AFragment aFragment;
    private BFragment bFragment;
    private Button mBtnChange;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_container);
        mBtnChange = (Button) findViewById(R.id.btn_change);

        mBtnChange.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(bFragment == null){
                    bFragment = new BFragment();
                }
                getSupportFragmentManager().beginTransaction().replace(R.id.fl_container,bFragment).commitAllowingStateLoss();
            }
        });
    //实例化AFragment
        aFragment = AFragment.newInstance("我是参数");
//        aFragment = new AFragment();
    //        把AFragment 添加到Activity中
        getSupportFragmentManager().beginTransaction().add(R.id.fl_container, aFragment).commitAllowingStateLoss();
    }
}
