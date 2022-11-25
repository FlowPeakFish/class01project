package cn.fengyu.class01project;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;
import cn.fengyu.class01project.adapter.FragmentAdapter;
import cn.fengyu.class01project.fragment.Fragment1;
import cn.fengyu.class01project.fragment.Fragment2;
import cn.fengyu.class01project.fragment.Fragment3;

import java.util.ArrayList;
import java.util.List;

public class FragmentActivity extends AppCompatActivity {

    private ViewPager viewPager;

    private List<Fragment> fragmentList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fragment);

        viewPager = findViewById(R.id.view_pager_2);

        fragmentList = new ArrayList<>();
        fragmentList.add(new Fragment1());
        fragmentList.add(new Fragment2());
        fragmentList.add(new Fragment3());

        FragmentAdapter adapter = new FragmentAdapter(getSupportFragmentManager(), fragmentList);

        viewPager.setAdapter(adapter);
    }
}