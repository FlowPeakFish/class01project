package cn.fengyu.class01project;

import android.widget.ArrayAdapter;
import android.widget.ListView;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

public class SimpleListViewActivity extends AppCompatActivity {

    ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_simple_list_view);

        listView = findViewById(R.id.ls1);

        String[] list = new String[]{
                "步茜中",
                "危帛彦",
                "童妍倩",
                "林嘉信",
                "屈岚彦",
                "晁璟雨",
                "虞休芳",
                "郏桂萱",
                "项云祜",
                "尉迟凡荣",
                "暨震泽",
                "钟离桂薇",
                "司徒妮琛",
                "彭昕帛",
                "蓝雨轩",
                "凤柏日",
                "毕锋听",
                "班雯芙",
                "段坤姿",
                "宇文暄沛"
        };

        ArrayAdapter<String> adapter = new ArrayAdapter<>(SimpleListViewActivity.this,
                android.R.layout.simple_list_item_1, list);

        listView.setAdapter(adapter);
    }
}