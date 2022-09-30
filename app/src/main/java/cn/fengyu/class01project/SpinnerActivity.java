package cn.fengyu.class01project;

import android.os.Build;
import android.view.View;
import android.widget.*;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SpinnerActivity extends AppCompatActivity {

    Spinner spinner;

    Button btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_spinner);

        spinner = findViewById(R.id.spinner);
        btn = findViewById(R.id.btn);

        // 3.设置下拉列表数据
        String[] arr = new String[]{"全部", "纪录片", "漫画", "音乐", "舞蹈", "游戏"};

        // List<String> list = Arrays.asList(arr);

        // 4.配置适配器
        ArrayAdapter<String> adapter = new ArrayAdapter<>(SpinnerActivity.this,
                android.R.layout.simple_spinner_item, arr);

        // 5.让控件显示数据
        // 下拉列表(界面) -> 绑定Spinner(findViewById) -> 链接Adapter(setAdapter) -> 设置数据(new Adapter) -> 数据(new String[])
        spinner.setAdapter(adapter);

        // btn.setOnClickListener(new View.OnClickListener() {
        //     @Override
        //     public void onClick(View v) {
        //         System.out.println(arr[spinner.getSelectedItemPosition()]);
        //     }
        // });

        // 6.添加触发事件
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                // 方式一
                // TextView textView = (TextView) view;
                // String select = textView.getText().toString();
                // Toast.makeText(SpinnerActivity.this, select
                //         , Toast.LENGTH_SHORT).show();

                // 方法二
                Toast.makeText(SpinnerActivity.this, arr[position]
                        , Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });
    }
}