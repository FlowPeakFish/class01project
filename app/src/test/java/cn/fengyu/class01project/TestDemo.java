package cn.fengyu.class01project;

import org.json.JSONException;
import org.json.JSONObject;
import org.junit.Test;
import org.junit.runner.RunWith;

public class TestDemo {
    @Test
    public void Test1() throws JSONException {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("id", 1);
        jsonObject.put("name", "张三");
        jsonObject.put("sex", "M");
        jsonObject.put("age", 19);
        jsonObject.put("major", new String[]{"程序设计", "人工智能"});
        System.out.println(jsonObject.toString());
    }
}
