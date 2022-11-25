package cn.fengyu.class01project;

import android.view.LayoutInflater;
import android.view.View;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

public class ViewPagerActivity extends AppCompatActivity {

    private List<View> viewList;
    private View page1, page2, page3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_pager_actitivy);

        LayoutInflater layoutInflater = getLayoutInflater();
        View page1 = layoutInflater.inflate(R.layout.page1, null, false);
        View page2 = layoutInflater.inflate(R.layout.page2, null, false);
        View page3 = layoutInflater.inflate(R.layout.page3, null, false);
        viewList = new ArrayList<View>();
        viewList.add(page1);
        viewList.add(page2);
        viewList.add(page3);
    }
}