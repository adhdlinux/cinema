package androidx.room.migration;

import androidx.sqlite.db.SupportSQLiteDatabase;

public abstract class Migration {

    /* renamed from: a  reason: collision with root package name */
    public final int f11527a;

    /* renamed from: b  reason: collision with root package name */
    public final int f11528b;

    public Migration(int i2, int i3) {
        this.f11527a = i2;
        this.f11528b = i3;
    }

    public abstract void a(SupportSQLiteDatabase supportSQLiteDatabase);
}
