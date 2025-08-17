package com.google.android.datatransport.runtime.scheduling.persistence;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabaseLockedException;
import android.os.SystemClock;
import android.util.Base64;
import com.google.android.datatransport.Encoding;
import com.google.android.datatransport.runtime.EncodedPayload;
import com.google.android.datatransport.runtime.EventInternal;
import com.google.android.datatransport.runtime.TransportContext;
import com.google.android.datatransport.runtime.dagger.Lazy;
import com.google.android.datatransport.runtime.firebase.transport.ClientMetrics;
import com.google.android.datatransport.runtime.firebase.transport.GlobalMetrics;
import com.google.android.datatransport.runtime.firebase.transport.LogEventDropped;
import com.google.android.datatransport.runtime.firebase.transport.LogSourceMetrics;
import com.google.android.datatransport.runtime.firebase.transport.StorageMetrics;
import com.google.android.datatransport.runtime.firebase.transport.TimeWindow;
import com.google.android.datatransport.runtime.logging.Logging;
import com.google.android.datatransport.runtime.synchronization.SynchronizationException;
import com.google.android.datatransport.runtime.synchronization.SynchronizationGuard;
import com.google.android.datatransport.runtime.time.Clock;
import com.google.android.datatransport.runtime.util.PriorityMapping;
import com.google.android.gms.measurement.api.AppMeasurementSdk;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import javax.inject.Inject;
import javax.inject.Named;
import javax.inject.Singleton;

@Singleton
public class SQLiteEventStore implements EventStore, SynchronizationGuard, ClientHealthMetricsStore {

    /* renamed from: g  reason: collision with root package name */
    private static final Encoding f22715g = Encoding.b("proto");

    /* renamed from: b  reason: collision with root package name */
    private final SchemaManager f22716b;

    /* renamed from: c  reason: collision with root package name */
    private final Clock f22717c;

    /* renamed from: d  reason: collision with root package name */
    private final Clock f22718d;

    /* renamed from: e  reason: collision with root package name */
    private final EventStoreConfig f22719e;

    /* renamed from: f  reason: collision with root package name */
    private final Lazy<String> f22720f;

    interface Function<T, U> {
        U apply(T t2);
    }

    private static class Metadata {

        /* renamed from: a  reason: collision with root package name */
        final String f22721a;

        /* renamed from: b  reason: collision with root package name */
        final String f22722b;

        private Metadata(String str, String str2) {
            this.f22721a = str;
            this.f22722b = str2;
        }
    }

    interface Producer<T> {
        T a();
    }

    @Inject
    SQLiteEventStore(Clock clock, Clock clock2, EventStoreConfig eventStoreConfig, SchemaManager schemaManager, @Named("PACKAGE_NAME") Lazy<String> lazy) {
        this.f22716b = schemaManager;
        this.f22717c = clock;
        this.f22718d = clock2;
        this.f22719e = eventStoreConfig;
        this.f22720f = lazy;
    }

    private LogEventDropped.Reason B0(int i2) {
        LogEventDropped.Reason reason = LogEventDropped.Reason.REASON_UNKNOWN;
        if (i2 == reason.getNumber()) {
            return reason;
        }
        LogEventDropped.Reason reason2 = LogEventDropped.Reason.MESSAGE_TOO_OLD;
        if (i2 == reason2.getNumber()) {
            return reason2;
        }
        LogEventDropped.Reason reason3 = LogEventDropped.Reason.CACHE_FULL;
        if (i2 == reason3.getNumber()) {
            return reason3;
        }
        LogEventDropped.Reason reason4 = LogEventDropped.Reason.PAYLOAD_TOO_BIG;
        if (i2 == reason4.getNumber()) {
            return reason4;
        }
        LogEventDropped.Reason reason5 = LogEventDropped.Reason.MAX_RETRIES_REACHED;
        if (i2 == reason5.getNumber()) {
            return reason5;
        }
        LogEventDropped.Reason reason6 = LogEventDropped.Reason.INVALID_PAYLOD;
        if (i2 == reason6.getNumber()) {
            return reason6;
        }
        LogEventDropped.Reason reason7 = LogEventDropped.Reason.SERVER_ERROR;
        if (i2 == reason7.getNumber()) {
            return reason7;
        }
        Logging.a("SQLiteEventStore", "%n is not valid. No matched LogEventDropped-Reason found. Treated it as REASON_UNKNOWN", Integer.valueOf(i2));
        return reason;
    }

