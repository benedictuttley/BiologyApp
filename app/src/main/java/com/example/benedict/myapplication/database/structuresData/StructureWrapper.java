package com.example.benedict.myapplication.database.structuresData;

import android.database.Cursor;
import android.database.CursorWrapper;

import com.example.benedict.myapplication.model.Structure;

/**
 * Created by Benedict on 12/10/2017.
 */

public class StructureWrapper extends CursorWrapper {
    public StructureWrapper(Cursor cursor) {
        super(cursor);
    }

    public Structure getStructure() {
        String structureTitle = getString(getColumnIndex(StructureDbSchema.StructuresTable.Cols.TITLE));
        String structureImageId = getString(getColumnIndex(StructureDbSchema.StructuresTable.Cols.IMAGE_ID));
        String structureDescription = getString(getColumnIndex(StructureDbSchema.StructuresTable.Cols.DESCRIPTION));

        Structure mStructure = new Structure(structureTitle, structureImageId, structureDescription);
        return mStructure;
    }
}
