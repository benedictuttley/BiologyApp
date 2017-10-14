package com.example.benedict.myapplication.database.structuresData;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.benedict.myapplication.database.topicsData.TopicDbSchema;

/**
 * Created by Benedict on 12/10/2017.
 */

public class StructureBaseHelper extends SQLiteOpenHelper {
    private static final int VERSION = 1;
    private static final String DATABASE_NAME = "Structures.db";

    public StructureBaseHelper(Context context) {
        super(context, DATABASE_NAME, null, VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table " + StructureDbSchema.StructuresTable.NAME + "(" +
                "_id integer primary key autoincrement, " +
                StructureDbSchema.StructuresTable.Cols.TITLE + ", " +
                StructureDbSchema.StructuresTable.Cols.IMAGE_ID + ", " +
                StructureDbSchema.StructuresTable.Cols.DESCRIPTION + ")"
        );
    }


    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }


}
