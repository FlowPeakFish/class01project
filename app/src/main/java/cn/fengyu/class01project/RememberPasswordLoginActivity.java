package cn.fengyu.class01project;

import android.content.SharedPreferences;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

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

        loginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                System.out.println("用户名：" + username.getText().toString());
                System.out.println("密码：" + password.getText().toString());
                System.out.println("记住密码：" + checkBox.isChecked());

                if (checkBox.isChecked()) {
                    // SharedPreference存储
                    SharedPreferences.Editor editor =
                            getSharedPreferences("myfile", MODE_PRIVATE).edit();
                    editor.putString("username", username.getText().toString());
                    editor.putString("password", password.getText().toString());
                    editor.commit();
                    Toast.makeText(RememberPasswordLoginActivity.this, "记住密码成功",
                            Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}