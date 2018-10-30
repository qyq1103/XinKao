package com.xinkao.xinkao.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.hyphenate.easeui.ui.EaseChatFragment;
import com.xinkao.xinkao.R;

/**
 * Author by ${user},Date on 2018/10/25 0025.
 * PS:Not easy to write code,please indicate.
 */
public class ChatActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chat);
        //EaseUI封装好的聊天界面
        EaseChatFragment easeChatFragment = new EaseChatFragment();
        //将参数传给聊天界面
        easeChatFragment.setArguments(getIntent().getExtras());
        //加载EaseUI封装的的聊天界面Fragment
        getSupportFragmentManager().beginTransaction().add(R.id.ec_layout_container,easeChatFragment).commit();
    }
}
