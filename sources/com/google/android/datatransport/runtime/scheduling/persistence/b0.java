package com.google.android.datatransport.runtime.scheduling.persistence;

import android.database.sqlite.SQLiteDatabase;
import com.google.android.datatransport.runtime.scheduling.persistence.SchemaManager;

public final /* synthetic */ class b0 implements SchemaManager.Migration {
    public final void a(SQLiteDatabase sQLiteDatabase) {
        SchemaManager.v(sQLiteDatabase);
    }
}
