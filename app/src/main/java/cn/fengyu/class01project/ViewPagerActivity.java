package cn.fengyu.class01project;

import android.view.LayoutInflater;
import android.view.View;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import androidx.viewpager.widget.ViewPager;
import cn.fengyu.class01project.adapter.ImageViewPagerAdapter;

public class ViewPagerActivity extends AppCompatActivity {

    private ViewPager viewPager;
    private View page1, page2, page3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_pager_actitivy);

        viewPager = findViewById(R.id.view_pager_1);

        LayoutInflater layoutInflater = getLayoutInflater();
        page1 = layoutInflater.inflate(R.layout.activity_main, null, false);
        page2 = layoutInflater.inflate(R.layout.activity_frame_layout, null, false);
        page3 = layoutInflater.inflate(R.layout.page3, null, false);

        ImageViewPagerAdapter adapter = new ImageViewPagerAdapter();
        adapter.add(page1);
        adapter.add(page2);
        adapter.add(page3);

        viewPager.setAdapter(adapter);
    }
}