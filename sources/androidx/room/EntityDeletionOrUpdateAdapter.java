package androidx.room;

import androidx.sqlite.db.SupportSQLiteStatement;

public abstract class EntityDeletionOrUpdateAdapter<T> extends SharedSQLiteStatement {
    public EntityDeletionOrUpdateAdapter(RoomDatabase roomDatabase) {
        super(roomDatabase);
    }

    /* access modifiers changed from: protected */
    public abstract void g(SupportSQLiteStatement supportSQLiteStatement, T t2);

    public final int h(T[] tArr) {
        SupportSQLiteStatement a2 = a();
        try {
            int i2 = 0;
            for (T g2 : tArr) {
                g(a2, g2);
                i2 += a2.j();
            }
            return i2;
        } finally {
            f(a2);
        }
    }
}
