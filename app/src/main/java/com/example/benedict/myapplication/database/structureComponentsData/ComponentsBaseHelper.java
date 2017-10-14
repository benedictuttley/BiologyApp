package com.example.benedict.myapplication.database.structureComponentsData;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Benedict on 13/10/2017.
 */

public class ComponentsBaseHelper extends SQLiteOpenHelper {

    private static final int VERSION = 1;
    private static final String DATABASE_NAME = "Components.db";

    public ComponentsBaseHelper(Context context) {
        super(context, DATABASE_NAME, null, VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table " + ComponentsDbSchema.ComponentsTable.NAME + "(" +
                "_id integer primary key autoincrement, " +
                ComponentsDbSchema.ComponentsTable.Cols.TITLE + ", " +
                ComponentsDbSchema.ComponentsTable.Cols.IMAGE_ID + ", " +
                ComponentsDbSchema.ComponentsTable.Cols.DESCRIPTION + ", " +
                ComponentsDbSchema.ComponentsTable.Cols.PURPOSE + ", " +
                ComponentsDbSchema.ComponentsTable.Cols.ORGANELLE +
                ")"
        );
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
}
