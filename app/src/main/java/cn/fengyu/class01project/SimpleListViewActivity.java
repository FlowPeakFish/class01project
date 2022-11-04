package cn.fengyu.class01project;

import android.view.View;
import android.widget.*;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

import static android.widget.Toast.LENGTH_SHORT;

public class SimpleListViewActivity extends AppCompatActivity {

    // 1、定义对象(控件)
    ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_simple_list_view);

        // 2、绑定控件
        listView = findViewById(R.id.ls2);

        // 3、准备数据
        //      a. 代码初始化数据
        //      b. 服务器接口获取数据（RestFul）
        //      c. 本地存储空间
        String[] list = new String[]{
                "步茜中",
                "危帛彦",
                "童妍倩"
        };

        // 4、设计子布局
        int childItemLayout = android.R.layout.simple_list_item_1;
        // 5、初始化适配器(子项布局+数据)
        ArrayAdapter<String> adapter = new ArrayAdapter<>(SimpleListViewActivity.this,
                childItemLayout, list);

        // 6、将适配器加到控件中(子项布局+数据+列表控件)
        listView.setAdapter(adapter);

        // 7、ListView的单击事件
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String name;
                // 方式一：通过控件获取值
                TextView textView = (TextView) view;
                name = textView.getText().toString();

                // 方式二：通过索引值获取值
                name = list[position];

                Toast.makeText(SimpleListViewActivity.this,
                                // R.string.clicked_text,)
                                name + "子项被点击了", LENGTH_SHORT)
                        .show();
            }
        });
    }
}