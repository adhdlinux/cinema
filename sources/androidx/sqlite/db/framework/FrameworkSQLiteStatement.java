package androidx.sqlite.db.framework;

import android.database.sqlite.SQLiteStatement;
import androidx.sqlite.db.SupportSQLiteStatement;

class FrameworkSQLiteStatement extends FrameworkSQLiteProgram implements SupportSQLiteStatement {

    /* renamed from: c  reason: collision with root package name */
    private final SQLiteStatement f11634c;

    FrameworkSQLiteStatement(SQLiteStatement sQLiteStatement) {
        super(sQLiteStatement);
        this.f11634c = sQLiteStatement;
    }

    public long P() {
        return this.f11634c.executeInsert();
    }

    public int j() {
        return this.f11634c.executeUpdateDelete();
    }
}
