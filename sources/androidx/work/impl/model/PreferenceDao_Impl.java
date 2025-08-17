package androidx.work.impl.model;

import android.database.Cursor;
import android.os.CancellationSignal;
import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.room.util.DBUtil;
import androidx.sqlite.db.SupportSQLiteStatement;

public final class PreferenceDao_Impl implements PreferenceDao {

    /* renamed from: a  reason: collision with root package name */
    private final RoomDatabase f12490a;

    /* renamed from: b  reason: collision with root package name */
    private final EntityInsertionAdapter<Preference> f12491b;

    public PreferenceDao_Impl(RoomDatabase roomDatabase) {
        this.f12490a = roomDatabase;
        this.f12491b = new EntityInsertionAdapter<Preference>(roomDatabase) {
            public String d() {
                return "INSERT OR REPLACE INTO `Preference` (`key`,`long_value`) VALUES (?,?)";
            }

            /* renamed from: j */
            public void g(SupportSQLiteStatement supportSQLiteStatement, Preference preference) {
                String str = preference.f12488a;
                if (str == null) {
                    supportSQLiteStatement.d0(1);
                } else {
                    supportSQLiteStatement.R(1, str);
                }
                Long l2 = preference.f12489b;
                if (l2 == null) {
                    supportSQLiteStatement.d0(2);
                } else {
                    supportSQLiteStatement.X(2, l2.longValue());
                }
            }
        };
    }

    public void a(Preference preference) {
        this.f12490a.b();
        this.f12490a.c();
        try {
            this.f12491b.h(preference);
            this.f12490a.t();
        } finally {
            this.f12490a.g();
        }
    }

    public Long b(String str) {
        RoomSQLiteQuery i2 = RoomSQLiteQuery.i("SELECT long_value FROM Preference where `key`=?", 1);
        if (str == null) {
            i2.d0(1);
        } else {
            i2.R(1, str);
        }
        this.f12490a.b();
        Long l2 = null;
        Cursor c2 = DBUtil.c(this.f12490a, i2, false, (CancellationSignal) null);
        try {
            if (c2.moveToFirst()) {
                if (!c2.isNull(0)) {
                    l2 = Long.valueOf(c2.getLong(0));
                }
            }
            return l2;
        } finally {
            c2.close();
            i2.release();
        }
    }
}
