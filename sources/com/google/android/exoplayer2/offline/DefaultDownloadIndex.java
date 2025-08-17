package com.google.android.exoplayer2.offline;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.net.Uri;
import android.text.TextUtils;
import com.google.android.exoplayer2.database.DatabaseIOException;
import com.google.android.exoplayer2.database.DatabaseProvider;
import com.google.android.exoplayer2.database.VersionTable;
import com.google.android.exoplayer2.offline.DownloadRequest;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.Util;
import com.unity3d.services.core.request.metrics.AdOperationMetric;
import java.util.ArrayList;
import java.util.List;

public final class DefaultDownloadIndex implements WritableDownloadIndex {

    /* renamed from: f  reason: collision with root package name */
    private static final String f25508f = p(3, 4);

    /* renamed from: g  reason: collision with root package name */
    private static final String[] f25509g = {"id", "mime_type", "uri", "stream_keys", "custom_cache_key", "data", AdOperationMetric.INIT_STATE, "start_time_ms", "update_time_ms", "content_length", DownloadService.KEY_STOP_REASON, "failure_reason", "percent_downloaded", "bytes_downloaded", "key_set_id"};

    /* renamed from: a  reason: collision with root package name */
    private final String f25510a;

    /* renamed from: b  reason: collision with root package name */
    private final String f25511b;

    /* renamed from: c  reason: collision with root package name */
    private final DatabaseProvider f25512c;

    /* renamed from: d  reason: collision with root package name */
    private final Object f25513d;

    /* renamed from: e  reason: collision with root package name */
    private boolean f25514e;

    private static final class DownloadCursorImpl implements DownloadCursor {

        /* renamed from: b  reason: collision with root package name */
        private final Cursor f25515b;

        public Download I() {
            return DefaultDownloadIndex.n(this.f25515b);
        }

        public void close() {
            this.f25515b.close();
        }

        public int getPosition() {
            return this.f25515b.getPosition();
        }

        public /* synthetic */ boolean moveToNext() {
            return a.a(this);
        }

        public boolean moveToPosition(int i2) {
            return this.f25515b.moveToPosition(i2);
        }

        private DownloadCursorImpl(Cursor cursor) {
            this.f25515b = cursor;
        }
    }

    public DefaultDownloadIndex(DatabaseProvider databaseProvider) {
        this(databaseProvider, "");
    }

    private static List<StreamKey> j(String str) {
        boolean z2;
        ArrayList arrayList = new ArrayList();
        if (TextUtils.isEmpty(str)) {
            return arrayList;
        }
        for (String W0 : Util.W0(str, ",")) {
            String[] W02 = Util.W0(W0, "\\.");
            if (W02.length == 3) {
                z2 = true;
            } else {
                z2 = false;
            }
            Assertions.g(z2);
            arrayList.add(new StreamKey(Integer.parseInt(W02[0]), Integer.parseInt(W02[1]), Integer.parseInt(W02[2])));
        }
        return arrayList;
    }

    static String k(List<StreamKey> list) {
        StringBuilder sb = new StringBuilder();
        for (int i2 = 0; i2 < list.size(); i2++) {
            StreamKey streamKey = list.get(i2);
            sb.append(streamKey.f25636b);
            sb.append('.');
            sb.append(streamKey.f25637c);
            sb.append('.');
            sb.append(streamKey.f25638d);
            sb.append(',');
        }
        if (sb.length() > 0) {
            sb.setLength(sb.length() - 1);
        }
        return sb.toString();
    }

    private void l() throws DatabaseIOException {
        SQLiteDatabase writableDatabase;
        List<Download> list;
        synchronized (this.f25513d) {
            if (!this.f25514e) {
                try {
                    int b2 = VersionTable.b(this.f25512c.getReadableDatabase(), 0, this.f25510a);
                    if (b2 != 3) {
                        writableDatabase = this.f25512c.getWritableDatabase();
                        writableDatabase.beginTransactionNonExclusive();
                        VersionTable.d(writableDatabase, 0, this.f25510a, 3);
                        if (b2 == 2) {
                            list = r(writableDatabase);
                        } else {
                            list = new ArrayList<>();
                        }
                        writableDatabase.execSQL("DROP TABLE IF EXISTS " + this.f25511b);
                        writableDatabase.execSQL("CREATE TABLE " + this.f25511b + " " + "(id TEXT PRIMARY KEY NOT NULL,mime_type TEXT,uri TEXT NOT NULL,stream_keys TEXT NOT NULL,custom_cache_key TEXT,data BLOB NOT NULL,state INTEGER NOT NULL,start_time_ms INTEGER NOT NULL,update_time_ms INTEGER NOT NULL,content_length INTEGER NOT NULL,stop_reason INTEGER NOT NULL,failure_reason INTEGER NOT NULL,percent_downloaded REAL NOT NULL,bytes_downloaded INTEGER NOT NULL,key_set_id BLOB NOT NULL)");
                        for (Download s2 : list) {
                            s(s2, writableDatabase);
                        }
                        writableDatabase.setTransactionSuccessful();
                        writableDatabase.endTransaction();
                    }
                    this.f25514e = true;
                } catch (SQLException e2) {
                    throw new DatabaseIOException(e2);
                } catch (Throwable th) {
                    writableDatabase.endTransaction();
                    throw th;
                }
            }
        }
    }

