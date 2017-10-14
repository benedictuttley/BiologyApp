package com.example.benedict.myapplication.database.structureComponentsData;

import android.database.Cursor;
import android.database.CursorWrapper;

import com.example.benedict.myapplication.model.StructureComponent;

/**
 * Created by Benedict on 13/10/2017.
 */

public class ComponentsWrapper extends CursorWrapper {
    public ComponentsWrapper(Cursor cursor) {
        super(cursor);
    }

    public StructureComponent getComponent() {
        String componentTitle = getString(getColumnIndex(ComponentsDbSchema.ComponentsTable.Cols.TITLE));
        String componentImageId = getString(getColumnIndex(ComponentsDbSchema.ComponentsTable.Cols.IMAGE_ID));
        String componentDescription = getString(getColumnIndex(ComponentsDbSchema.ComponentsTable.Cols.DESCRIPTION));
        String componentPurpose = getString(getColumnIndex(ComponentsDbSchema.ComponentsTable.Cols.PURPOSE));
        String componentOrganelle = getString(getColumnIndex(ComponentsDbSchema.ComponentsTable.Cols.ORGANELLE));

        StructureComponent mComponent = new StructureComponent(componentTitle,
                componentImageId,
                componentDescription,
                componentPurpose,
                componentOrganelle);

        return mComponent;

    }

}
