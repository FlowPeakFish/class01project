package cn.fengyu.class01project;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.database.Cursor;
import android.media.MediaPlayer;
import android.os.Handler;
import android.os.Message;
import android.provider.MediaStore;
import android.widget.SeekBar;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import org.json.JSONObject;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.Timer;
import java.util.TimerTask;

public class MusicPlayerActivity extends AppCompatActivity {

    TextView title, artist, currentTime, duration;
    SeekBar seekBar;

    MediaPlayer mp;
    private Timer timer;
    private TimerTask timerTask;
    private Handler handler;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_music_player);

        title = findViewById(R.id.title);
        artist = findViewById(R.id.artist);
        currentTime = findViewById(R.id.currentTime);
        duration = findViewById(R.id.duration);
        seekBar = findViewById(R.id.seek_bar);

        int position = getIntent().getIntExtra("position", -1);

        Cursor cursor = getContentResolver().query(
                MediaStore.Audio.Media.EXTERNAL_CONTENT_URI
                , null, null, null,
                MediaStore.Audio.Media.DEFAULT_SORT_ORDER);

        cursor.moveToPosition(position);
        int titleIndex = cursor.getColumnIndex("title");
        System.out.println("title: " + cursor.getString(titleIndex));
        title.setText(cursor.getString(titleIndex));
        int artistIndex = cursor.getColumnIndex("artist");
        System.out.println("artist: " + cursor.getString(artistIndex));
        artist.setText(cursor.getString(artistIndex));

        mp = new MediaPlayer();

        int dataIndex = cursor.getColumnIndex(MediaStore.Audio.Media.DATA);
        try {
            mp.setDataSource(cursor.getString(dataIndex));
            mp.prepare();
            mp.start();
            System.out.println("音乐开始播放");
        } catch (IOException e) {
            System.out.println("音乐播放失败");
            throw new RuntimeException(e);
        }

        int musicDuration = mp.getDuration();
        seekBar.setMax(musicDuration);
        duration.setText(toTime(musicDuration));

        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                System.out.println("progress: " + progress + ", fromUser: " + fromUser);
                if (fromUser) {
                    mp.seekTo(progress);
                }
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
            }
        });

        handler = new Handler() {
            @Override
            public void handleMessage(@NonNull Message msg) {
                super.handleMessage(msg);
                switch (msg.what) {
                    case 1:
                        int currentPosition = mp.getCurrentPosition();
                        seekBar.setProgress(currentPosition);
                        currentTime.setText(toTime(currentPosition));
                        break;
                }
            }
        };
        timer = new Timer();
        timerTask = new TimerTask() {
            @Override
            public void run() {
                handler.sendEmptyMessage(1);
            }
        };
        timer.schedule(timerTask, 0, 500);
    }

    private String toTime(int time) {
        int secs = time / 1000;
        int min = secs / 60;
        int sec = secs % 60;
        return min + ":" + sec;
    }
}