package cn.fengyu.class01project;

import android.content.Intent;
import android.net.Uri;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {
// public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    // 1、定义
    ImageView imageView;
    TextView textView1;
    TextView textView2;
    TextView textView3;
    EditText editText1;
    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // 2、绑定
        imageView = findViewById(R.id.imageView1);
        textView1 = findViewById(R.id.textView1);
        textView2 = findViewById(R.id.textView2);
        textView3 = findViewById(R.id.textView3);
        editText1 = findViewById(R.id.editText1);
        button.findViewById(R.id.button);

        // 3、使用
        Log.i("MainActivity", button.getText().toString());

        // button监听器 方法一
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // imageView.setImageResource(R.drawable.shizi);
                // Intent i = new Intent(
                //         MainActivity.this,
                //         DetailActivity.class);
                // i.putExtra("name", editText1.getText().toString());
                // // i.putExtra("age", 18);
                // startActivity(i);

                // Intent intent = new Intent(Intent.ACTION_VIEW);
                // intent.setData(Uri.parse("https://www.baidu.com"));
                // startActivity(intent);

                Uri uri = Uri.parse("tel:10086");
                Intent it = new Intent(Intent.ACTION_DIAL, uri);
                startActivity(it);

                // 返回数据给上一个活动
                // 书P:72
            }
        });

        // button监听器 方法二
        // button.setOnClickListener(this);
    }

    // button监听器 方法二
    // @Override
    // public void onClick(View view) {
    //     switch (view.getId()) {
    //         case R.id.button:
    //             textView3.setText(editText1.getText().toString());
    //             break;
    //         default:
    //             break;
    //     }
    // }
}