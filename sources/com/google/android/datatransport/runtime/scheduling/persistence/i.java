package com.google.android.datatransport.runtime.scheduling.persistence;

import android.database.Cursor;
import com.google.android.datatransport.runtime.scheduling.persistence.SQLiteEventStore;
import java.util.Map;

public final /* synthetic */ class i implements SQLiteEventStore.Function {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Map f22755a;

    public /* synthetic */ i(Map map) {
        this.f22755a = map;
    }

    public final Object apply(Object obj) {
        return SQLiteEventStore.e1(this.f22755a, (Cursor) obj);
    }
}
