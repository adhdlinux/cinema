package com.google.android.datatransport.runtime.scheduling.persistence;

import android.database.Cursor;
import com.google.android.datatransport.runtime.scheduling.persistence.SQLiteEventStore;

public final /* synthetic */ class g implements SQLiteEventStore.Function {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ SQLiteEventStore f22754a;

    public /* synthetic */ g(SQLiteEventStore sQLiteEventStore) {
        this.f22754a = sQLiteEventStore;
    }

    public final Object apply(Object obj) {
        return this.f22754a.O0((Cursor) obj);
    }
}
