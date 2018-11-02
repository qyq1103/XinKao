package com.xinkao.xinkao.adapter;

import android.app.Activity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.xinkao.xinkao.R;

/**
 * Create by 钱 on 2018/11/2 0002
 */
public class MeAdapter extends BaseAdapter {
    private String[] meNames;
    private Activity meActivity;

    public MeAdapter(String[] meName, Activity meActivity) {
        this.meNames = meName;
        this.meActivity = meActivity;
    }

    @Override
    public int getCount() {
        return meNames.length;
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null){
            convertView = meActivity.getLayoutInflater().inflate(R.layout.item_me,null);
        }
        TextView meText = convertView.findViewById(R.id.text_me);
        meText.setText(meNames[position]);
        return convertView;
    }
}
