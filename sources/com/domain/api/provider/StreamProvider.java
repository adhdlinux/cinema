package com.domain.api.provider;

import android.content.ContentProvider;
import android.content.ContentProviderOperation;
import android.content.ContentProviderResult;
import android.content.ContentResolver;
import android.content.ContentUris;
import android.content.ContentValues;
import android.content.Context;
import android.content.UriMatcher;
import android.database.ContentObserver;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.database.sqlite.SQLiteQueryBuilder;
import android.net.Uri;
import android.os.Binder;
import android.os.Bundle;
import android.provider.DocumentsContract;
import android.util.Log;
import java.io.Closeable;
import java.util.ArrayList;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.locks.ReadWriteLock;
import kotlin.Lazy;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.io.CloseableKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

public abstract class StreamProvider extends ContentProvider implements ProviderClient {

    /* renamed from: i  reason: collision with root package name */
    public static final Companion f19356i = new Companion((DefaultConstructorMarker) null);

    /* renamed from: j  reason: collision with root package name */
    private static final UriMatcher f19357j;

    /* renamed from: b  reason: collision with root package name */
    private final Map<String, String> f19358b = MapsKt__MapsKt.j(TuplesKt.a("_id", "_id"), TuplesKt.a("streamUri", "streamUri"), TuplesKt.a("provider", "provider"), TuplesKt.a("resolvedUrl", "resolvedUrl"), TuplesKt.a("update_at", "update_at"), TuplesKt.a("type", "type"));

    /* renamed from: c  reason: collision with root package name */
    private DatabaseHelper f19359c;

    /* renamed from: d  reason: collision with root package name */
    private String f19360d;

    /* renamed from: e  reason: collision with root package name */
    private final Lazy f19361e = LazyKt__LazyJVMKt.b(new StreamProvider$contentUri$2(this));

    /* renamed from: f  reason: collision with root package name */
    private final ThreadLocal<Boolean> f19362f = new ThreadLocal<>();

    /* renamed from: g  reason: collision with root package name */
    private final ThreadLocal<Set<Uri>> f19363g = new ThreadLocal<>();

    /* renamed from: h  reason: collision with root package name */
    private final ConcurrentMap<Long, ReadWriteLock> f19364h = new ConcurrentHashMap();

    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public static final class DatabaseHelper extends SQLiteOpenHelper {

        /* renamed from: b  reason: collision with root package name */
        public static final Companion f19365b = new Companion((DefaultConstructorMarker) null);

        public static final class Companion {
            private Companion() {
            }

            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public DatabaseHelper(Context context, String str) {
            super(context, str, (SQLiteDatabase.CursorFactory) null, 1);
            Intrinsics.f(context, "context");
            Intrinsics.f(str, "databaseName");
        }

        public void onCreate(SQLiteDatabase sQLiteDatabase) {
            Intrinsics.f(sQLiteDatabase, "db");
            sQLiteDatabase.execSQL("CREATE TABLE StreamEntity (_id INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL,streamUri TEXT,provider TEXT,resolvedUrl TEXT,type TEXT,update_at LONG);");
        }

        public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i2, int i3) {
            Intrinsics.f(sQLiteDatabase, "db");
        }
    }

    static {
        UriMatcher uriMatcher = new UriMatcher(-1);
        uriMatcher.addURI("com.domain.api.provider", "StreamEntity", 1);
        f19357j = uriMatcher;
    }

    private final boolean c() {
        if (this.f19362f.get() != null) {
            Boolean bool = this.f19362f.get();
            Intrinsics.c(bool);
            if (bool.booleanValue()) {
                return true;
            }
        }
        return false;
    }

    public final Uri a() {
        return (Uri) this.f19361e.getValue();
    }

    public ContentProviderResult[] applyBatch(ArrayList<ContentProviderOperation> arrayList) {
        Intrinsics.f(arrayList, "operations");
        ContentProviderResult[] applyBatch = super.applyBatch(arrayList);
        Intrinsics.e(applyBatch, "super.applyBatch(operations)");
        return applyBatch;
    }

    public Uri b(ContentValues contentValues) {
        Intrinsics.f(contentValues, "initialValues");
        return insert(a(), contentValues);
    }

