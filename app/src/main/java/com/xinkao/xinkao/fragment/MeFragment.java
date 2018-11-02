package com.xinkao.xinkao.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.GridView;

import com.xinkao.xinkao.R;
import com.xinkao.xinkao.activity.SettingActivity;
import com.xinkao.xinkao.adapter.MeAdapter;

public class MeFragment extends Fragment {
    private String[] meNames = {"我的积分", "“花”", "我的订单", "服务状态", "办理服务", "软件设置"};

    @NonNull
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View meView = inflater.inflate(R.layout.fragment_me, null);
        GridView gridView = meView.findViewById(R.id.me_gv);
        MeAdapter meAdapter = new MeAdapter(meNames, getActivity());
        gridView.setAdapter(meAdapter);
        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                switch (position) {
                    case 5:
                        startActivity(new Intent(getContext(), SettingActivity.class));
                        break;
                }
            }
        });

        return meView;
    }
}
