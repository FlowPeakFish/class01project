package cn.fengyu.class01project;

import android.content.DialogInterface;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

public class DialogActivity extends AppCompatActivity {

    Button dialog1;
    Button dialog2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dialog);

        dialog1 = findViewById(R.id.btn_dialog_1);
        dialog2 = findViewById(R.id.btn_dialog_2);

        dialog1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // AlertDialog.Builder builder = new AlertDialog.Builder(DialogActivity.this);
                // // 设置icon图标
                // builder.setIcon(R.drawable.shizi);
                // // 设置title标题
                // builder.setTitle("种族确认");
                // // 设置message内容
                // builder.setMessage("你是不是狮子吗？");
                // // 正面按钮
                // builder.setPositiveButton("是", new DialogInterface.OnClickListener() {
                //     @Override
                //     public void onClick(DialogInterface dialog, int which) {
                //         Toast.makeText(DialogActivity.this, "你是狮子", Toast.LENGTH_SHORT).show();
                //     }
                // });
                // // 负面按钮
                // builder.setNegativeButton("否", new DialogInterface.OnClickListener() {
                //     @Override
                //     public void onClick(DialogInterface dialog, int which) {
                //         Toast.makeText(DialogActivity.this, "你不是狮子", Toast.LENGTH_SHORT).show();
                //     }
                // });
                // // 中立按钮
                // builder.setNeutralButton("不确定", new DialogInterface.OnClickListener() {
                //     @Override
                //     public void onClick(DialogInterface dialog, int which) {
                //         Toast.makeText(DialogActivity.this, "不确定是不是狮子", Toast.LENGTH_SHORT).show();
                //     }
                // });


                AlertDialog.Builder builder = new AlertDialog.Builder(DialogActivity.this)
                        .setIcon(R.drawable.shizi)
                        .setTitle("种族确认")
                        .setMessage("你是不是狮子吗？")
                        .setPositiveButton("是", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                Toast.makeText(DialogActivity.this, "你是狮子", Toast.LENGTH_SHORT).show();
                            }
                        })
                        .setNegativeButton("否", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                Toast.makeText(DialogActivity.this, "你不是狮子", Toast.LENGTH_SHORT).show();
                            }
                        })
                        .setNeutralButton("不确定", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                Toast.makeText(DialogActivity.this, "不确定是不是狮子", Toast.LENGTH_SHORT).show();
                            }
                        });

                AlertDialog alertDialog = builder.create();
                alertDialog.show();
            }
        });

        dialog2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String[] item = new String[]{"北京", "上海", "四川"};
                AlertDialog.Builder builder = new AlertDialog.Builder(DialogActivity.this)
                        .setIcon(R.drawable.shizi)
                        .setTitle("地址确定")
                        .setSingleChoiceItems(item, 0, new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                Toast.makeText(DialogActivity.this, "你选择了：" + which, Toast.LENGTH_SHORT).show();
                            }
                        })
                        .setPositiveButton("确定", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                            }
                        })
                        .setNegativeButton("取消", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                            }
                        });

                builder.create().show();

            }
        });
    }
}