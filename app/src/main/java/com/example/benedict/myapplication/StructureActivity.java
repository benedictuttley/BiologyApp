package com.example.benedict.myapplication;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.benedict.myapplication.database.structuresData.StructureBaseHelper;
import com.example.benedict.myapplication.database.structuresData.StructureDbSchema;
import com.example.benedict.myapplication.database.structuresData.StructureWrapper;
import com.example.benedict.myapplication.model.Structure;


import java.util.ArrayList;
import java.util.List;

public class StructureActivity extends AppCompatActivity {
    private SQLiteDatabase mDatabase;
    private RecyclerView mStructureRecycler;
    private Structure.StructureAdapter mAdapter;
    //private static final String TAG = TopicActivity.class.getSimpleName();
    //Context context = this;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mDatabase = new StructureBaseHelper(this).getWritableDatabase();
        setContentView(R.layout.activity_structure);
        Structure structure;
        addStructure(structure = new Structure("TEST1","TEST2","TEST3"));

        mStructureRecycler = (RecyclerView) findViewById(R.id.structure_recylcer_view);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        mStructureRecycler.setLayoutManager(linearLayoutManager);

        updateUI();
    }


    public  List<Structure> getStructures(){
        List<Structure> structures = new ArrayList<>();
        StructureWrapper cursor = queryStructures(null, null);

        try {
            cursor.moveToFirst();
            while (!cursor.isAfterLast()) {
                structures.add(cursor.getStructure());
                cursor.moveToNext();
            }

        } finally {
            {
                cursor.close();
            }
        }

        return structures;

    }



    private StructureWrapper queryStructures(String whereClause, String whereArgs[]) {
        Cursor cursor = mDatabase.query(
                StructureDbSchema.StructuresTable.NAME,
                null,
                whereClause,
                whereArgs,
                null,
                null,
                null);
        return new StructureWrapper(cursor);
    }

    public void addStructure(Structure structure) {
        ContentValues values = getContentValues(structure);
        mDatabase.insert(StructureDbSchema.StructuresTable.NAME,
                null, values);
    }


    public static ContentValues getContentValues(Structure structure) {
        ContentValues values = new ContentValues();

        values.put(StructureDbSchema.StructuresTable.Cols.TITLE,
                structure.getStructureTitle());

        values.put(StructureDbSchema.StructuresTable.Cols.IMAGE_ID,
                structure.getImageId());

        values.put(StructureDbSchema.StructuresTable.Cols.DESCRIPTION,
                structure.getTopicDescription());

        return values;

    }

    private void updateUI() {
        List<Structure> structures = getStructures();
        mAdapter = new Structure.StructureAdapter(structures, this);
        mStructureRecycler.setAdapter(mAdapter);
        }
    }

