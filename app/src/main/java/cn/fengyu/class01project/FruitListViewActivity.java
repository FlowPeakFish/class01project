package cn.fengyu.class01project;

import android.view.View;
import android.widget.*;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import cn.fengyu.class01project.adapter.FruitAdapter;
import cn.fengyu.class01project.entity.Fruit;

import java.util.ArrayList;
import java.util.List;

import static android.widget.Toast.LENGTH_SHORT;

public class FruitListViewActivity extends AppCompatActivity {

    // 1、定义对象(控件)
    ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fruit_list_view);

        // 2、绑定控件
        listView = findViewById(R.id.fruit_list_view);

        // 3、准备数据
        List<Fruit> list = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            list.add(new Fruit(R.drawable.apple,
                    "苹果",
                    "￥20元/kg"));

            Fruit grape = new Fruit();
            grape.setImageId(R.drawable.grape);
            grape.setName("葡萄");
            grape.setPrice("￥9.9元/kg");
            list.add(grape);

            list.add(Fruit.builder()
                    .imageId(R.drawable.mango)
                    .name("芒果")
                    .price("￥29.9元/kg")
                    .build());
        }

        // 4、设计子项布局
        int childItemLayout = R.layout.fruit_item;
        // 5、初始化适配器(子项布局+数据)
        FruitAdapter adapter = new FruitAdapter(FruitListViewActivity.this,
                childItemLayout, list);

        // 6、将适配器加到控件中(子项布局+数据+列表控件)
        listView.setAdapter(adapter);


        // 7、ListView的单击事件
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String name;
                // 方式一：通过控件获取值
                name = view.findViewById(R.id.fruit_name).toString();

                // 方式二：通过索引值获取值
                name = list.get(position).getName();

                Toast.makeText(FruitListViewActivity.this,
                                // R.string.clicked_text,)
                                name + "子项被点击了", LENGTH_SHORT)
                        .show();
            }
        });
    }
}