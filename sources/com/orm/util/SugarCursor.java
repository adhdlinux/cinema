package com.orm.util;

import android.database.Cursor;
import android.database.CursorWrapper;

public class SugarCursor extends CursorWrapper {
    public SugarCursor(Cursor cursor) {
        super(cursor);
    }

    public int getColumnIndex(String str) {
        if (str.equals("_id")) {
            str = "ID";
        }
        return super.getColumnIndex(str);
    }

    public int getColumnIndexOrThrow(String str) throws IllegalArgumentException {
        try {
            return super.getColumnIndexOrThrow(str);
        } catch (IllegalArgumentException e2) {
            if (str.equals("_id")) {
                return super.getColumnIndexOrThrow("ID");
            }
            throw e2;
        }
    }
}
