package com.xinkao.xinkao.utils;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

public class HttpUtils {
    public static String sendGetMethod(String url){
        HttpURLConnection connection = null;
        String result = "";
        try {
            connection =(HttpURLConnection) new URL(url).openConnection();
            connection.setRequestMethod("GET");
            connection.setConnectTimeout(2000);
            connection.setReadTimeout(2000);
            connection.connect();

            if (connection.getResponseCode()==200){
                InputStream in = connection.getInputStream();
                result = StreamUtils.stream2String(in);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return result;
    }
}