    private void C0(SQLiteDatabase sQLiteDatabase) {
        s1(new v(sQLiteDatabase), new w());
    }

    private long D0(SQLiteDatabase sQLiteDatabase, TransportContext transportContext) {
        Long K0 = K0(sQLiteDatabase, transportContext);
        if (K0 != null) {
            return K0.longValue();
        }
        ContentValues contentValues = new ContentValues();
        contentValues.put("backend_name", transportContext.b());
        contentValues.put("priority", Integer.valueOf(PriorityMapping.a(transportContext.d())));
        contentValues.put("next_request_ms", 0);
        if (transportContext.c() != null) {
            contentValues.put("extras", Base64.encodeToString(transportContext.c(), 0));
        }
        return sQLiteDatabase.insert("transport_contexts", (String) null, contentValues);
    }

    private GlobalMetrics G0() {
        return GlobalMetrics.b().b(StorageMetrics.c().b(E0()).c(EventStoreConfig.f22710a.f()).a()).a();
    }

    private long H0() {
        return F0().compileStatement("PRAGMA page_count").simpleQueryForLong();
    }

    private long I0() {
        return F0().compileStatement("PRAGMA page_size").simpleQueryForLong();
    }

    private TimeWindow J0() {
        return (TimeWindow) L0(new r(this.f22717c.a()));
    }

    private Long K0(SQLiteDatabase sQLiteDatabase, TransportContext transportContext) {
        StringBuilder sb = new StringBuilder("backend_name = ? and priority = ?");
        ArrayList arrayList = new ArrayList(Arrays.asList(new String[]{transportContext.b(), String.valueOf(PriorityMapping.a(transportContext.d()))}));
        if (transportContext.c() != null) {
            sb.append(" and extras = ?");
            arrayList.add(Base64.encodeToString(transportContext.c(), 0));
        } else {
            sb.append(" and extras is null");
        }
        return (Long) v1(sQLiteDatabase.query("transport_contexts", new String[]{"_id"}, sb.toString(), (String[]) arrayList.toArray(new String[0]), (String) null, (String) null, (String) null), new h());
    }

    private boolean M0() {
        if (H0() * I0() >= this.f22719e.f()) {
            return true;
        }
        return false;
    }

    private List<PersistedEvent> N0(List<PersistedEvent> list, Map<Long, Set<Metadata>> map) {
        ListIterator<PersistedEvent> listIterator = list.listIterator();
        while (listIterator.hasNext()) {
            PersistedEvent next = listIterator.next();
            if (map.containsKey(Long.valueOf(next.c()))) {
                EventInternal.Builder l2 = next.b().l();
                for (Metadata metadata : map.get(Long.valueOf(next.c()))) {
                    l2.c(metadata.f22721a, metadata.f22722b);
                }
                listIterator.set(PersistedEvent.a(next.c(), next.d(), l2.d()));
            }
        }
        return list;
    }

    /* access modifiers changed from: private */
    public /* synthetic */ Object O0(Cursor cursor) {
        while (cursor.moveToNext()) {
            int i2 = cursor.getInt(0);
            k((long) i2, LogEventDropped.Reason.MESSAGE_TOO_OLD, cursor.getString(1));
        }
        return null;
    }

