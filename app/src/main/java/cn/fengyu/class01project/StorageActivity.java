package cn.fengyu.class01project;

import android.Manifest;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Build;
import android.os.Environment;
import android.os.StrictMode;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import androidx.core.content.ContextCompat;
import androidx.core.content.FileProvider;

import java.io.*;

public class StorageActivity extends AppCompatActivity {

    ImageView imageView;

    Button button1, button2;

    String tmpPath;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_storage);

        if (ContextCompat.checkSelfPermission(StorageActivity.this, Manifest.permission.WRITE_EXTERNAL_STORAGE) == PackageManager.PERMISSION_DENIED) {
            if (shouldShowRequestPermissionRationale(Manifest.permission.WRITE_EXTERNAL_STORAGE)) {
                Toast.makeText(StorageActivity.this, "求求你了，这个权限真得还很重要", Toast.LENGTH_LONG).show();
            }
            requestPermissions(new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE}, 233);
        }
        if (ContextCompat.checkSelfPermission(StorageActivity.this, Manifest.permission.CAMERA) == PackageManager.PERMISSION_DENIED) {
            requestPermissions(new String[]{Manifest.permission.CAMERA}, 233);
        }

        imageView = findViewById(R.id.imageView);
        button1 = findViewById(R.id.button5);
        button2 = findViewById(R.id.button6);
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                tmpPath = Environment.getExternalStorageDirectory() + "/" + Environment.DIRECTORY_PICTURES + "/" + "2.jpg";
                File tempFile = new File(tmpPath);
                if (!tempFile.exists()) {
                    try {
                        tempFile.createNewFile();
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }
                }
                String authority = StorageActivity.this.getPackageName() + ".fileprovider";
                Uri mImgUri = FileProvider.getUriForFile(StorageActivity.this, authority, tempFile);
                System.out.println("============" + mImgUri);
                intent.putExtra(MediaStore.EXTRA_OUTPUT, mImgUri);
                startActivityForResult(intent, 11);
            }
        });
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_GET_CONTENT);
                intent.setType("image/*");
                startActivityForResult(intent, 22);
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
        if (requestCode == 11){
            imageView.setImageURI(Uri.fromFile(new File(tmpPath)));
        }
        if (requestCode == 22){
            Uri data1 = data.getData();
            imageView.setImageURI(data1);
        }
        super.onActivityResult(requestCode, resultCode, data);
    }
}