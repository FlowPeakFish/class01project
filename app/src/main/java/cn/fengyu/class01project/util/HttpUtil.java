package cn.fengyu.class01project.util;

import cn.fengyu.class01project.HttpCallbackListener;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class HttpUtil {

    public static void sendHttpRequest(String address, HttpCallbackListener callback) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                HttpURLConnection conn = null;
                try {
                    // 步骤1：获得HttpURLConnection类的实例
                    //1. 使用new关键字创建一个URL对象，并传入目标的网络地址
                    URL url = new URL(address);
                    //2.调用openConnection()方法，创建HttpURLConnection类的实例
                    conn = (HttpURLConnection) url.openConnection();

                    // 步骤2：设置HTTP请求参数
                    conn.setRequestMethod("GET");
                    conn.setConnectTimeout(20000); // 20s

                    // 步骤3：调用connect()连接远程资源
                    conn.connect();

                    if (conn.getResponseCode() == HttpURLConnection.HTTP_OK) {
                        // 步骤4：利用getInputStream()访问资源（GET请求）
                        InputStream is = conn.getInputStream();
                        InputStreamReader isr = new InputStreamReader(is);
                        BufferedReader br = new BufferedReader(isr);
                        StringBuilder string = new StringBuilder();
                        String line;
                        while ((line = br.readLine()) != null) {
                            string.append(line);
                        }
                        callback.onFinish(string.toString());
                    }
                } catch (IOException e) {
                    callback.onError(e);
                } finally {
                    // 步骤5：关闭HttpURLConnection连接
                    if (conn != null) {
                        conn.disconnect();
                    }
                }
            }
        }).start();
    }
}
