package cn.fengyu.class01project;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import cn.fengyu.class01project.adapter.FruitRecyclerViewAdapter;
import cn.fengyu.class01project.entity.Fruit;

import java.util.ArrayList;
import java.util.List;

public class FruitRecyclerViewActivity extends AppCompatActivity {

    // 1、定义对象(控件)
    RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fruit_recycler_view);

        // 2、绑定控件
        recyclerView = findViewById(R.id.recycler_view_1);

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
        FruitRecyclerViewAdapter adapter = new FruitRecyclerViewAdapter(
                list
        );

        // 6、将适配器加到控件中(子项布局+数据+列表控件)
        LinearLayoutManager layoutManager = new LinearLayoutManager(
                FruitRecyclerViewActivity.this);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapter);
    }
}