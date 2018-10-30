package com.xinkao.xinkao.activity;

import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.xinkao.xinkao.R;
import com.xinkao.xinkao.fragment.ConversationList;
import com.xinkao.xinkao.fragment.HomeFragment;
import com.xinkao.xinkao.fragment.MeFragment;
import com.xinkao.xinkao.fragment.ShareFragment;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends FragmentActivity {
    private RadioGroup radioGroup;
    private String[] tab = {"首页", "聊天", "分享", "我"};
    private Button[] buttons;
    private int index;
    private int selectTabIndex;
    private List<Fragment> fragments;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //复选按钮组
//        radioGroup = findViewById(R.id.radio_group);
        //复选按钮组点击监听
//        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
//            @Override
//            public void onCheckedChanged(RadioGroup group, int checkedId) {
//                switch (checkedId) {
//                    case R.id.home:
//                        //设置drawableTop图片大小
//                        //设置Fragment
//                        radioDrawable((RadioButton) findViewById(R.id.home));
//                        switchFragmentSupport(R.id.content, tab[0]);
//                        break;
//                    case R.id.chat:
//                        radioDrawable((RadioButton) findViewById(R.id.chat));
//                        switchFragmentSupport(R.id.content, tab[1]);
//                        break;
//                    case R.id.share:
//                        radioDrawable((RadioButton) findViewById(R.id.share));
//                        switchFragmentSupport(R.id.content, tab[2]);
//                        break;
//                    case R.id.me:
//                        radioDrawable((RadioButton) findViewById(R.id.me));
//                        switchFragmentSupport(R.id.content, tab[3]);
//                }
//            }
//        });
//        RadioButton radioButton = (RadioButton) radioGroup.getChildAt(0);
//        radioButton.toggle();
        fragments = new ArrayList<Fragment>();
        HomeFragment homeFragment = new HomeFragment();
        ConversationList conversationList = new ConversationList();
        ShareFragment shareFragment = new ShareFragment();
        MeFragment meFragment = new MeFragment();
        fragments.add(homeFragment);
        fragments.add(conversationList);
        fragments.add(shareFragment);
        fragments.add(meFragment);
        buttons = new Button[4];
        buttons[0] = findViewById(R.id.home);
        buttons[1] = findViewById(R.id.chat);
        buttons[2] = findViewById(R.id.share);
        buttons[3] = findViewById(R.id.me);
        setButtonsDrawable(buttons);
        buttons[0].setSelected(true);

    }

    public void onTabClick(View view) {
        switch (view.getId()) {
            case R.id.home:
                index = 0;
                break;
            case R.id.chat:
                index = 1;
                break;
            case R.id.share:
                index = 2;
                break;
            case R.id.me:
                index = 3;
                break;
        }
        if (selectTabIndex != index) {
            FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
            ft.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN);
            ft.hide(fragments.get(selectTabIndex));
            if (!fragments.get(index).isAdded()) {
                ft.add(R.id.fragment_content, fragments.get(index));
            }
            ft.show(fragments.get(index)).commit();
        }
        buttons[selectTabIndex].setSelected(false);
        buttons[index].setSelected(true);
        selectTabIndex = index;

    }
//
//    /**
//     * @param containerId
//     * @param tag
//     */
//    private void switchFragmentSupport(int containerId, String tag) {
//        //获取fragment管理器
//        FragmentManager fragmentManager = getSupportFragmentManager();
//        Fragment fragment = fragmentManager.findFragmentByTag(tag);
//        if (fragment == null) {
//            if (tag.equals(tab[0]))
//                //首页
//                fragment = new HomeFragment();
//            if (tag.equals(tab[1]))
//                //聊天
//                fragment = new ConversationList();
//            if (tag.equals(tab[2]))
//                //分享
//                fragment = new ShareFragment();
//            if (tag.equals(tab[3]))
//                //我
//                fragment = new MeFragment();
//        }
//
//        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
//        fragmentTransaction.replace(containerId, fragment, tag);
//        fragmentTransaction.commit();
//    }

    /**
     * 限制drawableTop属性的图片的大小
     *
     * @param buttons
     */
    private void setButtonsDrawable(Button[] buttons) {
        //将radiobutton加入drawable限制边距以限制大小
        for (int i = 0; i < buttons.length; i++) {
            Drawable[] drawables = buttons[i].getCompoundDrawables();
            //获取drawable
            Rect rect = new Rect(0, 0, drawables[1].getMinimumWidth() * 3 / 4, drawables[1].getMinimumHeight() * 3 / 4);
            drawables[1].setBounds(rect);
            buttons[i].setCompoundDrawables(null, drawables[1], null, null);
        }
    }

}
