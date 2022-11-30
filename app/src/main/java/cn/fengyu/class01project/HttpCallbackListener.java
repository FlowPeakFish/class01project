package cn.fengyu.class01project;

public interface HttpCallbackListener {
    void onFinish(String response);
    void onError(Exception e);
}
