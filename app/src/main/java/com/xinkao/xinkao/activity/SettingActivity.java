package com.xinkao.xinkao.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.hyphenate.EMCallBack;
import com.hyphenate.chat.EMClient;
import com.xinkao.xinkao.LoginActivity;
import com.xinkao.xinkao.R;

/**
 * Create by 钱 on 2018/11/2 0002
 */
public class SettingActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setting);

        Button logout = findViewById(R.id.logout);
        logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                singout();
            }
        });
    }

    private void singout() {
        EMClient.getInstance().logout(false, new EMCallBack() {
            @Override
            public void onSuccess() {
                startActivity(new Intent(getApplicationContext(), LoginActivity.class));
                Log.i("tag", "退出成功!");
                setResult(5);
                finish();
            }

            @Override
            public void onError(int i, String s) {
                Log.e("error", i + "退出失败，————" + s);
            }

            @Override
            public void onProgress(int i, String s) {

            }
        });
    }

}
