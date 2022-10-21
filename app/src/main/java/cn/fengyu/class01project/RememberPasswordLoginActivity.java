package cn.fengyu.class01project;

import android.content.SharedPreferences;
import android.os.Environment;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Map;
import java.util.Set;

public class RememberPasswordLoginActivity extends AppCompatActivity {

    EditText username, password;

    CheckBox checkBox;

    Button loginBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_remember_password_login);

        username = findViewById(R.id.username);
        password = findViewById(R.id.password);
        checkBox = findViewById(R.id.remeber);
        loginBtn = findViewById(R.id.login);

        SharedPreferences sharedPreferences = getSharedPreferences("myfile", MODE_PRIVATE);
        // SharedPreference存储第一种读取
        // String preferencesUsername = sharedPreferences.getString("username", "第一次登录");
        // String preferencesPassword = sharedPreferences.getString("password", "");
        // username.setText(preferencesUsername);
        // password.setText(preferencesPassword);
        // SharedPreference存储第二种读取
        // Map<String, ?> sharedPreferencesAll = sharedPreferences.getAll();
        // Set<String> keySet = sharedPreferencesAll.keySet();
        // System.out.println("size: " + keySet.size());
        // for (String key : keySet) {
        //     System.out.println(key + " : " + sharedPreferencesAll.get(key));
        // }

        try {
            FileInputStream fis = openFileInput("file.txt");
            byte[] content = new byte[fis.available()];
            fis.read(content);
            System.out.println("FIS FILE 内容：" + new String(content));
            fis.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        loginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                System.out.println("用户名：" + username.getText().toString());
                System.out.println("密码：" + password.getText().toString());
                System.out.println("记住密码：" + checkBox.isChecked());

                if (checkBox.isChecked()) {
                    // SharedPreference存储写入
                    // SharedPreferences.Editor editor =
                    //         getSharedPreferences("myfile", MODE_PRIVATE).edit();
                    // editor.putString("username", username.getText().toString());
                    // editor.putString("password", password.getText().toString());
                    // editor.commit();

                    // 文件存储写入
                    try {
                        FileOutputStream fos = openFileOutput("file.txt", MODE_PRIVATE);
                        fos.write(username.getText().toString().getBytes());
                        fos.close();
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }

                    Toast.makeText(RememberPasswordLoginActivity.this, "记住密码成功",
                            Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}