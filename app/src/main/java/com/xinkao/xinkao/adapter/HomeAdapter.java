package com.xinkao.xinkao.adapter;

import android.app.Activity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.xinkao.xinkao.R;
import com.xinkao.xinkao.bean.HomeBean;

import java.util.List;

public class HomeAdapter extends BaseAdapter {
    private List<HomeBean> mHomeBeans;
    private Activity mActivity;
    public HomeAdapter(Activity activity, List<HomeBean> mHomeBeans) {
        this.mHomeBeans = mHomeBeans;
        this.mActivity = activity;
    }

    @Override
    public int getCount() {
        return mHomeBeans.size();
    }

    @Override
    public Object getItem(int position) {
        return mHomeBeans.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View view, ViewGroup parent) {
        if (view == null) {
            view = mActivity.getLayoutInflater().inflate(R.layout.item_home, null);
        }
        TextView name = view.findViewById(R.id.home_name);
        TextView roomId = view.findViewById(R.id.home_roomId);
        TextView state = view.findViewById(R.id.home_state);
        HomeBean homeBean = mHomeBeans.get(position);
        name.setText(String.format("name:%s", homeBean.name));
        roomId.setText(String.format("roomId:%s", homeBean.roomId));
        state.setText(String.format("state:%s", homeBean.state));
        return view;
    }
}