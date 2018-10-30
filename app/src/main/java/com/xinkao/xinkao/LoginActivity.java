package com.xinkao.xinkao;

import android.content.Intent;
import android.content.res.Resources;
import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.hyphenate.EMCallBack;
import com.hyphenate.chat.EMClient;
import com.xinkao.xinkao.activity.MainActivity;

public class LoginActivity extends AppCompatActivity {

    private EditText phone;
    private EditText password;
    private Button login;
    private static boolean BUTTON_IF_CLICK = false;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        login = findViewById(R.id.login);
        phone = findViewById(R.id.phone);
        password = findViewById(R.id.password);
        login.setOnClickListener(new View.OnClickListener() {
            Resources res = getResources();
            Drawable btn_animation = res.getDrawable(R.drawable.btn_animation_list);

            @Override
            public void onClick(View v) {
                singin();
                if (BUTTON_IF_CLICK) {
                    login.setText("登录中...");
                    login.setBackground(btn_animation);
                    AnimationDrawable animationDrawable = (AnimationDrawable) login.getBackground();
                    animationDrawable.setExitFadeDuration(500);
                    animationDrawable.start();
                }

            }
        });

        LinearLayout linearLayout = findViewById(R.id.login_animation);
        AnimationDrawable animationDrawable = (AnimationDrawable) linearLayout.getBackground();

        animationDrawable.setEnterFadeDuration(200);
        animationDrawable.setExitFadeDuration(1000);
        animationDrawable.start();
    }

    /**
     * 登录按钮的事件处理
     */
    private void singin() {
        //判断是否有输入，没有则弹吐司告诉用户输入后再进行登录
//        if (phone.getText().toString().trim().isEmpty()) {
//            Toast.makeText(this, "手机号不能为空", Toast.LENGTH_SHORT).show();
//            return;
//        }
//        if (password.getText().toString().trim().isEmpty()) {
//            Toast.makeText(this, "密码不能为空", Toast.LENGTH_SHORT).show();
//            return;
//        }

        BUTTON_IF_CLICK = true;
//        EMClient.getInstance().login(phone.getText().toString().trim(), password.getText().toString().trim(), new EMCallBack() {
//            @Override
//            public void onSuccess() {
//                        Timer timer = new Timer();
//                        TimerTask task = new TimerTask() {
//                            @Override
//                            public void run() {
                startActivity(new Intent(getApplicationContext(), MainActivity.class));
//                            }
//                        };
//                        timer.schedule(task, 1000 * 2);
//                Log.i("tag", "登陆成功");
                finish();
//            }
//
//            @Override
//            public void onError(int i, String s) {
//                Log.e("tag", i + "登录失败" + s);
//            }
//
//            @Override
//            public void onProgress(int i, String s) {
//
//            }
//        });
    }

    /**
     * 登录之外的按钮的点击处理
     *
     * @param view 通过view获取id判断点的是哪个控件
     */
    public void click(View view) {
        switch (view.getId()) {
            case R.id.back:
//                startActivity(new Intent(this, MainActivity.class));
                Toast.makeText(this, "回不去咯", Toast.LENGTH_SHORT).show();
                break;
            case R.id.login_problem:
                Toast.makeText(this, "有问题找警察", Toast.LENGTH_SHORT).show();
                break;
            case R.id.forget_pwd:
                Toast.makeText(this, "忘了？我也没有办法哦", Toast.LENGTH_SHORT).show();
                break;
        }
    }

}
