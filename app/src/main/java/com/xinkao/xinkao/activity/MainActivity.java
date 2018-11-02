package com.xinkao.xinkao.activity;

import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.widget.Button;

import com.xinkao.xinkao.R;
import com.xinkao.xinkao.adapter.MainPagerAdapter;
import com.xinkao.xinkao.fragment.ConversationList;
import com.xinkao.xinkao.fragment.HomeFragment;
import com.xinkao.xinkao.fragment.MeFragment;
import com.xinkao.xinkao.fragment.ShareFragment;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends FragmentActivity {
    //    private RadioGroup radioGroup;
    //    private String[] tab = {"首页", "聊天", "分享", "我"};
    private Button[] buttons;
    private int index;
    private int selectTabIndex;
    private ViewPager fragmentPager;

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
        List<Fragment> fragments = new ArrayList<>();
        HomeFragment homeFragment = new HomeFragment();
        ConversationList conversationList = new ConversationList();
        ShareFragment shareFragment = new ShareFragment();
        MeFragment meFragment = new MeFragment();
        fragments.add(homeFragment);
        fragments.add(conversationList);
        fragments.add(shareFragment);
        fragments.add(meFragment);
        fragmentPager = findViewById(R.id.fragment_content);
        //fragment适配到fragmentPager上
        MainPagerAdapter mainPagerAdapter = new MainPagerAdapter(getSupportFragmentManager(), fragments);
        fragmentPager.setAdapter(mainPagerAdapter);

        buttons = new Button[4];
        buttons[0] = findViewById(R.id.home);
        buttons[1] = findViewById(R.id.chat);
        buttons[2] = findViewById(R.id.share);
        buttons[3] = findViewById(R.id.me);
        //改变drawableTop属性图片的大小
        setButtonsDrawable(buttons);
        //默认第一个按钮选中
        buttons[0].setSelected(true);
        fragmentPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int i, float v, int i1) {

            }

            @Override
            public void onPageSelected(int i) {
                onTabChange();
            }

            @Override
            public void onPageScrollStateChanged(int i) {

            }
        });


    }

    /**
     * 滑动屏幕改变按钮的选中状态
     */
    private void onTabChange() {
        index = fragmentPager.getCurrentItem();
        buttons[selectTabIndex].setSelected(false);
        buttons[index].setSelected(true);
        selectTabIndex = index;

    }

    /**
     * 按钮点击事件处理
     *
     * @param view 通过view.getId()获取点击的是哪个按钮
     */
    public void onTabClick(View view) {
        switch (view.getId()) {
            case R.id.home:
                index = 0;
                fragmentPager.setCurrentItem(index);
                break;
            case R.id.chat:
                index = 1;
                fragmentPager.setCurrentItem(index);
                break;
            case R.id.share:
                index = 2;
                fragmentPager.setCurrentItem(index);
                break;
            case R.id.me:
                index = 3;
                fragmentPager.setCurrentItem(index);
                break;
        }
        //        if (selectTabIndex != index) {
        //            FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
        //            ft.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN);
        //            ft.hide(fragments.get(selectTabIndex));
        //            if (!fragments.get(index).isAdded()) {
        //                ft.add(R.id.fragment_content, fragments.get(index));
        //            }
        //            ft.show(fragments.get(index)).commit();
        //        }
        //        buttons[selectTabIndex].setSelected(false);
        //        buttons[index].setSelected(true);
        //        selectTabIndex = index;

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
     * @param buttons buttons按钮组做参数
     */
    private void setButtonsDrawable(Button[] buttons) {
        //将radiobutton加入drawable限制边距以限制大小
        for (Button button : buttons) {
            Drawable[] drawables = button.getCompoundDrawables();
            //获取drawable
            Rect rect = new Rect(0, 0, drawables[1].getMinimumWidth() * 3 / 4, drawables[1].getMinimumHeight() * 3 / 4);
            drawables[1].setBounds(rect);
            button.setCompoundDrawables(null, drawables[1], null, null);
        }
    }

}
