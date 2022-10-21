package cn.fengyu.class01project;

import android.Manifest;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Environment;
import android.provider.MediaStore;
import android.provider.Settings;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import androidx.core.content.ContextCompat;
import androidx.core.content.FileProvider;

import java.io.File;
import java.io.IOException;

public class CameraActivity extends AppCompatActivity {

    ImageView imageView;
    Button photoBtn, galleryBtn;
    File file;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_camera);

        imageView = findViewById(R.id.image);
        photoBtn = findViewById(R.id.photo);
        galleryBtn = findViewById(R.id.gallery);

        // 权限
        if (ContextCompat.checkSelfPermission(CameraActivity.this,
                Manifest.permission.CAMERA
        ) == PackageManager.PERMISSION_DENIED) {
            requestPermissions(new String[]{Manifest.permission.CAMERA},
                    0x02);
        }
        if (!Environment.isExternalStorageManager()) {
            startActivityForResult(new Intent(Settings.ACTION_MANAGE_ALL_FILES_ACCESS_PERMISSION),
                    0x03);
        }


        System.out.println("=== Environment.getExternalStorageDirectory() ===");
        System.out.println(Environment.getExternalStorageDirectory());
        System.out.println("=== CameraActivity.this.getCacheDir() ===");
        System.out.println(CameraActivity.this.getCacheDir());
        System.out.println("=== CameraActivity.this.getFilesDir() ===");
        System.out.println(CameraActivity.this.getFilesDir());
        System.out.println("=== CameraActivity.this.getExternalCacheDir() ===");
        System.out.println(CameraActivity.this.getExternalCacheDir());


        System.out.println(Environment.DIRECTORY_PICTURES);
        String imgPath = Environment.getExternalStorageDirectory() + "/111.jpg";
        System.out.println(imgPath);

        photoBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                file = new File(imgPath);
                if (!file.exists()) {
                    try {
                        file.createNewFile();
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }
                }

                Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);

                Uri photoURI = FileProvider.getUriForFile(CameraActivity.this,
                        "cn.fengyu.class01project.fileprovider",
                        file);
                intent.putExtra(MediaStore.EXTRA_OUTPUT, photoURI);
                startActivityForResult(intent, 0x01);
            }
        });

        galleryBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_GET_CONTENT);
                intent.setType("image/*");
                startActivityForResult(intent, 0x04);
            }
        });
    }

    /**
     * @param requestCode The integer request code originally supplied to
     *                    startActivityForResult(), allowing you to identify who this
     *                    result came from.
     * @param resultCode  The integer result code returned by the child activity
     *                    through its setResult().
     * @param data        An Intent, which can return result data to the caller
     *                    (various data can be attached to Intent "extras").
     */
    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable @org.jetbrains.annotations.Nullable Intent data) {
        if (requestCode == 0x01) {
            imageView.setImageURI(Uri.fromFile(file));
        } else if (requestCode == 0x04) {
            Uri uri = data.getData();
            imageView.setImageURI(uri);
        } else {
            // 不进行操作
        }
        super.onActivityResult(requestCode, resultCode, data);
    }
}