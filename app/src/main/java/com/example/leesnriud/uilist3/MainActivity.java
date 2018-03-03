package com.example.leesnriud.uilist3;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * android 部分UI控件
 *
 * spinner 列表选择框
 * autocompletetextview 自动完成文本框
 * natification 状态栏通知
 *
 */
public class MainActivity extends AppCompatActivity {

    private Intent intent;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
    }

    @OnClick({R.id.bt_spinner, R.id.bt_autocompletetextview, R.id.bt_notification})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.bt_spinner:
                intent = new Intent(MainActivity.this,SpinnerActivity.class);
                startActivity(intent);
                break;
            case R.id.bt_autocompletetextview:
                intent = new Intent(MainActivity.this,AutoCompleteTextActivity.class);
                startActivity(intent);
                break;
            case R.id.bt_notification:
                intent = new Intent(MainActivity.this,NotificationActivity.class);
                startActivity(intent);
                break;
        }
    }
}
