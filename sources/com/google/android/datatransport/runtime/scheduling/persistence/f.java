package com.google.android.datatransport.runtime.scheduling.persistence;

import android.database.sqlite.SQLiteDatabase;
import com.google.android.datatransport.runtime.scheduling.persistence.SQLiteEventStore;

public final /* synthetic */ class f implements SQLiteEventStore.Function {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ SQLiteEventStore f22751a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ String f22752b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ String f22753c;

    public /* synthetic */ f(SQLiteEventStore sQLiteEventStore, String str, String str2) {
        this.f22751a = sQLiteEventStore;
        this.f22752b = str;
        this.f22753c = str2;
    }

    public final Object apply(Object obj) {
        return this.f22751a.i1(this.f22752b, this.f22753c, (SQLiteDatabase) obj);
    }
}