    /* access modifiers changed from: private */
    public /* synthetic */ Integer P0(long j2, SQLiteDatabase sQLiteDatabase) {
        String[] strArr = {String.valueOf(j2)};
        v1(sQLiteDatabase.rawQuery("SELECT COUNT(*), transport_name FROM events WHERE timestamp_ms < ? GROUP BY transport_name", strArr), new g(this));
        return Integer.valueOf(sQLiteDatabase.delete("events", "timestamp_ms < ?", strArr));
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ Object R0(Throwable th) {
        throw new SynchronizationException("Timed out while trying to acquire the lock.", th);
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ SQLiteDatabase S0(Throwable th) {
        throw new SynchronizationException("Timed out while trying to open db.", th);
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ Long T0(Cursor cursor) {
        if (cursor.moveToNext()) {
            return Long.valueOf(cursor.getLong(0));
        }
        return 0L;
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ TimeWindow V0(long j2, SQLiteDatabase sQLiteDatabase) {
        return (TimeWindow) v1(sQLiteDatabase.rawQuery("SELECT last_metrics_upload_ms FROM global_log_event_state LIMIT 1", new String[0]), new s(j2));
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ Long W0(Cursor cursor) {
        if (!cursor.moveToNext()) {
            return null;
        }
        return Long.valueOf(cursor.getLong(0));
    }

    /* access modifiers changed from: private */
    public /* synthetic */ Boolean X0(TransportContext transportContext, SQLiteDatabase sQLiteDatabase) {
        Long K0 = K0(sQLiteDatabase, transportContext);
        if (K0 == null) {
            return Boolean.FALSE;
        }
        return (Boolean) v1(F0().rawQuery("SELECT 1 FROM events WHERE context_id = ? LIMIT 1", new String[]{K0.toString()}), new o());
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ List Y0(SQLiteDatabase sQLiteDatabase) {
        return (List) v1(sQLiteDatabase.rawQuery("SELECT distinct t._id, t.backend_name, t.priority, t.extras FROM transport_contexts AS t, events AS e WHERE e.context_id = t._id", new String[0]), new z());
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ List Z0(Cursor cursor) {
        ArrayList arrayList = new ArrayList();
        while (cursor.moveToNext()) {
            arrayList.add(TransportContext.a().b(cursor.getString(1)).d(PriorityMapping.b(cursor.getInt(2))).c(p1(cursor.getString(3))).a());
        }
        return arrayList;
    }

    /* access modifiers changed from: private */
    public /* synthetic */ List a1(TransportContext transportContext, SQLiteDatabase sQLiteDatabase) {
        List<PersistedEvent> n12 = n1(sQLiteDatabase, transportContext);
        return N0(n12, o1(sQLiteDatabase, n12));
    }

    /* access modifiers changed from: private */
    public /* synthetic */ ClientMetrics b1(Map map, ClientMetrics.Builder builder, Cursor cursor) {
        while (cursor.moveToNext()) {
            String string = cursor.getString(0);
            LogEventDropped.Reason B0 = B0(cursor.getInt(1));
            long j2 = cursor.getLong(2);
            if (!map.containsKey(string)) {
                map.put(string, new ArrayList());
            }
            ((List) map.get(string)).add(LogEventDropped.c().c(B0).b(j2).a());
        }
        q1(builder, map);
        builder.e(J0());
        builder.d(G0());
        builder.c(this.f22720f.get());
        return builder.b();
    }

    /* access modifiers changed from: private */
    public /* synthetic */ ClientMetrics c1(String str, Map map, ClientMetrics.Builder builder, SQLiteDatabase sQLiteDatabase) {
        return (ClientMetrics) v1(sQLiteDatabase.rawQuery(str, new String[0]), new q(this, map, builder));
    }

    /* access modifiers changed from: private */
    public /* synthetic */ Object d1(List list, TransportContext transportContext, Cursor cursor) {
        while (cursor.moveToNext()) {
            boolean z2 = false;
            long j2 = cursor.getLong(0);
            if (cursor.getInt(7) != 0) {
                z2 = true;
            }
            EventInternal.Builder k2 = EventInternal.a().j(cursor.getString(1)).i(cursor.getLong(2)).k(cursor.getLong(3));
            if (z2) {
                k2.h(new EncodedPayload(t1(cursor.getString(4)), cursor.getBlob(5)));
            } else {
                k2.h(new EncodedPayload(t1(cursor.getString(4)), r1(j2)));
            }
            if (!cursor.isNull(6)) {
                k2.g(Integer.valueOf(cursor.getInt(6)));
            }
            list.add(PersistedEvent.a(j2, transportContext, k2.d()));
        }
        return null;
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ Object e1(Map map, Cursor cursor) {
        while (cursor.moveToNext()) {
            long j2 = cursor.getLong(0);
            Set set = (Set) map.get(Long.valueOf(j2));
            if (set == null) {
                set = new HashSet();
                map.put(Long.valueOf(j2), set);
            }
            set.add(new Metadata(cursor.getString(1), cursor.getString(2)));
        }
        return null;
    }

    /* access modifiers changed from: private */
    public /* synthetic */ Long f1(EventInternal eventInternal, TransportContext transportContext, SQLiteDatabase sQLiteDatabase) {
        boolean z2;
        byte[] bArr;
        if (M0()) {
            k(1, LogEventDropped.Reason.CACHE_FULL, eventInternal.j());
            return -1L;
        }
        long D0 = D0(sQLiteDatabase, transportContext);
        int e2 = this.f22719e.e();
        byte[] a2 = eventInternal.e().a();
        if (a2.length <= e2) {
            z2 = true;
        } else {
            z2 = false;
        }
        ContentValues contentValues = new ContentValues();
        contentValues.put("context_id", Long.valueOf(D0));
        contentValues.put("transport_name", eventInternal.j());
        contentValues.put("timestamp_ms", Long.valueOf(eventInternal.f()));
        contentValues.put("uptime_ms", Long.valueOf(eventInternal.k()));
        contentValues.put("payload_encoding", eventInternal.e().b().a());
        contentValues.put("code", eventInternal.d());
        contentValues.put("num_attempts", 0);
        contentValues.put("inline", Boolean.valueOf(z2));
        if (z2) {
            bArr = a2;
        } else {
            bArr = new byte[0];
        }
        contentValues.put("payload", bArr);
        long insert = sQLiteDatabase.insert("events", (String) null, contentValues);
        if (!z2) {
            int ceil = (int) Math.ceil(((double) a2.length) / ((double) e2));
            for (int i2 = 1; i2 <= ceil; i2++) {
                byte[] copyOfRange = Arrays.copyOfRange(a2, (i2 - 1) * e2, Math.min(i2 * e2, a2.length));
                ContentValues contentValues2 = new ContentValues();
                contentValues2.put("event_id", Long.valueOf(insert));
                contentValues2.put("sequence_num", Integer.valueOf(i2));
                contentValues2.put("bytes", copyOfRange);
                sQLiteDatabase.insert("event_payloads", (String) null, contentValues2);
            }
        }
        for (Map.Entry next : eventInternal.i().entrySet()) {
            ContentValues contentValues3 = new ContentValues();
            contentValues3.put("event_id", Long.valueOf(insert));
            contentValues3.put("name", (String) next.getKey());
            contentValues3.put(AppMeasurementSdk.ConditionalUserProperty.VALUE, (String) next.getValue());
            sQLiteDatabase.insert("event_metadata", (String) null, contentValues3);
        }
        return Long.valueOf(insert);
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ byte[] g1(Cursor cursor) {
        ArrayList arrayList = new ArrayList();
        int i2 = 0;
        while (cursor.moveToNext()) {
            byte[] blob = cursor.getBlob(0);
            arrayList.add(blob);
            i2 += blob.length;
        }
        byte[] bArr = new byte[i2];
        int i3 = 0;
        for (int i4 = 0; i4 < arrayList.size(); i4++) {
            byte[] bArr2 = (byte[]) arrayList.get(i4);
            System.arraycopy(bArr2, 0, bArr, i3, bArr2.length);
            i3 += bArr2.length;
        }
        return bArr;
    }

    /* access modifiers changed from: private */
    public /* synthetic */ Object h1(Cursor cursor) {
        while (cursor.moveToNext()) {
            int i2 = cursor.getInt(0);
            k((long) i2, LogEventDropped.Reason.MAX_RETRIES_REACHED, cursor.getString(1));
        }
        return null;
    }

    /* access modifiers changed from: private */
    public /* synthetic */ Object i1(String str, String str2, SQLiteDatabase sQLiteDatabase) {
        sQLiteDatabase.compileStatement(str).execute();
        v1(sQLiteDatabase.rawQuery(str2, (String[]) null), new n(this));
        sQLiteDatabase.compileStatement("DELETE FROM events WHERE num_attempts >= 16").execute();
        return null;
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ Boolean j1(Cursor cursor) {
        return Boolean.valueOf(cursor.getCount() > 0);
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ Object k1(String str, LogEventDropped.Reason reason, long j2, SQLiteDatabase sQLiteDatabase) {
        if (!((Boolean) v1(sQLiteDatabase.rawQuery("SELECT 1 FROM log_event_dropped WHERE log_source = ? AND reason = ?", new String[]{str, Integer.toString(reason.getNumber())}), new m())).booleanValue()) {
            ContentValues contentValues = new ContentValues();
            contentValues.put("log_source", str);
            contentValues.put("reason", Integer.valueOf(reason.getNumber()));
            contentValues.put("events_dropped_count", Long.valueOf(j2));
            sQLiteDatabase.insert("log_event_dropped", (String) null, contentValues);
        } else {
            sQLiteDatabase.execSQL("UPDATE log_event_dropped SET events_dropped_count = events_dropped_count + " + j2 + " WHERE log_source = ? AND reason = ?", new String[]{str, Integer.toString(reason.getNumber())});
        }
        return null;
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ Object l1(long j2, TransportContext transportContext, SQLiteDatabase sQLiteDatabase) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("next_request_ms", Long.valueOf(j2));
        if (sQLiteDatabase.update("transport_contexts", contentValues, "backend_name = ? and priority = ?", new String[]{transportContext.b(), String.valueOf(PriorityMapping.a(transportContext.d()))}) < 1) {
            contentValues.put("backend_name", transportContext.b());
            contentValues.put("priority", Integer.valueOf(PriorityMapping.a(transportContext.d())));
            sQLiteDatabase.insert("transport_contexts", (String) null, contentValues);
        }
        return null;
    }

    /* access modifiers changed from: private */
    public /* synthetic */ Object m1(SQLiteDatabase sQLiteDatabase) {
        sQLiteDatabase.compileStatement("DELETE FROM log_event_dropped").execute();
        sQLiteDatabase.compileStatement("UPDATE global_log_event_state SET last_metrics_upload_ms=" + this.f22717c.a()).execute();
        return null;
    }

    private List<PersistedEvent> n1(SQLiteDatabase sQLiteDatabase, TransportContext transportContext) {
        ArrayList arrayList = new ArrayList();
        Long K0 = K0(sQLiteDatabase, transportContext);
        if (K0 == null) {
            return arrayList;
        }
        SQLiteDatabase sQLiteDatabase2 = sQLiteDatabase;
        v1(sQLiteDatabase2.query("events", new String[]{"_id", "transport_name", "timestamp_ms", "uptime_ms", "payload_encoding", "payload", "code", "inline"}, "context_id = ?", new String[]{K0.toString()}, (String) null, (String) null, (String) null, String.valueOf(this.f22719e.d())), new k(this, arrayList, transportContext));
        return arrayList;
    }

    private Map<Long, Set<Metadata>> o1(SQLiteDatabase sQLiteDatabase, List<PersistedEvent> list) {
        HashMap hashMap = new HashMap();
        StringBuilder sb = new StringBuilder("event_id IN (");
        for (int i2 = 0; i2 < list.size(); i2++) {
            sb.append(list.get(i2).c());
            if (i2 < list.size() - 1) {
                sb.append(',');
            }
        }
        sb.append(')');
        v1(sQLiteDatabase.query("event_metadata", new String[]{"event_id", "name", AppMeasurementSdk.ConditionalUserProperty.VALUE}, sb.toString(), (String[]) null, (String) null, (String) null, (String) null), new i(hashMap));
        return hashMap;
    }

    private static byte[] p1(String str) {
        if (str == null) {
            return null;
        }
        return Base64.decode(str, 0);
    }

    private void q1(ClientMetrics.Builder builder, Map<String, List<LogEventDropped>> map) {
        for (Map.Entry next : map.entrySet()) {
            builder.a(LogSourceMetrics.c().c((String) next.getKey()).b((List) next.getValue()).a());
        }
    }

    private byte[] r1(long j2) {
        return (byte[]) v1(F0().query("event_payloads", new String[]{"bytes"}, "event_id = ?", new String[]{String.valueOf(j2)}, (String) null, (String) null, "sequence_num"), new p());
    }

    private <T> T s1(Producer<T> producer, Function<Throwable, T> function) {
        long a2 = this.f22718d.a();
        while (true) {
            try {
                return producer.a();
            } catch (SQLiteDatabaseLockedException e2) {
                if (this.f22718d.a() >= ((long) this.f22719e.b()) + a2) {
                    return function.apply(e2);
                }
                SystemClock.sleep(50);
            }
        }
    }

    private static Encoding t1(String str) {
        if (str == null) {
            return f22715g;
        }
        return Encoding.b(str);
    }

    private static String u1(Iterable<PersistedEvent> iterable) {
        StringBuilder sb = new StringBuilder("(");
        Iterator<PersistedEvent> it2 = iterable.iterator();
        while (it2.hasNext()) {
            sb.append(it2.next().c());
            if (it2.hasNext()) {
                sb.append(',');
            }
        }
        sb.append(')');
        return sb.toString();
    }

    static <T> T v1(Cursor cursor, Function<Cursor, T> function) {
        try {
            return function.apply(cursor);
        } finally {
            cursor.close();
        }
    }

    /* access modifiers changed from: package-private */
    public long E0() {
        return H0() * I0();
    }

    /* access modifiers changed from: package-private */
    public SQLiteDatabase F0() {
        SchemaManager schemaManager = this.f22716b;
        Objects.requireNonNull(schemaManager);
        return (SQLiteDatabase) s1(new l(schemaManager), new t());
    }

    public long J(TransportContext transportContext) {
        return ((Long) v1(F0().rawQuery("SELECT next_request_ms FROM transport_contexts WHERE backend_name = ? and priority = ?", new String[]{transportContext.b(), String.valueOf(PriorityMapping.a(transportContext.d()))}), new u())).longValue();
    }

    public boolean K(TransportContext transportContext) {
        return ((Boolean) L0(new a0(this, transportContext))).booleanValue();
    }

    /* access modifiers changed from: package-private */
    public <T> T L0(Function<SQLiteDatabase, T> function) {
        SQLiteDatabase F0 = F0();
        F0.beginTransaction();
        try {
            T apply = function.apply(F0);
            F0.setTransactionSuccessful();
            return apply;
        } finally {
            F0.endTransaction();
        }
    }

    public void M(Iterable<PersistedEvent> iterable) {
        if (iterable.iterator().hasNext()) {
            L0(new f(this, "UPDATE events SET num_attempts = num_attempts + 1 WHERE _id in " + u1(iterable), "SELECT COUNT(*), transport_name FROM events WHERE num_attempts >= 16 GROUP BY transport_name"));
        }
    }

    public Iterable<PersistedEvent> T(TransportContext transportContext) {
        return (Iterable) L0(new e(this, transportContext));
    }

    public void a() {
        L0(new d(this));
    }

    public void b(Iterable<PersistedEvent> iterable) {
        if (iterable.iterator().hasNext()) {
            F0().compileStatement("DELETE FROM events WHERE _id in " + u1(iterable)).execute();
        }
    }

    public int cleanUp() {
        return ((Integer) L0(new y(this, this.f22717c.a() - this.f22719e.c()))).intValue();
    }

    public void close() {
        this.f22716b.close();
    }

    public <T> T f(SynchronizationGuard.CriticalSection<T> criticalSection) {
        SQLiteDatabase F0 = F0();
        C0(F0);
        try {
            T execute = criticalSection.execute();
            F0.setTransactionSuccessful();
            return execute;
        } finally {
            F0.endTransaction();
        }
    }

    public PersistedEvent g0(TransportContext transportContext, EventInternal eventInternal) {
        Logging.b("SQLiteEventStore", "Storing event with priority=%s, name=%s for destination %s", transportContext.d(), eventInternal.j(), transportContext.b());
        long longValue = ((Long) L0(new x(this, eventInternal, transportContext))).longValue();
        if (longValue < 1) {
            return null;
        }
        return PersistedEvent.a(longValue, transportContext, eventInternal);
    }

    public ClientMetrics i() {
        return (ClientMetrics) L0(new j(this, "SELECT log_source, reason, events_dropped_count FROM log_event_dropped", new HashMap(), ClientMetrics.e()));
    }

    public void k(long j2, LogEventDropped.Reason reason, String str) {
        L0(new b(str, reason, j2));
    }

    public void m(TransportContext transportContext, long j2) {
        L0(new c(j2, transportContext));
    }

    public Iterable<TransportContext> o() {
        return (Iterable) L0(new a());
    }
}
