package com.xinkao.xinkao.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.hyphenate.EMCallBack;
import com.hyphenate.chat.EMClient;
import com.xinkao.xinkao.LoginActivity;
import com.xinkao.xinkao.R;

public class MeFragment extends Fragment {

    private View meView;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        meView = inflater.inflate(R.layout.fragment_me, null);
        meView.findViewById(R.id.logout).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                singout();
            }
        });

        return meView;
    }

    private void singout() {
        EMClient.getInstance().logout(false, new EMCallBack() {
            @Override
            public void onSuccess() {
                startActivity(new Intent(getContext(), LoginActivity.class));
                Log.i("tag", "退出成功!");
                if (getActivity() != null) {
                    getActivity().finish();
                }
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
