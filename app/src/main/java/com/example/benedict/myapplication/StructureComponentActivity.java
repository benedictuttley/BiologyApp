package com.example.benedict.myapplication;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.example.benedict.myapplication.database.structureComponentsData.ComponentsBaseHelper;
import com.example.benedict.myapplication.database.structureComponentsData.ComponentsDbSchema;
import com.example.benedict.myapplication.database.structureComponentsData.ComponentsWrapper;
import com.example.benedict.myapplication.model.StructureComponent;

import java.util.ArrayList;
import java.util.List;

public class StructureComponentActivity extends AppCompatActivity {
    private RecyclerView mComponentRecycler;
    private SQLiteDatabase mDatabase;
    private StructureComponent.ComponentAdapter mAdapter;
    private static final String TAG = StructureComponentActivity.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_structure_component);
        mDatabase = new ComponentsBaseHelper(this).getWritableDatabase();

        mComponentRecycler = (RecyclerView) findViewById(R.id.component_recycler_view);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
        mComponentRecycler.setLayoutManager(linearLayoutManager);
        Log.i(TAG,"Structure Component Activity");
        StructureComponent test = new StructureComponent("Nucleolus","","","","");
        addComponent(test);
        updateUI();
    }


    private List<StructureComponent> getComponents() {

        List<StructureComponent> components = new ArrayList<>();
        ComponentsWrapper cursor = queryComponents(null, null);

        try {
            cursor.moveToFirst();
            while (!cursor.isAfterLast()) {
                components.add(cursor.getComponent());
                cursor.moveToNext();
            }

        } finally {
            {
                cursor.close();
            }
        }

        return components;


    }

    public void addComponent(StructureComponent component) {
        ContentValues values = getContentValues(component);
        mDatabase.insert(ComponentsDbSchema.ComponentsTable.NAME,
                null, values);
    }


    public static ContentValues getContentValues(StructureComponent component) {
        ContentValues values = new ContentValues();

        values.put(ComponentsDbSchema.ComponentsTable.Cols.TITLE,
                component.getStructureTitle());

        values.put(ComponentsDbSchema.ComponentsTable.Cols.IMAGE_ID,
                component.getImageId());

        values.put(ComponentsDbSchema.ComponentsTable.Cols.DESCRIPTION,
                component.getDescription());

        values.put(ComponentsDbSchema.ComponentsTable.Cols.PURPOSE,
                component.getPurpose());

        values.put(ComponentsDbSchema.ComponentsTable.Cols.ORGANELLE,
                component.getOrganelle());
        return values;

    }

    private ComponentsWrapper queryComponents(String whereClause, String whereArgs[]) {
        Cursor cursor = mDatabase.query(
                ComponentsDbSchema.ComponentsTable.NAME,
                null,
                whereClause,
                whereArgs,
                null,
                null,
                null);
        return new ComponentsWrapper(cursor);
    }


    private void updateUI() {
        List<StructureComponent> components = getComponents();
        mAdapter = new StructureComponent.ComponentAdapter(components, this);
        mComponentRecycler.setAdapter(mAdapter);
    }


}
