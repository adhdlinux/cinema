package com.google.android.datatransport.runtime.scheduling.persistence;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import java.util.Arrays;
import java.util.List;
import javax.inject.Inject;
import javax.inject.Named;

final class SchemaManager extends SQLiteOpenHelper {

    /* renamed from: d  reason: collision with root package name */
    private static final String f22728d = ("INSERT INTO global_log_event_state VALUES (" + System.currentTimeMillis() + ")");

    /* renamed from: e  reason: collision with root package name */
    static int f22729e = 5;

    /* renamed from: f  reason: collision with root package name */
    private static final Migration f22730f;

    /* renamed from: g  reason: collision with root package name */
    private static final Migration f22731g;

    /* renamed from: h  reason: collision with root package name */
    private static final Migration f22732h;

    /* renamed from: i  reason: collision with root package name */
    private static final Migration f22733i;

    /* renamed from: j  reason: collision with root package name */
    private static final Migration f22734j;

    /* renamed from: k  reason: collision with root package name */
    private static final List<Migration> f22735k;

    /* renamed from: b  reason: collision with root package name */
    private final int f22736b;

    /* renamed from: c  reason: collision with root package name */
    private boolean f22737c = false;

    public interface Migration {
        void a(SQLiteDatabase sQLiteDatabase);
    }

    static {
        b0 b0Var = new b0();
        f22730f = b0Var;
        c0 c0Var = new c0();
        f22731g = c0Var;
        d0 d0Var = new d0();
        f22732h = d0Var;
        e0 e0Var = new e0();
        f22733i = e0Var;
        f0 f0Var = new f0();
        f22734j = f0Var;
        f22735k = Arrays.asList(new Migration[]{b0Var, c0Var, d0Var, e0Var, f0Var});
    }

    @Inject
    SchemaManager(Context context, @Named("SQLITE_DB_NAME") String str, @Named("SCHEMA_VERSION") int i2) {
        super(context, str, (SQLiteDatabase.CursorFactory) null, i2);
        this.f22736b = i2;
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ void B(SQLiteDatabase sQLiteDatabase) {
        sQLiteDatabase.execSQL("ALTER TABLE events ADD COLUMN inline BOOLEAN NOT NULL DEFAULT 1");
        sQLiteDatabase.execSQL("DROP TABLE IF EXISTS event_payloads");
        sQLiteDatabase.execSQL("CREATE TABLE event_payloads (sequence_num INTEGER NOT NULL, event_id INTEGER NOT NULL, bytes BLOB NOT NULL,FOREIGN KEY (event_id) REFERENCES events(_id) ON DELETE CASCADE,PRIMARY KEY (sequence_num, event_id))");
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ void D(SQLiteDatabase sQLiteDatabase) {
        sQLiteDatabase.execSQL("DROP TABLE IF EXISTS log_event_dropped");
        sQLiteDatabase.execSQL("DROP TABLE IF EXISTS global_log_event_state");
        sQLiteDatabase.execSQL("CREATE TABLE log_event_dropped (log_source VARCHAR(45) NOT NULL,reason INTEGER NOT NULL,events_dropped_count BIGINT NOT NULL,PRIMARY KEY(log_source, reason))");
        sQLiteDatabase.execSQL("CREATE TABLE global_log_event_state (last_metrics_upload_ms BIGINT PRIMARY KEY)");
        sQLiteDatabase.execSQL(f22728d);
    }

    private void E(SQLiteDatabase sQLiteDatabase, int i2) {
        s(sQLiteDatabase);
        H(sQLiteDatabase, 0, i2);
    }

    private void H(SQLiteDatabase sQLiteDatabase, int i2, int i3) {
        List<Migration> list = f22735k;
        if (i3 <= list.size()) {
            while (i2 < i3) {
                f22735k.get(i2).a(sQLiteDatabase);
                i2++;
            }
            return;
        }
        throw new IllegalArgumentException("Migration from " + i2 + " to " + i3 + " was requested, but cannot be performed. Only " + list.size() + " migrations are provided");
    }

    private void s(SQLiteDatabase sQLiteDatabase) {
        if (!this.f22737c) {
            onConfigure(sQLiteDatabase);
        }
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ void v(SQLiteDatabase sQLiteDatabase) {
        sQLiteDatabase.execSQL("CREATE TABLE events (_id INTEGER PRIMARY KEY, context_id INTEGER NOT NULL, transport_name TEXT NOT NULL, timestamp_ms INTEGER NOT NULL, uptime_ms INTEGER NOT NULL, payload BLOB NOT NULL, code INTEGER, num_attempts INTEGER NOT NULL,FOREIGN KEY (context_id) REFERENCES transport_contexts(_id) ON DELETE CASCADE)");
        sQLiteDatabase.execSQL("CREATE TABLE event_metadata (_id INTEGER PRIMARY KEY, event_id INTEGER NOT NULL, name TEXT NOT NULL, value TEXT NOT NULL,FOREIGN KEY (event_id) REFERENCES events(_id) ON DELETE CASCADE)");
        sQLiteDatabase.execSQL("CREATE TABLE transport_contexts (_id INTEGER PRIMARY KEY, backend_name TEXT NOT NULL, priority INTEGER NOT NULL, next_request_ms INTEGER NOT NULL)");
        sQLiteDatabase.execSQL("CREATE INDEX events_backend_id on events(context_id)");
        sQLiteDatabase.execSQL("CREATE UNIQUE INDEX contexts_backend_priority on transport_contexts(backend_name, priority)");
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ void z(SQLiteDatabase sQLiteDatabase) {
        sQLiteDatabase.execSQL("ALTER TABLE transport_contexts ADD COLUMN extras BLOB");
        sQLiteDatabase.execSQL("CREATE UNIQUE INDEX contexts_backend_priority_extras on transport_contexts(backend_name, priority, extras)");
        sQLiteDatabase.execSQL("DROP INDEX contexts_backend_priority");
    }

    public void onConfigure(SQLiteDatabase sQLiteDatabase) {
        this.f22737c = true;
        sQLiteDatabase.rawQuery("PRAGMA busy_timeout=0;", new String[0]).close();
        sQLiteDatabase.setForeignKeyConstraintsEnabled(true);
    }

    public void onCreate(SQLiteDatabase sQLiteDatabase) {
        E(sQLiteDatabase, this.f22736b);
    }

    public void onDowngrade(SQLiteDatabase sQLiteDatabase, int i2, int i3) {
        sQLiteDatabase.execSQL("DROP TABLE events");
        sQLiteDatabase.execSQL("DROP TABLE event_metadata");
        sQLiteDatabase.execSQL("DROP TABLE transport_contexts");
        sQLiteDatabase.execSQL("DROP TABLE IF EXISTS event_payloads");
        sQLiteDatabase.execSQL("DROP TABLE IF EXISTS log_event_dropped");
        sQLiteDatabase.execSQL("DROP TABLE IF EXISTS global_log_event_state");
        E(sQLiteDatabase, i3);
    }

    public void onOpen(SQLiteDatabase sQLiteDatabase) {
        s(sQLiteDatabase);
    }

    public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i2, int i3) {
        s(sQLiteDatabase);
        H(sQLiteDatabase, i2, i3);
    }
}
