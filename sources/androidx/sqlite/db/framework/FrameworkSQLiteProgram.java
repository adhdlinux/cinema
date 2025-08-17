package androidx.sqlite.db.framework;

import android.database.sqlite.SQLiteProgram;
import androidx.sqlite.db.SupportSQLiteProgram;

class FrameworkSQLiteProgram implements SupportSQLiteProgram {

    /* renamed from: b  reason: collision with root package name */
    private final SQLiteProgram f11633b;

    FrameworkSQLiteProgram(SQLiteProgram sQLiteProgram) {
        this.f11633b = sQLiteProgram;
    }

    public void R(int i2, String str) {
        this.f11633b.bindString(i2, str);
    }

    public void X(int i2, long j2) {
        this.f11633b.bindLong(i2, j2);
    }

    public void Y(int i2, byte[] bArr) {
        this.f11633b.bindBlob(i2, bArr);
    }

    public void close() {
        this.f11633b.close();
    }

    public void d0(int i2) {
        this.f11633b.bindNull(i2);
    }

    public void l(int i2, double d2) {
        this.f11633b.bindDouble(i2, d2);
    }
}
