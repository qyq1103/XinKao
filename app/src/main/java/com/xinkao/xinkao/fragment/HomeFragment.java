package com.xinkao.xinkao.fragment;

import android.os.AsyncTask;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.xinkao.xinkao.R;
import com.xinkao.xinkao.adapter.HomeAdapter;
import com.xinkao.xinkao.bean.HomeBean;
import com.xinkao.xinkao.utils.HttpUtils;
import com.xinkao.xinkao.utils.JsonUtils;

import java.util.List;

public class HomeFragment extends Fragment {

    private ListView listView;
    private final String apiUrl = "http://api.cclive.xinkaoyun.com/cc/teacher/getRooms?teacherId=530";

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View homeView = inflater.inflate(R.layout.fragment_home, null);
        listView = homeView.findViewById(R.id.home_list_view);
        new HomeAsyncTask().execute();
        return homeView;
    }

    class HomeAsyncTask extends AsyncTask<HomeBean, Void, List<HomeBean>> {
        @Override
        protected void onPostExecute(List<HomeBean> homeBeans) {
            super.onPostExecute(homeBeans);
            HomeAdapter homeAdapter = new HomeAdapter(getActivity(), homeBeans);
            listView.setAdapter(homeAdapter);
        }

        @Override
        protected List<HomeBean> doInBackground(HomeBean... homeBeans) {
            List<HomeBean> homeBeanList;
            //获取网络返回的数据
            String jsonString = HttpUtils.sendGetMethod(apiUrl);
            //获取json解析的数据
            homeBeanList = JsonUtils.parseList(jsonString);
            return homeBeanList;
        }
    }
}
