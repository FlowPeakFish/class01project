package cn.fengyu.class01project;

import android.os.Handler;
import android.os.Message;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import cn.fengyu.class01project.entity.Fruit;

import java.time.LocalDateTime;
import java.util.Timer;
import java.util.TimerTask;

public class MusicWelcomeActivity extends AppCompatActivity {
    // 创建定时器
    private Timer timer;

    private TimerTask timerTask;

    private Handler handler;

    private TextView textView;

    private int num = 5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_music_welcome);

        textView = findViewById(R.id.textView);

        handler = new Handler() {
            /**
             * @param msg
             */
            @Override
            public void handleMessage(@NonNull Message msg) {
                super.handleMessage(msg);
                switch (msg.what) {
                    case 1:
                        System.out.println(LocalDateTime.now());
                        textView.setText((--num) + "");
                        if (num == 0) {
                            timer.cancel();
                        }
                        break;
                }
            }
        };

        timer = new Timer();
        timerTask = new TimerTask() {
            @Override
            public void run() {
                // Message message = new Message();
                // message.what = 1;
                // message.obj = null;
                // message.arg1 = 0;
                // message.arg2 = 0;
                // handler.sendMessage(message);
                handler.sendEmptyMessage(1);

                // Message message = new Message();
                // message.what = 1;
                // message.obj = new Fruit(R.drawable.apple,
                //         "苹果",
                //         "￥20元/kg");
                // handler.sendMessage(message);
            }
        };
        timer.scheduleAtFixedRate(timerTask, 2000, 1000);
    }
}