    private Cursor m(String str, String[] strArr) throws DatabaseIOException {
        try {
            return this.f25512c.getReadableDatabase().query(this.f25511b, f25509g, str, strArr, (String) null, (String) null, "start_time_ms ASC");
        } catch (SQLiteException e2) {
            throw new DatabaseIOException(e2);
        }
    }

    /* access modifiers changed from: private */
    public static Download n(Cursor cursor) {
        int i2;
        byte[] blob = cursor.getBlob(14);
        DownloadRequest.Builder f2 = new DownloadRequest.Builder((String) Assertions.e(cursor.getString(0)), Uri.parse((String) Assertions.e(cursor.getString(2)))).e(cursor.getString(1)).f(j(cursor.getString(3)));
        if (blob.length <= 0) {
            blob = null;
        }
        DownloadRequest a2 = f2.d(blob).b(cursor.getString(4)).c(cursor.getBlob(5)).a();
        DownloadProgress downloadProgress = new DownloadProgress();
        downloadProgress.f25570a = cursor.getLong(13);
        downloadProgress.f25571b = cursor.getFloat(12);
        int i3 = cursor.getInt(6);
        if (i3 == 4) {
            i2 = cursor.getInt(11);
        } else {
            i2 = 0;
        }
        return new Download(a2, i3, cursor.getLong(7), cursor.getLong(8), cursor.getLong(9), cursor.getInt(10), i2, downloadProgress);
    }

    private static Download o(Cursor cursor) {
        int i2;
        DownloadRequest a2 = new DownloadRequest.Builder((String) Assertions.e(cursor.getString(0)), Uri.parse((String) Assertions.e(cursor.getString(2)))).e(q(cursor.getString(1))).f(j(cursor.getString(3))).b(cursor.getString(4)).c(cursor.getBlob(5)).a();
        DownloadProgress downloadProgress = new DownloadProgress();
        downloadProgress.f25570a = cursor.getLong(13);
        downloadProgress.f25571b = cursor.getFloat(12);
        int i3 = cursor.getInt(6);
        if (i3 == 4) {
            i2 = cursor.getInt(11);
        } else {
            i2 = 0;
        }
        return new Download(a2, i3, cursor.getLong(7), cursor.getLong(8), cursor.getLong(9), cursor.getInt(10), i2, downloadProgress);
    }

    private static String p(int... iArr) {
        if (iArr.length == 0) {
            return "1";
        }
        StringBuilder sb = new StringBuilder();
        sb.append(AdOperationMetric.INIT_STATE);
        sb.append(" IN (");
        for (int i2 = 0; i2 < iArr.length; i2++) {
            if (i2 > 0) {
                sb.append(',');
            }
            sb.append(iArr[i2]);
        }
        sb.append(')');
        return sb.toString();
    }

    private static String q(String str) {
        if ("dash".equals(str)) {
            return "application/dash+xml";
        }
        if ("hls".equals(str)) {
            return "application/x-mpegURL";
        }
        if ("ss".equals(str)) {
            return "application/vnd.ms-sstr+xml";
        }
        return "video/x-unknown";
    }

    private List<Download> r(SQLiteDatabase sQLiteDatabase) {
        Throwable th;
        ArrayList arrayList = new ArrayList();
        if (!Util.b1(sQLiteDatabase, this.f25511b)) {
            return arrayList;
        }
        SQLiteDatabase sQLiteDatabase2 = sQLiteDatabase;
        Cursor query = sQLiteDatabase2.query(this.f25511b, new String[]{"id", "title", "uri", "stream_keys", "custom_cache_key", "data", AdOperationMetric.INIT_STATE, "start_time_ms", "update_time_ms", "content_length", DownloadService.KEY_STOP_REASON, "failure_reason", "percent_downloaded", "bytes_downloaded"}, (String) null, (String[]) null, (String) null, (String) null, (String) null);
        while (query.moveToNext()) {
            try {
                arrayList.add(o(query));
            } catch (Throwable th2) {
                th.addSuppressed(th2);
            }
        }
        query.close();
        return arrayList;
        throw th;
    }