    /* JADX INFO: finally extract failed */
    public Bundle call(String str, String str2, Bundle bundle) {
        Intrinsics.f(str, "method");
        if (getContext() == null) {
            return null;
        }
        long clearCallingIdentity = Binder.clearCallingIdentity();
        if (Log.isLoggable("StreamProvider", 2)) {
            Log.v("StreamProvider", "Received command " + str + " with arg \"" + str2 + "\" and extras " + bundle);
        }
        try {
            if (Intrinsics.a(str, "com.features.extension.appget_stream")) {
                d(clearCallingIdentity, bundle);
            } else if (Intrinsics.a(str, "com.features.extension.appget_version")) {
                Bundle bundle2 = new Bundle();
                bundle2.putInt("com.features.extension.appkey_version", 100);
                Binder.restoreCallingIdentity(clearCallingIdentity);
                return bundle2;
            }
            Binder.restoreCallingIdentity(clearCallingIdentity);
            return super.call(str, str2, bundle);
        } catch (Throwable th) {
            Binder.restoreCallingIdentity(clearCallingIdentity);
            throw th;
        }
    }

    public abstract void d(long j2, Bundle bundle);

    public int delete(Uri uri, String str, String[] strArr) {
        Intrinsics.f(uri, "uri");
        throw new UnsupportedOperationException("Deletes are not supported");
    }

    public Uri insert(Uri uri, ContentValues contentValues) {
        ContentValues contentValues2;
        boolean z2;
        Throwable th;
        int columnIndex;
        Intrinsics.f(uri, "uri");
        if (contentValues == null) {
            contentValues2 = new ContentValues();
        } else {
            contentValues2 = contentValues;
        }
        Context context = getContext();
        if (context == null) {
            throw new IllegalStateException("Called insert() before onCreate()");
        } else if (!contentValues2.containsKey("streamUri")) {
            return null;
        } else {
            String asString = contentValues2.getAsString("streamUri");
            if (asString == null || asString.length() == 0) {
                z2 = true;
            } else {
                z2 = false;
            }
            if (z2) {
                if (asString != null && Log.isLoggable("StreamProvider", 4)) {
                    Log.i("StreamProvider", "streamUri must be non-empty if included");
                }
                contentValues2.remove(asString);
            } else {
                Intrinsics.e(asString, "token");
                Closeable query = query(uri, (String[]) null, "streamUri=?", new String[]{asString}, (String) null);
                try {
                    Cursor cursor = (Cursor) query;
                    if (!cursor.moveToFirst() || (columnIndex = cursor.getColumnIndex("_id")) <= -1) {
                        Unit unit = Unit.f40298a;
                        CloseableKt.a(query, (Throwable) null);
                    } else {
                        long j2 = cursor.getLong(columnIndex);
                        Uri withAppendedId = ContentUris.withAppendedId(a(), j2);
                        Intrinsics.e(withAppendedId, "withAppendedId(contentUri, id)");
                        contentValues2.clear();
                        contentValues2.put("update_at", Long.valueOf(System.currentTimeMillis()));
                        DatabaseHelper databaseHelper = this.f19359c;
                        if (databaseHelper == null) {
                            Intrinsics.x("databaseHelper");
                            databaseHelper = null;
                        }
                        databaseHelper.getWritableDatabase().update("StreamEntity", contentValues2, "_id=?", new String[]{String.valueOf(j2)});
                        CloseableKt.a(query, (Throwable) null);
                        return withAppendedId;
                    }
                } catch (Throwable th2) {
                    Throwable th3 = th2;
                    CloseableKt.a(query, th);
                    throw th3;
                }
            }
            contentValues2.put("update_at", Long.valueOf(System.currentTimeMillis()));
            DatabaseHelper databaseHelper2 = this.f19359c;
            if (databaseHelper2 == null) {
                Intrinsics.x("databaseHelper");
                databaseHelper2 = null;
            }
            SQLiteDatabase writableDatabase = databaseHelper2.getWritableDatabase();
            writableDatabase.beginTransaction();
            long insert = writableDatabase.insert("StreamEntity", "update_at", contentValues2);
            if (insert <= 0) {
                writableDatabase.endTransaction();
                return null;
            }
            writableDatabase.setTransactionSuccessful();
            writableDatabase.endTransaction();
            Uri withAppendedId2 = ContentUris.withAppendedId(a(), insert);
            Intrinsics.e(withAppendedId2, "withAppendedId(contentUri, rowId)");
            if (c()) {
                Set<Uri> set = this.f19363g.get();
                Intrinsics.c(set);
                set.add(a());
            } else {
                if (Log.isLoggable("StreamProvider", 2)) {
                    Log.v("StreamProvider", Intrinsics.o("Notified for insert on ", withAppendedId2));
                }
                context.getContentResolver().notifyChange(withAppendedId2, (ContentObserver) null);
            }
            return withAppendedId2;
        }
    }

