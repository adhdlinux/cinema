package androidx.sqlite.db.framework;

import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteCursor;
import android.database.sqlite.SQLiteCursorDriver;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteQuery;
import android.os.CancellationSignal;
import android.util.Pair;
import androidx.sqlite.db.SimpleSQLiteQuery;
import androidx.sqlite.db.SupportSQLiteDatabase;
import androidx.sqlite.db.SupportSQLiteQuery;
import androidx.sqlite.db.SupportSQLiteStatement;
import java.io.IOException;
import java.util.List;

class FrameworkSQLiteDatabase implements SupportSQLiteDatabase {

    /* renamed from: c  reason: collision with root package name */
    private static final String[] f11614c = {"", " OR ROLLBACK ", " OR ABORT ", " OR FAIL ", " OR IGNORE ", " OR REPLACE "};

    /* renamed from: d  reason: collision with root package name */
    private static final String[] f11615d = new String[0];

    /* renamed from: b  reason: collision with root package name */
    private final SQLiteDatabase f11616b;

    FrameworkSQLiteDatabase(SQLiteDatabase sQLiteDatabase) {
        this.f11616b = sQLiteDatabase;
    }

    public Cursor C(final SupportSQLiteQuery supportSQLiteQuery) {
        return this.f11616b.rawQueryWithFactory(new SQLiteDatabase.CursorFactory() {
            public Cursor newCursor(SQLiteDatabase sQLiteDatabase, SQLiteCursorDriver sQLiteCursorDriver, String str, SQLiteQuery sQLiteQuery) {
                supportSQLiteQuery.f(new FrameworkSQLiteProgram(sQLiteQuery));
                return new SQLiteCursor(sQLiteCursorDriver, str, sQLiteQuery);
            }
        }, supportSQLiteQuery.a(), f11615d, (String) null);
    }

    public SupportSQLiteStatement S(String str) {
        return new FrameworkSQLiteStatement(this.f11616b.compileStatement(str));
    }

    public Cursor Z(String str) {
        return C(new SimpleSQLiteQuery(str));
    }

    /* access modifiers changed from: package-private */
    public boolean a(SQLiteDatabase sQLiteDatabase) {
        return this.f11616b == sQLiteDatabase;
    }

    public void beginTransaction() {
        this.f11616b.beginTransaction();
    }

    public void close() throws IOException {
        this.f11616b.close();
    }

    public List<Pair<String, String>> e() {
        return this.f11616b.getAttachedDbs();
    }

    public boolean e0() {
        return this.f11616b.inTransaction();
    }

    public void endTransaction() {
        this.f11616b.endTransaction();
    }

    public void g(String str) throws SQLException {
        this.f11616b.execSQL(str);
    }

    public String getPath() {
        return this.f11616b.getPath();
    }

    public boolean isOpen() {
        return this.f11616b.isOpen();
    }

    public Cursor n(final SupportSQLiteQuery supportSQLiteQuery, CancellationSignal cancellationSignal) {
        return this.f11616b.rawQueryWithFactory(new SQLiteDatabase.CursorFactory() {
            public Cursor newCursor(SQLiteDatabase sQLiteDatabase, SQLiteCursorDriver sQLiteCursorDriver, String str, SQLiteQuery sQLiteQuery) {
                supportSQLiteQuery.f(new FrameworkSQLiteProgram(sQLiteQuery));
                return new SQLiteCursor(sQLiteCursorDriver, str, sQLiteQuery);
            }
        }, supportSQLiteQuery.a(), f11615d, (String) null, cancellationSignal);
    }

    public void setTransactionSuccessful() {
        this.f11616b.setTransactionSuccessful();
    }

    public void u(String str, Object[] objArr) throws SQLException {
        this.f11616b.execSQL(str, objArr);
    }
}