    private void s(Download download, SQLiteDatabase sQLiteDatabase) {
        byte[] bArr = download.f25519a.f25576f;
        if (bArr == null) {
            bArr = Util.f28813f;
        }
        ContentValues contentValues = new ContentValues();
        contentValues.put("id", download.f25519a.f25572b);
        contentValues.put("mime_type", download.f25519a.f25574d);
        contentValues.put("uri", download.f25519a.f25573c.toString());
        contentValues.put("stream_keys", k(download.f25519a.f25575e));
        contentValues.put("custom_cache_key", download.f25519a.f25577g);
        contentValues.put("data", download.f25519a.f25578h);
        contentValues.put(AdOperationMetric.INIT_STATE, Integer.valueOf(download.f25520b));
        contentValues.put("start_time_ms", Long.valueOf(download.f25521c));
        contentValues.put("update_time_ms", Long.valueOf(download.f25522d));
        contentValues.put("content_length", Long.valueOf(download.f25523e));
        contentValues.put(DownloadService.KEY_STOP_REASON, Integer.valueOf(download.f25524f));
        contentValues.put("failure_reason", Integer.valueOf(download.f25525g));
        contentValues.put("percent_downloaded", Float.valueOf(download.b()));
        contentValues.put("bytes_downloaded", Long.valueOf(download.a()));
        contentValues.put("key_set_id", bArr);
        sQLiteDatabase.replaceOrThrow(this.f25511b, (String) null, contentValues);
    }

    public void a(String str, int i2) throws DatabaseIOException {
        l();
        try {
            ContentValues contentValues = new ContentValues();
            contentValues.put(DownloadService.KEY_STOP_REASON, Integer.valueOf(i2));
            SQLiteDatabase writableDatabase = this.f25512c.getWritableDatabase();
            String str2 = this.f25511b;
            writableDatabase.update(str2, contentValues, f25508f + " AND " + "id = ?", new String[]{str});
        } catch (SQLException e2) {
            throw new DatabaseIOException(e2);
        }
    }

    public void b(String str) throws DatabaseIOException {
        l();
        try {
            this.f25512c.getWritableDatabase().delete(this.f25511b, "id = ?", new String[]{str});
        } catch (SQLiteException e2) {
            throw new DatabaseIOException(e2);
        }
    }

    public void c(int i2) throws DatabaseIOException {
        l();
        try {
            ContentValues contentValues = new ContentValues();
            contentValues.put(DownloadService.KEY_STOP_REASON, Integer.valueOf(i2));
            this.f25512c.getWritableDatabase().update(this.f25511b, contentValues, f25508f, (String[]) null);
        } catch (SQLException e2) {
            throw new DatabaseIOException(e2);
        }
    }

    public DownloadCursor d(int... iArr) throws DatabaseIOException {
        l();
        return new DownloadCursorImpl(m(p(iArr), (String[]) null));
    }

    public void e() throws DatabaseIOException {
        l();
        try {
            ContentValues contentValues = new ContentValues();
            contentValues.put(AdOperationMetric.INIT_STATE, 5);
            contentValues.put("failure_reason", 0);
            this.f25512c.getWritableDatabase().update(this.f25511b, contentValues, (String) null, (String[]) null);
        } catch (SQLException e2) {
            throw new DatabaseIOException(e2);
        }
    }

    public void f() throws DatabaseIOException {
        l();
        try {
            ContentValues contentValues = new ContentValues();
            contentValues.put(AdOperationMetric.INIT_STATE, 0);
            this.f25512c.getWritableDatabase().update(this.f25511b, contentValues, "state = 2", (String[]) null);
        } catch (SQLException e2) {
            throw new DatabaseIOException(e2);
        }
    }

    public Download g(String str) throws DatabaseIOException {
        Cursor m2;
        l();
        try {
            m2 = m("id = ?", new String[]{str});
            if (m2.getCount() == 0) {
                m2.close();
                return null;
            }
            m2.moveToNext();
            Download n2 = n(m2);
            m2.close();
            return n2;
        } catch (SQLiteException e2) {
            throw new DatabaseIOException(e2);
        } catch (Throwable th) {
            th.addSuppressed(th);
        }
        throw th;
    }

    public void h(Download download) throws DatabaseIOException {
        l();
        try {
            s(download, this.f25512c.getWritableDatabase());
        } catch (SQLiteException e2) {
            throw new DatabaseIOException(e2);
        }
    }

    public DefaultDownloadIndex(DatabaseProvider databaseProvider, String str) {
        this.f25510a = str;
        this.f25512c = databaseProvider;
        this.f25511b = "ExoPlayerDownloads" + str;
        this.f25513d = new Object();
    }
}
