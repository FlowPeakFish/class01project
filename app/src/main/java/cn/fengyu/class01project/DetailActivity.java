package cn.fengyu.class01project;

import android.content.Intent;
import android.widget.DatePicker;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

import java.time.LocalDate;

public class DetailActivity extends AppCompatActivity {

    DatePicker datePicker;

    TextView textView1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        Intent intent = getIntent();
        String name = intent.getStringExtra("name");
        int age = intent.getIntExtra("age", 8);

        datePicker = findViewById(R.id.dataPicker1);
        textView1 = findViewById(R.id.textView1);

        textView1.setText(name + "你好，当前年龄：" +
                age + "岁");

        LocalDate localDate = LocalDate.now();

        datePicker.init(localDate.getYear(),
                localDate.getMonthValue() - 1,
                localDate.getDayOfMonth(),
                new DatePicker.OnDateChangedListener() {
                    @Override
                    public void onDateChanged(DatePicker datePicker,
                                              int year, int month, int dayOfMonth) {
                        textView1.setText(year + "年" +
                                (month + 1) + "月" +
                                dayOfMonth + "日");
                    }
                });
    }
}