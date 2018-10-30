package com.xinkao.xinkao;

import android.app.Application;

import com.hyphenate.chat.EMClient;
import com.hyphenate.easeui.EaseUI;

public class XinKaoApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        //初始化EaseUI
        EaseUI.getInstance().init(getApplicationContext(),null);
        //开启debug模式
        EMClient.getInstance().setDebugMode(true);
    }
}
