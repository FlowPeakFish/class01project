package cn.fengyu.class01project;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

public class TimerActivity extends AppCompatActivity {

    private int time = 10;

    private TextView textView;

    private Handler handler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_timer);

        textView = findViewById(R.id.time);


        handler = new Handler() {
            @Override
            public void handleMessage(@NonNull Message msg) {
                System.out.println("handleMessage");
                if (msg.what == 2) {
                    System.out.println("测试");
                }
                if (msg.what == 3) {
                    textView.setText("倒计时：" + time);
                    System.out.println("收到倒计时的消息了");
                }
                super.handleMessage(msg);
            }
        };

        Thread t = new Thread(new Runnable() {
            @Override
            public void run() {
                while (time > 0) {
                    System.out.println("===" + time);
                    // textView.setText("测试" + time);
                    Message message = handler.obtainMessage();
                    message.arg1 = time;
                    message.what = 3;
                    message.obj = "测试";
                    handler.sendMessage(message);
                    time--;
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
            }
        });
        t.start();
    }
}