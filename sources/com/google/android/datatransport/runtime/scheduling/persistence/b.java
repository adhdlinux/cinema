package com.google.android.datatransport.runtime.scheduling.persistence;

import android.database.sqlite.SQLiteDatabase;
import com.google.android.datatransport.runtime.firebase.transport.LogEventDropped;
import com.google.android.datatransport.runtime.scheduling.persistence.SQLiteEventStore;

public final /* synthetic */ class b implements SQLiteEventStore.Function {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ String f22743a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ LogEventDropped.Reason f22744b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ long f22745c;

    public /* synthetic */ b(String str, LogEventDropped.Reason reason, long j2) {
        this.f22743a = str;
        this.f22744b = reason;
        this.f22745c = j2;
    }

    public final Object apply(Object obj) {
        return SQLiteEventStore.k1(this.f22743a, this.f22744b, this.f22745c, (SQLiteDatabase) obj);
    }
}
