package cn.fengyu.class01project;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DBActivity extends AppCompatActivity {

    private MyDBOpenHelper myDBOpenHelper;

    private Button addBtn, searchBtn, updateBtn, deleteBtn;

    private Map<String, Object> data = new HashMap<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dbactivity);

        myDBOpenHelper = new MyDBOpenHelper(DBActivity.this);
        SQLiteDatabase db = myDBOpenHelper.getWritableDatabase();

        addBtn = findViewById(R.id.add);
        addBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // 方法一（ContentValues）
                // ContentValues contentValues = new ContentValues();
                // contentValues.put("sno", "123456");
                // contentValues.put("name", "小明");
                // contentValues.put("sex", "男");
                // contentValues.put("professional", "软件工程");
                // contentValues.put("department", "智能科技学院");
                // db.insert("stu_info", null, contentValues);

                // 方法二（SQL）
                db.execSQL("INSERT INTO stu_info " + "(sno, name, sex, professional, department)" + "VALUES (123457, '小李', '男', '计算机', '智能科技学院');");
                Toast.makeText(DBActivity.this, "插入成功", Toast.LENGTH_SHORT).show();
            }
        });

        searchBtn = findViewById(R.id.search);
        searchBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // 方式一（query）
                // Cursor cursor = db.query("stu_info", new String[]{"sno", "name", "sex"},
                //         "sno=?", new String[]{"123456"},
                //         null, null, null, null);


                // 方式二（SQL）
                Cursor cursor = db.rawQuery("select * from stu_info where name = '小明'",
                        null);
                if (cursor.getCount() != 0) {
                    String[] columnNames = cursor.getColumnNames();
                    int index = 0;
                    while (cursor.moveToNext()) {
                        System.out.println("========== 第" + (++index) + "条数据 ==========");
                        for (String columnName : columnNames) {
                            int columnIndex = cursor.getColumnIndex(columnName);
                            String string = cursor.getString(columnIndex);
                            System.out.println(columnName + "：" + string);
                        }
                    }
                }
            }
        });

        updateBtn = findViewById(R.id.update);
        updateBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // 方法一（ContentValues）
                // ContentValues contentValues = new ContentValues();
                // contentValues.put("name", "小红");
                // contentValues.put("sex", "女");
                // db.update("stu_info", contentValues,
                //         "id=?", new String[]{"1"});

                // 方法二（SQL）
                db.execSQL("update stu_info set department = '商学院' where id = 1");
                Toast.makeText(DBActivity.this, "修改成功", Toast.LENGTH_SHORT).show();
            }
        });

        deleteBtn = findViewById(R.id.delete);
        deleteBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // db.delete("stu_info", "id = ?", new String[]{"2"});

                db.execSQL("delete from stu_info where id = 1");
                Toast.makeText(DBActivity.this, "删除成功", Toast.LENGTH_SHORT).show();
            }
        });
    }
}