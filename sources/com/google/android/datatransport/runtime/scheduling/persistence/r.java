package com.google.android.datatransport.runtime.scheduling.persistence;

import android.database.sqlite.SQLiteDatabase;
import com.google.android.datatransport.runtime.scheduling.persistence.SQLiteEventStore;

public final /* synthetic */ class r implements SQLiteEventStore.Function {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ long f22768a;

    public /* synthetic */ r(long j2) {
        this.f22768a = j2;
    }

    public final Object apply(Object obj) {
        return SQLiteEventStore.V0(this.f22768a, (SQLiteDatabase) obj);
    }
}
