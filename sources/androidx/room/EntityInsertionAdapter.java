package androidx.room;

import androidx.sqlite.db.SupportSQLiteStatement;

public abstract class EntityInsertionAdapter<T> extends SharedSQLiteStatement {
    public EntityInsertionAdapter(RoomDatabase roomDatabase) {
        super(roomDatabase);
    }

    /* access modifiers changed from: protected */
    public abstract void g(SupportSQLiteStatement supportSQLiteStatement, T t2);

    public final void h(T t2) {
        SupportSQLiteStatement a2 = a();
        try {
            g(a2, t2);
            a2.P();
        } finally {
            f(a2);
        }
    }

    public final void i(T[] tArr) {
        SupportSQLiteStatement a2 = a();
        try {
            for (T g2 : tArr) {
                g(a2, g2);
                a2.P();
            }
        } finally {
            f(a2);
        }
    }
}
