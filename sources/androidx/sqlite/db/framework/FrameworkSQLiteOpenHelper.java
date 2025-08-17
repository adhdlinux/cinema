package androidx.sqlite.db.framework;

import android.content.Context;
import android.database.DatabaseErrorHandler;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Build;
import androidx.sqlite.db.SupportSQLiteDatabase;
import androidx.sqlite.db.SupportSQLiteOpenHelper;
import java.io.File;

class FrameworkSQLiteOpenHelper implements SupportSQLiteOpenHelper {

    /* renamed from: b  reason: collision with root package name */
    private final Context f11621b;

    /* renamed from: c  reason: collision with root package name */
    private final String f11622c;

    /* renamed from: d  reason: collision with root package name */
    private final SupportSQLiteOpenHelper.Callback f11623d;

    /* renamed from: e  reason: collision with root package name */
    private final boolean f11624e;

    /* renamed from: f  reason: collision with root package name */
    private final Object f11625f = new Object();

    /* renamed from: g  reason: collision with root package name */
    private OpenHelper f11626g;

    /* renamed from: h  reason: collision with root package name */
    private boolean f11627h;

    static class OpenHelper extends SQLiteOpenHelper {

        /* renamed from: b  reason: collision with root package name */
        final FrameworkSQLiteDatabase[] f11628b;

        /* renamed from: c  reason: collision with root package name */
        final SupportSQLiteOpenHelper.Callback f11629c;

        /* renamed from: d  reason: collision with root package name */
        private boolean f11630d;

        OpenHelper(Context context, String str, final FrameworkSQLiteDatabase[] frameworkSQLiteDatabaseArr, final SupportSQLiteOpenHelper.Callback callback) {
            super(context, str, (SQLiteDatabase.CursorFactory) null, callback.f11605a, new DatabaseErrorHandler() {
                public void onCorruption(SQLiteDatabase sQLiteDatabase) {
                    SupportSQLiteOpenHelper.Callback.this.c(OpenHelper.f(frameworkSQLiteDatabaseArr, sQLiteDatabase));
                }
            });
            this.f11629c = callback;
            this.f11628b = frameworkSQLiteDatabaseArr;
        }

        static FrameworkSQLiteDatabase f(FrameworkSQLiteDatabase[] frameworkSQLiteDatabaseArr, SQLiteDatabase sQLiteDatabase) {
            FrameworkSQLiteDatabase frameworkSQLiteDatabase = frameworkSQLiteDatabaseArr[0];
            if (frameworkSQLiteDatabase == null || !frameworkSQLiteDatabase.a(sQLiteDatabase)) {
                frameworkSQLiteDatabaseArr[0] = new FrameworkSQLiteDatabase(sQLiteDatabase);
            }
            return frameworkSQLiteDatabaseArr[0];
        }

        /* access modifiers changed from: package-private */
        public FrameworkSQLiteDatabase a(SQLiteDatabase sQLiteDatabase) {
            return f(this.f11628b, sQLiteDatabase);
        }

        public synchronized void close() {
            super.close();
            this.f11628b[0] = null;
        }

        /* access modifiers changed from: package-private */
        public synchronized SupportSQLiteDatabase i() {
            this.f11630d = false;
            SQLiteDatabase writableDatabase = super.getWritableDatabase();
            if (this.f11630d) {
                close();
                return i();
            }
            return a(writableDatabase);
        }

        public void onConfigure(SQLiteDatabase sQLiteDatabase) {
            this.f11629c.b(a(sQLiteDatabase));
        }

        public void onCreate(SQLiteDatabase sQLiteDatabase) {
            this.f11629c.d(a(sQLiteDatabase));
        }

        public void onDowngrade(SQLiteDatabase sQLiteDatabase, int i2, int i3) {
            this.f11630d = true;
            this.f11629c.e(a(sQLiteDatabase), i2, i3);
        }

        public void onOpen(SQLiteDatabase sQLiteDatabase) {
            if (!this.f11630d) {
                this.f11629c.f(a(sQLiteDatabase));
            }
        }

        public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i2, int i3) {
            this.f11630d = true;
            this.f11629c.g(a(sQLiteDatabase), i2, i3);
        }
    }

    FrameworkSQLiteOpenHelper(Context context, String str, SupportSQLiteOpenHelper.Callback callback, boolean z2) {
        this.f11621b = context;
        this.f11622c = str;
        this.f11623d = callback;
        this.f11624e = z2;
    }

    private OpenHelper a() {
        OpenHelper openHelper;
        synchronized (this.f11625f) {
            if (this.f11626g == null) {
                FrameworkSQLiteDatabase[] frameworkSQLiteDatabaseArr = new FrameworkSQLiteDatabase[1];
                if (Build.VERSION.SDK_INT < 23 || this.f11622c == null || !this.f11624e) {
                    this.f11626g = new OpenHelper(this.f11621b, this.f11622c, frameworkSQLiteDatabaseArr, this.f11623d);
                } else {
                    this.f11626g = new OpenHelper(this.f11621b, new File(this.f11621b.getNoBackupFilesDir(), this.f11622c).getAbsolutePath(), frameworkSQLiteDatabaseArr, this.f11623d);
                }
                this.f11626g.setWriteAheadLoggingEnabled(this.f11627h);
            }
            openHelper = this.f11626g;
        }
        return openHelper;
    }

    public void close() {
        a().close();
    }

    public String getDatabaseName() {
        return this.f11622c;
    }

    public SupportSQLiteDatabase getWritableDatabase() {
        return a().i();
    }

    public void setWriteAheadLoggingEnabled(boolean z2) {
        synchronized (this.f11625f) {
            OpenHelper openHelper = this.f11626g;
            if (openHelper != null) {
                openHelper.setWriteAheadLoggingEnabled(z2);
            }
            this.f11627h = z2;
        }
    }
}
