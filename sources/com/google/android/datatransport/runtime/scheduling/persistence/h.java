package com.google.android.datatransport.runtime.scheduling.persistence;

import android.database.Cursor;
import com.google.android.datatransport.runtime.scheduling.persistence.SQLiteEventStore;

public final /* synthetic */ class h implements SQLiteEventStore.Function {
    public final Object apply(Object obj) {
        return SQLiteEventStore.W0((Cursor) obj);
    }
}