    public boolean onCreate() {
        String str;
        String authority = a().getAuthority();
        Intrinsics.c(authority);
        Intrinsics.e(authority, "contentUri.authority!!");
        this.f19360d = authority;
        if (authority == null) {
            Intrinsics.x("authority");
            authority = null;
        }
        String str2 = this.f19360d;
        if (str2 == null) {
            Intrinsics.x("authority");
            str = null;
        } else {
            str = str2;
        }
        String substring = authority.substring(StringsKt__StringsKt.a0(str, '.', 0, false, 6, (Object) null) + 1);
        Intrinsics.e(substring, "this as java.lang.String).substring(startIndex)");
        Context context = getContext();
        Intrinsics.c(context);
        Intrinsics.e(context, "context!!");
        this.f19359c = new DatabaseHelper(context, substring);
        return true;
    }

    public Cursor query(Uri uri, String[] strArr, String str, String[] strArr2, String str2) {
        ContentResolver contentResolver;
        String str3;
        Uri uri2 = uri;
        Intrinsics.f(uri, "uri");
        Context context = getContext();
        DatabaseHelper databaseHelper = null;
        if (context == null) {
            contentResolver = null;
        } else {
            contentResolver = context.getContentResolver();
        }
        if (contentResolver != null) {
            SQLiteQueryBuilder sQLiteQueryBuilder = new SQLiteQueryBuilder();
            sQLiteQueryBuilder.setTables("StreamEntity");
            sQLiteQueryBuilder.setProjectionMap(this.f19358b);
            boolean z2 = true;
            sQLiteQueryBuilder.setStrict(true);
            DatabaseHelper databaseHelper2 = this.f19359c;
            if (databaseHelper2 == null) {
                Intrinsics.x("databaseHelper");
            } else {
                databaseHelper = databaseHelper2;
            }
            SQLiteDatabase readableDatabase = databaseHelper.getReadableDatabase();
            if (!Intrinsics.a(uri, a())) {
                sQLiteQueryBuilder.appendWhere(Intrinsics.o("_id=", uri.getLastPathSegment()));
            }
            if (!(str2 == null || str2.length() == 0)) {
                z2 = false;
            }
            if (z2) {
                str3 = "update_at DESC";
            } else {
                str3 = str2;
            }
            Cursor query = sQLiteQueryBuilder.query(readableDatabase, strArr, str, strArr2, (String) null, (String) null, str3, (String) null);
            query.setNotificationUri(contentResolver, uri);
            Intrinsics.e(query, "c");
            return query;
        }
        throw new IllegalStateException("Called query() before onCreate()");
    }

    public int update(Uri uri, ContentValues contentValues, String str, String[] strArr) {
        Intrinsics.f(uri, "uri");
        if (contentValues == null) {
            return 0;
        }
        DatabaseHelper databaseHelper = this.f19359c;
        if (databaseHelper == null) {
            Intrinsics.x("databaseHelper");
            databaseHelper = null;
        }
        SQLiteDatabase writableDatabase = databaseHelper.getWritableDatabase();
        if (!Intrinsics.a(a(), uri)) {
            String o2 = Intrinsics.o("_id = ", uri.getLastPathSegment());
            if (str != null) {
                str = o2 + " AND " + str;
            } else {
                str = o2;
            }
        }
        contentValues.remove("streamUri");
        contentValues.remove("provider");
        contentValues.put("update_at", Long.valueOf(System.currentTimeMillis()));
        int update = writableDatabase.update("StreamEntity", contentValues, str, strArr);
        Context context = getContext();
        if (context != null && update > 0) {
            String str2 = this.f19360d;
            if (str2 == null) {
                Intrinsics.x("authority");
                str2 = null;
            }
            String o3 = Intrinsics.o(str2, ".documents");
            String str3 = this.f19360d;
            if (str3 == null) {
                Intrinsics.x("authority");
                str3 = null;
            }
            DocumentsContract.buildChildDocumentsUri(o3, str3);
            if (c()) {
                Set<Uri> set = this.f19363g.get();
                Intrinsics.c(set);
                set.add(a());
            } else {
                if (Log.isLoggable("StreamProvider", 2)) {
                    Log.v("StreamProvider", Intrinsics.o("Notified for update on ", uri));
                }
                context.getContentResolver().notifyChange(uri, (ContentObserver) null);
            }
        }
        return update;
    }
}
