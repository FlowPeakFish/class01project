package cn.fengyu.class01project;

import android.database.Cursor;
import android.os.Bundle;
import android.provider.MediaStore;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import cn.fengyu.class01project.adapter.FruitRecyclerViewAdapter;
import cn.fengyu.class01project.adapter.MusicRecyclerViewAdapter;
import cn.fengyu.class01project.entity.Music;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MusicListActivity extends AppCompatActivity {
    // 1、定义对象(控件)
    RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_music_list);

        // 2、绑定控件
        recyclerView = findViewById(R.id.recycler_view_2);

        // 3、准备数据
        List<Music> list = new ArrayList<>();
        Cursor cursor = getContentResolver().query(
                MediaStore.Audio.Media.EXTERNAL_CONTENT_URI
                , null, null, null,
                MediaStore.Audio.Media.DEFAULT_SORT_ORDER);
        System.out.println("查询到了数据条数：" + cursor.getCount());
        while (cursor.moveToNext()) {
            String[] columnNames = cursor.getColumnNames();
            System.out.println(Arrays.toString(columnNames));
            int titleIndex = cursor.getColumnIndex("title");
            System.out.println("title: " + cursor.getString(titleIndex));
            int artistIndex = cursor.getColumnIndex("artist");
            System.out.println("artist: " + cursor.getString(artistIndex));
            int durationIndex = cursor.getColumnIndex("duration");
            System.out.println("duration: " + cursor.getInt(durationIndex) / 1000 + "秒");
            Music music = new Music(cursor.getString(titleIndex), cursor.getString(artistIndex));
            list.add(music);
        }
        // 4、设计子项布局
        int childItemLayout = R.layout.fruit_item;

        // 5、初始化适配器(子项布局+数据)
        MusicRecyclerViewAdapter adapter = new MusicRecyclerViewAdapter(
                list
        );

        // 6、将适配器加到控件中(子项布局+数据+列表控件)
        // 线性布局
        LinearLayoutManager layoutManager =
                new LinearLayoutManager(
                MusicListActivity.this);
        layoutManager.setOrientation(RecyclerView.VERTICAL);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapter);
    }
}