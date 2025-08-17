package androidx.room;

import androidx.sqlite.db.SupportSQLiteStatement;
import java.util.concurrent.atomic.AtomicBoolean;

public abstract class SharedSQLiteStatement {

    /* renamed from: a  reason: collision with root package name */
    private final AtomicBoolean f11519a = new AtomicBoolean(false);

    /* renamed from: b  reason: collision with root package name */
    private final RoomDatabase f11520b;

    /* renamed from: c  reason: collision with root package name */
    private volatile SupportSQLiteStatement f11521c;

    public SharedSQLiteStatement(RoomDatabase roomDatabase) {
        this.f11520b = roomDatabase;
    }

    private SupportSQLiteStatement c() {
        return this.f11520b.d(d());
    }

    private SupportSQLiteStatement e(boolean z2) {
        if (!z2) {
            return c();
        }
        if (this.f11521c == null) {
            this.f11521c = c();
        }
        return this.f11521c;
    }

    public SupportSQLiteStatement a() {
        b();
        return e(this.f11519a.compareAndSet(false, true));
    }

    /* access modifiers changed from: protected */
    public void b() {
        this.f11520b.a();
    }

    /* access modifiers changed from: protected */
    public abstract String d();

    public void f(SupportSQLiteStatement supportSQLiteStatement) {
        if (supportSQLiteStatement == this.f11521c) {
            this.f11519a.set(false);
        }
    }
}
