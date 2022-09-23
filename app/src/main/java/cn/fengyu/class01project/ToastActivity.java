package cn.fengyu.class01project;

import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

public class ToastActivity extends AppCompatActivity {

    private Button button2;
    private Button button4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_toast);
        button2 = findViewById(R.id.button2);
        button4 = findViewById(R.id.button4);

        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // 1、Context上下文
                // 2、CharSequence提示内容 res/string/name
                // 3、时间长短
                Toast toast = new Toast(ToastActivity.this);
                toast.setText(R.string.toast_string);
                toast.setDuration(Toast.LENGTH_SHORT);
                toast.show();
            }
        });

        button4.setOnClickListener(v -> {
            Toast.makeText(ToastActivity.this,
                            "长的消息",
                            Toast.LENGTH_LONG)
                    .show();
        });
    }
}