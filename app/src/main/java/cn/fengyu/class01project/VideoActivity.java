package cn.fengyu.class01project;

import android.net.Uri;
import android.os.Environment;
import android.widget.MediaController;
import android.widget.VideoView;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

public class VideoActivity extends AppCompatActivity {

    VideoView vv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_video);

        vv = findViewById(R.id.vv);

        // 方式一：外部存储空间
        // System.out.println(Environment.getExternalStorageDirectory().getPath() + "/Movies/chacha.mp4");
        // vv.setVideoPath(Environment.getExternalStorageDirectory().getPath() + "/Movies/chacha.mp4");

        // 方式二：内部存储空间（体积大）
        String packageName = getPackageName();
        vv.setVideoURI(Uri.parse("android.resource://cn.fengyu.class01project/" + R.raw.mhr));

        // 方式三：使用在线资源
        // vv.setVideoURI(Uri.parse("http://vfx.mtime.cn/Video/2019/03/19/mp4/190319222227698228.mp4"));
        vv.setMediaController(new MediaController(VideoActivity.this));
        vv.start();
    }
}