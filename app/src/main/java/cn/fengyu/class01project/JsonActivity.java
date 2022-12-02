package cn.fengyu.class01project;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;

public class JsonActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_json);

        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    OkHttpClient client = new OkHttpClient().newBuilder()
                            .build();
                    Request request = new Request.Builder()
                            .url("https://mock.presstime.cn/mock/63871963e7aea00081e02c10/example/weather")
                            .build();
                    Response response = client.newCall(request).execute();
                    String jsonText = response.body().string();
                    JSONObject jsonObject = new JSONObject(jsonText);
                    System.out.println("状态：" + jsonObject.getString("reason"));
                    JSONObject resultJsonObject = jsonObject.getJSONObject("result");
                    System.out.println("城市：" + resultJsonObject.getString("city"));
                    System.out.println("温度：" + resultJsonObject.getJSONObject("realtime").getInt("temperature"));
                    System.out.println("湿度：" + resultJsonObject.getJSONObject("realtime").getInt("humidity"));
                    System.out.println("天气：" + resultJsonObject.getJSONObject("realtime").getString("weather"));

                    JSONArray jsonArray = resultJsonObject.getJSONArray("future");
                    for (int i = 0; i < jsonArray.length(); i++) {
                        JSONObject item = (JSONObject) jsonArray.get(i);
                        System.out.println("============");
                        System.out.println("日期：" + item.getString("date"));
                        System.out.println("温度：" + item.getString("temperature"));
                        System.out.println("天气：" + item.getString("weather"));
                    }
                } catch (IOException | JSONException e) {
                    throw new RuntimeException(e);
                }
            }
        }).start();
    }
}