package com.xinkao.xinkao.utils;


import com.xinkao.xinkao.bean.HomeBean;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class JsonUtils {

    private static String state;
    private static String name;
    private static String roomId;

    public static List<HomeBean> parseList(String jsonString) {

        List<HomeBean> homeBeanList = new ArrayList<HomeBean>();
        HomeBean homeBean;
        try {
            JSONObject jsonObject = new JSONObject(jsonString);
            state = jsonObject.getString("state");
            JSONArray array = jsonObject.getJSONArray("rooms");
            for (int i = 0; i < array.length(); i++) {
                JSONObject room = array.getJSONObject(i);
                name = room.getString("name");
                roomId = room.getString("roomId");
                homeBean = new HomeBean(state, name, roomId);
                homeBeanList.add(homeBean);
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return homeBeanList;
    }
}
