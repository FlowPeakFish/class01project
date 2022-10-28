package cn.fengyu.class01project;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import androidx.annotation.Nullable;

public class MyDBOpenHelper extends SQLiteOpenHelper {

    public MyDBOpenHelper(@Nullable Context context) {
        super(context, "stu.db", null, 1);
    }

    /**
     * @param db The database.
     */
    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table stu_info (id integer primary key autoincrement," +
                "sno varchar(10)," +
                "name varchar(20)," +
                "sex varchar(2)," +
                "professional varchar(30)," +
                "department varchar(50))");
    }

    /**
     * @param db         The database.
     * @param oldVersion The old database version.
     * @param newVersion The new database version.
     */
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
    }
}
