package cn.fengyu.class01project;

import android.annotation.SuppressLint;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

/**
 * @author fengyu
 */
public class MenuActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.demo_item, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.insert:
                Toast.makeText(MenuActivity.this,
                        "点击了添加按钮", Toast.LENGTH_SHORT).show();
            case R.id.delete:
                Toast.makeText(MenuActivity.this,
                        "点击了删除按钮", Toast.LENGTH_SHORT).show();
            case R.id.exit:
                Toast.makeText(MenuActivity.this,
                        "退出应用", Toast.LENGTH_SHORT).show();
                finish();
            default:
                break;
        }
        return false;
    }
}