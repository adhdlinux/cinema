package androidx.work.impl.model;

import android.database.Cursor;
import android.os.CancellationSignal;
import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.room.util.DBUtil;
import androidx.sqlite.db.SupportSQLiteStatement;
import java.util.ArrayList;
import java.util.List;

public final class DependencyDao_Impl implements DependencyDao {

    /* renamed from: a  reason: collision with root package name */
    private final RoomDatabase f12485a;

    /* renamed from: b  reason: collision with root package name */
    private final EntityInsertionAdapter<Dependency> f12486b;

    public DependencyDao_Impl(RoomDatabase roomDatabase) {
        this.f12485a = roomDatabase;
        this.f12486b = new EntityInsertionAdapter<Dependency>(roomDatabase) {
            public String d() {
                return "INSERT OR IGNORE INTO `Dependency` (`work_spec_id`,`prerequisite_id`) VALUES (?,?)";
            }

            /* renamed from: j */
            public void g(SupportSQLiteStatement supportSQLiteStatement, Dependency dependency) {
                String str = dependency.f12483a;
                if (str == null) {
                    supportSQLiteStatement.d0(1);
                } else {
                    supportSQLiteStatement.R(1, str);
                }
                String str2 = dependency.f12484b;
                if (str2 == null) {
                    supportSQLiteStatement.d0(2);
                } else {
                    supportSQLiteStatement.R(2, str2);
                }
            }
        };
    }

    public void a(Dependency dependency) {
        this.f12485a.b();
        this.f12485a.c();
        try {
            this.f12486b.h(dependency);
            this.f12485a.t();
        } finally {
            this.f12485a.g();
        }
    }

    public List<String> b(String str) {
        RoomSQLiteQuery i2 = RoomSQLiteQuery.i("SELECT work_spec_id FROM dependency WHERE prerequisite_id=?", 1);
        if (str == null) {
            i2.d0(1);
        } else {
            i2.R(1, str);
        }
        this.f12485a.b();
        Cursor c2 = DBUtil.c(this.f12485a, i2, false, (CancellationSignal) null);
        try {
            ArrayList arrayList = new ArrayList(c2.getCount());
            while (c2.moveToNext()) {
                arrayList.add(c2.getString(0));
            }
            return arrayList;
        } finally {
            c2.close();
            i2.release();
        }
    }

    public boolean c(String str) {
        boolean z2 = true;
        RoomSQLiteQuery i2 = RoomSQLiteQuery.i("SELECT COUNT(*)=0 FROM dependency WHERE work_spec_id=? AND prerequisite_id IN (SELECT id FROM workspec WHERE state!=2)", 1);
        if (str == null) {
            i2.d0(1);
        } else {
            i2.R(1, str);
        }
        this.f12485a.b();
        boolean z3 = false;
        Cursor c2 = DBUtil.c(this.f12485a, i2, false, (CancellationSignal) null);
        try {
            if (c2.moveToFirst()) {
                if (c2.getInt(0) == 0) {
                    z2 = false;
                }
                z3 = z2;
            }
            return z3;
        } finally {
            c2.close();
            i2.release();
        }
    }

    public boolean d(String str) {
        boolean z2 = true;
        RoomSQLiteQuery i2 = RoomSQLiteQuery.i("SELECT COUNT(*)>0 FROM dependency WHERE prerequisite_id=?", 1);
        if (str == null) {
            i2.d0(1);
        } else {
            i2.R(1, str);
        }
        this.f12485a.b();
        boolean z3 = false;
        Cursor c2 = DBUtil.c(this.f12485a, i2, false, (CancellationSignal) null);
        try {
            if (c2.moveToFirst()) {
                if (c2.getInt(0) == 0) {
                    z2 = false;
                }
                z3 = z2;
            }
            return z3;
        } finally {
            c2.close();
            i2.release();
        }
    }
}
