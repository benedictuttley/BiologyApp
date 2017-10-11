package com.example.benedict.myapplication.database.topicsData;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Benedict on 09/10/2017.
 */

public class TopicBaseHelper extends SQLiteOpenHelper {

    private static final int VERSION = 1;
    private static final String DATABASE_NAME = "Topics.db";

    public TopicBaseHelper(Context context) {
        super(context, DATABASE_NAME, null, VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table " + TopicDbSchema.TopicsTable.NAME + "(" +
                "_id integer primary key autoincrement, " +
                TopicDbSchema.TopicsTable.Cols.TITLE + ", " +
                TopicDbSchema.TopicsTable.Cols.IMAGE_ID + ")"
        );
    }


    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
}